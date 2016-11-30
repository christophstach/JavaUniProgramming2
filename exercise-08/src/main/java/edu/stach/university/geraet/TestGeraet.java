/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.stach.university.geraet;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/29/16
 */
public class TestGeraet {
    /**
     * Entry point for the application
     *
     * @param args Console arguments
     */
    public static void main(String[] args) {
        LaserDrucker l1 = new LaserDrucker();
        LaserDrucker l2 = new LaserDrucker();
        FaxGeraet f1 = new FaxGeraet();
        FaxGeraet f2 = new FaxGeraet();
        KombiGeraet k1 = new KombiGeraet();
        KombiGeraet k2 = new KombiGeraet();

        f1.senden("Dies ist ein Test");
        f2.senden("Dies ist ein Test");
        l1.drucken("Dies ist ein Test");
        l2.drucken("Dies ist ein Test");
        k1.senden("Dies ist ein Test");
        k2.senden("Dies ist ein Test");
        k1.drucken("Dies ist ein Test");
        k2.drucken("Dies ist ein Test");
    }
}
