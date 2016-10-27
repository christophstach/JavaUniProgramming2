package exercise;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 24.10.2016
 */
public class Main {
    /**
     * @param args CMD arguments
     */
    public static void main(String[] args) {
        for(int i = -16; i <= 16; i++) {
            System.out.println("i:                      " + i);
            System.out.println("Integer.toBinaryString: " + Integer.toBinaryString(i));
            System.out.println("Binary.inBinary:        " + Binary.inBinary(i));
            System.out.println();
        }
    }
}
