//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean match(String wild, String pattern)
    {
        // code here
        int n=pattern.length();
        int m=wild.length();
        
        boolean dp[][]=new boolean[n+1][m+1];
        
        dp[0][0]=true;
        
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }
        
        for(int j=1;j<m+1;j++){
            if(wild.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }
        //bottom-up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(pattern.charAt(i-1)==wild.charAt(j-1) || wild.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(wild.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
}