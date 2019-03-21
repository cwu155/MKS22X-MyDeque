public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  //Add: (push / en-queue)
  //Get: return but NOT remove the element. (peek)
  //Remove: return AND remove the element. (pop / de-queue)
  //Size,Add, remove, and get should be O(1)

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[size];
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
  }
  public int size(){
    return size;
  }
  //public String toString(){ }
  public void addFirst(E element){ }
  public void addLast(E element){ }
  // public E removeFirst(){ }
  // public E removeLast(){ }
  // public E getFirst(){ }
  // public E getLast(){ }
}
