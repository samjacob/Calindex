package com.calindex.domain;

import static org.apache.commons.lang3.StringUtils.defaultString;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Domain Object for OptOut.
 *
 * @author 410908
 * @since Oct 7, 2014
 */

@Entity
@Table(name = "OPT_OUT", schema = "CALINDEXDEV")
public class OptOut {

    /** The Constant RECORD_PROCESSED. */
    public static final String RECORD_PROCESSED = "processedStatus";

    /** The transaction id. */
    @Column(name = "transaction_id")
    @Id
    private String transactionId;

    /** The first name. */
    @Column(name = "first_name")
    private String firstName;

    /** The middle name. */
    @Column(name = "middle_name")
    private String middleName;

    /** The last name. */
    @Column(name = "last_name")
    private String lastName;

    /** The first name of the person completing the form. */
    @Column(name = "first_name_person_completing_form")
    private String firstNameOfThePersonCompletingTheForm;

    /** The last name of the person completing the form. */
    @Column(name = "last_name_person_completing_form")
    private String lastNameOfThePersonCompletingTheForm;

    /** The phone number of the person completing the form. */
    @Column(name = "phone_number_person_completing_form")
    private String phoneNumberOfThePersonCompletingTheForm;

    /** The relationship to the opted out person. */
    @Column(name = "relationship_person_completing_form")
    private String relationshipToTheOptedOutPerson;

    /** The gender. */
    @Column(name = "gender")
    private String gender;

    /** The date of birth. */
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    /** The previous first name. */
    @Column(name = "previous_first_name")
    private String previousFirstName;

    /** The previous last name. */
    @Column(name = "previous_last_name")
    private String previousLastName;

    /** The address. */
    @Column(name = "address")
    private String address;

    /** The apartment number. */
    @Column(name = "apartment_number")
    private String apartmentNumber;

    /** The city. */
    @Column(name = "city")
    private String city;

    /** The state. */
    @Column(name = "state")
    private String state;

    /** The zip code. */
    @Column(name = "zip_code")
    private String zipCode;

    /** The health plan member. */
    @Column(name = "member_health_plan")
    private String healthPlanMember;

    /** The health plan name. */
    @Column(name = "health_plan_name")
    private String healthPlanName;

    /** The email. */
    @Column(name = "email")
    private String email;

    /** The phone number. */
    @Column(name = "main_phone_number")
    private String phoneNumber;

    /** The alternate phone number. */
    @Column(name = "alternate_phone_number")
    private String alternatePhoneNumber;

    /** The group id. */
    @Column(name = "group_id")
    private String groupId;

    /** The subscriber id. */
    @Column(name = "subscriber_id")
    private String subscriberId;

    /** filed to check if the records is processed. */
    @Column(name = "is_processed")
    private String processedStatus;

    /** The group number. */
    @Column(name = "group_number")
    private String groupNumber;

    /** The identification number. */
    @Column(name = "identification_number")
    private String identificationNumber;

    /** The other health plan name. */
    @Column(name = "other_health_plan_name")
    private String otherHealthPlanName;

    /** The address type. */
    @Transient
    private String addressType;

    /** The phone type. */
    @Transient
    private String phoneType;

    /** The health plan identifier code. */
    @Transient
    private String healthPlanIdentifierCode;

    /**
     * Gets the group number.
     *
     * @return the groupNumber
     */
    public String getGroupNumber() {
        return groupNumber;
    }

    /**
     * Sets the group number.
     *
     * @param groupNumber
     *            the groupNumber to set
     */
    public void setGroupNumber(String groupNumber) {
        this.groupNumber = defaultString(groupNumber);
    }

    /**
     * Gets the identification number.
     *
     * @return the identificationNumber
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Sets the identification number.
     *
     * @param identificationNumber
     *            the identificationNumber to set
     */
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = defaultString(identificationNumber);
    }

    /**
     * Gets the other health plan name.
     *
     * @return the otherHealthPlanName
     */
    public String getOtherHealthPlanName() {
        return otherHealthPlanName;
    }

    /**
     * Sets the other health plan name.
     *
     * @param otherHealthPlanName
     *            the otherHealthPlanName to set
     */
    public void setOtherHealthPlanName(String otherHealthPlanName) {
        this.otherHealthPlanName = defaultString(otherHealthPlanName);
    }

    /**
     * Gets the first name.
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the middle name.
     *
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name.
     *
     * @param middleName
     *            the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = defaultString(middleName);
    }

    /**
     * Gets the last name.
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the person completing the form.
     *
     * @return the firstNameOfThePersonCompletingTheForm
     */
    public String getFirstNameOfThePersonCompletingTheForm() {
        return firstNameOfThePersonCompletingTheForm;
    }

    /**
     * Sets the first name of the person completing the form.
     *
     * @param firstNameOfThePersonCompletingTheForm
     *            the firstNameOfThePersonCompletingTheForm to set
     */
    public void setFirstNameOfThePersonCompletingTheForm(String firstNameOfThePersonCompletingTheForm) {
        this.firstNameOfThePersonCompletingTheForm = defaultString(firstNameOfThePersonCompletingTheForm);
    }

    /**
     * Gets the last name of the person completing the form.
     *
     * @return the lastNameOfThePersonCompletingTheForm
     */
    public String getLastNameOfThePersonCompletingTheForm() {
        return lastNameOfThePersonCompletingTheForm;
    }

    /**
     * Sets the last name of the person completing the form.
     *
     * @param lastNameOfThePersonCompletingTheForm
     *            the lastNameOfThePersonCompletingTheForm to set
     */
    public void setLastNameOfThePersonCompletingTheForm(String lastNameOfThePersonCompletingTheForm) {
        this.lastNameOfThePersonCompletingTheForm = defaultString(lastNameOfThePersonCompletingTheForm);
    }

    /**
     * Gets the phone number of the person completing the form.
     *
     * @return the phoneNumberOfThePersonCompletingTheForm
     */
    public String getPhoneNumberOfThePersonCompletingTheForm() {
        return phoneNumberOfThePersonCompletingTheForm;
    }

    /**
     * Sets the phone number of the person completing the form.
     *
     * @param phoneNumberOfThePersonCompletingTheForm
     *            the phoneNumberOfThePersonCompletingTheForm to set
     */
    public void setPhoneNumberOfThePersonCompletingTheForm(String phoneNumberOfThePersonCompletingTheForm) {
        this.phoneNumberOfThePersonCompletingTheForm = defaultString(phoneNumberOfThePersonCompletingTheForm);
    }

    /**
     * Gets the relationship to the opted out person.
     *
     * @return the relationshipToTheOptedOutPerson
     */
    public String getRelationshipToTheOptedOutPerson() {
        return relationshipToTheOptedOutPerson;
    }

    /**
     * Sets the relationship to the opted out person.
     *
     * @param relationshipToTheOptedOutPerson
     *            the relationshipToTheOptedOutPerson to set
     */
    public void setRelationshipToTheOptedOutPerson(String relationshipToTheOptedOutPerson) {
        this.relationshipToTheOptedOutPerson = defaultString(relationshipToTheOptedOutPerson);
    }

    /**
     * Gets the gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender
     *            the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the date of birth.
     *
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth.
     *
     * @param dateOfBirth
     *            the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the previous first name.
     *
     * @return the previousFirstName
     */
    public String getPreviousFirstName() {
        return previousFirstName;
    }

    /**
     * Sets the previous first name.
     *
     * @param previousFirstName
     *            the previousFirstName to set
     */
    public void setPreviousFirstName(String previousFirstName) {
        this.previousFirstName = defaultString(previousFirstName);
    }

    /**
     * Gets the previous last name.
     *
     * @return the previousLastName
     */
    public String getPreviousLastName() {
        return previousLastName;
    }

    /**
     * Sets the previous last name.
     *
     * @param previousLastName
     *            the previousLastName to set
     */
    public void setPreviousLastName(String previousLastName) {
        this.previousLastName = defaultString(previousLastName);
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the apartment number.
     *
     * @return the apartmentNumber
     */
    public String getApartmentNumber() {
        return apartmentNumber;
    }

    /**
     * Sets the apartment number.
     *
     * @param apartmentNumber
     *            the apartmentNumber to set
     */
    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = defaultString(apartmentNumber);
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state
     *            the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zip code.
     *
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code.
     *
     * @param zipCode
     *            the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the health plan member.
     *
     * @return the healthPlanMember
     */
    public String getHealthPlanMember() {
        return healthPlanMember;
    }

    /**
     * Sets the health plan member.
     *
     * @param healthPlanMember
     *            the healthPlanMember to set
     */
    public void setHealthPlanMember(String healthPlanMember) {
        this.healthPlanMember = healthPlanMember;
    }

    /**
     * Gets the health plan name.
     *
     * @return the healthPlanName
     */
    public String getHealthPlanName() {
        return healthPlanName;
    }

    /**
     * Sets the health plan name.
     *
     * @param healthPlanName
     *            the healthPlanName to set
     */
    public void setHealthPlanName(String healthPlanName) {
        this.healthPlanName = defaultString(healthPlanName);
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number.
     *
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber
     *            the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the alternate phone number.
     *
     * @return the alternatePhoneNumber
     */
    public String getAlternatePhoneNumber() {
        return alternatePhoneNumber;
    }

    /**
     * Sets the alternate phone number.
     *
     * @param alternatePhoneNumber
     *            the alternatePhoneNumber to set
     */
    public void setAlternatePhoneNumber(String alternatePhoneNumber) {
        this.alternatePhoneNumber = defaultString(alternatePhoneNumber);
    }

    /**
     * Gets the group id.
     *
     * @return the groupId
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Sets the group id.
     *
     * @param groupId
     *            the groupId to set
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * Gets the subscriber id.
     *
     * @return the subscriberId
     */
    public String getSubscriberId() {
        return subscriberId;
    }

    /**
     * Sets the subscriber id.
     *
     * @param subscriberId
     *            the subscriberId to set
     */
    public void setSubscriberId(String subscriberId) {
        this.subscriberId = defaultString(subscriberId);
    }

    /**
     * Gets the processed status.
     *
     * @return the processedStatus
     */
    public String getProcessedStatus() {
        return processedStatus;
    }

    /**
     * Sets the processed status.
     *
     * @param processedStatus
     *            the processedStatus to set
     */
    public void setProcessedStatus(String processedStatus) {
        this.processedStatus = processedStatus;
    }

    /**
     * Gets the transaction id.
     *
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the transaction id.
     *
     * @param transactionId
     *            the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Gets the address type.
     *
     * @return the addressType
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * Sets the address type.
     *
     * @param addressType
     *            the addressType to set
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * Gets the phone type.
     *
     * @return the phoneType
     */
    public String getPhoneType() {
        return phoneType;
    }

    /**
     * Sets the phone type.
     *
     * @param phoneType
     *            the phoneType to set
     */
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    /**
     * Gets the health plan identifier code.
     *
     * @return the healthPlanIdentifierCode
     */
    public String getHealthPlanIdentifierCode() {
        return healthPlanIdentifierCode;
    }

    /**
     * Sets the health plan identifier code.
     *
     * @param healthPlanIdentifierCode
     *            the healthPlanIdentifierCode to set
     */
    public void setHealthPlanIdentifierCode(String healthPlanIdentifierCode) {
        this.healthPlanIdentifierCode = healthPlanIdentifierCode;
    }

    /**
     * Gets the record processed.
     *
     * @return the recordProcessed
     */
    public static String getRecordProcessed() {
        return RECORD_PROCESSED;
    }

    @Override
    public String toString() {
        return "OptOut [transactionId=" + transactionId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", firstNameOfThePersonCompletingTheForm="
                + firstNameOfThePersonCompletingTheForm + ", lastNameOfThePersonCompletingTheForm=" + lastNameOfThePersonCompletingTheForm + ", phoneNumberOfThePersonCompletingTheForm="
                + phoneNumberOfThePersonCompletingTheForm + ", relationshipToTheOptedOutPerson=" + relationshipToTheOptedOutPerson + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
                + ", previousFirstName=" + previousFirstName + ", previousLastName=" + previousLastName + ", address=" + address + ", apartmentNumber=" + apartmentNumber + ", city=" + city
                + ", state=" + state + ", zipCode=" + zipCode + ", healthPlanMember=" + healthPlanMember + ", healthPlanName=" + healthPlanName + ", email=" + email + ", phoneNumber=" + phoneNumber
                + ", alternatePhoneNumber=" + alternatePhoneNumber + ", groupId=" + groupId + ", subscriberId=" + subscriberId + ", processedStatus=" + processedStatus + ", groupNumber="
                + groupNumber + ", identificationNumber=" + identificationNumber + ", otherHealthPlanName=" + otherHealthPlanName + ", addressType=" + addressType + ", phoneType=" + phoneType
                + ", healthPlanIdentifierCode=" + healthPlanIdentifierCode + "]";
    }

}
