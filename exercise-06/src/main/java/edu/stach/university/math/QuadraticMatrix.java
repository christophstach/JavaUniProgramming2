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

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @version 1.0.0
 * @since 11/19/16
 */
public class QuadraticMatrix extends Matrix {
    /**
     * Constructor sets the elements
     *
     * @param elements The elements for the matrix
     * @throws IllegalArgumentException Is thrown if the row count is unequal to the column count
     */
    public QuadraticMatrix(double[][] elements) {
        super(elements);

        if (this.getCols() != this.getRows()) {
            throw new IllegalArgumentException("Row count must be the same like column count in a quadratic matrix");
        }
    }

    /**
     * Setter for elements
     *
     * @param elements A double array for rows and columns
     * @throws IllegalArgumentException Is thrown if the row count is unequal the column count
     */
    @Override
    public void setElements(double[][] elements) {
        super.setElements(elements);

        if (this.getCols() != this.getRows()) {
            throw new IllegalArgumentException("Row count must be the same like column count in a quadratic matrix");
        }
    }

    /**
     * Multiplies the matrix n-times with itself
     *
     * @param exponent The number of multiplications
     * @return The resulting matrix
     * @throws IllegalArgumentException Is thrown if the exponent is less than 0
     */
    public Matrix pow(int exponent) {
        if (exponent > 0) {
            Matrix result = new Matrix(this.getElements());

            for (int i = 1; i < exponent; i++) {
                result = result.multiply(this);
            }

            return result;
        } else if (exponent == 0) {
            double[][] elements = new double[this.getRows()][this.getCols()];

            for (int i = 0; i < elements.length; i++) {
                for (int j = 0; j < elements[i].length; j++) {
                    if (i == j) {
                        elements[i][j] = 1;
                    } else {
                        elements[i][j] = 0;
                    }
                }
            }

            return new Matrix(elements);
        } else {
            throw new IllegalArgumentException("Exponents < 0 are not allowed");
        }
    }

    /**
     * Transforms the data of the quadratic matrix to a string
     *
     * @return The quadratic matrix as a string
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
