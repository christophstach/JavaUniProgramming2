/**
 * @author s0555912@htw-berlin.de<Christoph Stach>
 * @since 09.10.2016
 */
public class Vektor {
    private int dimension;
    private float[] komponenten;
    private boolean istZeilenvektor = true;

    /**
     * Konstruktor
     *
     * @param komponenten
     * @param istZeilenvektor
     */
    public Vektor(float[] komponenten, boolean istZeilenvektor) {
        this.komponenten = komponenten;
        this.dimension = this.komponenten.length;
        this.istZeilenvektor = istZeilenvektor;
    }

    /**
     * Konstruktor
     *
     * @param komponenten
     */
    public Vektor(float[] komponenten) {
        this.komponenten = komponenten;
        this.dimension = this.komponenten.length;
    }

    /**
     * Getter
     *
     * @return
     */
    public int getDimension() {
        return dimension;
    }

    /**
     * Getter
     *
     * @return
     */
    public float[] getKomponenten() {
        return komponenten;
    }

    /**
     * Setter
     *
     * @param komponenten
     */
    public void setKomponenten(float[] komponenten) {
        this.komponenten = komponenten;
        this.dimension = this.komponenten.length;
    }

    /**
     * Getter
     *
     * @return
     */
    public boolean getIstZeilenvektor() {
        return istZeilenvektor;
    }

    /**
     * Setter
     *
     * @param istZeilenvektor
     */
    public void setIstZeilenvektor(boolean istZeilenvektor) {
        this.istZeilenvektor = istZeilenvektor;
    }

    /**
     * Macht aus einem Zeilenvektor einen Spaltenvektor und anders herum.
     */
    public void transponiere() {
        this.istZeilenvektor = !this.istZeilenvektor;
    }

    /**
     * Bildet das Skalarprodukt mit einem fremden Vektor
     *
     * @param v
     * @return
     */
    public float skalarProdukt(Vektor v) {
        float skalarProdukt = 0;

        if(this.getDimension() != v.getDimension()) {
            throw new RuntimeException("Die Vektoren haben unterschiedliche Dimensionen und es kann somit kein Skalarprodukt gebildet werden.");
        }

        for(int i = 0; i < this.komponenten.length ; i++) {
            skalarProdukt += this.komponenten[i] * v.komponenten[i];
        }

        return skalarProdukt;
    }

    /**
     * toString()
     *
     * @return
     */
    @Override
    public String toString() {
        String rStr = "";
        if(this.istZeilenvektor) {
            rStr += "Zeilenvektor (" + this.dimension + ") \n";
            rStr += "---\n";

            for (float element : this.komponenten) {
                rStr += element + "\n";
            }

            rStr += "---";
        } else {
            rStr = "Spaltenvektor (" + this.dimension + ") \n";
            rStr += "(|";

            for (float element : this.komponenten) {
                rStr += element +  "|";
            }

            rStr += ")";
        }

        return rStr;
    }
}
