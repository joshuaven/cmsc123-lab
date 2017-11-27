class HashData {
    String key;
    int value;
  
    public HashData(String key, int value) {
      this.key = key;
      this.value = value;
    }
    
    int getValue() {
      return value;
    }
    
    void setValue(int thisValue) {
      this.value = thisValue;
    }
    
    String getKey() {
      return key;
    }
  }

class HashTable {
  
  class HashNode {
    HashData data;
    HashNode next;
    
    public HashNode(HashData data, HashNode next) {
      this.data = data;
      this.next = next;
    }
  }
  
 
  int size = 0;
  HashNode head = null;
  
  String[] keys() {
    HashNode curr = head;
    String[] kis = new String[size];
    
    for (int i = 0; curr != null; i++, curr = curr.next) {
      kis[i] = curr.data.getKey();
    }
    
    //for printing the list
    for (int i = 0; i < kis.length; i++) {
      System.out.println(kis[i]);
    }
    
    return kis;
    
  }
  
  boolean containsKey(String key) {
    HashNode curr = head;
    while (curr != null) {
      if (curr.data.getKey().equals(key)) {
        return true;
      }
      curr = curr.next;
    }
    return false;
  }
  
  int[] values() {
    HashNode curr = head;
    int[] vals = new int[size];
    for (int i = 0; curr != null; curr = curr.next, i++) {
      vals[i] = curr.data.getValue();
      /////// --for printing -- //////
      System.out.println(vals[i]);
      ////////////////////////////////
    }
    return vals;
  }
  
  
 //determining the index of a given key 
 Integer indexOf(String key) {
    HashNode curr = head;
    int i = size;
    while (curr != null) {
      if (curr.data.getKey().equals(key)) {
        return i;
      }
      curr = curr.next;
      i--;
    }
    return null;
  }
  
  Integer remove(String key) {
    HashNode prev = head;
    HashNode curr = head.next;
    
    Integer i = indexOf(key);
    
    // index null should return null
    if (i == null) {
      return null;
    }
    
    if (i == size) {
      int remove = prev.data.getValue();
      prev = null;
      head = curr;
      size--;
      return remove;
    } else if (i > 1 && i < size) {
      int j = 2;
      while (curr != null) {
        if (j == i - 1) {
          int remove = curr.data.getValue();
          curr = curr.next;
          prev.next = curr;
          size--;
          return remove;
        }
        prev = curr;
        curr = curr.next;
        j++;
      } 
    } else if (i == 1) {
      while (curr != null) {
        if (curr.data.getKey().equals(key)) {
          int remove = curr.data.getValue();
          curr = null;
          prev.next = null;
          return remove;
        }
        prev = curr;
        curr = curr.next;
      }
    }
    return null;
  }
  
  Integer get(String key) {
    HashNode curr = head;
    while (curr != null) {
      if (curr.data.getKey().equals(key)) {
        return curr.data.getValue();
      }
      curr = curr.next;
    }
    return null;
  }
  
  void put(String key, int value) {
    HashNode curr = head;
    while (curr != null) {
      if (curr.data.getKey().equals(key)) {
        curr.data.setValue(value);
        return;
      }
      curr = curr.next;
    }
    HashData newData = new HashData(key, value);
    HashNode newNode = new HashNode(newData, head);
    head = newNode;
    size++; 
  }
  
  
  //printing the current state of the Linked List
  void display() {
    HashNode curr = head;
    while (curr != null) {
      System.out.println(curr.data.key + " : " + curr.data.value);
      curr = curr.next;
    }
  }
}

public class HashTableMain {

  public static void main(String[] args) {
    HashTable l = new HashTable();
    
    l.put("one", 1);
    l.put("two", 2);
    l.put("three", 3);
    l.put("four", 4);
    l.put("one", 11);
    System.out.println("The size of list is " + l.size);
    l.values();
    l.display();
    System.out.println(l.get("one"));
    System.out.println(l.get("four"));
    System.out.println(l.get("five"));    
    l.display();
    System.out.println(l.containsKey("one"));
    System.out.println(l.containsKey("four"));
    System.out.println(l.containsKey("five"));
    l.keys();
    l.display();
    System.out.println(l.remove("one"));
    System.out.println(l.remove("three"));
    System.out.println(l.remove("four"));
    System.out.println(l.remove("five"));
    l.display();
  }
}
