/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.stach.university.math;

import java.util.Arrays;

/**
 * Klasse zum Erzeugen von Matrizen
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 17.10.2016
 */
public class Matrix {
    private double[][] elements;

    /**
     * Erzeugt eine Matrix
     *
     * @param elements Eine Tabelle mit Werten die als Matrix dargestellt werden sollen.
     */
    public Matrix(double[][] elements) {
        this.setElements(elements);
    }

    /**
     * Gibt die der Matrix zugrundeliegende Tabelle zurück
     *
     * @return Die Tabelle ist ein double array
     */
    public double[][] getElements() {
        return elements;
    }

    /**
     * Setzt die tabelle der Matrix
     *
     * @param elements Ein double array für die Zeilen und Zellen
     */
    public void setElements(double[][] elements) {
        if (elements.length == 0) {
            throw new IllegalArgumentException("Table can't be empty");
        } else {
            int expectedLength = elements[0].length;

            for (double[] row : elements) {
                if (row.length != expectedLength) {
                    throw new IllegalArgumentException("All rows of the elements needs to have the same length, otherwise it is not a matrix");
                }
            }

            this.elements = elements;
        }

    }

    /**
     * Gibt die Zeilen Anzahl der Matrix zurück
     *
     * @return Die Anzahl an Zeilen
     */
    public int getRows() {
        return this.elements.length;
    }

    /**
     * Gibt die Spalten Anzahl der Matrix zurück
     *
     * @return Die Anzahl an Spalten
     */
    public int getCols() {
        return this.elements[0].length;
    }

    /**
     * Vergleicht diese Matrix mit einer anderen Matrix
     *
     * @param m Die zu überprüfende Matrix
     * @return true wenn Matrizen gleich sind sonst false
     */
    public boolean equals(Matrix m) {
        if (this.elements.length == m.elements.length) {
            for (int i = 0; i < this.elements.length; i++) {
                if (this.elements[i].length == m.elements[i].length) {
                    for (int o = 0; o < this.elements[i].length; o++) {
                        if (this.elements[i][o] != m.elements[i][o]) {
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

            for (int i = 0; i < this.elements.length; i++) {
                for (int o = 0; o < this.elements[i].length; o++) {
                    resultTable[i][o] = this.elements[i][o] + m.elements[i][o];
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
                        resultTable[i][j] += this.elements[i][k] * m.elements[k][j];
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
                resultTable[i][o] = this.elements[i][o] * scalar;
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

        for (double[] row : this.elements) {
            matrix += Arrays.toString(row) + "\n";
        }

        return matrix;
    }
}
