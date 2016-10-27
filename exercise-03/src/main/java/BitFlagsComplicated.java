/**
 * Eine Klasse zum Arbeiten mit BitFlags
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 24.10.16
 */
public class BitFlagsComplicated {
    private boolean[] rawStatus;

    /**
     * Konstruktor
     *
     * @param status Eine Bit-Folge als Integer
     */
    public BitFlagsComplicated(int status) {
        this.setStatus(status);
    }

    /**
     * Gibt den rohen Status zur&uuml;
     *
     * @return Ein Boolean array was eine Bin&auml;rdarstellung repr&auml;sentiert
     */
    public boolean[] getRawStatus() {
        return rawStatus;
    }

    /**
     * Setzt den rohen Status
     *
     * @param rawStatus Ein Boolean array was eine Bin&auml;rdarstellung repr&auml;sentiert
     */
    public void setRawStatus(boolean[] rawStatus) {
        this.rawStatus = rawStatus;
    }

    /**
     * Gibt den Status als Integer Wert zu&uuml;ck
     *
     * @return Der Status als Integer Wert
     */
    public int getStatus() {
        int status = 0;

        for (int i = 0; i < this.rawStatus.length; i++) {
            status += this.rawStatus[i] ? Math.pow(2, this.rawStatus.length - 1 - i) : 0;
        }

        return status;
    }

    /**
     * Gibt den Status zur&uuml;
     *
     * @param status Der Status als Integer Wert
     */
    public void setStatus(int status) {
        if (status >= 0) {
            if (status == 0) {
                this.rawStatus = new boolean[1];
            } else {
                this.rawStatus = new boolean[((int) Math.ceil(Math.log(status + 1) / Math.log(2)))];
            }

            for (int i = 0; i < this.rawStatus.length; i++) {
                this.rawStatus[this.rawStatus.length - 1 - i] = ((status >> i) & 1) == 1;
            }
        } else {
            throw new IllegalArgumentException("Negative Zahlen werden nicht unterstützt");
        }
    }

    /**
     * Setzt ein Bit an der gew&auml;hlten Stelle auf 1
     *
     * @param index Die Stelle
     */
    public void switchOn(int index) {
        if (index >= 0) {
            try {
                this.rawStatus[this.rawStatus.length - 1 - index] = true;
            } catch (IndexOutOfBoundsException exception) {
                this.prepareRaw(index);
                this.rawStatus[0] = true;
            }
        } else {
            throw new IllegalArgumentException("Es existieren keine negativen Indizes");
        }
    }

    /**
     * Setzt ein Bit an der gew&auml;hlten Stelle auf 0
     *
     * @param index Die Stelle
     */
    public void switchOff(int index) {
        if (index >= 0) {
            try {
                this.rawStatus[this.rawStatus.length - 1 - index] = false;

                if (!this.rawStatus[0]) {
                    this.cleanRaw();
                }
            } catch (ArrayIndexOutOfBoundsException exception) {

            }
        } else {
            throw new IllegalArgumentException("Es existieren keine negativen Indizes");
        }
    }

    /**
     * Negiert ein Bit an der gew&auml;hlten Stelle
     *
     * @param index Die Stelle
     */
    public void swap(int index) {
        if (index >= 0) {
            try {
                this.rawStatus[this.rawStatus.length - 1 - index] = !this.rawStatus[this.rawStatus.length - 1 - index];

                if (!this.rawStatus[0]) {
                    this.cleanRaw();
                }
            } catch (IndexOutOfBoundsException exception) {
                this.prepareRaw(index);
                this.rawStatus[0] = true;
            }
        } else {
            throw new IllegalArgumentException("Es existieren keine negativen Indizes");
        }
    }

    /**
     * Bereitet das rawStatus Array darauf vor mehr eintr&auml;ge Speichern zu k&ouml;nnen
     *
     * @param index Bis zu diesem index wird das Array erweitert
     */
    private void prepareRaw(int index) {
        boolean[] tempRaw = new boolean[index + 1];

        for (int i = 0; i < this.rawStatus.length; i++) {
            tempRaw[tempRaw.length - 1 - i] = this.rawStatus[this.rawStatus.length - 1 - i];
        }

        this.rawStatus = tempRaw;
    }

    /**
     * L&ouml;scht &uuml;berfl&uuml;ssige Array Eintr&aauml;ge aus dem rawStatus Array
     */
    private void cleanRaw() {
        int positionOfFirstTrue = 0;
        boolean[] tempStatus;

        for (int i = 0; i < this.rawStatus.length; i++) {
            if (this.rawStatus[i]) {
                positionOfFirstTrue = i;
                break;
            }
        }

        tempStatus = new boolean[this.rawStatus.length - positionOfFirstTrue];

        for (int i = 0; i < tempStatus.length; i++) {
            tempStatus[tempStatus.length - 1 - i] = this.rawStatus[this.rawStatus.length - 1 - i];
        }

        this.rawStatus = tempStatus;
    }

    /**
     * &Uuml;berpr&uuml; ob ein Bit an der gew&auml;hlten Stelle gesetzt ist
     *
     * @param index Die Stelle
     * @return true wenn 1 und false wenn 0
     */
    public boolean isSet(int index) {
        if (index >= 0) {
            try {
                return this.rawStatus[index];
            } catch (IndexOutOfBoundsException exception) {
                return false;
            }
        } else {
            throw new IllegalArgumentException("Es existieren keine negativen Indizes");
        }
    }

    /**
     * Gibt die BitFlags als String zur&uuml;ck
     *
     * @return BitFlags als String
     */
    @Override
    public String toString() {
        String string = "";

        for (boolean bit : this.rawStatus) {
            string += bit ? "1" : "0";
        }

        return string;
    }
}
