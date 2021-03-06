/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.stach.university;

import edu.stach.university.math.QuadraticMatrix;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/19/16
 */
public class TestQuadraticMatrix {
    /**
     * Entry point for the application
     *
     * @param args Console arguments
     */
    public static void main(String[] args) {
        QuadraticMatrix m = new QuadraticMatrix(new double[][]{
                new double[] {1, 2, 3},
                new double[] {4, 5, 6},
                new double[] {7, 8, 9},
        });

        System.out.println("m.toString(): \n" + m);

        System.out.println("m.pow(0):  \n" + m.pow(0));
        System.out.println("m.pow(1):  \n" + m.pow(1));
        System.out.println("m.pow(2):  \n" + m.pow(2));
        System.out.println("m.pow(3):  \n" + m.pow(3));

    }
}
