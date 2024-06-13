package Homework.Stack;

public class ArrayStack<E> {

  static int CAPACITY = 100;
  private E[] data;
  private int t = -1; // index of the top element in the stack;

  public ArrayStack() {this(CAPACITY)}

  public ArrayStack(int capacity) {
   data = (E[]) new Object[capacity];
  }

  public int size() {
   return t + 1;
  }

  public boolean isEmpty() {
    return t == -1;
  }

  public void push(E e) throws IllegalStateException {
   if (t == data.length) {
    throw new IllegalStateException("Stack is full");
   }

   data[++t] = e;
  }

  public E pop() {
   if (isEmpty()) {
    return null;
   }

   E result = data[t];
   data[t--] = null;
   return result;
  }

  public E top() {
   if (isEmpty()) {
    return null;
   }

   return data[t];
  }
}
