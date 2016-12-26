/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.university.stack;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/26/16
 */
public interface StapelSchnittstelle {

    /**
     * legt ein Element (mit einem gegebenen Wert) oben auf den Stach
     *
     * @param value Der Wert
     */
    void push(int value);

    /**
     * nimmt das oberste Element vom Stack herunter und gibt seinen Wert zurück
     *
     * @return Der wert
     */
    int pop();

    /**
     * liefert den Wert des obersten Elements des Stacks zurück
     *
     * @return Der Wert
     */
    int top();

    /**
     * liefert true zurück, wenn der Stack leer ist
     *
     * @return true, wenn der Stack leer ist
     */
    boolean isEmpty();
}
