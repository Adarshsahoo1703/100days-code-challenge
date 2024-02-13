//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        ArrayList<Integer> arr=new ArrayList<>();
           int mod = 1000000007;
        arr.add(0);
        arr.add(1);
       if(n==1){
           return 1;
       }
       else{
           for(int i=2;i<=n;i++){
               int j=(arr.get(i-2)+arr.get(i-1))%mod;
               arr.add(j);
           }
           return arr.get(n);
       }
    }
}