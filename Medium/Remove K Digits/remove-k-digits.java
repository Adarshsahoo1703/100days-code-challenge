//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public String removeKdigits(String S, int K) {
        if (S.length() == K) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < S.length()) {
            char currentDigit = S.charAt(i);

            while (K > 0 && result.length() > 0 && result.charAt(result.length() - 1) > currentDigit) {
                result.deleteCharAt(result.length() - 1);
                K--;
            }

            result.append(currentDigit);
            i++;
        }

        while (K > 0) {
            result.deleteCharAt(result.length() - 1);
            K--;
        }

        // Remove leading zeros
        int startIndex = 0;
        while (startIndex < result.length() && result.charAt(startIndex) == '0') {
            startIndex++;
        }

        String finalResult = result.substring(startIndex);

        return finalResult.length() == 0 ? "0" : finalResult;
    }
}
