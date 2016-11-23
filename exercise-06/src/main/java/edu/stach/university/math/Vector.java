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
public class Vector extends Matrix {
    /**
     * Cunstructor transforms array to 2-dimensional array
     *
     * @param elements The input array
     */
    public Vector(double... elements) {
        super(new double[][]{elements});
    }


    /**
     * Calculates the length of the vector
     *
     * @return The length of the vector
     */
    public double length() {
        double sum = 0;

        for (double value : this.getElements()[0]) {
            sum += value * value;
        }

        return Math.sqrt(sum);
    }

    /**
     * Transforms the vector data to a string
     *
     * @return The vector as a string
     */
    @Override
    public String toString() {
        return "Vector{} -> " + super.toString();
    }
}
