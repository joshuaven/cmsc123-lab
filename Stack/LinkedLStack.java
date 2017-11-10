import java.util.NoSuchElementException;

class Stack<E> implements Collection<E> {

  class Node {
    E data;
    Node next;
    
    public Node(E data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
  
  Node head = null;
  Node temp = null;
  int size = 0;
  
  boolean isEmpty() {
    return this.size == 0;
  }
  
  void push(E item) {
    Node newNode = new Node(item, head);
    head = newNode;
    size++;
  }
  
  E pop() {
    if (isEmpty()) {
      throw new Error();
    }
    
    Node current = head;
    Node next = head.next;
    
    E item = current.data;
    current = null;
    head = next;
    size--;
    return item;
  }
  
  E peek() {
    if (isEmpty()) {
      throw new Error();
    }
      
    return head.data;
  }
  
  int size() {
    return this.size;
  }
  
  //////////////////////////////////////////////////////////
  
  void display() {
    System.out.println("Displaying current items in the Linked List");
    Node current = head;
    while (current != null) {
      System.out.println("--" + current.data);
      current = current.next;
    }
    System.out.println();
  }
  
  //////////////////////////////////////////////////////////
  
  public Iterator<E> iterator() {
    return new StackIterator();
  }
  
  class StackIterator implements Iterator<E>{
    Node current = head;
    
    public boolean hasNext() {
      return current != null;
    }
    
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      } 
      E item = current.data;
      current = current.next;
      return item;
    }
    
  }
}


public class LinkedLStack {
  
  public static void main(String[] args) {
    Integer o = new Integer(1);
    Integer t = new Integer(2);
    Integer th = new Integer(3);
    
    Stack l = new Stack();
    
    // System.out.println(l.pop()); // expect error
    
    l.push(o);
    l.push(t);
    l.push(th);
    
    l.display();    
    /* Expect -> 3
     *           2 
     *           1
    */
    
    System.out.println("Popping last entered item in the Linked List -> " + l.pop() + "\n"); // popping 3
    System.out.println("Popping last entered item in the Linked List -> " + l.pop() + "\n"); // popping 2
    
    l.display();
    
    System.out.println("First item in the Linked List -> " + l.peek()); // 1
    System.out.println("Size of the Linked List -> " + l.size()); // 1
  }
}
