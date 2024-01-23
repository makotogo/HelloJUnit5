package com;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unchecked")
public class AVLTreeTest {

  private static final Logger logger = LoggerFactory.getLogger(
    AVLTreeTest.class
  );
  private AVLTree avlTree;

  @BeforeEach
  public void setup() {
    avlTree = new AVLTree();
  }

  @Test
  @DisplayName("Insert with Positive Argument")
  public void insert_PositiveNumbers_Pass() {
    Integer targetNumber = 8;
    avlTree.insert(5);
    avlTree.insert(10);
    avlTree.insert(2);
    avlTree.insert(8);
    avlTree.insert(7);
    ArrayList<Integer> result = avlTree.inorder();
    ArrayList<Integer> expected = new ArrayList<>();
    expected.add(2);
    expected.add(5);
    expected.add(7);
    expected.add(8);
    expected.add(10);

    assertAll(
      "Should all be true",
      () ->
        assertTrue(
          result.contains(targetNumber),
          "ArrayList should contain " + targetNumber
        ),
      () -> assertEquals(expected, result)
    );
  }

  @Test
  @DisplayName("Insert with negative numbers")
  public void insert_NegativeNumbers_Pass() {
    Integer targetNumber = -8;
    avlTree.insert(-5);
    avlTree.insert(-10);
    avlTree.insert(-2);
    avlTree.insert(-8);
    avlTree.insert(-7);
    ArrayList<Integer> result = avlTree.inorder();
    ArrayList<Integer> expected = new ArrayList<>();
    expected.add(-10);
    expected.add(-8);
    expected.add(-7);
    expected.add(-5);
    expected.add(-2);

    assertAll(
      "Should all be true",
      () ->
        assertTrue(
          result.contains(targetNumber),
          "ArrayList should contain " + targetNumber
        ),
      () -> assertEquals(expected, result)
    );
  }

  @Test
  @DisplayName("Using the same number")
  public void insert_SameNumber_Pass() {
    avlTree.insert(8);
    avlTree.insert(8);
    avlTree.insert(8);
    avlTree.insert(9);
    ArrayList<Integer> result = avlTree.inorder();
    ArrayList<Integer> expected = new ArrayList<>();
    expected.add(8);
    expected.add(9);
    assertAll(
      "Must contain only one 8 and 9",
      () -> assertTrue(result.contains(8)),
      () -> assertEquals(expected, result)
    );
  }

  @Nested
  class BadArgumentsTest {

    @Test
    @DisplayName("Null value added")
    public void insert_NullValueAdded_Fail() {
      // You can't insert null values for AVLTree<Integer>
      assertThrows(NullPointerException.class, () -> avlTree.insert(null));
    }

    @Test
    @DisplayName("Uncomparable keys added")
    public void insert_UncomparableKeyAdded_Fail() {
      Object[] o = { "this", 56, new int[] { 8, 9 } };
      assertThrows(IllegalArgumentException.class, () -> avlTree.insert(o));
    }

    @Test
    @DisplayName("Comparable keys added")
    public void insert_ComparableKeyAdded_Pass() {
      LocalDateTime local = LocalDateTime.now().plusDays(1);
      LocalDateTime local2 = LocalDateTime.now().plusDays(90);
      LocalDateTime local3 = LocalDateTime.now().plusDays(8);
      avlTree.insert(local);
      avlTree.insert(local2);
      avlTree.insert(local3);
      ArrayList<LocalDateTime> result = avlTree.inorder();
      assertAll(
        "shoudl contain add times",
        () -> assertTrue(result.contains(local)),
        () -> assertTrue(result.contains(local2)),
        () -> assertTrue(result.contains(local3))
      );
    }
  }
}
