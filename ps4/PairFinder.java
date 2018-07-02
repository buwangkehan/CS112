public class PairFinder{
  /* requires O(n?) steps to solve this problem.*/
  public static void findPairSums(int k, int[] arr){
    for(int i =0; i<arr.length; i++){
      for(int j =0; j<i;j++){
        if(arr[i] + arr[j] == k){
          System.out.println(arr[i] + "+" + arr[j] + "=" + k);
        }
      }
    }
  }
  //takes the same parameters as findPairSums, but that requires only O(nlogn) steps in the average case to solve this problem.//
  public static void findPairSumFaster(int k, int[] arr){
    SortCount.quickSort(arr);
    for(int i=0;i <arr.length; i++){
      for(int j=arr.length-1;j>=0;j--){
        while(i<=j){
          if(arr[i] + arr[j] ==k){
            System.out.println(arr[i] + "+" + arr[j] + "=" + k);
            break;
          }
          else if(arr[i] + arr[j] <k){
            break;}
          else if(arr[i] + arr[j] >k){
            break;}
        }
      }
    }
  }
  public static void main(String[] args){
    int[] Testarr = {10,4,7,7,8,5,15};
    findPairSums(12,Testarr);
    findPairSumFaster(15,Testarr);
    
    
  }
}
