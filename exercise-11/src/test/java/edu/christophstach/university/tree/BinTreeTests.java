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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/26/16
 */
public class BinTreeTests {
    @Test
    public void testEmptyTree() {
        BinTree tree = new BinTree();

        Assert.assertFalse(tree.isNotEmpty());
        Assert.assertEquals(0, tree.countLeaves());
        Assert.assertTrue(tree.isSorted());
    }


    @Test
    public void testSingleNodeTree() {
        BinTree tree = new BinTree(new BinNode(5));

        Assert.assertTrue(tree.isNotEmpty());
        Assert.assertEquals(1, tree.countLeaves());
        Assert.assertTrue(tree.isSorted());
    }

    @Test
    public void testUnEmptyTree() {
        BinNode root = new BinNode(7);
        root.left = new BinNode(4);
        root.left.left = new BinNode(2);
        root.left.left.left = new BinNode(1);

        root.left.left.right = new BinNode(3);
        root.left.right = new BinNode(5);

        root.right = new BinNode(9);
        root.right.left = new BinNode(8);

        BinTree tree = new BinTree(root);

        Assert.assertTrue(tree.isNotEmpty());
        Assert.assertEquals(4, tree.countLeaves());
        Assert.assertTrue(tree.isSorted());
    }
}
