import java.util.Arrays;

/**
 * @author s0555912@htw-berlin.de<Christoph Stach>
 * @since 17.10.2016
 */
public class Matrix {
    private double[][] table;
    private int rows;
    private int cols;

    /**
     * Erzeugt eine Matrix
     *
     * @param table Eine Tabelle mit Werten die als Matrix dargestellt werden sollen.
     */
    public Matrix(double[][] table) {
        this.setTable(table);

        this.rows = table.length;
        this.cols = table[0].length;
    }

    /**
     * @return
     */
    public double[][] getTable() {
        return table;
    }

    /**
     * @param table
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
     * @return
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return
     */
    public int getCols() {
        return cols;
    }

    /**
     * Vergleicht diese Matrix mit einer anderen Matrix
     *
     * @param m
     * @return
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
     * @param m
     * @return
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
     * @param m
     * @return
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
     * Bildet das Scalarprodukt mit dieser Matrix und gibt die Ergebnis-Matrix zurück
     *
     * @param scalar
     * @return
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
     * @return
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
