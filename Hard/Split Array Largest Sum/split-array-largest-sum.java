//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int start=0;
        int end=0;
        
        for(int x:arr){
            start=Math.max(start,x);
            end+=x;
        }

        
        while(start<end){
            
            int mid=start+(end-start)/2;
            
            int pieces=1;
            int sum=0;
            
            for(int x:arr){
                
                if(x+sum<=mid){
                    sum+=x;
                }
                else{
                    pieces++;
                    sum=x;
                }
            }
            if(pieces<=K){
                end=mid;
            }
            else{
                start=mid+1;
            }
            
           
        }return end;
    }
};