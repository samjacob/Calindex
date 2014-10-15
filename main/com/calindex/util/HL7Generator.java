package com.calindex.util;

/**
 * @author 232727
 * @since Oct 10, 2014
 */

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.v23.message.ADT_A08;
import ca.uhn.hl7v2.model.v23.segment.EVN;
import ca.uhn.hl7v2.model.v23.segment.IN1;
import ca.uhn.hl7v2.model.v23.segment.MSH;
import ca.uhn.hl7v2.model.v23.segment.NK1;
import ca.uhn.hl7v2.model.v23.segment.PD1;
import ca.uhn.hl7v2.model.v23.segment.PID;
import ca.uhn.hl7v2.parser.Parser;

import com.calindex.db.OptOutDao;
import com.calindex.domain.OptOut;

import static com.calindex.util.Constants.HEALTH_PLAN_IDENTIFIER_CODE_FOR_ABC;
import static com.calindex.util.Constants.HEALTH_PLAN_IDENTIFIER_CODE_FOR_BSC;

@Component
public class HL7Generator {

    @Value("${adtMessageCode}")
    private  String adtMessageCode;
    
    @Value("${messageTriggerEvent}")
    private  String messageTriggerEvent;
    
    @Value("${processingId}")
    private  String processingId;
    
    @Value("${receivingApplication}")
    private  String receivingApplication;

    @Value("${sendingApplication}")
    private  String sendingApplication;

    @Value("${sendingFacility}")
    private  String sendingfacility;

    @Value("${receivingFacility}")
    private  String receivingFacility;   

    @Value("${eventTypeCode}")
    private  String eventTypeCode;

    @Value("${evn2_RecordedDateTime}")
    private  String evn2_RecordedDateTime;

    @Value("${eventReasonCode}")
    private  String eventReasonCode;
    
    @Value("${patientIDInternalID_AssigningAuthority}")
    private  String patientIDInternalID_AssigningAuthority;
    
    @Value("${IDInsurance}")
    private  String IDInsurance;
    
    @Value("${IDPatientID}")
    private  String IDPatientID;
    
    @Value("${IDNextOfKin}")
    private  String IDNextOfKin;
    
    @Value("${CRchar}")
    private  String CRchar;
    
    @Value("${protectionIndicator}")
    private  String protectionIndicator; 

    @Autowired
    private  OptOutDao optOutDao;
  
    
    public String convertToHL7(OptOut optOutRecord) throws HL7Exception, IOException {

        /*
         * Create the DAO object and fetch the details from database to generate the HL7 message
         * TO DO
        /*
         * Creating a ADT_A08 abject for generating the message
         */  
        
        ADT_A08 adt = new ADT_A08();
        adt.initQuickstart(adtMessageCode, messageTriggerEvent, processingId);

        /*
         * Creating the Message Header object for setting the necesary header fields.
         */

        MSH mshSegment = adt.getMSH();

        /*
         * All Message Header values are populated from the property file.
         */

        mshSegment.getSendingApplication().getNamespaceID().setValue(sendingApplication);
        mshSegment.getSendingFacility().getHd1_NamespaceID().setValue(sendingfacility);
        mshSegment.getReceivingApplication().getNamespaceID().setValue(receivingApplication);
        mshSegment.getReceivingFacility().getNamespaceID().setValue(receivingFacility);
        //mshSegment.getMsh11_ProcessingID().getProcessingID().setValue(msh11_ProcessingID);
        //mshSegment.getAcceptAcknowledgementType().setValue(acceptAcknowledgementType);
        //mshSegment.getMsh4_SendingFacility().getUniversalID().setValue("");
        mshSegment.encode().endsWith(CRchar);        
        /*
         * Creating the Event Information object and data
         */
        EVN evnSegment = adt.getEVN();

        /*
         * All Event Segment values need to be populated from property file
         * Date can be current data
         */
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();        
        
        evnSegment.getEventTypeCode().setValue(eventTypeCode);
        evnSegment.getEvn2_RecordedDateTime().getTimeOfAnEvent().setValue(dateFormat.format(date));
        //evnSegment.getDateTimePlannedEvent().getTimeOfAnEvent().setValue("");
        evnSegment.getEventReasonCode().setValue(eventReasonCode);
        evnSegment.encode().endsWith(CRchar);

        /*
         * Creating the Patient Information Object and data
         */
        PID pid = adt.getPID();

        // Set ID - PID
        pid.getSetIDPatientID().setValue(IDPatientID);

        // PID-3   CX     20  Patient ID (Internal ID)
        /*
         * Needs to be retrieved from property file
         */
        pid.getPatientIDInternalID(0).getCx1_ID().setValue(optOutRecord.getTransactionId());

        /*
         * Assigning Authority Universal ID,
         * Needs to be retrieved from property file
         */

        pid.getPatientIDInternalID(0).getAssigningAuthority().getHd2_UniversalID().setValue(patientIDInternalID_AssigningAuthority);
        
        pid.getPatientName(0).getXpn1_FamilyName().setValue(optOutRecord.getLastName());
        pid.getPatientName(0).getXpn2_GivenName().setValue(optOutRecord.getFirstName());
        pid.getPatientName(0).getXpn3_MiddleInitialOrName().setValue(optOutRecord.getMiddleName());            
        
        pid.getPatientAddress(0).getXad1_StreetAddress().setValue(optOutRecord.getAddress());
        pid.getPatientAddress(0).getXad2_OtherDesignation().setValue(optOutRecord.getApartmentNumber());
        pid.getPatientAddress(0).getXad3_City().setValue(optOutRecord.getCity());
        pid.getPatientAddress(0).getXad4_StateOrProvince().setValue(optOutRecord.getState());
        pid.getPatientAddress(0).getXad5_ZipOrPostalCode().setValue(optOutRecord.getZipCode());
        
        pid.getPid7_DateOfBirth().getTimeOfAnEvent().setValue(optOutRecord.getDateOfBirth());
        
        pid.getPid3_PatientIDInternalID(0).getCx1_ID().setValue(optOutRecord.getTransactionId());
        
        pid.getPid8_Sex().setValue(optOutRecord.getGender());
                       
        pid.getPid9_PatientAlias(0).getGivenName().setValue(optOutRecord.getPreviousFirstName());
        pid.getPid9_PatientAlias(0).getFamilyName().setValue(optOutRecord.getPreviousLastName());
        
        pid.getPatientAddress(0).getXad7_AddressType().setValue(optOutRecord.getAddressType());
        pid.getPatientIDInternalID(0).getCx5_IdentifierTypeCode().setValue(optOutRecord.getHealthPlanIdentifierCode());      
        
        pid.getPid13_PhoneNumberHome(0).getEmailAddress().setValue(optOutRecord.getEmail());
        
        pid.getPid13_PhoneNumberHome(0).getPhoneNumber().setValue(optOutRecord.getPhoneNumber());
        pid.getPid13_PhoneNumberHome(0).getTelecommunicationEquipmentType().setValue(optOutRecord.getPhoneType());
        
        pid.getPid14_PhoneNumberBusiness(0).getPhoneNumber().setValue(optOutRecord.getPhoneNumber());
        
        pid.encode().endsWith(CRchar);
        
        NK1 nk1Segment = adt.getNK1();
        
        //NK1-1   SI      4  Set ID - NK1
        nk1Segment.getSetIDNextOfKin().setValue(IDNextOfKin);
        
        //NK1-2   XPN    48  Name
        nk1Segment.getContactPersonSName(0).getFamilyName().setValue(optOutRecord.getLastNameOfThePersonCompletingTheForm());
        nk1Segment.getContactPersonSName(0).getGivenName().setValue(optOutRecord.getFirstNameOfThePersonCompletingTheForm());
        
        // NK1-3   CE     60  Relationship
        nk1Segment.getRelationship().getCe2_Text().setValue(optOutRecord.getRelationshipToTheOptedOutPerson());
        
        nk1Segment.getContactPersonSTelephoneNumber(0).getPhoneNumber().setValue(optOutRecord.getPhoneNumberOfThePersonCompletingTheForm());
        


        /*
         * Creating Patient Demographic Information object and data
         */        
        PD1 pd1seg = adt.getPD1();

        pd1seg.getProtectionIndicator().setValue(protectionIndicator);

        pd1seg.encode().endsWith(CRchar);

        /*
         * Creating Insurance Information object and data
         */        
        IN1 in1seg = adt.getINSURANCE(0).getIN1();

        // IN1-1 SI 4 Set ID - IN1
        in1seg.getSetIDInsurance().setValue(IDInsurance);
        if(StringUtils.equalsIgnoreCase(optOutRecord.getHealthPlanMember(),"Yes")){

            if(StringUtils.equalsIgnoreCase(optOutRecord.getHealthPlanIdentifierCode(),HEALTH_PLAN_IDENTIFIER_CODE_FOR_ABC)){
                    
                // IN1-8   ST     12  Group Number
                in1seg.getIn18_GroupNumber().setValue(optOutRecord.getGroupNumber());
                
                // IN1-2 CE 60 Insurance Plan ID
                in1seg.getIn12_InsurancePlanID().getCe1_Identifier().setValue(optOutRecord.getIdentificationNumber());
                
                
            }else{
                // IN1-8   ST     12  Group Number
                in1seg.getIn18_GroupNumber().setValue(optOutRecord.getGroupId());
                          
                // IN1-2 CE 60 Insurance Plan ID
                in1seg.getIn12_InsurancePlanID().getCe1_Identifier().setValue(optOutRecord.getSubscriberId());            
                   
            }        
        
        
            if(StringUtils.equalsIgnoreCase(optOutRecord.getHealthPlanIdentifierCode(),HEALTH_PLAN_IDENTIFIER_CODE_FOR_ABC) || StringUtils.equalsIgnoreCase(optOutRecord.getHealthPlanIdentifierCode(),HEALTH_PLAN_IDENTIFIER_CODE_FOR_BSC)){
                    // IN1-4 XON 130 Insurance Company Name Group Number
                    in1seg.getInsuranceCompanyName().getOrganizationName().setValue(optOutRecord.getHealthPlanName());
            }else{
                    //  IN1-4 XON 130 Insurance Company Name Group Number
                    in1seg.getInsuranceCompanyName().getOrganizationName().setValue(optOutRecord.getOtherHealthPlanName());
            }
        }        
        //in1seg.getGroupName().getOrganizationName().setValue(groupName);
        in1seg.encode().endsWith(CRchar);

        /*
         * Code for context and Parser setup and encoding
         */        
        HapiContext context = new DefaultHapiContext();
        Parser parser = context.getPipeParser();
        String encodedMessage = parser.encode(adt);
        return encodedMessage;        

    }
}
