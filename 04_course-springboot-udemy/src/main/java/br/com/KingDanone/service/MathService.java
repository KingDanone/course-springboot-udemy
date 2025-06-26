package br.com.KingDanone.service;

import br.com.KingDanone.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter a valid numeric value !");
        return convertDouble(numberOne) + convertDouble(numberTwo);
    }

    public Double sub(String numberOne, String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter a valid numeric value !");
        return convertDouble(numberOne) - convertDouble(numberTwo);
    }

    public Double multi(String numberOne, String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter a valid numeric value !");
        return convertDouble(numberOne) * convertDouble(numberTwo);
    }

    public Double divide(String numberOne, String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter a valid numeric value");
        Double b = convertDouble(numberTwo);
        if (b <= 0) throw new UnsupportedMathOperationException("cannot divide by 0");
        return convertDouble(numberOne) / convertDouble(numberTwo);
    }

    public Double squareRoot(String numberOne) throws Exception {
        if (!isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please enter a valid numeric value");
        if (convertDouble(numberOne) < 0)
            throw new UnsupportedMathOperationException("cannot square root by number < 0 ");
        return Math.sqrt(convertDouble(numberOne));
    }

    public Double media(String numberOne,
                        String numberTwo,
                        String numberThree,
                        String numberFour
    ) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo) || !isNumeric(numberThree) || !isNumeric(numberFour))
            throw new UnsupportedMathOperationException("Please enter a valid numeric value");
        return (convertDouble(numberOne) + convertDouble(numberTwo) + convertDouble(numberThree) + convertDouble(numberFour)) / 4;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertDouble(String strNumber) throws IllegalArgumentException{
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
}
