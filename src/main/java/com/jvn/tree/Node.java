package com.jvn.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

  protected final Object data;
  protected List<Node> children;

  public Node(Object data) {
    this.data = data;
    children = initializeChildren();
  }

  public Node(Object data, List<Node> children) {
    this.data = data;
    this.setChildren(children);
  }

  public Node(Node copyNode) {
    this(copyNode.getData(), copyNode.getChildren());
  }

  public Object getData() {
    return data;
  }

  public List<Node> getChildren() {
    return children;
  }

  public void setChildren(List<Node> children) {
    this.children = children;
  }

  public Node getChild(int index) {
    return children.get(index);
  }

  public void setChild(int index, Node child) {
    children.set(index, child);
  }

  public void addChild(Node child) {
    children.add(child);
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
    return Objects.equals(data, node.data) &&
        Objects.equals(children, node.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, children);
  }

  @Override
  public String toString() {
    return "Node{" +
        "data=" + data +
        ", children=" + children +
        '}';
  }

  protected List<Node> initializeChildren() {
    return new ArrayList<>();
  }

}
