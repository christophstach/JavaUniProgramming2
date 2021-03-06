/*
 * Copyright (c) 2017 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package stapel_warteschlange;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 1/10/17
 */
public interface IStack<T> {
    /**
     * Pushs an element to the Stack
     *
     * @param element The element
     */
    void push(T element);

    /**
     * Removes an element from the Stack and returns it
     *
     * @return The element
     */
    T pop();

    /**
     * Returns the top element of the Stack without returning it
     *
     * @return The element
     */
    T top();

    /**
     * Checks ifs the Stack is empty
     *
     * @return True if the Stack is empty
     */
    boolean isEmpty();

    /**
     * Prints the content of the Stack to the console
     */
    void print();
}
