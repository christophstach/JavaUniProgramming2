/**
 * @author s0555912@htw-berlin.de<Christoph Stach>
 * @since 09.10.2016
 */
public class ArrayElement {

    /**
     * Als erstes alle Werte im Array gezählt und in zwei neue Arrays gespeichert.
     * counterKey sind die Werte im Array
     * counterValues sind die Anzahl der Werte
     *
     * Danach werden nur die Werte mit der höchsten Anzahl in das Array res übernommen.
     *
     * @param arr
     * @return
     */
    public static byte[] haeufigstesElement(byte[] arr) {
        byte[] counterKeys = new byte[0];
        int[] counterValues = new int[0];
        byte[] res = new byte[0];

        for (byte element : arr) {
            if(!ArrayUtils.valueExists(counterKeys, element)) {
                counterKeys = ArrayUtils.addToArray(counterKeys, element);
                counterValues = ArrayUtils.addToArray(counterValues, 0);
            }

            int index = ArrayUtils.findFirstIndexByValue(counterKeys, element);
            counterValues[index]++;
        }

        int max = ArrayUtils.max(counterValues);

        for (int i = 0; i < counterValues.length; i++) {
            if(counterValues[i] == max) {
                res = ArrayUtils.addToArray(res, counterKeys[i]);
            }
        }

        return res;
    }

}
