//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        // code here
        HashMap<Character, Integer> mp = new HashMap<>();
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        
        int sz = mp.size();
        int avg = (int)(n / sz);
        
        if(n - (sz * avg) > 1) // we need at most one character to delete
            return false;
            
        for(HashMap.Entry<Character, Integer>m: mp.entrySet())
            if(m.getValue() < avg)
                return false;
                
        return true;
    }
}