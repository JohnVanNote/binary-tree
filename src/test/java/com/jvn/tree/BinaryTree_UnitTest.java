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

}
