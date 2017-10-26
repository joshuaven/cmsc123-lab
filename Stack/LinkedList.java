import java.util.NoSuchElementException;

class LinkedList<E> implements Collection<E> {

  class Node {
    E data;
    Node next;
    
    Node(E data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
  
  Node head = null;
  Node temp = null;
  int size = 0;
  
  // -> true
  // Returns true if an item has successfully added to the Linked List at a given index
  boolean add(E item, int index) {
    
    if (index == 1) {
      Node newNode = new Node(item, head);
      head = newNode;
      size++;
      return true;
    }
    
    Node newNode = new Node(item, head);
    Node previous = head;
    Node current = head.next;
    
    int previousIndex = 1;
    
    if (index > size + 1) {
      return false;
    }
    
    while (previous != null) {
      if (previousIndex == (index - 1)) {
        previous.next = newNode;
        newNode.next = current;
        size++;
        return true;
      } 
      previousIndex++;
      previous = current;
      current = current.next;
    }
    return false;
  }
  
  // -> boolean
  // Returns true if the item at the given index has been successfully removed
  boolean remove(int index) {
    Node previous = head;
    Node current = head.next;
    
    if (index == 1) {
      previous = null;
      head = current;
      size--;
      return true;
    } else if (index == size) {
        while (current != null) {
          if (current.next == null){
            current = null;
            previous.next = null;
            size--;
            return true;
          }
          previous = current;
          current = current.next;
        }
    } else {
      int i = 2;
      while (current != null) {
        if (i == index) {
          current = current.next;
          previous.next = current;
          this.size--;
          return true;
        }
        previous = current;
        current = current.next;
        i++;
      }
    }
    return false;
  }
  
  int size() {
    return size;
  }
  
  void display() {
    Node current = head;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }
  }

  public Iterator<E> iterator() {
    return new LinkedListIterator();
  }
  
  class LinkedListIterator implements Iterator<E> {

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



