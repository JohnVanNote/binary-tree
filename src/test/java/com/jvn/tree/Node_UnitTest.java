package com.jvn.tree;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Node_UnitTest {

  @DataProvider
  public Object[][] nodes() {
    Node node = new Node(100);
    Node sameNode = new Node(100);
    Node copyNode = new Node(node);
    Node differentNode = new Node(0);

    Node leftNode = new Node(50);
    Node rightNode = new Node(150);
    Node alternateNode = new Node(-1);

    return new Object[][]{
        {node, node, true},
        {node, sameNode, true},
        {node, copyNode, true},
        {node, differentNode, false},
        {new Node(100, leftNode, rightNode), new Node(100, leftNode, rightNode), true},
        {new Node(100, leftNode, rightNode), new Node(0, leftNode, rightNode), false},
        {new Node(100, leftNode, rightNode), new Node(100, leftNode, alternateNode), false},
        {new Node(100, leftNode, rightNode), new Node(100, alternateNode, rightNode), false},

    };
  }

  @Test(dataProvider = "nodes")
  public void equals_nodes_expectedEqual(Node n1, Node n2, boolean expectedEqual) {
    Assert.assertEquals(n1.equals(n2), expectedEqual);
  }

}
