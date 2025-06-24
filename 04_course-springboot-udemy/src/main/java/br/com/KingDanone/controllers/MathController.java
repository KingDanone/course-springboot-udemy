package br.com.KingDanone.controllers;


import br.com.KingDanone.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if (isNumeric(numberOne) || isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!!");
        return convertDouble(numberOne) + convertDouble(numberTwo);
    }

    private Double convertDouble(String strNumber) throws IllegalArgumentException{
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return true;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+]");
    }
}
