package com.jvn.tree;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BinaryTree_UnitTest {

  @DataProvider
  public Object[][] nodes() {
    return new BinaryNode_UnitTest().nodes();
  }

  @Test(dataProvider = "nodes")
  public void equals_nodes_expectedEqual(BinaryNode n1, BinaryNode n2, boolean expectedEqual) {
    BinaryTree bt1 = new BinaryTree(n1);
    BinaryTree bt2 = new BinaryTree(n2);
    Assert.assertEquals(bt1.equals(bt2), expectedEqual);
  }

  public BinaryNode searchNode() {
    BinaryNode leftLeftMostChild = new BinaryNode(5);
    BinaryNode leftMostChild = new BinaryNode(2, leftLeftMostChild, null);
    BinaryNode leftMidChild = new BinaryNode(10);
    BinaryNode rightMidChild = new BinaryNode(7);
    BinaryNode rightMostChild = new BinaryNode(8);
    BinaryNode leftParent = new BinaryNode(12, leftMostChild, leftMidChild);
    BinaryNode rightParent = new BinaryNode(15, rightMidChild, rightMostChild);
    BinaryNode root = new BinaryNode(1000, leftParent, rightParent);
    return root;
  }

  @Test
  public void depthFirstSearch_found_true() {
    BinaryTree bt = new BinaryTree(searchNode());
    Assert.assertTrue(bt.depthFirstSearch(7));
  }

  @Test
  public void depthFirstSearch_notFound_false() {
    BinaryTree bt = new BinaryTree(searchNode());
    Assert.assertFalse(bt.depthFirstSearch(13));
  }

  @Test
  public void breadthFirstSearch_found_true() {
    BinaryTree bt = new BinaryTree(searchNode());
    Assert.assertTrue(bt.breadthFirstSearch(7));
  }

  @Test
  public void breadthFirstSearch_notFound_false() {
    BinaryTree bt = new BinaryTree(searchNode());
    Assert.assertFalse(bt.breadthFirstSearch(13));
  }

}
