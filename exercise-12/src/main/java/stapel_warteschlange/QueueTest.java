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
public class QueueTest {
    /**
     * Entry point for the application
     *
     * @param args Console arguments
     */
    public static void main(String[] args) {
        IQueue<Double> doubleStack = new Queue<>();
        IQueue<Integer> integerStack = new Queue<>();


        doubleStack.enqueue(5d);
        doubleStack.enqueue(6d);
        doubleStack.enqueue(new Double(4));


        doubleStack.print();
        doubleStack.dequeue();
        System.out.println(doubleStack.first());
        System.out.println("isEmpty: " + doubleStack.isEmpty());
        doubleStack.print();

        System.out.println("-----------------------------------------------------------------------------------------");

        integerStack.enqueue(5);
        integerStack.enqueue(6);
        integerStack.enqueue(new Integer(4));

        integerStack.print();
        integerStack.dequeue();
        System.out.println(integerStack.first());
        System.out.println("isEmpty: " + integerStack.isEmpty());
        integerStack.print();
    }
}
