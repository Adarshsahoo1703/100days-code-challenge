//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int n = nums.length;
        long product = 1;
        long zero = 1;
        long[] arr = new long[n];
        int count = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] == 0){
                count++;
            }
            if(nums[i] == 0 && count < 2){
                zero = 1;
            } else {
                zero = (long)nums[i];
            }
            product *= zero;
        }
        for(int i = 0; i<n; i++){
            if(nums[i] == 0){
                nums[i] = 1;
                arr[i] = product / nums[i];
            } else if (nums[i] != 0 && count == 1){
            arr[i] = 0;
            }
            else if(count == 0){
                arr[i] = product / (long) nums[i];
            }
        }
        return arr;
    }
}
