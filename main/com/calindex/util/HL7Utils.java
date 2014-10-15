package com.calindex.util;

import static com.calindex.util.Constants.HEALTH_PLAN_ABC;
import static com.calindex.util.Constants.HEALTH_PLAN_BSC;
import static com.calindex.util.Constants.HEALTH_PLAN_IDENTIFIER_CODE_FOR_ABC;
import static com.calindex.util.Constants.HEALTH_PLAN_IDENTIFIER_CODE_FOR_BSC;
import static com.calindex.util.Constants.HEALTH_PLAN_IDENTIFIER_CODE_FOR_OTHERS;
import static com.calindex.util.Constants.HEALTH_PLAN_OTHERS;
import static com.calindex.util.Constants.TRANSACTION_ID_PREFIX;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.calindex.domain.OptOut;

/**
 * The Class HL7Utils.
 *
 * @author 410908
 * @since Oct 13, 2014
 */
@Component
public class HL7Utils {

    /** The address type. */
    @Value("${addressType}")
    private String addressType;

    /** The phone type. */
    @Value("${phoneType}")
    private String phoneType;

    /**
     * Modifies form for HL7.
     *
     * @param optOut
     *            the opt out form
     * @return the opt out form
     */
    public OptOut modifyFormForHL7(OptOut optOut) {

        // Setting the Phone Type in the form Object.
        optOut.setPhoneType(phoneType);

        // Setting the Address Type in the form Object.
        optOut.setAddressType(addressType);

        // Prefixing CI to the transaction ID.
        optOut.setTransactionId(TRANSACTION_ID_PREFIX + optOut.getTransactionId());

        // Setting the Health Plan Identifier Code based on the Health Plan Name.
        switch (optOut.getHealthPlanName()) {
            case HEALTH_PLAN_BSC:
                optOut.setHealthPlanIdentifierCode(HEALTH_PLAN_IDENTIFIER_CODE_FOR_BSC);
                break;
            case HEALTH_PLAN_ABC:
                optOut.setHealthPlanIdentifierCode(HEALTH_PLAN_IDENTIFIER_CODE_FOR_ABC);
                break;
            case HEALTH_PLAN_OTHERS:
                optOut.setHealthPlanIdentifierCode(HEALTH_PLAN_IDENTIFIER_CODE_FOR_OTHERS);
        }

        // Setting the Gender as 'M' or 'F' respectively.
        if ("Male".equalsIgnoreCase(optOut.getGender())) {
            optOut.setGender("M");
        } else {
            optOut.setGender("F");
        }

        return optOut;
    }

}
