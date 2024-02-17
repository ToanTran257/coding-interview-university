package Homework.test;

import static org.junit.Assert.*;

import Homework.Queue.ArrayQueue;
import Homework.Queue.LinkedQueue;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

public class QueueTests {

  @Nested
  @TestInstance(Lifecycle.PER_CLASS)
  class LinkedQueueTest {

    LinkedQueue<Integer> lQueue;

    @BeforeAll
    void beforeAll() {
      lQueue = new LinkedQueue<Integer>();
    }

    @BeforeEach
    void beforeEach() {
      lQueue.enqueue(1);
      lQueue.enqueue(2);
      lQueue.enqueue(3);
      lQueue.enqueue(4);
      lQueue.enqueue(5);
    }

    @AfterEach
    void afterEach() {
      empty();
    }

    private void empty() {
      int size = lQueue.size();
      for (int i = 0; i < size; i++) {
        lQueue.dequeue();
      }
    }

    @Test
    public void testEmpty() {
      empty();
      assertEquals(lQueue.size(), 0);
      assertEquals(lQueue.isEmpty(), true);
    }

    @Test
    public void testEnqueue() {
      assertEquals(lQueue.size(), 5);
      assertEquals(lQueue.isEmpty(), false);
    }

    @Test
    public void testDequeue() {
      assertEquals((int) lQueue.dequeue(), 1);
      assertEquals(lQueue.size(), 4);
      assertEquals(lQueue.isEmpty(), false);
    }

    @Test
    public void testDequeueWhenQueueIsEmpty() {
      empty();

      assertNull(lQueue.dequeue());
    }
  }

  @Nested
  @TestInstance(Lifecycle.PER_CLASS)
  class ArrayQueueTest {

    ArrayQueue<Integer> aQueue;

    @BeforeAll
    void beforeAll() {
      aQueue = new ArrayQueue<Integer>(10);
    }

    @BeforeEach
    void beforeEach() {
      aQueue.enqueue(1);
      aQueue.enqueue(2);
      aQueue.enqueue(3);
      aQueue.enqueue(4);
      aQueue.enqueue(5);
    }

    @AfterEach
    void afterEach() {
      empty();
    }

    private void empty() {
      int size = aQueue.size();
      for (int i = 0; i < size; i++) {
        aQueue.dequeue();
      }
    }

    @Test
    public void testEmpty() {
      empty();
      assertEquals(aQueue.size(), 0);
      assertEquals(aQueue.isEmpty(), true);
    }

    @Test
    public void testEnqueue() {
      assertEquals(aQueue.size(), 5);
      assertEquals(aQueue.isEmpty(), false);
    }

    @Test
    public void testDequeue() {
      assertEquals((int) aQueue.dequeue(), 1);
      assertEquals(aQueue.size(), 4);
      assertEquals(aQueue.isEmpty(), false);
    }

    @Test
    public void testDequeueWhenQueueIsEmpty() {
      empty();

      assertNull(aQueue.dequeue());
    }

    @Test
    public void testIsFull() {
      while (!aQueue.isFull()) {
        aQueue.enqueue(1);
      }

      assertEquals(aQueue.isFull(), true);
    }

    @Test
    public void testThrowIllegalStateException() {
      while (!aQueue.isFull()) {
        aQueue.enqueue(1);
      }
      assertThrows(IllegalStateException.class, () -> aQueue.enqueue(1));
    }
  }
}
