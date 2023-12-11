//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int i = 0;
        int j = 0;
        long sum = 0; // Change to long to handle potential overflow
        long mx = Long.MIN_VALUE; // Change to long to handle potential overflow
        
        while (j < N) {
            sum = sum + Arr.get(j); // do calculation to reduce tc
            if (j - i + 1 < K) {
                j++; // increment j until the size of the window is not equal to the required size
            } else if (j - i + 1 == K) { // when window size hits the required size
                mx = Math.max(mx, sum); // select ans from the candidates
                sum = sum - Arr.get(i); // start removing from the first
                i++;
                j++;
            }
        }
        return mx;
    

    }
}