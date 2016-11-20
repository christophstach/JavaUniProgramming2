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
 * Class for creating matrices
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 17.10.2016
 */
public class Matrix {
    private double[][] elements;

    /**
     * Constructor for a matrix
     *
     * @param elements A double array for rows and columns
     */
    public Matrix(double[][] elements) {
        this.setElements(elements);
    }

    /**
     * Returns the elements of the matrix
     *
     * @return A double array for rows and columns
     */
    public double[][] getElements() {
        return elements;
    }

    /**
     * Setter for the elements of the matrix
     *
     * @param elements A double array for rows and columns
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
     * Returns the rowcount of the matrix
     *
     * @return The row count
     */
    public int getRows() {
        return this.elements.length;
    }

    /**
     * Returns the column count of the matrix
     *
     * @return The column count
     */
    public int getCols() {
        return this.elements[0].length;
    }

    /**
     * Checks if this matrix is equal to another on
     *
     * @param m The matrix which will be checked
     * @return Returns true if they are equal otherwise false
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
     * Adds a matrix to this one
     *
     * @param m The matrix which will be added
     * @return A new matrix containing the result
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
     * Calculates the product of this matrix with another one
     *
     * @param m The matrix which will be multiplied to this one from the right
     * @return The resulting matrix
     */
    public Matrix multiply(Matrix m) {
        if (this.getCols() != m.getRows()) {
            throw new IllegalArgumentException("These matrices can't be multiplied");
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
     * Calculates the scalar product of this matrix with a scalar value
     *
     * @param scalar A scalar value
     * @return The resulting matrix
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
     * Returns the matrix as a string
     *
     * @return The matrix as a string
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
