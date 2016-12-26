/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.university.list;

/**
 * Singly linked list
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/1/16.
 */
public class Liste implements AbstrakteListe {
    private Node head;
    private int size = 0;


    @Override
    public void addLast(int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node temp = this.head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        this.size++;
    }

    @Override
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;

        this.head = newNode;
        this.size++;
    }

    @Override
    public boolean remove(int index) {
        if (index >= 0 && index < this.size) {
            if (index == 0) {
                this.head = this.head.next;
            } else {
                Node temp = this.head;

                while (index > 1) {
                    temp = temp.next;
                    index--;
                }

                temp.next = temp.next.next;
            }

            this.size--;

            return true;
        } else {
            return false;
        }
    }

    @Override
    public int removeFirst() throws NullPointerException {
        if(this.size() == 0) {
            throw new NullPointerException("List is empty");
        }

        int v = this.head.data;
        this.head = this.head.next;

        return v;
    }

    @Override
    public int removeLast() throws NullPointerException {
        if(this.size() == 0) {
            throw new NullPointerException("List is empty");
        }

        Node temp = this.head;
        int index = this.size() - 2;

        while (index > 1) {
            temp = temp.next;
            index--;
        }


        int v = temp.next.data;
        temp.next = null;

        return v;
    }

    @Override
    public int removeAtIndex(int index) throws NullPointerException {
        if(index <= 0 || index >= this.size()) {
            throw new NullPointerException("Index doesn't exist");
        }

        if (index >= 0 && index < this.size) {
            int v;

            if (index == 0) {
                v = this.head.data;
                this.head = this.head.next;
            } else {
                Node temp = this.head;

                while (index > 1) {
                    temp = temp.next;
                    index--;
                }

                v = temp.next.data;
                temp.next = temp.next.next;
            }

            this.size--;

            return v;
        } else {
            throw new NullPointerException("The index:" + index + " is out of bounds");
        }
    }

    @Override
    public boolean add(int index, int data) {
        if (index >= 0 && index <= this.size) {
            Node newNode = new Node(data);

            if (index == 0) {
                newNode.next = this.head;
                this.head = newNode;
            } else {
                Node temp = this.head;

                while (index > 1) {
                    temp = temp.next;
                    index--;
                }

                newNode.next = temp.next;
                temp.next = newNode;
            }

            this.size++;

            return true;
        } else {
            return false;
        }
    }

    public void clearAll() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String s = "[ ";
        Node temp = this.head;

        while (temp != null) {
            s += temp.data + " ";
            temp = temp.next;
        }

        s += "]";

        return s;
    }

    public boolean empty() {
        return (this.head == null);
    }

    @Override
    public int get(int index) throws NullPointerException {
        if (index >= 0 && index < this.size) {
            Node temp = this.head;

            while (index > 0) {
                temp = temp.next;
                index--;
            }

            return temp.data;
        } else {
            throw new NullPointerException("The index:" + index + "  is out of bounds");
        }
    }

    @Override
    public int set(int index, int data) throws NullPointerException {
        if (index >= 0 && index < this.size) {
            Node temp = this.head;

            while (index > 0) {
                temp = temp.next;
                index--;
            }

            int tmp = temp.data;
            temp.data = data;

            return tmp;
        } else {
            throw new NullPointerException("The index:" + index + " is out of bounds");
        }
    }

    @Override
    public boolean contains(int wert) {
        Node temp = this.head;

        while(temp.next != null) {
            if(temp.data == wert) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }
}
