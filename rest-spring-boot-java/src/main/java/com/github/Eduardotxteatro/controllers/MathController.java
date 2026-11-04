package com.github.Eduardotxteatro.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Eduardotxteatro.exception.UnsuportedMathOperationException;
import com.github.Eduardotxteatro.math.SimpleMath;
import com.github.Eduardotxteatro.request.converters.NumberConverter;

@RestController 
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception{

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsuportedMathOperationException("Please set a numeric value!"); 
            return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        

    }

    // http://localhost:8080/math/subtraction/55/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception{

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsuportedMathOperationException("Please set a numeric value!"); 
            return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        

    }

    // http://localhost:8080/math/division/100/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception{

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsuportedMathOperationException("Please set a numeric value!"); 
            return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        

    }

    // http://localhost:8080/math/squareroot/81
    @RequestMapping("/squareroot/{number}")
    public Double squareRoot(
        @PathVariable("number") String number
    ) throws Exception{

        if(!NumberConverter.isNumeric(number)) 
            throw new UnsuportedMathOperationException("Please set a numeric value!"); 
            return math.squareRoot(NumberConverter.convertToDouble(number));
        

    }

}
