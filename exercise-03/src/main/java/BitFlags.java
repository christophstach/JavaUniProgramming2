import java.util.Arrays;

/**
 * Eine Klasse zum Arbeiten mit BitFlags
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 24.10.16
 */
public class BitFlags {
    private int status;

    /**
     * Konstruktor
     *
     * @param status Eine Bit-Folge als Integer
     */
    public BitFlags(int status) {
        this.setStatus(status);
    }


    /**
     * Gibt den Status als Integer Wert zu&uuml;ck
     *
     * @return Der Status als Integer Wert
     */
    public int getStatus() {
        return this.status;
    }

    /**
     * Gibt den Status zur&uuml;
     *
     * @param status Der Status als Integer Wert
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Setzt ein Bit an der gew&auml;hlten Stelle auf 1
     *
     * @param index Die Stelle
     */
    public void switchOn(int index) {
        if(index >= 0 && index <=  31) {
            this.status |= 1 << index;
        } else {
            throw new IllegalArgumentException("Nur Zahlen zwischen 0 und 31 sind erlaubt um innerhalb des Wertebereichs vom Integer zu bleiben");
        }
    }

    /**
     * Setzt ein Bit an der gew&auml;hlten Stelle auf 0
     *
     * @param index Die Stelle
     */
    public void switchOff(int index) {
        if(index >= 0 && index <=  31) {
            this.status &= ~(1 << index);
        } else {
            throw new IllegalArgumentException("Nur Zahlen zwischen 0 und 31 sind erlaubt um innerhalb des Wertebereichs vom Integer zu bleiben");
        }
    }

    /**
     * Negiert ein Bit an der gew&auml;hlten Stelle
     *
     * @param index Die Stelle
     */
    public void swap(int index) {
        if(index >= 0 && index <=  31) {
            this.status ^= 1 << index;
        } else {
            throw new IllegalArgumentException("Nur Zahlen zwischen 0 und 31 sind erlaubt um innerhalb des Wertebereichs vom Integer zu bleiben");
        }
    }


    /**
     * &Uuml;berpr&uuml; ob ein Bit an der gew&auml;hlten Stelle gesetzt ist
     *
     * @param index Die Stelle
     * @return true wenn 1 und false wenn 0
     */
    public boolean isSet(int index) {
        if(index >= 0 && index <=  31) {
            return (this.status & 1 << index) != 0;
        } else {
            throw new IllegalArgumentException("Nur Zahlen zwischen 0 und 31 sind erlaubt um innerhalb des Wertebereichs vom Integer zu bleiben");
        }
    }

    /**
     * Gibt die BitFlags als String zur&uuml;ck
     *
     * @return BitFlags als String
     */
    @Override
    public String toString() {
        return Integer.toBinaryString(this.status);
        //return Binary.inBinary(this.status);
    }
}
