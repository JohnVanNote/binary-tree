package com.jvn.tree;

import java.util.Objects;

public class Node {

  private final int data;
  private Node left;
  private Node right;

  public Node(int data) {
    this.data = data;
    this.setLeft(null);
    this.setRight(null);
  }

  public Node(int data, Node left, Node right) {
    this.data = data;
    this.setLeft(left == null ? null : new Node(left));
    this.setRight(right == null ? null : new Node(right));
  }

  public Node(Node copyNode) {
    this(copyNode.getData(), copyNode.getLeft(), copyNode.getRight());
  }

  public int getData() {
    return data;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return data == node.data &&
        Objects.equals(left, node.left) &&
        Objects.equals(right, node.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, left, right);
  }

  @Override
  public String toString() {
    return "Node{" +
        "data=" + data +
        ", left=" + left +
        ", right=" + right +
        '}';
  }

}
