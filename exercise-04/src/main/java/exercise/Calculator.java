package exercise;

import java.nio.channels.Pipe;
import java.util.Arrays;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/3/16.
 */
public class Calculator {
    public static void main(String[] args) {
        CalculatorService calc = new CalculatorService();
        calc.setInput(args);
        System.out.println(calc.getOutput());
    }
}
