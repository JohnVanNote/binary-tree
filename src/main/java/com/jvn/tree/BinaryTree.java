package com.jvn.tree;

import java.util.Objects;

public class BinaryTree {

  private final Node root;

  public BinaryTree(Node root) {
    this.root = root;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BinaryTree that = (BinaryTree) o;
    return Objects.equals(root, that.root);
  }

  @Override
  public int hashCode() {
    return Objects.hash(root);
  }
  
}


