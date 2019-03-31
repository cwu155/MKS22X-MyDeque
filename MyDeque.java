import java.util.*;

public class MyDeque<E>{
  private E[] data;
  public static int size, start, end, dataSize;

  //Constructor numero uno?
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0; start = 0; end = 0; dataSize = 10;
  }

  //Constructor numero dos con size?
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

    //addFirst
    if (start >= end){
      for (int i = start; i < dataSize; i++){
        if (i == dataSize-1){
          result += data[i];
        } else {
          result += data[i] + " ";
        }
      }
    }

    //addLast
    if (start < end){
      for (int i = start; i < end; i++){
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
    return data[data.length-1];
  }

  public void resize(){
    @SuppressWarnings("unchecked")
    E[] copy = (E[])new Object[(size() * 2) + 1];
    dataSize = (size() * 2) + 1;
    int j = 0;
    int k = copy.length-1;

    //addFirst
    if (start >= end){
      for (int i = data.length-1; i >= 0; i--) {
        copy[k] = data[i];
        k--;
      }
    }

    //addLast
    if (start < end){
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
    if (size() <= 0) { System.out.println("You did a yikes :("); throw new NoSuchElementException();}
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
    if (size() <= 0) { System.out.println("You did a yikes :("); throw new NoSuchElementException();}
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

  public static void main(String[] args) {
    MyDeque<Integer> test = new MyDeque<>();
    for (int i = 0; i < 15; i++){
      test.addFirst(i);
      //test.addLast(i);
    }

    System.out.println("Start: " + start);
    System.out.println("End: " + end);
    System.out.println("Size: " + test.size());

    System.out.println(test);
    System.out.println("---------------------------------------");

    for (int i = 0; i < 6; i++){
      test.removeFirst();
      //test.removeLast();
    }

    System.out.println("New Start: " + start);
    System.out.println("New End: " + end);
    System.out.println("New Size: " + test.size());
    System.out.println(test);
  }
}
