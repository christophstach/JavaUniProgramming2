/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.university.tree;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/26/16
 */
public class BinTree {
    private BinNode root;

    /**
     * Constructor
     */
    BinTree() {
        root = null;
    }


    /**
     * Constructor
     *
     * @param root The root node
     */
    BinTree(BinNode root) {
        this.root = root;
    }

    /**
     * Checks if the tree is not empty
     *
     * @return true if not empty
     */
    public boolean isNotEmpty() {
        return root != null;
    }

    /**
     * Counts the leaves of the tree
     *
     * @param node The node
     * @return The leave count
     */
    private int countLeaves(BinNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }

    /**
     * Counts the leaves of the tree
     *
     * @return The leave count
     */
    public int countLeaves() {
        return countLeaves(root);
    }

    /**
     * Checks if the tree is sorted
     *
     * @return true if sorted
     */
    private boolean isSorted(BinNode node) {
        if (node == null) {
            return true;
        } else if (node.left == null && node.right == null) {
            return true;
        } else if (node.left == null && node.right.data > node.data && isSorted(node.right)) {
            return true;
        } else if (node.left.data < node.data && isSorted(node.left) && node.right == null) {
            return true;
        } else if (node.left.data < node.data && isSorted(node.left) && node.right.data > node.data && isSorted(node.right)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the tree is sorted
     *
     * @return true if sorted
     */
    public boolean isSorted() {
        return isSorted(root);
    }

    /**
     * Counts the nodes of
     *
     * @param node The node
     * @return The node count
     */
    private int countNodes(BinNode node) {
        int counter = 0;

        if (node != null) {
            counter = 1 + countNodes(node.left) + countNodes(node.right);
        }

        return counter;
    }

    /**
     * Counts the nodes
     *
     * @return The node count
     */
    public int countNodes() {
        return countNodes(root);
    }


    /**
     * Calculates the depth
     *
     * @param node The node
     * @return The depth
     */
    private int calculateDepth(BinNode node) {
        int counter = 0;

        if (node != null && (node.left != null || node.right != null)) {
            counter = 1 + Math.max(calculateDepth(node.left), calculateDepth(node.right));
        }

        return counter;
    }

    /**
     * The depth
     *
     * @return The depth
     */
    public int calculateDepth() {
        return calculateDepth(root);
    }
}
