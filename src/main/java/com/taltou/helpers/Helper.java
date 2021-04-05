package com.taltou.helpers;

import org.jbehave.core.steps.ParameterConverters;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String EMPTY_INPUT = "          ";
    public static final SimpleDateFormat sdf = new SimpleDateFormat(Helper.DATE_FORMAT);
    public static final int START = 0;
    public static final String HEADER = "date       || credit   || debit    || balance";
    public static final DecimalFormat decimalFormat = new DecimalFormat("#.00");


    /**
     * @param theDateString : The date string
     * @return : The return value
     */
    public static Date date(String theDateString) {
        ParameterConverters.DateConverter dateConverter = new ParameterConverters.DateConverter();
        return (Date) dateConverter.convertValue(theDateString, Date.class);
    }
}
