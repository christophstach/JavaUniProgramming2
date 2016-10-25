/**
 * Zusatzklasse für Arrays mit einigen nützlichen Funktionen
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 24.06.2016
 */
public class ArrayUtils {
    /**
     * Gibt ein Int-Array formatiert aus.
     *
     * @param padding
     * @return
     */
    public static String arrayToPaddedString(int[] arr, int padding) {
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            str += String.format("%1$-" + padding + "d", arr[i]);
        }

        return str;
    }

    /**
     * Gibt ein Float-Array formatiert aus.
     *
     * @param padding
     * @return
     */
    public static String arrayToPaddedString(float[] arr, int padding) {
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            str += String.format("%1$-" + padding + "f", arr[i]);
        }

        return str;
    }

    /**
     * Gibt ein Double-Array formatiert aus.
     *
     * @param padding
     * @return
     */
    public static String arrayToPaddedString(double[] arr, int padding) {
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            str += String.format("%1$-" + padding + "f", arr[i]);
        }

        return str;
    }

    /**
     * Gibt ein Int-Array wie Arrays.toString() aus.
     *
     * @param arr
     * @return
     */
    public static String arrayToString(int[] arr) {
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                str = "[" + arr[i] + ", ";
            } else if (i == arr.length - 1) {
                str += arr[i] + "]";
            } else {
                str += arr[i] + ", ";
            }
        }

        return str;
    }

    /**
     * Gibt ein Float-Array wie Arrays.toString() aus.
     *
     * @param arr
     * @return
     */
    public static String arrayToString(float[] arr) {
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                str = "[" + arr[i] + ", ";
            } else if (i == arr.length - 1) {
                str += arr[i] + "]";
            } else {
                str += arr[i] + ", ";
            }
        }

        return str;
    }

    /**
     * Gibt ein String-Array wie Arrays.toString() aus.
     *
     * @param arr
     * @return
     */
    public static String arrayToString(double[] arr) {
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                str = "[" + arr[i] + ", ";
            } else if (i == arr.length - 1) {
                str += arr[i] + "]";
            } else {
                str += arr[i] + ", ";
            }
        }

        return str;
    }

    /**
     * Fügt einem Int-Array einen neuen Wert hinzu in dem eine Kopie des Arrays erzeugt wird die von der Länge um 1 größer
     * ist als das alte Arrays erzeugt.
     *
     * @param arr
     * @param value
     * @return
     */
    public static int[] addToArray(int[] arr, int value) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = value;

        return newArr;
    }

    /**
     * Fügt einem Double-Array einen neuen Wert hinzu in dem eine Kopie des Arrays erzeugt wird die von der Länge um 1 größer
     * ist als das alte Arrays erzeugt.
     *
     * @param arr
     * @param value
     * @return
     */
    public static double[] addToArray(double[] arr, double value) {
        double[] newArr = new double[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = value;

        return newArr;
    }

    /**
     * Fügt einem Float-Array einen neuen Wert hinzu in dem eine Kopie des Arrays erzeugt wird die von der Länge um 1 größer
     * ist als das alte Arrays erzeugt.
     *
     * @param arr
     * @param value
     * @return
     */
    public static float[] addToArray(float[] arr, float value) {
        float[] newArr = new float[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = value;

        return newArr;
    }

    /**
     * Fügt einem String-Array einen neuen Wert hinzu in dem eine Kopie des Arrays erzeugt wird die von der Länge um 1 größer
     * ist als das alte Arrays erzeugt.
     *
     * @param arr
     * @param value
     * @return
     */
    public static String[] addToArray(String[] arr, String value) {
        String[] newArr = new String[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = value;

        return newArr;
    }

    /**
     * Fügt einem byte-Array einen neuen Wert hinzu in dem eine Kopie des Arrays erzeugt wird die von der Länge um 1 größer
     * ist als das alte Arrays erzeugt.
     *
     * @param arr
     * @param value
     * @return
     */
    public static byte[] addToArray(byte[] arr, byte value) {
        byte[] newArr = new byte[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = value;

        return newArr;
    }

    /**
     * Überprüft ob eine Wert im Array existiert
     *
     * @param arr
     * @param value
     * @return
     */
    public static boolean valueExists(byte[] arr, byte value) {
        boolean exists = false;

        for (byte element : arr) {
            if (element == value) {
                exists = true;
                break;
            }
        }

        return exists;
    }

    /**
     * Findet den ersten Wert im Array und gibt den entsprechenden Index zurück
     *
     * @param arr
     * @param value
     * @return
     */
    public static int findFirstIndexByValue(byte[] arr, byte value) {
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                res = i;
                break;
            }
        }

        return res;
    }

    /**
     * Gibt den höchsten Wert aus einem Array zurück
     *
     * @param arr
     * @return
     */
    public static int max(int[] arr) {
        int max = arr[0];
        for (int element : arr) {
            if (max < element) {
                max = element;
            }
        }

        return max;
    }
}
