package com.jvn.tree;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BinaryNode_UnitTest {

  @DataProvider
  public Object[][] nodes() {
    BinaryNode BinaryNode = new BinaryNode(100);
    BinaryNode sameBinaryNode = new BinaryNode(100);
    BinaryNode copyBinaryNode = new BinaryNode(BinaryNode);
    BinaryNode differentBinaryNode = new BinaryNode(0);

    BinaryNode leftBinaryNode = new BinaryNode(50);
    BinaryNode rightBinaryNode = new BinaryNode(150);
    BinaryNode alternateBinaryNode = new BinaryNode(-1);

    return new Object[][]{
        {BinaryNode, BinaryNode, true},
        {BinaryNode, sameBinaryNode, true},
        {BinaryNode, copyBinaryNode, true},
        {BinaryNode, differentBinaryNode, false},
        {new BinaryNode(100, leftBinaryNode, rightBinaryNode), new BinaryNode(100, leftBinaryNode, rightBinaryNode), true},
        {new BinaryNode(100, leftBinaryNode, rightBinaryNode), new BinaryNode(0, leftBinaryNode, rightBinaryNode), false},
        {new BinaryNode(100, leftBinaryNode, rightBinaryNode), new BinaryNode(100, leftBinaryNode, alternateBinaryNode), false},
        {new BinaryNode(100, leftBinaryNode, rightBinaryNode), new BinaryNode(100, alternateBinaryNode, rightBinaryNode), false},

    };
  }

  @Test(dataProvider = "nodes")
  public void equals_BinaryNodes_expectedEqual(BinaryNode n1, BinaryNode n2, boolean expectedEqual) {
    Assert.assertEquals(n1.equals(n2), expectedEqual);
  }

}
