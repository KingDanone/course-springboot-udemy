package br.com.KingDanone.controllers;


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

    //Soma
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public ResponseEntity<Double> sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        return ResponseEntity.ok(mathService.sum(numberOne, numberTwo));
    }
    //Subtração
    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public ResponseEntity<Double> sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        return  ResponseEntity.ok(mathService.sub(numberOne, numberTwo));
    }
    //Multiplicação
    @RequestMapping("/multi/{numberOne}/{numberTwo}")
    public ResponseEntity<Double> multi(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        return  ResponseEntity.ok(mathService.multi(numberOne, numberTwo));
    }
    //Divisão
    @RequestMapping("/divi/{numberOne}/{numberTwo}")
    public ResponseEntity<Double> divi(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        return  ResponseEntity.ok(mathService.divide(numberOne, numberTwo));
    }
    //Raiz Quadrada
    @RequestMapping("/squartroot/{numberOne}")
    public ResponseEntity<Double> squartRoot(
            @PathVariable("numberOne") String numberOne
    ) throws Exception{
        return  ResponseEntity.ok(mathService.squareRoot(numberOne));
    }
}
