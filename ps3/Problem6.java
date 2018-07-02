/*
 * Problem Set 3, Problem 6
 *
 * Recursive string processing
 *
 * Note:  implement the methods described below, 
 * and then create a main() method to test these methods
 */

public class Problem6{
  /*
   * a static method called reflect that takes a string as 
   * its parameter and uses recursion to create and return a 
   * ¡°reflected¡± version of the string in which the original 
   * string is followed by the characters of the string in reverse order. */
  public static String reflect(String str) {
    if(str == null){
      throw new IllegalArgumentException();
    }
    if(str.equals("")){
      return "";
    }
    else{
      String rest = reflect(str.substring(1));
      return str.charAt(0) + rest + str.charAt(0);
    }
  }
  /*a static method called lastIndexOf that takes as its two 
   * parameters a string str and a character ch 
   * and returns the index of the last occurrence of ch in str. 
   * If ch does not appear in str at all, the method should return -1.
   * */
  public static int lastIndexOf(String s, char a){
    if(s == null){
      throw new IllegalArgumentException(); 
    }
    if(s.length() == 0){
      return -1;
    }
    else{
      int count = 0;
      String rest = s.substring(0, s.length()-1);
      if (a == s.charAt(s.length()-1)){
        return count = s.length()-1;
      }
      else{
        return lastIndexOf(rest, a);
      }
    }
  }
  /* a main function, used to test lastIndexOf and reflect*/
  public static void main(String [] args){
    System.out.println(reflect("method"));
    System.out.println(reflect("hello"));
    System.out.println(lastIndexOf("Boston", 'o'));
    System.out.println(lastIndexOf("banana", 'x'));
  }
  
}


