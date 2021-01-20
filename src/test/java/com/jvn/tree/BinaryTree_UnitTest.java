package com.jvn.tree;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BinaryTree_UnitTest {

  @DataProvider
  public Object[][] nodes() {
    return new Node_UnitTest().nodes();
  }

  @Test(dataProvider = "nodes")
  public void equals_nodes_expectedEqual(Node n1, Node n2, boolean expectedEqual) {
    BinaryTree bt1 = new BinaryTree(n1);
    BinaryTree bt2 = new BinaryTree(n2);
    Assert.assertEquals(bt1.equals(bt2), expectedEqual);
  }

  public Node searchNode() {
    Node leftLeftMostChild = new Node(5);
    Node leftMostChild = new Node(2, leftLeftMostChild, null);
    Node leftMidChild = new Node(10);
    Node rightMidChild = new Node(7);
    Node rightMostChild = new Node(8);
    Node leftParent = new Node(12, leftMostChild, leftMidChild);
    Node rightParent = new Node(15, rightMidChild, rightMostChild);
    Node root = new Node(1000, leftParent, rightParent);
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
