package com;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unchecked")
public class NodeTest {

  private static final Logger logger = LoggerFactory.getLogger(NodeTest.class);
  private Node node;

  @BeforeEach
  public void setup() {
    node = new Node(5);
  }

  @Test
  @DisplayName("Node set up")
  public void Node_CheckConstructor_Pass() {
    logger.info("in the node tests");
    assertAll(
      "Constructor should do each of these:",
      () -> assertEquals(5, node.key),
      () -> assertEquals(1, node.height),
      () -> assertNull(node.left),
      () -> assertNull(node.right)
    );
  }

  @Nested
  class GettersAndSettersTests {

    @Test
    @DisplayName("Get Key")
    public void getKey_NormalInput_Pass() {
      Integer result = (Integer) node.getKey();
      Integer expected = 5;
      assertEquals(expected, result);
    }

    @Test
    @DisplayName("Set Key")
    public void setKey_NormalInput_Pass() {
      node.setKey("apple");
      String expected = "apple";
      assertEquals(expected, node.getKey());
    }

    @Test
    @DisplayName("Get Height")
    public void getHeight_NormalSituations_Pass() {
      Integer targetHeight = 6;
      node.setHeight(targetHeight);
      assertEquals(targetHeight, (Integer) node.getHeight());
    }

    @Test
    @DisplayName("Set Height")
    public void setHeight_Positive_Pass() {
      Integer targetHeight = 89;
      node.setHeight(targetHeight);
      assertEquals(targetHeight, (Integer) node.getHeight());
    }

    @Test
    @DisplayName("Set Height Negative")
    public void setHeight_Negative_Fail() {
      Integer targetHeight = -89;
      assertThrows(
        IllegalArgumentException.class,
        () -> node.setHeight(targetHeight)
      );
    }
  }

  @Test
  @DisplayName("Check Equals Method")
  public void equals_LocalDate_Pass() {
    Node newNode = new Node(LocalDate.now().plusDays(6));
    node.setKey(LocalDate.now().plusDays(6));
    assertEquals(node, newNode);
  }

  @Test
  @DisplayName("Check Equals Method")
  public void equals_LocalDate_Fail() {
    Node newNode = new Node(LocalDate.now().plusDays(8));
    node.setKey(LocalDate.now().plusDays(6));
    assertNotEquals(node, newNode);
  }
}
