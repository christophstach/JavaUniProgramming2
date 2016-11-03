package exercise;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/3/16.
 */
public class CalculatorTest {
    public static void main(String[] args) {
        String[][] testCases = new String[][]{
            //Add
            new String[]{"1", "add", "2"},
            new String[]{"-1", "add", "2"},
            new String[]{"1", "add", "-2"},
            new String[]{"2.5", "add", "2.3"},

            //Sub
            new String[]{"1", "sub", "2"},
            new String[]{"-1", "sub", "2"},
            new String[]{"1", "sub", "-2"},
            new String[]{"2.5", "sub", "2.3"},

            //Mul
            new String[]{"1", "mul", "2"},
            new String[]{"-1", "mul", "2"},
            new String[]{"1", "mul", "-2"},
            new String[]{"2.5", "mul", "2.3"},

            //Div
            new String[]{"1", "div", "2"},
            new String[]{"-1", "div", "2"},
            new String[]{"1", "div", "-2"},
            new String[]{"2.5", "div", "2.3"},

            //Errors
            new String[]{"1,2", "add", "2"},
            new String[]{"1", "add", "2,2"},
            new String[]{"1", "div", "0"}
        };

        for (int i = 0; i < testCases.length; i++) {
            Calculator.main(testCases[i]);
        }
    }
}
