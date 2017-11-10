class CircularArrayList {
  int max;
  Object[] items;
  int size;
  int front;
  int rear;
  
  
  public CircularArrayList(int max) {
    this.max = max;
    items = new Object[max];
    size = 0;
    front = 0;
    rear = 0;
  }
  
  void extend() {
    max *= 2;
    Object[] itemsBigger = new Object[max];
    for (int i = 0; i < size; i++) {
      itemsBigger[i] = items[front];
      front = (front + 1) % size;
    }
    front = 0;
    rear = size;
    items = itemsBigger;
  }
  
  void enqueue(Object item) {
    if (size == max) {
      extend();
    }
 
    items[rear] = item;
    rear = (rear + 1) % max;
    this.size++;
    System.out.println("Successfully added -> " + item + " -> array.");
  }
  
  Object dequeue() {
    if (isEmpty()) {
      throw new Error("List is Empty!");
    } 
    
    int i = 0;
    for (; i < size; i++) {
      if (items[i] != null) {
        break;
      }
    }

    Object item = items[i];
    items[i] = null;
    
    front = (front + 1) % max;
    return item;
  }
  
  Object peek() {
    if (isEmpty()) {
      throw new Error();
    }
    
    Object item = items[front];
    return item;
  }
  
  boolean isEmpty() {
    for (int i = 0; i < size; i++) {
      if (items[i] != null) {
        return false;
      }
    }
    return true;
  }
  
  int size() {
    return this.size;
  }
  
 //////////////////////////////////////////////////////////////////////////
 // for displaying current content of array
  
  void display() {
    System.out.println("///////////////////////////////////////////////////////////////////////////");
    System.out.println("Front value -> " + front + " : Rear value -> " + rear);
    System.out.println("\nCurrent max of array -> " + max + " : Current size of array -> " + size);
    System.out.println("\nDisplaying current elements in the array list");
    for (int i = 0; i < size; i++) {
      System.out.println("-- " + items[i]);
    }
    System.out.println("///////////////////////////////////////////////////////////////////////////");
  }
  
}

///////////////////////////////////////////////////////////////////////////

public class ArrayQueue {

  public static void main(String[] args) {
    CircularArrayList l = new CircularArrayList(1);
    
    l.enqueue(1);
    l.display();
    l.enqueue(2);
    l.display();
    l.enqueue(3);
    l.display();
    l.enqueue(4);
    l.display();
    System.out.println("Dequeueing -> " + l.dequeue());
    l.display();
    System.out.println("Dequeuing -> " + l.dequeue());
    l.display();
    System.out.println("Peeking -> " + l.peek());
    l.display();
    l.enqueue(5);
    l.display();
    System.out.println("Dequeueing -> " + l.dequeue());
    l.display();
    l.enqueue(6);
    l.display();
    System.out.println("Dequeueing -> " + l.dequeue());
    l.display();
    l.enqueue(7);
    l.display();
    l.enqueue(8);
    l.display();
    l.enqueue(9);
    l.display();
    System.out.println("Dequeueing -> " + l.dequeue());
    System.out.println("Dequeueing -> " + l.dequeue());
    System.out.println("Dequeueing -> " + l.dequeue());
    System.out.println("Dequeueing -> " + l.dequeue());
    l.display();
    System.out.println("Is the array list empty? -> " + l.isEmpty());
    l.display();
    System.out.println("Dequeueing -> " + l.dequeue());
    l.display();
    System.out.println("Is the array list empty? -> " + l.isEmpty());
    l.enqueue(10);
    l.display();
    System.out.println("Is the array list empty? -> " + l.isEmpty());
    l.dequeue();
    l.display();
    System.out.println("Is the array list empty? -> " + l.isEmpty());
    l.dequeue(); // expect error
    l.display();
    System.out.println("Is the array list empty? -> " + l.isEmpty());
    
  }

}
