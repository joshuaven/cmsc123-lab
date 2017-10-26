
interface Iterator<E> {
  
  // -> boolean
  // Return true if the iteration has more elements. Otherwise, throw an exception
  boolean hasNext();
  
  // -> E
  // Returns the next element in the iteration
  E next();
}


