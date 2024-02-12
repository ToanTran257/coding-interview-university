package Homework.test;

import Homework.LinkedList.LinkedList;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

public class LinkedListTests {

  LinkedList ll;
  static final Logger logger = Logger.getLogger(
    LinkedListTests.class.getName()
  );

  @BeforeAll
  void beforeAllTests() {
    logger.info("Before all tests");
  }

  @Test
  public void sizeIsEmpty() {
    this.ll = new LinkedList();

    Assertions.assertEquals(ll.size(), 0);
    Assertions.assertEquals(ll.isEmpty(), true);
  }

  @Test
  public void pushFront() {
    this.ll = new LinkedList();

    ll.pushFront(0);
    Assertions.assertEquals(ll.size(), 1);
    Assertions.assertEquals(ll.isEmpty(), false);

    ll.pushFront(1);
    ll.pushFront(2);
    ll.pushFront(3);
    Assertions.assertEquals(ll.size(), 4);
  }
}
