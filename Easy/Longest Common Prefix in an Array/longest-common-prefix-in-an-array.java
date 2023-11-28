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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int N){
        int cnt = 0, minLen = Integer.MAX_VALUE;

        for (int i = 0; i < N; ++i) {
            minLen = Math.min(minLen, arr[i].length());
        }

        for (int c = 0; c < minLen; ++c) {
            boolean flag = true;
            for (int i = 0; i < N - 1; ++i) {
                if (arr[i].charAt(c) != arr[i + 1].charAt(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }

        return cnt > 0 ? arr[0].substring(0, cnt) : "-1";
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; ++i)
                arr[i] = scanner.next();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
    
