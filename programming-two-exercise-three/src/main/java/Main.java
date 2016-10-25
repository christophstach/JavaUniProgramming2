/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 24.10.2016
 */
public class Main {
    /**
     * @param args CMD arguments
     */
    public static void main(String[] args) {
        BitFlags bitFlags = new BitFlags(1);
        bitFlags.swap(5);
        bitFlags.swap(3);
        bitFlags.swap(5);

        System.out.println(bitFlags);
        System.out.println("-----------------------------");
        for(int i = 0; i <= 16; i++) {
            System.out.println(i + ": " + Binary.inBinary(i));
        }
    }
}
