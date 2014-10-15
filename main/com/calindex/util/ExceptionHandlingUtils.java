package com.calindex.util;

import static com.calindex.util.Constants.DEFAULT_NULL_MESSAGE;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.lang3.StringUtils;

/**
 * General Utilities
 * 
 * @author 413643
 */
public class ExceptionHandlingUtils {

    /**
     * Checks if the input object is null or blank in case the object is a string.
     * If it is a Blank then an Exception is thrown!
     * 
     * @param notNullableObject
     *            - an object which has to be checked for null
     * @param objectVariableName
     *            - meaningful variable name of the object for logging
     * @throws Exception
     **/
    public static void handleNullValues(Object notNullableObject, String objectVariableName) throws Exception {
        String errorMessage = objectVariableName;

        if (StringUtils.isBlank(objectVariableName)) {
            errorMessage = DEFAULT_NULL_MESSAGE;
        } else {
            errorMessage = getErrorMessage(objectVariableName);
        }

        if (notNullableObject == null) throw new Exception(errorMessage);

        if (notNullableObject instanceof String && StringUtils.isBlank(notNullableObject.toString())) {
            throw new Exception(errorMessage);
        }
    }

    public static String getErrorStackAsString(Exception e) {
        StringWriter error = new StringWriter();
        e.printStackTrace(new PrintWriter(error));
        return error.toString();
    }

    private static final String getErrorMessage(String value) {
        return "Unexpected Null/Blank value found for [" + value + "]." + System.lineSeparator() + "This could be due to one of the these reasons:" + System.lineSeparator()
                + "1) Value is not configured in property placeholders." + System.lineSeparator() + "2) Dependency Injection Failed!" + System.lineSeparator()
                + "3) Expected File/Folder doesn't exist!";
    }

}