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

    MyDeque<Double> numbers = new MyDeque<Double>();
    String tokens = "";

    for(int i = 0; i < s.length(); i++){
      if (Character.isDigit(s.charAt(i)) || s.charAt(i)=='.' ||
        (s.charAt(i)=='-' && i+1<s.length() && Character.isDigit(s.charAt(i+1)))){
        tokens += s.charAt(i);
      } else if (s.charAt(i) != ' ') {

        Double a = numbers.removeFirst();
        Double b = numbers.removeFirst();

        if(s.charAt(i) == '+'){
          numbers.addFirst(a+b);
        } else if(s.charAt(i) == '-'){
          numbers.addFirst(b-a);
        } else if(s.charAt(i) == '*'){
          numbers.addFirst(a*b);
        } else if(s.charAt(i) == '/'){
          numbers.addFirst(b/a);
        } else if(s.charAt(i) == '%'){
          numbers.addFirst(b%a);
        }
        i++;
      } else{
        numbers.addFirst(Double.parseDouble(tokens));
        tokens = "";
      }
    }
    return numbers.removeFirst();
  }

    public static void main(String[] args) {
      System.out.println(eval("4 5 6 * +"));
      System.out.println(eval("11 3 - 4 + 2.5 *"));
      System.out.println(eval("1 2 3 4 5 + * - -"));
      System.out.println(eval("10 2.0 +"));
      System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}
