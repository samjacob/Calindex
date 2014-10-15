package com.calindex.util;

import static com.calindex.util.Constants.BLANK_STRING;
import static com.calindex.util.Constants.DEFAULT_ENCODING;
import static com.calindex.util.ExceptionHandlingUtils.getErrorStackAsString;
import static com.calindex.util.ExceptionHandlingUtils.handleNullValues;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This is a utility class for reading / writing / housekeeping the batch files .
 *
 * @author 413643
 * @since Oct 8, 2014
 */
@Component
public class BatchFileUtils {

    /** The logger. */
    private static final Logger log = Logger.getLogger(BatchFileUtils.class);

    /** The temporary file path. */
    @Value("${temporaryFilePath}")
    private String temporaryFilePath;

    /** The absolute path to batch file. */
    @Value("${absolutePathToBatchFile}")
    private String absolutePathToBatchFile;

    /** The absolute path to batch file archive. */
    @Value("${absolutePathToBatchFileArchive}")
    private String absolutePathToBatchFileArchive;

    /** The batch file name prefix. */
    @Value("${batchFileNamePrefix}")
    private String batchFileNamePrefix;

    /** The batch file extension. */
    @Value("${batchFileExtension}")
    private String batchFileExtension;

    /** The batch file name's date format. */
    @Value("${batchFileNameDateFormat}")
    private String batchFileNameDateFormat;

    /** The max age. */
    @Value("${maxAgeOfArchivedFiles}")
    private Integer maxAge;

    /**
     * This method sends the file to the specified location on the server
     * 
     * @param fileName
     *            - the name of the file that has to be transferred
     * @param currentFileLocation
     *            - the path where the file currently exists
     * @return <b>True</b> - If the transfer was successful <br>
     *         <b>False</b> - Otherwise
     */
    public boolean transferFile(String fileName, String currentFileLocation) throws Exception {

        handleNullValues(absolutePathToBatchFile, "The Directory where the batch files are placed on the remote server");
        handleNullValues(fileName, "The local file which has to be transferred to the remote server");

        log.trace("Path where the file has to be created is : " + absolutePathToBatchFile);
        log.trace("Name of the file that will be created in the above path : " + fileName);

        String completeFilePathOfRemoteFile = absolutePathToBatchFile + File.separator + fileName;
        log.trace("Complete Path to File (this is going to be created) : " + completeFilePathOfRemoteFile);


        String completeFilePathOfLocalFile = currentFileLocation + File.separator + fileName;
        log.trace("Complete Path to File (data will be read from here) : " + completeFilePathOfLocalFile);

        File remoteBatchFile = new File(completeFilePathOfRemoteFile);
        remoteBatchFile.createNewFile();
        remoteBatchFile.setExecutable(true, false);
        remoteBatchFile.setReadable(true, false);
        remoteBatchFile.setWritable(true, false);
        log.debug("Created file with name [" + fileName + "] at location [" + absolutePathToBatchFile + "] with all permissions!");

        log.trace("Reading data from [" + completeFilePathOfLocalFile + "] and writing it to [" + completeFilePathOfRemoteFile +"]");

        if (remoteBatchFile.exists()) {
            String batchData = BLANK_STRING;
            try {
                batchData = FileUtils.readFileToString(new File(completeFilePathOfLocalFile), Charset.forName(DEFAULT_ENCODING));
            } catch (Exception e) {
                log.error("Couldn't read data from the file!");
                log.error("Error Message : " + getErrorStackAsString(e));
                log.error("File from which data was being read : " + completeFilePathOfLocalFile);
            }
            writeToFile(remoteBatchFile.toString(), batchData);
            log.info("Successfully created a new batch file with name [" + fileName + "] at location [" + absolutePathToBatchFile + "] with all permissions");
            return true;
        }
        log.error("Something has gone wrong! Couldn't find (create failed!) the batch file with name [" + fileName + "] at location [" + absolutePathToBatchFile + "]");
        return false;
    }

    /**
     * This method creates the file locally to store the data
     * 
     * @param fileName
     *            - the file that has to be created
     * @return <b>Complete Path to File</b> - If the file creation was successful <br>
     *         <b>Exception</b> - Otherwise
     */
    public String createTemporaryFile(String fileName) throws Exception {

        handleNullValues(fileName, "The name for the local file which has to be created for storing the messages!");
        handleNullValues(temporaryFilePath, "The temporary directory where the local file which has to be created for storing the messages!");

        log.trace("Path where the file has to be created is : " + temporaryFilePath);

        File file = new File(temporaryFilePath + File.separator + fileName);
        file.createNewFile();
        file.setExecutable(true, false);
        file.setReadable(true, false);
        file.setWritable(true, false);

        if (file.exists()) {
            log.debug("Creating file successfully with name [" + fileName + "] at location [" + file.getAbsolutePath() + "] with all permissions");
            return file.getAbsolutePath();
        }
        log.error("Something has gone wrong! Couldn't create the batch file with name [" + fileName + "] at location [" + temporaryFilePath + "]");
        throw new Exception();
    }

    /**
     * This method writes a given string to the specified file (in append mode) in UTF-8 format.
     *
     * @param absolutePathToFile
     *            the absolute path to file
     * @param data
     *            the data
     * @return <b>True</b> - If the write was successful <br>
     *         <b>False</b> - Otherwise
     */
    @SuppressWarnings("static-method")
    public boolean writeToFile(String absolutePathToFile, String data) throws Exception {

        handleNullValues(absolutePathToFile, "The complete path to the file where the data has to be written!");
        handleNullValues(data, "The data (HL7 A04 formatted) which has to be written to the batch file");

        try {
            FileUtils.write(new File(absolutePathToFile), data + System.lineSeparator(), DEFAULT_ENCODING, true);
            return true;
        } catch (Exception e) {
            log.error("Couldn't write data to the file!");
            log.error("Error Message : " + getErrorStackAsString(e));
            log.error("Absolute File Path to write data : " + absolutePathToFile);
            log.error("Data which was to be written : " + data + System.lineSeparator());
            log.error("Encoding Format Used : " + DEFAULT_ENCODING);
            return false;
        }
    }

    /**
     * This method performs housekeeping tasks i.e. <br>
     * 1) Move all files from the main file path to the archive folder <br>
     * 2) Delete all files older than 7 days from the archive folder
     */
    public void performHouseKeeping() {
        try {
            archiveExistingFiles();
            cleanUpOldArchivedFiles();
            cleanUpTemporaryFiles();
        } catch (Exception e) {
            log.error("Something went wrong while performing housekeeping activities!");
            log.error("Error Message : " + getErrorStackAsString(e));
            log.error("Ignoring and continuing...");
        }
    }

    // /**
    // * This method picks up the Acknowledgment File generated by Orion from their server to local system.
    // */
    // public String getOrionAcknowledgementFile() {
    // try {
    // FileUtils.copyFileToDirectory(orion, new File(absolutePathToBatchFileArchive), true);
    // cleanUpOldArchivedFiles();
    // } catch (Exception e) {
    // log.error("Something went wrong while performing housekeeping activities!");
    // log.error("Error Message : " + getErrorStackAsString(e));
    // log.error("Ignoring and continuing...");
    // }
    // }

    /**
     * This method returns the File Name that has to be used for the Batch File. <br>
     * The format is prefix_<i>mmddyyyyhhmmss</i> <br>
     * <b>where</b> <br>
     * prefix --> is the standard name of the file <br>
     * mmddyyyyhhmmss --> is the current month, day, year, hour, minute and second <br>
     * Example - <b>CalINDEX_10092014181236.txt</b>
     * 
     * @return the Batch File Name in the required format
     */
    public String getBatchFileName() throws Exception {

        handleNullValues(batchFileNameDateFormat, "The date format for the name of the batch file.");
        handleNullValues(batchFileNamePrefix, "The format for the name of the batch file.");
        handleNullValues(batchFileExtension, "The extension type for the batch file.");

        String formattedDate = BLANK_STRING;
        try {
            formattedDate = FastDateFormat.getInstance(batchFileNameDateFormat).format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            log.error("Couldn't get the Current Date and Time in the required format!");
            log.error("Error Message : " + getErrorStackAsString(e));
            log.error("The requested date/time format was : " + batchFileNameDateFormat);
            log.error("Please verify if the above is a valid date/time format!");
            throw new Exception();
        }
        String fileName = batchFileNamePrefix + formattedDate + batchFileExtension;
        log.trace("Generated File Name is : " + fileName);
        return fileName;
    }

    /**
     * This method moves the current batch file(s)
     * from the main batch folder to the archive folder.
     */
    private void archiveExistingFiles() throws Exception {

        handleNullValues(absolutePathToBatchFile, "The Directory where the batch files are placed on the remote server");
        handleNullValues(absolutePathToBatchFileArchive, "The Directory where the batch files are Archived on the remote server");

        final File batchFilePath = new File(absolutePathToBatchFile);
        File[] listOfBatchFiles = batchFilePath.listFiles();

        handleNullValues(listOfBatchFiles, "List of Files at Remote Batch File Location : " + absolutePathToBatchFile);

        Integer numberOfBatchFiles = listOfBatchFiles.length;
        if (numberOfBatchFiles != 1) {
            log.error("Something is wrong at [" + absolutePathToBatchFile + "]. Expected exactly one file to be present here but found [" + numberOfBatchFiles + "]");
        }
        if (numberOfBatchFiles >= 1) {
            for (final File child : listOfBatchFiles) {
                try {
                    if (child.isFile()) FileUtils.moveFileToDirectory(child, new File(absolutePathToBatchFileArchive), true);
                } catch (FileExistsException e) {
                    log.warn("File [" + child + "] already exists in the location [" + absolutePathToBatchFileArchive + "]. Deleting this file!");
                    child.delete();
                } catch (Exception e) {
                    log.error("Couldn't perform house keeping as and exception was encountered while archiving!");
                    log.error("Error Message : " + getErrorStackAsString(e));
                    log.error("Was trying to move the file [" + child + "] from [" + absolutePathToBatchFile + "] to [" + absolutePathToBatchFileArchive + "]");
                }
            }
        }
        log.info("Completed Archive of Existing Files.");
    }

    /**
     * This method deletes all files in the temporary folder.
     */
    private void cleanUpTemporaryFiles() throws Exception {

        handleNullValues(temporaryFilePath, "The Directory where files are created temporarily");

        final File temporaryDirectory = new File(temporaryFilePath);
        try {
            FileUtils.deleteQuietly(temporaryDirectory);
            FileUtils.forceMkdir(temporaryDirectory);
            setAllPermissions(temporaryDirectory);
        } catch (Exception e) {
            log.error("Couldn't delete / recreate the temporary directory : " + temporaryDirectory);
            log.error("Error Message : " + getErrorStackAsString(e));
        }
    }

    /**
     * This method deletes all files older than 'X' days, from the archive folder.
     */
    private void cleanUpOldArchivedFiles() throws Exception {

        handleNullValues(absolutePathToBatchFileArchive, "The Directory where the batch files are Archived on the remote server");

        final File archiveFilePath = new File(absolutePathToBatchFileArchive);
        File[] listOfArchivedFiles = archiveFilePath.listFiles();

        handleNullValues(listOfArchivedFiles, "List of Archived Files at Remote Archive Batch File Location : " + absolutePathToBatchFileArchive);

        final Date maxAllowableDate = getMaxAllowableDate();

        for (final File child : listOfArchivedFiles) {
            try {
                if (FileUtils.isFileOlder(child, maxAllowableDate)) {
                    FileUtils.forceDelete(child);
                    log.trace("Deleted File : " + child.getAbsolutePath());
                }
            } catch (Exception e) {
                log.error("Couldn't delete an old archive file!");
                log.error("Error Message : " + getErrorStackAsString(e));
                log.error("Was trying to delete file [" + child + "] from [" + absolutePathToBatchFileArchive + "]");
            }
        }
        log.info("Completed Cleanup of Old Archived Files.");
    }

    /**
     * This method gets the date upto which a file should be archived.
     * If a file's creation date is older than this date, it should be deleted.
     *
     * @return the max allowable date
     */
    private Date getMaxAllowableDate() throws Exception {

        handleNullValues(maxAge, "The number of days up to which the batch files should be archived.");

        DateTime currentDateTime = new DateTime();
        DateTime dateMinusMaxAge = currentDateTime.minusDays(maxAge);
        log.trace("Batch Files created before this date will be deleted : " + dateMinusMaxAge);
        return dateMinusMaxAge.toDate();
    }

    private File setAllPermissions(File file){
        file.setExecutable(true, false);
        file.setReadable(true, false);
        file.setWritable(true, false);
        return file;
    }
}
