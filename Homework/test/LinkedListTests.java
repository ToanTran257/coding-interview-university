package Homework.test;

import Homework.LinkedList.LinkedList;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

// TODO: edit this test file to remove all the repeated code
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
  public void valueAt() throws Exception {
    this.ll = new LinkedList();
    ll.pushBack(0);
    ll.pushBack(1);
    ll.pushBack(2);
    ll.pushBack(3);

    Assertions.assertEquals(ll.valueAt(1), 1);
    Assertions.assertEquals(ll.valueAt(3), 3);
    Assertions.assertThrows(Exception.class, () -> ll.valueAt(-1));
    Assertions.assertThrows(Exception.class, () -> ll.valueAt(5));
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
    System.out.println(ll);
  }

  @Test
  public void popFront() throws Exception {
    this.ll = new LinkedList();

    ll.pushFront(0);
    ll.pushFront(1);
    ll.pushFront(2);
    ll.pushFront(3);
    Assertions.assertEquals(ll.popFront(), 3);
    Assertions.assertEquals(ll.popFront(), 2);
    Assertions.assertEquals(ll.popFront(), 1);
    Assertions.assertEquals(ll.popFront(), 0);
    Assertions.assertEquals(ll.isEmpty(), true);

    Assertions.assertThrows(Exception.class, () -> ll.popFront());
  }

  @Test
  public void pushBack() {
    this.ll = new LinkedList();

    ll.pushBack(0);
    ll.pushBack(1);
    ll.pushBack(2);
    ll.pushBack(3);
    Assertions.assertEquals(ll.toString(), "0,1,2,3");
  }

  @Test
  public void popBack() throws Exception {
    this.ll = new LinkedList();

    ll.pushBack(0);
    ll.pushBack(1);
    ll.pushBack(2);
    ll.pushBack(3);

    Assertions.assertEquals(ll.popBack(), 3);
    Assertions.assertEquals(ll.popBack(), 2);
    Assertions.assertEquals(ll.popBack(), 1);
    Assertions.assertEquals(ll.popBack(), 0);

    Assertions.assertThrows(Exception.class, () -> ll.popBack());
  }

  @Test
  public void frontBack() throws Exception {
    this.ll = new LinkedList();

    ll.pushBack(0);
    ll.pushBack(1);
    ll.pushBack(2);
    ll.pushBack(3);

    ll.pushFront(-1);
    ll.pushBack(4);

    Assertions.assertEquals(ll.front(), -1);
    Assertions.assertEquals(ll.back(), 4);
  }

  @Test
  public void insert() throws Exception {
    this.ll = new LinkedList();

    ll.pushBack(50);
    ll.pushBack(1);
    ll.pushBack(2);
    ll.pushBack(3);

    ll.insert(2, 10);
    Assertions.assertEquals(ll.valueAt(2), 10);

    ll.insert(0, 11);
    Assertions.assertEquals(ll.front(), 11);

    ll.insert(ll.size() - 1, 12);
    Assertions.assertEquals(ll.back(), 3);

    ll.insert(ll.size(), 30);
    Assertions.assertEquals(ll.back(), 30);

    Assertions.assertThrows(Exception.class, () -> ll.insert(-1, 12));
    Assertions.assertThrows(
      Exception.class,
      () -> ll.insert(ll.size() + 1, 12)
    );
  }

  @Test
  public void erase() throws Exception {
    this.ll = new LinkedList();

    ll.pushBack(0);
    ll.pushBack(1);
    ll.pushBack(2);
    ll.pushBack(3);

    ll.erase(0);
    Assertions.assertEquals(ll.toString(), "1,2,3");

    ll.erase(1);
    Assertions.assertEquals(ll.toString(), "1,3");

    ll.erase(ll.size() - 1);
    ll.erase(ll.size() - 1);
    Assertions.assertEquals(ll.toString(), "");

    Assertions.assertThrows(Exception.class, () -> ll.erase(0));
  }

  @Test
  public void valueNFromEnd() throws Exception {
    this.ll = new LinkedList();

    ll.pushBack(0);
    ll.pushBack(1);
    ll.pushBack(2);
    ll.pushBack(3);

    Assertions.assertEquals(ll.valueNFromEnd(1), 3);

    Assertions.assertEquals(ll.valueNFromEnd(3), 1);
    Assertions.assertEquals(ll.valueNFromEnd(ll.size()), 0);

    Assertions.assertThrows(Exception.class, () -> ll.valueNFromEnd(5));
    Assertions.assertThrows(Exception.class, () -> ll.valueNFromEnd(0));
  }

  @Test
  public void reverse() throws Exception {
    this.ll = new LinkedList();

    ll.pushBack(0);
    ll.pushBack(1);
    ll.pushBack(2);
    ll.pushBack(3);
    ll.reverse();
    Assertions.assertEquals(ll.toString(), "3,2,1,0");
  }

  @Test
  public void removeValue() throws Exception {
    this.ll = new LinkedList();

    ll.pushBack(0);
    ll.pushBack(1);
    ll.pushBack(2);
    ll.pushBack(3);
    ll.removeValue(1);
    Assertions.assertEquals(ll.toString(), "0,2,3");

    ll.removeValue(1);
    Assertions.assertEquals(ll.toString(), "0,2,3");

    ll.removeValue(3);
    Assertions.assertEquals(ll.toString(), "0,2");
  }
}
