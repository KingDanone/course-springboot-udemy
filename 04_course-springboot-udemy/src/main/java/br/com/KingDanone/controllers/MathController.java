package br.com.KingDanone.controllers;


import br.com.KingDanone.exception.UnsupportedMathOperationException;
import br.com.KingDanone.service.MathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;
    public MathController(MathService mathService) {this.mathService = mathService;}

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public ResponseEntity<Double> sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        return ResponseEntity.ok(mathService.sum(numberOne, numberTwo));
    }

//    private Double convertDouble(String strNumber) throws IllegalArgumentException{
//        if (strNumber == null || strNumber.isEmpty())
//            throw new UnsupportedMathOperationException("Please set a numeric value!!");
//        String number = strNumber.replace(",", ".");
//        return Double.parseDouble(number);
//    }
//
//    private boolean isNumeric(String strNumber) {
//        if (strNumber == null || strNumber.isEmpty()) return true;
//        String number = strNumber.replace(",", ".");
//        return number.matches("[-+]?[0-9]*\\.?[0-9]+]");
//    }
}
