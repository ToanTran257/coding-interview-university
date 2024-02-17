package Homework.Queue;

import java.util.LinkedList;

public class LinkedQueue<E> {

  private LinkedList<E> list = new LinkedList<E>();

  public LinkedQueue() {}

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public void enqueue(E element) {
    list.addLast(element);
  }

  public E dequeue() {
    return list.pollFirst();
  }

  public E peek() {
    return list.peekFirst();
  }
}
