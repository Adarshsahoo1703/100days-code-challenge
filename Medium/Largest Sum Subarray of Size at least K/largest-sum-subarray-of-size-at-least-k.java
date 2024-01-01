//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        long[] dp = new long[(int)n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = a[i] + ((i == 0) ? 0 : Math.max(0, dp[i - 1]));
        }
        
        long sum = Arrays.stream(a, 0, (int)k).sum();
        long ans = sum;
        
        for (int i = (int)k; i < n; i++) {
            sum += a[i] - a[i - (int)k];
            ans = Math.max(Math.max(ans, sum), sum + dp[i - (int)k]);
        }
        
        return ans; 
    }
}