class Heap {
  int[] list;
  int maxCapacity;
  int size;
  
  Heap(int maxCapacity) {
    this.maxCapacity = maxCapacity;
    this.size = 0;
    list = new int[maxCapacity];
     
  }
  
  int bubbleUp(int item) {
    if (item == list[0]) {
      return item;
    }
    for (int i = 0; i < size; i++) {
      if (list[i] == item) {
        if (list[i] >= list[(i - 1)/ 2]) {
          return item;
        }
        int temp = list[(i - 1) / 2];
        list[(i - 1) / 2] = list[i];
        list[i] = temp;
        return bubbleUp(list[(i - 1)/ 2]);
      }
    }
    throw new Error();
  }
  
  void add(int item) {
    list[size] = item;
    size++;
    bubbleUp(item);
  }
  
  void trickleDown(int index) {
    int indexOfLeft = 2 * index + 1;
    int indexOfRight = 2 * index + 2;
    int indexOfLargest = index;
    int indexOfLastElement = size - 1;
    
    if (indexOfLeft <= indexOfLastElement) {
      if (compare(list[indexOfLeft], list[index]) < 0) {
        indexOfLargest = indexOfLeft;
      }
      if (indexOfRight <= indexOfLastElement) {
        if (compare(list[indexOfLargest], list[indexOfRight]) > 0) {
          indexOfLargest = indexOfRight;
        }
      } 
      if (indexOfLargest != index) {
        int temp = list[index];
        list[index] = list[indexOfLargest];
        list[indexOfLargest] = temp;
        trickleDown(indexOfLargest);
      }
    }
  }
  
  int compare(int i, int j) {
    if (i > j) {
      return 1;
    } else if (i < j) {
      return -1;
    }
    return 0;
  }

  int remove() {
    int oldTop = list[0];
    list[0] = list[size - 1];
    size--;
    trickleDown(0);
    return oldTop;
  }
  
  void print() {
    for (int i = 0; i < size; i++) {
      System.out.print(" " + list[i]);
    }
  }
  
  void preorder(int index) {
    if (index >= size) {
      return;
    }
    System.out.print(" " + list[index]);
    preorder(2 * index + 1);
    preorder(2 * index + 2);
  }
  
  void inorder(int index) {
    if (index >= size) {
      return;
    }
    inorder(2 * index + 1);
    System.out.print(" "+ list[index]);
    inorder(2 * index + 2);
  }
  
  void postorder(int index ) {
    if (index >= size) {
      return;
    }
    postorder(2 * index + 1);
    postorder(2 * index + 2);
    System.out.print(" " + list[index]);
  }
}


class MinHeap {
  public static void main(String[] args) {
    Heap l = new Heap(10);
    l.add(12);
    l.add(13);
    l.add(14);
    l.add(15);
    l.add(9);
    l.add(8);
    l.print();
    System.out.println();
    System.out.print("Preorder Traversal ->");
    l.preorder(0);
    System.out.println();
    System.out.print("Inorder Traversal ->");
    l.inorder(0);
    System.out.println();
    System.out.print("Postorder Traversal ->");
    l.postorder(0);
    System.out.println();
    System.out.println("\nBefore remove");
    l.print();
    System.out.println(l.remove());
    System.out.println("\nAfter remove");
    l.print();
    System.out.println(l.remove());
    System.out.println("\nAfter remove");
    l.print();
    l.add(1);
    System.out.println("\n Adding new item after removing");
    l.print();
  }
}