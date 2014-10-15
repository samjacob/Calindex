package com.calindex.util;

import static com.calindex.util.ExceptionHandlingUtils.getErrorStackAsString;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * An utility to send emails
 * 
 * @author 413643
 * @since Oct 10, 2014
 */
@Component
public class EmailUtils {

    /** The logger. */
    private static final Logger log = Logger.getLogger(EmailUtils.class);

    @Value("${smtpHost}")
    private String smtpHost;

    @Value("${smtpPort}")
    private Integer smtpPort;

    @Value("${userName}")
    private String userName;

    @Value("${password}")
    private String password;

    @Value("${emailRecipient}")
    private String emailRecipient;

    @Value("${emailSender}")
    private String emailSender;

    @Value("${emailSubject}")
    private String emailSubject;

    public void sendEmail(String emailMessage) {
        log.debug("Attempting to send email...");
        Email email = new SimpleEmail();
        email.setHostName(smtpHost);
        email.setSmtpPort(smtpPort);

        // email.setAuthenticator(new DefaultAuthenticator(userName, password));
        // email.setSSLOnConnect(true);

        try {
            email.setFrom(emailSender);
            email.setSubject(emailSubject);
            email.setMsg(emailMessage);
            email.addTo(emailRecipient);
            email.send();
            log.debug("Email sent successfully!");
        } catch (EmailException e) {
            log.error("Couldn't Send Email!");
            log.error("Error Message : " + getErrorStackAsString(e));
            log.error("Configuration Details : ");
            log.error("-------------------------------------------------------------------------------------------------------------------------------------");
            log.error("smtpHost : " + smtpHost);
            log.error("smtpPort : " + smtpPort);
//            log.trace("userName : " + userName);
//            log.trace("password : " + password);
            log.error("emailSender : " + emailSender);
            log.error("emailSubject : " + emailSubject);
            log.debug("emailMessage : " + emailMessage);
            log.error("emailRecipient : " + emailRecipient);
            log.error("-------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
