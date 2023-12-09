//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
                int n = S.length(), len = S.length();
        while (len > 0) {
            int j = 0;
            while (j + len <= n) {
                int start = j, end = j + len - 1;
                while (start < end) {
                    if (S.charAt(start) != S.charAt(end)) break;
                    start++;
                    end--;
                }
                if (start >= end) {
                    return S.substring(j, j + len);
                }
                j++;
            }
            len--;
        }
        return "";
    
    }
}