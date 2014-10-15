package com.calindex.batchjobs;

import static com.calindex.util.Constants.BLANK_STRING;
import static com.calindex.util.ExceptionHandlingUtils.getErrorStackAsString;

import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.calindex.db.OptOutDao;
import com.calindex.domain.OptOut;
import com.calindex.util.BatchFileUtils;
import com.calindex.util.EmailUtils;
import com.calindex.util.HL7Generator;
import com.calindex.util.HL7Utils;

/**
 * This is the Batch Job that will be run at specified intervals
 * 
 * @author 413643
 * @since Oct 9, 2014
 */
@Component
public class OptOutBatchJob {

    @Autowired
    private OptOutDao optOutDao;
    
    @Autowired
    private HL7Generator converter;
    
    @Autowired
    private HL7Utils hl7Utils;

    @Autowired
    private BatchFileUtils batchFileUtils;

    @Autowired
    private EmailUtils emailUtils;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        OptOutBatchJob batchJob = context.getBean(OptOutBatchJob.class);
        batchJob.email();
        batchJob.start();
        context.close();
    }

    private void email() {
        emailUtils.sendEmail("hello linesh");
    }

    private void start() {

        Logger log = Logger.getLogger(OptOutBatchJob.class);

        // --------------------------------- HOUSE KEEPING ---------------------------------
        log.info("Started the Batch Job for Opt Out Functionality...");
        log.info("Initiated House Keeping Activities...");
        batchFileUtils.performHouseKeeping();
        log.info("Completed House Keeping Activities!");

        // --------------------------------- FILE CREATION ---------------------------------
        log.info("Getting the name for the new Batch File...");
        String batchFileName = BLANK_STRING;
        String absolutePathToBatchFile = BLANK_STRING;
        
        try {
            batchFileName = batchFileUtils.getBatchFileName();
        } catch (Exception e) {
            log.error("Couldn't generate the name of the batch file!");
            log.error("Error Message : " + getErrorStackAsString(e));
            log.error("Batch Job cannot be executed successfully! Exiting with status [1]");
            System.exit(1);
        }
        log.info("Got the name for the new Batch File --> " + batchFileName);
        log.info("Creating the file...");
        try {
            absolutePathToBatchFile = batchFileUtils.createTemporaryFile(batchFileName);
            log.info("Succesfully created the file!");
        } catch (Exception e) {
            log.error("Couldn't create the batch file!");
            log.error("Error Message : " + getErrorStackAsString(e));
            log.error("Batch Job cannot be executed successfully! Exiting with status [1]");
            System.exit(1);
        }

        // --------------------------------- DATA SELECTION ---------------------------------
        log.info("Getting Unprocessed Records from Database...");
        List<OptOut> listOfRecords = optOutDao.getUnprocessedRecords();
        Integer totalRecords = listOfRecords.size();
        log.info("Received [" + totalRecords + "] records that have to be processsed to Orion");
        

        // --------------------------------- DATA PROCESSING ---------------------------------
        log.info("Started conversion of each record to HL07 format and writing to new batch file...");
        Integer passedRecords = 0;
        Integer failedRecords = 0;
        for (OptOut optOutRecord : listOfRecords) {
            try {
                hl7Utils.modifyFormForHL7(optOutRecord);
                String data = converter.convertToHL7(optOutRecord);
                log.info("HL7 Format is: " + data);
                batchFileUtils.writeToFile(absolutePathToBatchFile, data);
                passedRecords++;
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Couldn't process record with Subscriber Id : " + optOutRecord.getSubscriberId());
                failedRecords++;
            }
        }

        log.info("Successfully completed writing the records to file!");
        log.info("Total Passed Records : " + passedRecords);
        log.info("Total Failed Records : " + failedRecords);

        if ((passedRecords + failedRecords) != totalRecords) {
            log.error("Some Records went missing while processing as the count of all Passed and Failed Records don't match the count of Total Records!");
        }

        // --------------------------------- DATA TRANSMISSION ---------------------------------
        log.info("Sending File to Remote Server...");
        boolean isTransferSuccessful = false;
        try {
            isTransferSuccessful = batchFileUtils.transferFile(batchFileName, FilenameUtils.getFullPath(absolutePathToBatchFile));
            if (isTransferSuccessful) {
                log.info("File was successfully transferred to the Remote Server Location!");
                log.info("Batch Job was executed successfully! Exiting with status [0]");
                System.exit(0);
            }
        } catch (Exception e) {
            log.error("Error Message : " + getErrorStackAsString(e));
            log.error("File transfer to remote location failed! Batch Job couldn't be executed successfully! Exiting with status [1]");
            System.exit(1);
        }
    }
}
