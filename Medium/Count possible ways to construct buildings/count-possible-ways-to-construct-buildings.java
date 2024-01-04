//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
      int MOD = 1000000007;
      long prev1=1;
      long prev2=1;

    for (int ind = N - 1; ind >= 0; ind--) {
        long ways = (prev2 + prev1) % MOD;
        prev2=prev1;
        prev1=ways;
    }

    long result = (prev1*prev1) % MOD;
    return (int) result;
    }
}