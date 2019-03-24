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
  }

  //"Inserts the specified element at the front of this deque if it is possible to do so immediately without violating capacity restrictions."
  //Stack method?
  public void addFirst(E element){
    if (element == null){ throw new NullPointerException(); }
    if (data[start-1] != null){
      resize();
    }
    data[start - 1] = element;
    start -= 1;

    size += 1;
    data[0] = element;
    for (int i = 1; i < data.length-1; i++){
      data[i + 1] = data[i];
    }
  }

  public void addLast(E element){
    if (element == null){ throw new NullPointerException(); }
    if (data[data.length-1] != null){
      resize();
      data[end] = element;
    } else {
      data[end] = element;
    }
    end += 1;
    size += 1;
  }
  // public E removeFirst(){ }
  // public E removeLast(){ }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end-1];
  }

  public static void main(String[] args) {
    MyDeque test;
    test = new MyDeque(10);
    for (int i = 0; i < 12; i++){
      test.addLast(i);
    }
    System.out.println("End index: " + end);
    System.out.println("Last element: " + test.getLast());
    System.out.println("Size: " + test.size());
    System.out.println(test.toString());
  }
}
