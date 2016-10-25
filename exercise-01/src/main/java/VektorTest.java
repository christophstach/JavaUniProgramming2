/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 09.10.2016
 */
public class VektorTest {
    public static void main(String[] args) {
        Vektor v1 = new Vektor(new float[] {2f, 3f, 4f, 10f});
        Vektor v2 = new Vektor(new float[] {5f, 6f, 7f, 9f});

        System.out.println(v1);
        v1.transponiere();
        System.out.println(v1);
        System.out.printf("Skalarprodukt von v1 und v2 = " + v1.skalarProdukt(v2));
    }
}
