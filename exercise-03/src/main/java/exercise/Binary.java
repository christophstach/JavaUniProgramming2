package exercise;

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
        String result = "";
        boolean firstOneFound = false;
        BitFlags bitFlags = new BitFlags(value);

        for (int i = 31; i >= 0; i--) {
            firstOneFound = firstOneFound ? firstOneFound : bitFlags.isSet(i);

            if (firstOneFound) {
                result += bitFlags.isSet(i) ? "1" : "0";
            }
        }

        return result;

    }
}
