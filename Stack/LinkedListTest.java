import junit.framework.TestCase;

public class LinkedListTest extends TestCase {

  
  public void testAdd() {
    LinkedList l = new LinkedList();
    String h = new String("Hello");
    String w = new String("World");
    Integer o = new Integer(1);
    
    assertEquals(true, l.add(h, 1));
    assertEquals(true, l.add(w, 2));
    assertEquals(false, l.add(o, 5));
  }
  
  public void testRemoveAndSize() {
    LinkedList l = new LinkedList();
    String h = new String("Hello");
    String w = new String("World");
    Integer o = new Integer(1);
    
    l.add(h, 1);
    l.add(w, 2);
    l.add(o, 3);
    
    assertEquals(true, l.remove(2));
    assertEquals(2, l.size());
    assertEquals(false, l.remove(4));
    assertEquals(2, l.size());
    assertEquals(true, l.remove(1));
    assertEquals(1, l.size());
  }
  
  public void testHasNextAndNext() {
    LinkedList l = new LinkedList();
    String h = new String("Hello");
    String w = new String("World");
    Integer o = new Integer(1);
    
    Iterator itr = l.iterator();  
    assertEquals(false, itr.hasNext());
    
    l.add(h, 1);
    l.add(w, 2);
    l.add(o, 3);
    Iterator itr2 = l.iterator();
    assertEquals(true, itr2.hasNext());
    assertEquals("Hello", itr2.next());
    assertEquals(true, itr2.hasNext());
    assertEquals("World", itr2.next());
    assertEquals(true, itr2.hasNext());
    assertEquals(1, itr2.next());
    assertEquals(false, itr2.hasNext());
  }
}
