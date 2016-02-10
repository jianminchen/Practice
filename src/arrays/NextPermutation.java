package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {

  public static void main(String[] args) {

    
  }

  //O(N)
  public void nextPermutation(int[] nums) { 
    if(nums == null || nums.length<2)
      return;

  //From right to left, find the first digit (PartitionNumber) which violate the increase trend.  
  int p=0;            
  for(int i=nums.length-2; i>=0; i--){
      if(nums[i]<nums[i+1]){
          p=i;
          break;
      }    
  }

  // From left to partition, find the first digit which larger than PartitionNumber, call it ChangeNumber.
  int q = 0;
  for(int i=nums.length-1; i>p; i--){
      if(nums[i]> nums[p]){
          q=i;
          break;
      }    
  }

  if(p==0 && q==0){
      reverse(nums, 0, nums.length-1);
      return;
  }

  //Swap the PartitionNumber and ChangeNumber.
  int temp=nums[p];
  nums[p]=nums[q];
  nums[q]=temp;
  
  //Reverse all the digit on the right of partition index.
  if(p<nums.length-1){
      reverse(nums, p+1, nums.length-1);
  }

}

public void reverse(int[] nums, int left, int right){
  while(left<right){
      int temp = nums[left];
      nums[left]=nums[right];
      nums[right]=temp;
      left++;
      right--;
  }
}
}
