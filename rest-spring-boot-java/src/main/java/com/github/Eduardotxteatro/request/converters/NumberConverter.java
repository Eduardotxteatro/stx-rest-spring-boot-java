package com.github.Eduardotxteatro.request.converters;

import com.github.Eduardotxteatro.exception.UnsuportedMathOperationException;

public class NumberConverter {


    public static double convertToDouble(String strNumber) throws IllegalArgumentException {

        if(strNumber == null || strNumber.isEmpty()) 
            throw new UnsuportedMathOperationException("Please set a numeric value!"); 
        String number = strNumber.replaceAll(",", ".");

        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
