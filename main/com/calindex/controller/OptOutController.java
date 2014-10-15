/*
 * 
 */
package com.calindex.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.calindex.db.OptOutDao;
import com.calindex.domain.OptOut;
import com.calindex.util.HL7Utils;

/**
 * The Class OptOutController.
 */
@Controller
public class OptOutController {

    /** The opt out DAO. */
    @Autowired
    private OptOutDao optOutDao;

    /** The hl7 Utils. */
    @Autowired
    private HL7Utils hl7Utils;

    /** The logger. */
    private static final Logger log = Logger.getLogger(OptOutController.class);

    /**
     * Initialize application.
     *
     * @return the model and view
     */
    @RequestMapping("initialization")
    public ModelAndView initializeApplication() {
        log.debug("Application Initialized! Redirecting to the Opt Out Form!");
        return new ModelAndView("forward:" + "optout.html");
    }

    /**
     * Load opt out form.
     *
     * @return the model and view
     */
    @RequestMapping("/optout")
    public ModelAndView loadOptOutForm() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("optOutForm", new OptOut());
        return mav;
    }

    /**
     * Load opt out form in Spanish.
     *
     * @return the model and view
     */
    @RequestMapping("/espanol")
    public ModelAndView loadOptOutFormInSpanish() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("optOutForm", new OptOut());
        return mav;
    }

    /**
     * Capture data.
     *
     * @param form
     *            the form
     * @return the model and view
     */
    @RequestMapping("/captureData")
    public ModelAndView captureData(OptOut form) {
        // Removing the last character i.e ',' from the first name, middle name and the last name.
        form.setFirstName(removeLastCharacter(form.getFirstName()));
        form.setMiddleName(removeLastCharacter(form.getMiddleName()));
        form.setLastName(removeLastCharacter(form.getLastName()));

        // Sending the records to get persisted in the Database.
        optOutDao.persistRecord(form);

        return new ModelAndView("thankyou");
    }

    /**
     * Removes the last character i.e. ',' from the first name, middle name and the last name.
     *
     * @param name
     *            the name
     * @return the string
     */
    private String removeLastCharacter(String name) {
        if (StringUtils.endsWith(name, ",")) {
            name = StringUtils.removeEnd(name, ",");
        }
        return name;
    }
}
