package Homework.Queue;

public class ArrayQueue<E> {

  static final int CAPACITY = 100;

  private E[] data;
  private int f = 0;
  private int sz = 0;

  public ArrayQueue() {
    this(CAPACITY);
  }

  public ArrayQueue(int capacity) {
    data = (E[]) new Object[capacity];
  }

  public int size() {
    return sz;
  }

  public boolean isEmpty() {
    return sz == 0;
  }

  public void enqueue(E e) throws IllegalStateException {
    if (isFull()) {
      throw new IllegalStateException("Queue is full");
    }

    int available = (f + sz) % data.length;
    data[available] = e;
    sz++;
  }

  public E dequeue() {
    if (isEmpty()) {
      return null;
    }
    E e = data[f];
    data[f] = null;
    f = (f + 1) % data.length;
    sz--;
    return e;
  }

  public boolean isFull() {
    return sz == data.length;
  }
}
