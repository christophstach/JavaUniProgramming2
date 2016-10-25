import java.util.Arrays;

/**
 * Klasse zum Erzeugen von Matrizen
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 17.10.2016
 */
public class Matrix {
    private double[][] table;

    /**
     * Erzeugt eine Matrix
     *
     * @param table Eine Tabelle mit Werten die als Matrix dargestellt werden sollen.
     */
    public Matrix(double[][] table) {
        this.setTable(table);
    }

    /**
     * Gibt die der Matrix zugrundeliegende Tabelle zurück
     *
     * @return Die Tabelle ist ein float array
     */
    public double[][] getTable() {
        return table;
    }

    /**
     * Setzt die tabelle der Matrix
     *
     * @param table Ein double array für die Zeilen und Zellen
     */
    public void setTable(double[][] table) {
        if (table.length == 0) {
            throw new IllegalArgumentException("Table can't be empty");
        } else {
            int expectedLength = table[0].length;

            for (double[] row : table) {
                if (row.length != expectedLength) {
                    throw new IllegalArgumentException("All rows of the table needs to have the same length, otherwise it is not a matrix");
                }
            }

            this.table = table;
        }

    }

    /**
     * Gibt die Zeilen Anzahl der Matrix zurück
     *
     * @return Die Anzahl an Zeilen
     */
    public int getRows() {
        return this.table.length;
    }

    /**
     * Gibt die Spalten Anzahl der Matrix zurück
     *
     * @return Die Anzahl an Spalten
     */
    public int getCols() {
        return this.table[0].length;
    }

    /**
     * Vergleicht diese Matrix mit einer anderen Matrix
     *
     * @param m Die zu überprüfende Matrix
     * @return true wenn Matrizen gleich sind sonst false
     */
    public boolean equals(Matrix m) {
        if (this.table.length == m.table.length) {
            for (int i = 0; i < this.table.length; i++) {
                if (this.table[i].length == m.table[i].length) {
                    for (int o = 0; o < this.table[i].length; o++) {
                        if (this.table[i][o] != m.table[i][o]) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    /**
     * Addiert diese Matrix mit einer anderen Matrix und gibt die neue Matrix-Summe zurück
     *
     * @param m Die zu addierende Matrix
     * @return Eine neue Matrix mit der Summe der beien Matritzen
     */
    public Matrix add(Matrix m) {
        if (this.getRows() == m.getRows() && this.getCols() == m.getCols()) {
            double[][] resultTable = new double[this.getCols()][this.getRows()];

            for (int i = 0; i < this.table.length; i++) {
                for (int o = 0; o < this.table[i].length; o++) {
                    resultTable[i][o] = this.table[i][o] + m.table[i][o];
                }
            }

            return new Matrix(resultTable);
        } else {
            throw new IllegalArgumentException("Die Matritzen können nicht addiert werden");
        }
    }

    /**
     * Bildet das Produkt dieser Matrix mit einer anderen Matrix und gibt die Ergebnis-Matrix zurück
     *
     * @param m Die Matrix die rechts drank multipliziert wird
     * @return Die Ergebnismatrix
     */
    public Matrix multiply(Matrix m) {
        if (this.getCols() != m.getRows()) {
            throw new IllegalArgumentException("Diese Matritzen können nicht multipliziert werden");
        } else {
            double[][] resultTable = new double[this.getCols()][this.getRows()];

            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < this.getCols(); j++) {
                    for (int k = 0; k < this.getCols(); k++) {
                        resultTable[i][j] += this.table[i][k] * m.table[k][j];
                    }
                }
            }

            return new Matrix(resultTable);
        }
    }

    /**
     * Bildet das Scalarprodukt mit dieser Matrix und gibt die Ergebnismatrix zurück
     *
     * @param scalar Ein Scalarer Wert
     * @return Die Ergebnismatrix
     */
    public Matrix multiplyScalar(double scalar) {
        double[][] resultTable = new double[this.getCols()][this.getRows()];

        for (int i = 0; i < resultTable.length; i++) {
            for (int o = 0; o < resultTable[i].length; o++) {
                resultTable[i][o] = this.table[i][o] * scalar;
            }
        }

        return new Matrix(resultTable);
    }

    /**
     * Gibt die Matrix als String aus
     *
     * @return Die Darstellung einer Matrix
     */
    @Override
    public String toString() {
        String matrix = "";

        for (double[] row : this.table) {
            matrix += Arrays.toString(row) + "\n";
        }

        return matrix;
    }
}
