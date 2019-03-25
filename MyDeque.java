import java.util.*;

public class MyDeque<E>{
  private E[] data;
  public static int size, start, end;

  //Add: (push / en-queue)
  //Get: return but NOT remove the element. (peek)
  //Remove: return AND remove the element. (pop / de-queue)
  //Size, add, remove, and get should be O(1)

  //Constructor numero uno?
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[size];
    size = 0; start = 0; end = 0;
  }

  //Constructor numero dos con size?
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0; start = 0; end = 0;
  }

  //Returns size!
  public int size(){
    return size;
  }

  //Prints out deck :3
  public String toString(){
    if (size() == 0){ return "{}"; }
    String result = "{";
    for (int i = 0; i < data.length; i++){
      if (i == data.length-1){
        result += data[i];
      } else {
        result += data[i];
        result += " ";
      }
    }
    return result += "}";
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end-1];
  }

  //Too lazy to put this code in all the add/remove methods -_-
  public void resize(){
    @SuppressWarnings("unchecked")
    E[] copy = (E[])new Object[(size() * 2) + 1];
    int j = 0;
      for (int i = 0; i < size(); i++){
        copy[i] = data[j];
        j++;
      }

    data = copy;
    start = 0;
    end = size() - 1;

  }

  //"Inserts the specified element at the front of this deque if it is possible to do so immediately without violating capacity restrictions."
  //Stack method?
  public void addFirst(E element){
    if (element == null){ throw new NullPointerException(); }

    if (size >= data.length){
      resize();

    }

    if (start == 0){
      data[start] = element;
      start = data.length-1;
      size += 1;
    } else {
      start -= 1;
      data[start] = element;
      size += 1;
    }

    data[start] = element;
  }

  public void addLast(E element){
    if (element == null){ throw new NullPointerException(); }
    if (data[data.length-1] != null || size == data.length){
      resize();
      data[end] = element;
    } else {
      data[end] = element;
    }
      end += 1;
      size += 1;
  }
  // public E removeFirst(){ }

  public E removeLast(){
    if (size() == 0) { throw new NoSuchElementException();}
    if (size() == 1) {
      size = 0;
      return data[start];
    }

    E toRemove = getLast();
    data[end-1] = null;
    end -= 1;
    size -= 1;
    return toRemove;
}

  public static void main(String[] args) {
    MyDeque test;
    test = new MyDeque(10);
    for (int i = 0; i < 13; i++){
      test.addFirst(i); System.out.println("Current start: " + start + ", " + i);
    }

    //System.out.println("End index: " + end);
    //System.out.println("Last element: " + test.getLast());
    System.out.println("Size: " + test.size());
    System.out.println(test);

  }
}
