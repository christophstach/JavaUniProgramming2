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
 * @since 11/23/16
 */
public class IdentityMatrix extends QuadraticMatrix {
    /**
     * Constructor
     *
     * @param size The size of the IndentityMatrix
     */
    public IdentityMatrix(int size) {
        double[][] elements = new double[size][size];

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                if (i == j) {
                    elements[i][j] = 1;
                } else {
                    elements[i][j] = 0;
                }
            }
        }

        this.setElements(elements);
    }

    /**
     * Transforms the data of the identity matrix to a string
     *
     * @return The identity matrix as a string
     */
    @Override
    public String toString() {
        return "IdentityMatrix{} -> " + super.toString();
    }
}
