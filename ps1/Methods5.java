/*
 * Problem Set 1, Problem 5
 *
 * Practice with static methods, part I
 *
 * Note: Because this class is simply a collection of static methods 
 * and it does not have a main method, you cannot run it.
 * See the problem set for instructions about how to test the methods 
 * that you write.
 */

public class Methods5 {
  /*
   * printVertical - takes a string s and prints the characters of 
   * the string vertically -- with one character per line.
   */
  public static void printVertical(String s) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      System.out.println(c);
    }
  }
  public static void printWithSpaces(String s){
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      String s1 = c + " ";
      System.out.print(s1);
    }System.out.println(" ");
  }
  public static char middleChar(String s){
    char middle;
    int Length=s.length();
    if(Length%2==0){
      middle=s.charAt((Length/2)-1);
    }
    else 
      middle=s.charAt((Length/2));
    return middle;
    
  }
  public static String moveToEnd( String s, int i){
    int Length = s.length();
    String newS;
    if(Length < i){
      newS = s;
    }
    else
      newS = (s.substring(i,Length)) + (s.substring(0, i));
    return newS;
  }
    
  
}