/**
 * Klasse zum Arbeiten mit Bin&auml;r Zahlen
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 25.10.16
 */
public class Binary {
    /**
     * Wandelt eine Zahl in einen String in der Bin&auml;rdarstellung um
     *
     * @param value Die integer Zahl die umgewandelt werden soll
     * @return Die Darstellung als Bin&auml;r-Zahl
     */
    public static String inBinary(int value) {
        if (value == 0) {
            return "0";
        } else if (value > 0) {
            String result = "";

            for (int i = 0; i < Math.ceil(Math.log(value + 1) / Math.log(2)); i++) {
                result = ((value >> i) & 1) + result;
            }

            return result;
        } else {
            throw new IllegalArgumentException("Negative Zahlen werden nicht unterstützt");
        }
    }
}
