import java.util.*;

public class MyDeque<E>{
  private E[] data;
  public static int size, start, end, i;

  //Constructor numero uno?
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0; start = 0; end = 0;
  }

  //Constructor numero dos con size?
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0; start = 0; end = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    if (size == 0){ return "{}";}
    String result = "{";

    //addFirst
    if (start > end){
      for (int i = start; i < data.length; i++){
        if (i == data.length-1){
          result += data[i];
        } else {
          result += data[i] + " ";
        }
      }
    }

    //addLast
    if (start < end){
      for (int i = 0; i < end; i++){
        if (i == end-1){
          result += data[i];
        } else {
          result += data[i] + " ";
        }
      }
    }
    return result += "}";
  }

  public E getFirst(){
    if (size() <= 0){ throw new NoSuchElementException(); }
    return data[start];
  }

  public E getLast(){
    if (size() <= 0){ throw new NoSuchElementException(); }
    return data[end-1];
  }

  public void resize(){
    @SuppressWarnings("unchecked")
    E[] copy = (E[])new Object[(size() * 2) + 1];
    int j = 0;
    int k = copy.length-1;

    if (start >= end){
      //System.out.println("It's addFirst!");
      for (int i = data.length-1; i >= 0; i--) {
        copy[k] = data[i];
        k--;
      }
    }

    if (start < end){
      //System.out.println("It's addLast!");
      for (int i = 0; i < end; i++){
        copy[j] = data[i];
        j++;
      }
    }

    data = copy;
  }

  public void addFirst(E element){
    if (element == null){ throw new NullPointerException(); }

    if (size == data.length){
      resize();
      start = 0;
      //end = size-1;
    }

    if (start == 0){
      start = data.length-1-size;
    } else {
      start -= 1;
    }

      data[start] = element;
      size += 1;
  }

  public void addLast(E element){
    if (element == null){ throw new NullPointerException(); }
    if (data[data.length-1] != null || size == data.length){
      resize();
      start = 0;
      data[end] = element;
    } else {
      data[end] = element;
    }
      end += 1;
      size += 1;
  }

  public E removeFirst(){
    if (size() <= 0) { throw new NoSuchElementException();}
    if (size() == 1) {
      size = 0;
      return data[start];
    }

    E toRemove = getFirst();
    //data[start] = null;
    start += 1;
    size -= 1;
    return toRemove;
  }

  public E removeLast(){
    if (size() <= 0) { throw new NoSuchElementException();}
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
    for (int i = 0; i < 101; i++){
      test.addFirst(i);
      //test.addLast(i);
    }

    System.out.println("Start: " + start);
    System.out.println("End: " + end);

    // for (int i = 0; i < 10; i++){
    //   test.removeFirst();
    // }
    //System.out.println("End index: " + end);
    //System.out.println("Last element: " + test.getLast());
    System.out.println("Size: " + test.size());
    System.out.println(test);
  }
}
