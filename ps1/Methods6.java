/*
 * Problem Set 1, Problem 6
 *
 * Practice with static methods, part II
 *
 * Note: Because this class is simply a collection of static methods 
 * and it does not have a main method, you cannot run it.
 * See the problem set for instructions about how to test the methods 
 * that you write.
 */

public class Methods6 {
 /*takes a String as its parameter and prints decreasing substrings of the original string */
  public static void printDecreasing( String s){
    int Length = s.length();
    String newS;
    for(int i = Length; i >0; i--){
      newS = s.substring(0, i);
      System.out.println(newS);
    }
  }
  /*akes a string str as its parameter and returns a new string formed by combining the first and last characters of str. If the string has only one character, the method should just return the original string.*/
  public static String firstAndLast( String s){
    String newS;
    int Length = s.length();
    if(Length == 1){
      newS = s.substring(0,1);
    }
    else
      newS = s.substring(0,1) + s.substring(Length -1, Length);
    return newS;
  }
  /* takes as its two parameters a string str and a character ch and returns the index of the last occurrence of ch in str. If ch does not appear in str at all, the method should return -1*/
  public static int lastIndexOf(String s, char x){;
    int Length = s.length();
    for(int i = Length-1; i>=0; i--){
      if (s.charAt(i) == x){
        return i;
      }
    }
    return -1;
  }
  /* takes as its two parameters a string str and an integer n and returns a new string consisting of n copies of str.*/
  public static String repeat( String s, int times){
    String result = "";
    for(int i = times; i > 0; i --){
      result += s;
    }
    return result;
  }
}


