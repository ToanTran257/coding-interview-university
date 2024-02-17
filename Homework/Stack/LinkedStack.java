package Homework.Stack;

import java.util.LinkedList;

public class LinkedStack<E> {

  LinkedList<E> list = new LinkedList<E>();

  public LinkedStack() {}

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public int size() {
    return list.size();
  }

  public void push(E e) {
    list.addFirst(e);
  }

  public E top() {
    return list.peekFirst();
  }

  public E pop() {
    return list.pollFirst();
  }
}
