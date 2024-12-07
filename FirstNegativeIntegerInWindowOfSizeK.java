package SlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FirstNegativeIntegerInWindowOfSizeK {

    static List<Integer> FirstNegativeInteger(int arr[],int k){
        int size = arr.length;

        // we will use deque to store the negative integers frm every window 
        // nd use list to store the result 
        // here we are using deque to store negative instead of list because in list to remove an element takes time 
        // comlexity of O(n*k) , as in list we need to shift the elements after removing the first element 
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0 , j = 0 ;
        while(j < size){
            // add the element to the deque if it is negative\
            if(arr[j]<0){
                deque.add(arr[j]);
            }
            if(j-i+1  < k){
                j++;
            }else if(j-i+1 == k){
                // if the window size is equal to k then we need to find the first negative integer 
                if(!deque.isEmpty()){
                    result.add(deque.peekFirst());
                    // result.add(deque.peek());
                }else{
                    result.add(0);
                }
                // we will remove the elements from the front of the deque which are not in the current window
                if(!deque.isEmpty() &&  arr[i]== deque.peek()){
                    deque.removeFirst();
                    // dequeu.poll();
                }
                i++;j++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;
        System.out.println(FirstNegativeInteger(arr,k));
    }
}
