/*
 * Problem3.java
 *
 * Computer Science 112, Boston University
 */

public class Problem3 {
  public static void printPattern2(int m, int n){
    if(m == n){
      return;
    }
    if(m<n){
      System.out.println("(");
      printPattern2(m + 1, n);
      System.out.println("\\");     /* prints a single backslash */
    }
    else{
      System.out.println(")");
      printPattern2(m, n + 1);
      System.out.println("/");
    }
  }
}