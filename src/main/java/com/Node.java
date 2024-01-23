package com;

public class Node<K extends Comparable<K>> {

  K key;
  int height;
  public Node<K> left, right;

  Node(K key) {
    this.key = key;
    this.height = 1;
  }

  public K getKey() {
    return key;
  }

  public int getHeight() {
    return height;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public void setHeight(int height) {
    if (height < 0) throw new IllegalArgumentException(
      "Cannot have a negative height"
    );
    this.height = height;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Node<?> other = (Node<?>) obj;
    return key.equals(other.key);
  }
}
