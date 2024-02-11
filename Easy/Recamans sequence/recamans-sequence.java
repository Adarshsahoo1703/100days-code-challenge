//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> seq = new ArrayList<>();
        Set<Integer> check = new HashSet<>();
        seq.add(0);
        check.add(0);
        int i = 1;
        while(i<n){
            int ans = seq.get(i-1)-i;
            if(ans<0 || check.contains(ans)){
                ans = ans + 2*i;
            }
            i++;
            check.add(ans);
            seq.add(ans);
        }
        return seq;
    }
}