import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit-Tests für BitFlags
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 24.10.2016
 */
public class BitFlagsTest {
    private BitFlags bitFlags;

    @Before
    public void setUp() {
        this.bitFlags = new BitFlags(9);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void getSetRawStatus() {
        this.bitFlags.setRawStatus(new boolean[] {true, true, true});
        Assert.assertArrayEquals(new boolean[] {true, true, true}, this.bitFlags.getRawStatus());

        this.bitFlags.setRawStatus(new boolean[] {false, true, true});
        Assert.assertArrayEquals(new boolean[] {false, true, true}, this.bitFlags.getRawStatus());

        this.bitFlags.setRawStatus(new boolean[] {false});
        Assert.assertArrayEquals(new boolean[] {false}, this.bitFlags.getRawStatus());
    }

    @Test
    public void getSetStatus() {
        for(int i = 0; i <= 100; i++) {
            this.bitFlags.setStatus(i);
            Assert.assertEquals(i, this.bitFlags.getStatus());
        }
    }

    public void switchOn() {

    }

    public void switchOff() {

    }

    public void swap() {

    }

    public boolean isSet() {
        return true;
    }

}
