/**
 * Name:Kehan Wang
 * email:wangkk@bu.edu
 * takes two arrays of integers as parameters and uses an approach based on merging to find and return the intersection of the two arrays
 */

import java.util.*;

public class MergeIntersect {
  public static int[] intersect(int[] x, int[] y) {
    int smallerLength = x.length;
    if (y.length < smallerLength) {
      smallerLength = y.length;
    }
    /*Use one of the more efficient sorting 
     * algorithms from Sort.java to sort both of the arrays.*/
    Sort.quickSort(x);
    Sort.quickSort(y);
    
    int Intersect[] = new int[smallerLength];
    int i = 0, j = 0, n = 0;
    /*get the intersectio */
    while ((i < x.length) && (j < y.length)) {
      if (x[i] > y[j]) {
        j++;
      }
      else if(x[i] < y[j]){
        i++;
      }
      else{
        Intersect[n] = x[i];
        n++;
        i++;
        j++;
      }
    }
    return Intersect;
  }
  /* main method, test code */
  public static void main(String args[]) {
    int[] a1 = {10, 5, 7, 5, 9, 4};
    int[] a2 = {7, 5, 15, 7, 7, 9, 10};
    int[] result = intersect(a1, a2);
    System.out.println(Arrays.toString(result));
    int[] a3 = {0, 2, -4, 6, 10, 8};
    int[] a4 = {12, 0, -4, 8};
    result = intersect(a3, a4);
    System.out.println(Arrays.toString(result));
  }
}