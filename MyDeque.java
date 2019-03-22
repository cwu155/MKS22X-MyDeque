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
  }

  //Constructor numero dos con size?
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    size = initialCapacity;
    data = (E[])new Object[size];
  }

  //Returns size!
  public int size(){
    return size;
  }

  public String toString(){
    String result = "{ ";
    for (E i: data){
      result += i;
      result += " ";
    }
    return result += " }";
  }

  public void addFirst(E element){

  }
  public void addLast(E element){ }
  // public E removeFirst(){ }
  // public E removeLast(){ }
  // public E getFirst(){ }
  // public E getLast(){ }

  public static void main(String[] args) {
    MyDeque test;
    test = new MyDeque(10);

    System.out.println(test.size());
    System.out.println(test.toString());
  }
}
