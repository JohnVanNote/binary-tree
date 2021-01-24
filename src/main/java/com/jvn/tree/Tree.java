package com.jvn.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Tree<N extends Node> {

  private final N root;

  public Tree(N root) {
    this.root = root;
  }

  public boolean depthFirstSearch(int search) {
    return depthFirstSearch(this.root, search);
  }

  private boolean depthFirstSearch(Node root, int search) {
    boolean found = false;
    //System.out.println("Checking node " + root);
    if (root != null) {
      if (root.getData().equals(search)) {
        found = true;
      } else {
        for (Node child : root.getChildren()) {
          found = depthFirstSearch(child, search);
          if (found) {
            break;
          }
        }
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
      //System.out.println("Checking Node " + node);
      if (node != null) {
        if (node.getData().equals(search)) {
          found = true;
          break;
        } else {
          queue.addAll(node.getChildren());
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
    Tree<?> tree = (Tree<?>) o;
    return Objects.equals(root, tree.root);
  }

  @Override
  public int hashCode() {
    return Objects.hash(root);
  }

  @Override
  public String toString() {
    return "Tree{" +
        "root=" + root +
        '}';
  }

}
