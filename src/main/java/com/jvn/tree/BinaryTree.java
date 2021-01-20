package com.jvn.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class BinaryTree {

  private final Node root;

  public BinaryTree(Node root) {
    this.root = root;
  }

  public boolean depthFirstSearch(int search) {
    return depthFirstSearch(this.root, search);
  }

  private boolean depthFirstSearch(Node root, int search) {
    boolean found = false;
    System.out.println("Checking node " + root);
    if (root != null) {
      if (root.getData() == search) {
        found = true;
      } else {
        Node left = root.getLeft();
        Node right = root.getRight();
        found = depthFirstSearch(left, search) || depthFirstSearch(right, search);
      }
    }
    return found;
  }

  public boolean breadthFirstSearch(int search) {
    return breadthFirstSearch(this.root, search);
  }

  private boolean breadthFirstSearch(Node root, int search) {
    boolean found = false;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node node = queue.remove();
      System.out.println("Checking Node " + node);
      if (node != null) {
        if (node.getData() == search) {
          found = true;
          break;
        } else {
          queue.add(node.getLeft());
          queue.add(node.getRight());
        }
      }
    }

    return found;
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


