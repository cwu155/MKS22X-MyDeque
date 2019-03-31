import java.util.*;

public class Calculator{
  /*
    Evaluate a postfix expression stored in s.
    Assume valid postfix notation, separated by spaces.
  */

    public static boolean isNumber(String input){
      try {
          double token = Double.parseDouble(input);
          } catch (NumberFormatException nfe) {
            return false;
          }
        return true;
    }

    public static double eval(String s){

      ArrayList<String> tokens = new ArrayList<String>();
      MyDeque<Double> numbers = new MyDeque<Double>(10);

      Scanner tokenize = new Scanner(s);
      while (tokenize.hasNext()) {
          String toAdd = tokenize.next();

          if (isNumber(toAdd)){
            numbers.addLast(Double.parseDouble(toAdd));
          } else {
            tokens.add(toAdd);
          }
      }
      System.out.println(tokens);
      System.out.println(numbers);

      for (String element : tokens){
        Double a = numbers.removeFirst();
        Double b = numbers.removeFirst();

        if (element.equals("+")){
            numbers.addFirst(a + b);
          }
       if (element.equals("-")){
            numbers.addFirst(a - b);
          }
        if (element.equals("*")){
            numbers.addFirst(a * b);
          }
        // if (element.equals("/")){
        //     Double divisor = numbers.removeFirst();
        //     numbers.addFirst(numbers.removeFirst() / divisor);
        //   }
        }

       return numbers.removeFirst();
     }

    public static void main(String[] args) {
      System.out.println(eval("10 4.0 -"));
      System.out.println(eval("11 3 - 4 + 2.5 *"));
      System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));;
    }
}
