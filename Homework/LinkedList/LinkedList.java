package Homework.LinkedList;

class Node {

  int value;
  Node next;

  public Node(int value) {
    this.value = value;
    this.next = null;
  }
}

public class LinkedList {

  Node head;

  public LinkedList() {
    head = null;
  }

  public LinkedList(int value) {
    Node node = new Node(value);
    head = node;
  }

  public int size() {
    Node traverse = head;
    int count = 0;

    while (traverse != null) {
      count++;
      traverse = traverse.next;
    }

    return count;
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  public int valueAt(int index) throws Exception {
    Node traverse = head;

    while (traverse != null && index > 0) {
      index--;
      traverse = traverse.next;
    }

    if (index < 0 || traverse == null) {
      throw new Exception("Index out of bound");
    }
    return traverse.value;
  }

  public void pushFront(int value) {
    Node node = new Node(value);

    node.next = head;
    head = node;
  }

  public int popFront() {
    Node result = head;
    if (result == null) {
      // TODO: throw exception
      return 0;
    }

    head = head.next;
    return result.value;
  }

  public void pushBack(int value) {
    Node node = new Node(value);

    while (head.next != null) {
      head = head.next;
    }

    head.next = node;
  }

  public int popBack() {
    Node prev = new Node(0);
    prev.next = head;
    while (head.next != null) {
      prev = prev.next;
      head = head.next;
    }

    int result = head.value;
    prev.next = null;
    return result;
  }

  public int front() {
    return head.value;
  }

  public int back() {
    while (head.next != null) {
      head = head.next;
    }

    return head.value;
  }

  public void insert(int index, int value) {
    Node node = new Node(value);
    Node prev = new Node(0);
    prev.next = head;

    while (head != null && index-- > 0) {
      prev = prev.next;
      head = head.next;
    }

    node.next = head;
    prev.next = node;
  }

  public void erase(int index) throws Exception {
    Node prev = new Node(0);
    prev.next = head;

    while (head != null && index-- > 0) {
      prev = prev.next;
      head = head.next;
    }

    if (index > 0) {
      throw new Exception("Index out of bound");
    }

    prev.next = head == null ? null : head.next;
  }

  public int valueNFromEnd(int n) throws Exception {
    Node prev = head;

    while (head != null && n-- > 0) {
      head = head.next;
    }

    if (n > 0) {
      throw new Exception("Index out of bound");
    }

    while (head != null) {
      head = head.next;
      prev = prev.next;
    }

    return prev.value;
  }

  public void reverse() {
    Node prev = head;

    while (head != null) {
      Node temp = prev;

      prev = head.next;
      prev.next = head;
      head = head.next;

      prev = temp;
    }
  }

  public void removeValue(int value) {
    Node prev = new Node(0);
    prev.next = head;

    while (head != null && head.value != value) {
      head = head.next;
      prev = prev.next;
    }

    prev.next = prev.next.next;
  }
}
