import java.util.*;

public class MyDeque<E>{
  private E[] data;
  public static int size, start, end, dataSize;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0; start = 0; end = 0; dataSize = 10;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0; start = 0; end = 0; dataSize = initialCapacity;
  }

  public int size(){
    return size;
  }

  public String toString(){
    if (size == 0){ return "{}";}
    String result = "{";

    //debug
    // for (int i = 0; i < data.length; i++){
    //   //if (data[i] != null){
    //   result += data[i] + " ";
    //   //}
    // }

    //addFirst
    if (start >= end){
      for (int i = start; i < size + start; i++){
        if (i == size + start -1){
          result += data[i];
        } else {
          result += data[i] + " ";
        }
      }
    }

    //addLast
    if (start < end){
      for (int i = start; i < size; i++){
        if (i == size-1){
          result += data[i];
        } else {
          result += data[i] + " ";
        }
      }
    }
    return result += "}";
  }

  public void resize(){
    @SuppressWarnings("unchecked")
    E[] copy = (E[])new Object[(size() * 2) + 1];
    dataSize = (size() * 2) + 1;

    int j = 0;
    int k = copy.length-1;

    if (start >= end){
      for (int i = data.length-1; i >= 0; i--) {
        copy[k] = data[i];
        k--;
      }
      data = copy;
    }

    if (start < end){
    for (int i = start; i < end; i++) {
      copy[j] = data[i];
      j++;
    }
      start = 0;
      end = size;
      data = copy;
    }

  }

  public void addFirst(E element){
    if (element == null){ throw new NullPointerException(); }

    if (start < end){
      E[] copy = (E[])new Object[data.length + 1];
      int j = copy.length-1;
      for (int i = data.length-1; i >= 0; i--){
        copy[j] = data[i];
        j--;
      }
      data = copy;
      data[0] = element;
      size++;
      return;
    }

    if (size == data.length){
      resize();
      start = 0;
    }

    if (start == 0){
      start = data.length-1-size;
    } else {
      start--;
    }

    data[start] = element;
    size++;
  }

  public void addLast(E element){
    if (element == null){throw new NullPointerException();}

    if (size == data.length){
      resize();
    }

    if (end-1 == data.length-1) {
      end = 0;
    }

    if (start > end){
      E[] copy = (E[])new Object[data.length + 1];
      int j = 0;
      for (int i = start; i < data.length; i++){
        copy[j] = data[i];
        j++;
      }
      data = copy;
      start = 0;
      end = size;
    }

    data[end] = element;
    end++;
    size++;
  }

  public E removeFirst(){
    if (size() <= 0) {throw new NoSuchElementException();}
    if (size() == 1) {
      size = 0;
      return data[start];
    }

    E toRemove = getFirst();
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

    if (start >= end){
      end = 0;
    } else {
      end -= 1;
    }
    size -= 1;
    //dataSize = data.length-1;
    dataSize -= 1;
    return toRemove;
}

public E getFirst(){
  if (size() <= 0){ throw new NoSuchElementException(); }
  return data[start];
}

public E getLast(){
  if (size() <= 0){ throw new NoSuchElementException(); }
  return data[size - 1];
}

  public static void main(String[] args) {
    MyDeque<Integer> test = new MyDeque<>(5);
    for (int i = 0; i < 10; i++){
      test.addFirst(i);
      //test.addLast(i);
      System.out.println("Size: " + size + " Start: " + start + " End: " + end);
    }
    for (int i = -1; i > -10; i--){
      test.addFirst(i);
      //test.addLast(i);
    }

    // test.removeFirst();
    // test.removeFirst();
    // test.removeLast();

    System.out.println("Start: " + start);
    System.out.println("End: " + end);
    System.out.println("Size: " + size);
    System.out.println(test);
    System.out.println("First: " + test.getFirst());
    System.out.println("Last: " + test.getLast());
  }
}
