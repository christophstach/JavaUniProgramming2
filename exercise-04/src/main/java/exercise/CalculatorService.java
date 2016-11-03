package exercise;

/**
 * Rechnet mit Werten aus einem String. Kann somit direkt  mit den args der Main-Methode aufgerufen werden.
 * Rundet alle Ergebnisse auf zwei Nachkommastellen.
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/3/16.
 */
public class CalculatorService {
    private String output;

    /**
     * Addiert 2 Werte
     *
     * @param a 1. Wert
     * @param b 2. Wert
     * @return Ergebnis der Addition
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtrahiert 2 Werte
     *
     * @param a 1. Wert
     * @param b 2. Wert
     * @return Ergebnis der Subtraktion
     */
    public double sub(double a, double b) {
        return a - b;
    }

    /**
     * Multipliziert 2 Werte
     *
     * @param a 1. Wert
     * @param b 2. Wert
     * @return Ergebnis der Multiplikation
     */
    public double mul(double a, double b) {
        return a * b;
    }

    /**
     * Dividiert 2 Werte
     *
     * @param a 1. Wert
     * @param b 2. Wert
     * @return Ergebnis der Division
     */
    public double div(double a, double b) {
        return a / b;
    }

    /**
     * Gibt werte in den Input und rechnet mit diesen Werten
     *
     * @param args Array von der Laenge 3 | 1. Wert - Operation - 2. Wert |
     */
    public void setInput(String[] args) {
        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[2]);

            switch (args[1]) {
                case "add":
                    this.output = String.format("%.2f", a) +
                        " add " + String.format("%.2f", b) +
                        " ist " + String.format("%.2f", this.add(a, b));
                    break;

                case "sub":
                    this.output = String.format("%.2f", a) +
                        " sub " + String.format("%.2f", b) +
                        " ist " + String.format("%.2f", this.sub(a, b));
                    break;

                case "mul":
                    this.output = String.format("%.2f", a) +
                        " mul " + String.format("%.2f", b) +
                        " ist " + String.format("%.2f", this.mul(a, b));
                    break;

                case "div":
                    if (b != 0) {
                        this.output = String.format("%.2f", a) +
                            " div " + String.format("%.2f", b) +
                            " ist " + String.format("%.2f", this.div(a, b));
                    } else {
                        this.output = "Division durch 0 ist nicht moeglich";
                    }

                    break;

                default:
                    this.output = args[1] + " ist keine gueltige Rechenoperation";
            }
        } catch (NumberFormatException exception) {
            this.output = "Bitte geben Sie gueltige Nummern ein";
        }
    }

    /**
     * Gibt den Output des Services zurueck
     *
     * @return Output
     */
    public String getOutput() {
        return this.output;
    }
}
