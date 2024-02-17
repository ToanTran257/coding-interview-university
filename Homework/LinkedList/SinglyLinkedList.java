package Homework.LinkedList;

public class SinglyLinkedList<E> {

  private static class Node<E> {

    public E element;

    public Node<E> next;

    public Node(E e) {
      element = e;
      next = null;
    }
  }

  private Node<E> head = null;
  private Node<E> tail = null;
  private int size = 0;

  public SinglyLinkedList() {}

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E first() {
    if (isEmpty()) {
      return null;
    }

    return head.element;
  }

  public E last() {
    if (isEmpty()) {
      return null;
    }

    return head.element;
  }

  public void addFirst(E e) {
    Node<E> node = new Node<E>(e);

    if (isEmpty()) {
      head = node;
      tail = node;
    } else {
      Node<E> next = head.next;
      head = node;
      head.next = next;
    }
    size++;
  }

  public void addLast(E e) {
    Node<E> node = new Node<E>(e);

    if (isEmpty()) {
      head = node;
      tail = node;
    } else {
      Node<E> next = tail.next;
      tail = node;
      tail.next = next;
    }
    size++;
  }

  public E removeFirst() {
    if (isEmpty()) {
      return null;
    }
    Node<E> result = head;
    head = head.next;
    size--;

    if (isEmpty()) {
      tail = null;
    }

    return result.element;
  }
}
