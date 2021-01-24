package com.jvn.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryNode extends Node {

  public BinaryNode(Object data) {
    super(data);
  }

  public BinaryNode(Object data, Node left, Node right) {
    super(data, Arrays.asList(left, right));
  }

  public BinaryNode(Node copyNode) {
    super(copyNode);
  }

  public Node getLeft() {
    return children.get(0);
  }

  public void setLeft(Node left) {
    setChild(0, left);
  }

  public Node getRight() {
    return children.get(1);
  }

  public void setRight(Node right) {
    this.setChild(1, right);
  }

  @Override
  protected List<Node> initializeChildren() {
    return new ArrayList<>(2);
  }

}
