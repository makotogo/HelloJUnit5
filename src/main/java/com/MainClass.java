package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains our main application and methods.
 */
public class MainClass {

  private static final Logger logger = LoggerFactory.getLogger(MainClass.class);

  /**
   * Main Method, prints hello world and and starts our foctorial calculator.

   * @param args input for main method if desired
   */
  public static void main(String[] args) {
    logger.info("This is an AVL tree");
    AVLTree tree = new AVLTree();

    tree.insert(10);
    tree.insert(20);
    tree.insert(30);
    tree.insert(40);
    tree.insert(50);
    tree.insert(25);

    System.out.println("Inorder traversal of the constructed AVL tree:");
    tree.inorder();
  }
}
