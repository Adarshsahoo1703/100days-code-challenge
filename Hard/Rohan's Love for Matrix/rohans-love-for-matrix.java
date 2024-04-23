//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int firstElement(int n) {
        // code here
        int a00 = 1, a01 = 1, a10 = 1, a11 = 0;
        int b10 = 1, b11 = 0, mod = (int)1e9 + 7;
        
        if(n == 1)
            return a10;
        
        for(int i = 2; i <= n; i++) {
            int x = (b10 * a00 + b11 * a10) % mod;
            int y = (b10 * a01 + b11 * a11) % mod;
            b10 = x % mod;
            b11 = y % mod;
        }
        
        return b10 % mod;
    }
}