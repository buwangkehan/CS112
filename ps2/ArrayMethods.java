/*
 * Problem Set 2, Problem 5
 *
 * Practice with static methods, part I
 *
 * Note: Because this class is simply a collection of static methods 
 * and it does not have a main method, you cannot run it.
 * See the problem set for instructions about how to test the methods 
 * that you write.
 */

public class ArrayMethods{
  /*
   * takes a reference to an array of integers values and swaps adjacent pairs of elements*/
  public static void swapAdjacent(int[] values){
    if(values == null){
      throw new IllegalArgumentException();
    }
    else{
      int[] other =new int[values.length];
      int len = values.length;
      for(int i = 0; i< len; i ++){
        other[i] = values[i];
      }
      if (len%2 ==1){
        for(int i = 0; i<len -2; i +=2){
          values[i] = other[i+1];
          values[i+1] =other[i];
        }
      }
      else{
        for(int i = 0; i < len; i +=2){
          values[i] = other[i+1];
          values[i+1] =other[i];
        }
      }
    }
  }
  /*takes a reference to an array of integers values and two integers oldVal and newVal,
   * and that creates and returns a new array that is a copy of the original array, 
   * but in which all occurrences of the value oldVal are replaced with the value newVal.*/
  
  public static int[] copyReplace(int[] values, int oldVal, int newVal){
    int len = values.length;
    int[] other =new int[values.length];
    if(values == null){
      throw new IllegalArgumentException();
    }
    else{
      for(int i = 0; i< len; i ++){
        other[i] = values[i];
      }
      
      for( int i = 0; i < len; i ++){
        if(other[i] ==oldVal){
          other[i] = newVal;
        }
      }}
    return other;    
  }
  /*takes a reference to an array of integers and returns the 
   * length of the longest sorted sequence of integers in the array*/
  public static int maxSorted(int[] values){
    if(values==null){
      throw new IllegalArgumentException();
    }
    else{
      if(values.length == 0){
        return 0;
      }
      else{
        int count0 = 1;
        int count = 1;
          for(int i = 1; i < values.length;i++){
            if(values[i] >= values[i-1]){
              count +=1;
              if(count0<count){
                count0 = count;
              }
            }
            else if(values[i] < values[i-1]){
              count = 1;
            }
          }
          return count0;
      }
    }
  }
}
            
          
          
          
          
          
          
