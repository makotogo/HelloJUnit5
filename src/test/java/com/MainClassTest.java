package com;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainClassTest {

  private MainClass main;
  private static final Logger logger = LoggerFactory.getLogger(
    MainClassTest.class
  );

  @BeforeAll
  public static void init() {}

  @AfterAll
  public static void done() {}

  @BeforeEach
  public void setup() {
    main = new MainClass();
  }

  @Test
  public void dummyTest() {
    logger.info("running a dummy test");
    assertTrue(true);
  }
}
