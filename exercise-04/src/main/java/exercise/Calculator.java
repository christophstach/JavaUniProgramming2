package exercise;

/**
 * Taschenrechner der von der CMD augerufen wird.
 * Aufruf: zahl1 [add|sub|mul|div] zahl2
 * Behandelt auf Fehler wie z.B. Division durch 0.
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/3/16.
 */
public class Calculator {
    public static void main(String[] args) {
        if(args.length == 3) {
            String output;

            try {
                double a = Double.parseDouble(args[0]);
                double b = Double.parseDouble(args[2]);

                switch (args[1]) {
                    case "add":
                        output = String.format("%.2f", a) +
                            " add " + String.format("%.2f", b) +
                            " ist " + String.format("%.2f", (a + b));
                        break;

                    case "sub":
                        output = String.format("%.2f", a) +
                            " sub " + String.format("%.2f", b) +
                            " ist " + String.format("%.2f", (a - b));
                        break;

                    case "mul":
                        output = String.format("%.2f", a) +
                            " mul " + String.format("%.2f", b) +
                            " ist " + String.format("%.2f", (a * b));
                        break;

                    case "div":
                        if (b != 0) {
                            output = String.format("%.2f", a) +
                                " div " + String.format("%.2f", b) +
                                " ist " + String.format("%.2f", (a / b));
                        } else {
                            output = "Division durch 0 ist nicht moeglich";
                        }

                        break;

                    default:
                        output = args[1] + " ist keine gueltige Rechenoperation";
                }
            } catch (NumberFormatException exception) {
                output = "Bitte geben Sie gueltige Nummern ein";
            }

            System.out.println(output);
        } else {
            System.out.println("Falsche Anzahl an Argumenten");
        }
    }
}
