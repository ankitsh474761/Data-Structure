package SlidingWindow;

import java.util.Scanner;
public class MaximumSubarrayofSizeK {

    static int maxSubarray(int arr[], int k) {
        int i = 0 , j = 0;
        int size = arr.length;
        int sum = 0 , maxSum = Integer.MIN_VALUE;
        while(j < size){
            // do calculation
            sum += arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                // get ans from the calculation
                maxSum = Math.max(maxSum,sum);
                sum-= arr[i];
                i++;j++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {100,200,300,400 };
        int result = maxSubarray(arr,2);
        System.out.println(result);
    }

    
}
