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
  int size;

  public LinkedList() {
    size = 0;
    head = null;
  }

  public LinkedList(int value) {
    Node node = new Node(value);
    size = 1;
    head = node;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int valueAt(int index) throws Exception {
    if (size == 0) {
      throw new Exception("Index out of bound");
    }

    Node traverse = head;

    while (traverse != null && index > 0) {
      index--;
      traverse = traverse.next;
    }

    if (index != 0 || traverse == null) {
      throw new Exception("Index out of bound");
    }
    return traverse.value;
  }

  public void pushFront(int value) {
    Node node = new Node(value);
    if (size == 0) {
      size++;
      head = node;
      return;
    }

    node.next = head;
    head = node;
    size++;
  }

  public int popFront() throws Exception {
    if (size == 0) {
      throw new Exception("Linked List is empty");
    }

    int result = head.value;
    head = head.next;
    size--;
    return result;
  }

  public void pushBack(int value) {
    Node node = new Node(value);
    if (size == 0) {
      head = node;
      size++;
      return;
    }

    Node traverse = head;

    while (traverse.next != null) {
      traverse = traverse.next;
    }
    size++;
    traverse.next = node;
  }

  public int popBack() throws Exception {
    if (size == 0) {
      throw new Exception("Linked List is empty");
    }

    Node prev = new Node(0);
    Node traverse = head;

    prev.next = traverse;
    while (traverse.next != null) {
      prev = prev.next;
      traverse = traverse.next;
    }

    int result = traverse.value;
    prev.next = null;
    size--;
    return result;
  }

  public int front() {
    return head.value;
  }

  public int back() {
    Node traverse = head;

    while (traverse.next != null) {
      traverse = traverse.next;
    }

    return traverse.value;
  }

  public void insert(int index, int value) throws Exception {
    if (index < 0 || index > size) {
      throw new Exception("Index out of bound");
    }

    if (index == 0) {
      this.pushFront(value);
      return;
    }

    if (index == size) {
      this.pushBack(value);
      return;
    }

    Node node = new Node(value);
    Node prev = new Node(0);
    Node traverse = head;
    prev.next = traverse;

    while (traverse != null && index-- > 0) {
      prev = prev.next;
      traverse = traverse.next;
    }

    node.next = traverse;
    prev.next = node;
    size++;
  }

  public void erase(int index) throws Exception {
    if (index < 0 || index >= size) {
      throw new Exception("Index out of bound");
    }

    if (index == 0) {
      this.popFront();
      return;
    }

    if (index == size - 1) {
      this.popBack();
      return;
    }
    Node prev = new Node(0);
    Node traverse = head;

    prev.next = traverse;

    while (traverse != null && index-- > 0) {
      prev = prev.next;
      traverse = traverse.next;
    }

    prev.next = traverse == null ? null : traverse.next;
    size--;
  }

  public int valueNFromEnd(int n) throws Exception {
    if (n <= 0 || n > size) {
      throw new Exception("Index out of bound");
    }

    Node traverse = head;

    Node prev = traverse;

    while (traverse != null && n-- > 0) {
      traverse = traverse.next;
    }

    while (traverse != null) {
      traverse = traverse.next;
      prev = prev.next;
    }

    return prev.value;
  }

  public void reverse() {
    Node prev = null;

    while (head != null) {
      Node next = head.next;

      head.next = prev;
      prev = head;
      head = next;
    }
    head = prev;
  }

  public void removeValue(int value) {
    Node prev = new Node(0);
    Node traverse = head;

    prev.next = traverse;

    while (traverse != null && traverse.value != value) {
      traverse = traverse.next;
      prev = prev.next;
    }

    if (traverse == null) {
      return;
    }

    prev.next = prev.next.next;
    size--;
  }

  public String toString() {
    Node traverse = head;
    StringBuilder sb = new StringBuilder();

    while (traverse != null) {
      sb.append(traverse.value);
      traverse = traverse.next;
      if (traverse != null) {
        sb.append(",");
      }
    }

    return sb.toString();
  }
}
