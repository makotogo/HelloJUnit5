package com;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>> {

  private Node<K> root;

  private int height(Node<K> node) {
    return (node != null) ? node.getHeight() : 0;
  }

  private int getBalance(Node<K> node) {
    return (node != null) ? height(node.left) - height(node.right) : 0;
  }

  private Node<K> rotateRight(Node<K> y) {
    Node<K> x = y.left;
    Node<K> T2 = x.right;

    x.right = y;
    y.left = T2;

    y.height = Math.max(height(y.left), height(y.right)) + 1;
    x.height = Math.max(height(x.left), height(x.right)) + 1;

    return x;
  }

  private Node<K> rotateLeft(Node<K> x) {
    Node<K> y = x.right;
    Node<K> T2 = y.left;

    y.left = x;
    x.right = T2;

    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    return y;
  }

  public void insert(Object o) {
    if (o == null) {
      throw new NullPointerException("Key cannot be null");
    }

    if (!(o instanceof Comparable)) {
      throw new IllegalArgumentException("Object is not comparable");
    }

    K key = (K) o;
    root = insert(root, key);
  }

  private Node<K> insert(Node<K> node, K key) {
    if (node == null) return new Node<>(key);

    int comparisonResult = key.compareTo(node.getKey());

    if (comparisonResult < 0) {
      node.left = insert(node.left, key);
    } else if (comparisonResult > 0) {
      node.right = insert(node.right, key);
    } else {
      return node; // Duplicate keys not allowed
    }

    node.height = 1 + Math.max(height(node.left), height(node.right));

    int balance = getBalance(node);

    // Left Left Case
    if (
      balance > 1 && key.compareTo(node.left.getKey()) < 0
    ) return rotateRight(node);

    // Right Right Case
    if (
      balance < -1 && key.compareTo(node.right.getKey()) > 0
    ) return rotateLeft(node);

    // Left Right Case
    if (balance > 1 && key.compareTo(node.left.getKey()) > 0) {
      node.left = rotateLeft(node.left);
      return rotateRight(node);
    }

    // Right Left Case
    if (balance < -1 && key.compareTo(node.right.getKey()) < 0) {
      node.right = rotateRight(node.right);
      return rotateLeft(node);
    }

    return node;
  }

  public ArrayList<K> inorder() {
    return inorder(root);
  }

  private ArrayList<K> inorder(Node<K> root) {
    ArrayList<K> toReturn = new ArrayList<>();
    if (root != null) {
      toReturn.addAll(inorder(root.left));
      toReturn.add(root.getKey());
      toReturn.addAll(inorder(root.right));
    }
    return toReturn;
  }
}
