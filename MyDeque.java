public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

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
    String result = "{ ";
    for (E i: data){
      result += i;
      result += " ";
    }
    return result += " }";
  }

  //"Inserts the specified element at the front of this deque if it is possible to do so immediately without violating capacity restrictions."
  //Stack method?
  public void addFirst(E element) throws NullPointerException {
    data[0] = element;
    for (int i = 1; i < data.length-1; i++){
      data[i + 1] = data[i];
    }
  }

  public void addLast(E element) throws NullPointerException { }
  // public E removeFirst(){ }
  // public E removeLast(){ }
  // public E getFirst(){ }
  // public E getLast(){ }

  public static void main(String[] args) {
    MyDeque test;
    test = new MyDeque(10);
    test.addFirst(1);
    test.addFirst(2);

    System.out.println(test.size());
    System.out.println(test.toString());
  }
}
