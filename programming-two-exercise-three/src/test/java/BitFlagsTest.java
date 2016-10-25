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
        this.bitFlags.setRawStatus(new boolean[]{true, true, true});
        Assert.assertArrayEquals(new boolean[]{true, true, true}, this.bitFlags.getRawStatus());

        this.bitFlags.setRawStatus(new boolean[]{false, true, true});
        Assert.assertArrayEquals(new boolean[]{false, true, true}, this.bitFlags.getRawStatus());

        this.bitFlags.setRawStatus(new boolean[]{false});
        Assert.assertArrayEquals(new boolean[]{false}, this.bitFlags.getRawStatus());
    }


    @Test
    public void getSetStatus() {
        for (int i = 0; i <= 100; i++) {
            this.bitFlags.setStatus(i);
            Assert.assertEquals(i, this.bitFlags.getStatus());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setStatusExceptionOnNegativeNumber() {
        this.bitFlags.setStatus(-10);
    }

    @Test
    public void switchOn() {
        this.bitFlags.switchOn(1);
        this.bitFlags.switchOn(2);
        Assert.assertEquals(15, this.bitFlags.getStatus());

        this.bitFlags.switchOn(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void switchOnExceptionOnWrongIndex() {
        this.bitFlags.switchOn(-1);
    }

    @Test
    public void switchOff() {
        this.bitFlags.switchOff(3);
        Assert.assertEquals(1, this.bitFlags.getStatus());

        this.bitFlags.switchOff(5);
        Assert.assertEquals(1, this.bitFlags.getStatus());

        this.bitFlags.switchOff(0);
        Assert.assertEquals(0, this.bitFlags.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void switchOffExceptionOnWrongIndex() {
        this.bitFlags.switchOff(-1);
    }

    @Test
    public void swap() {
        this.bitFlags.swap(1);
        this.bitFlags.swap(2);
        Assert.assertEquals(15, this.bitFlags.getStatus());

        this.bitFlags.swap(5);
        Assert.assertEquals(47, this.bitFlags.getStatus());
        this.bitFlags.swap(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void swapExceptionOnWrongIndex() {
        this.bitFlags.swap(-1);
    }

    @Test
    public void isSet() {
        Assert.assertTrue(this.bitFlags.isSet(0));
        Assert.assertFalse(this.bitFlags.isSet(1));
        Assert.assertFalse(this.bitFlags.isSet(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSetOnExceptionOnWrongIndex() {
        this.bitFlags.isSet(-1);
    }

}
