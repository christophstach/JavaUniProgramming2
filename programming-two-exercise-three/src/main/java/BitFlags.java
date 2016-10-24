import java.util.Arrays;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 24.10.16
 */
public class BitFlags {
    private boolean[] rawStatus;

    /**
     * Konstruktor
     *
     * @param status Eine Bit-Folge als Integer
     */
    public BitFlags(int status) {
        this.setStatus(status);
    }

    public boolean[] getRawStatus() {
        return rawStatus;
    }

    public void setRawStatus(boolean[] rawStatus) {
        this.rawStatus = rawStatus;
    }

    public int getStatus() {
        int status = 0;

        for (int i = 0; i < this.rawStatus.length; i++) {
            status += this.rawStatus[i] ? Math.pow(2, this.rawStatus.length - 1 - i) : 0;
        }

        return status;
    }

    public void setStatus(int status) {
        if (status == 0) {
            this.rawStatus = new boolean[1];
        } else {
            this.rawStatus = new boolean[((int) Math.ceil(Math.log(status + 1) / Math.log(2)))];
        }

        for (int i = 0; i < this.rawStatus.length; i++) {
            this.rawStatus[this.rawStatus.length - 1 - i] = ((status >> i) & 1) == 1;
        }
    }

    public void switchOn(int index) {

    }

    public void switchOff(int index) {

    }

    public void swap(int index) {

    }

    public boolean isSet(int index) {
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.rawStatus);
        /*String string = "";

        for (boolean bit : this.rawStatus) {
            string += bit ? "1" : "0";
        }

        return string;*/
    }
}
