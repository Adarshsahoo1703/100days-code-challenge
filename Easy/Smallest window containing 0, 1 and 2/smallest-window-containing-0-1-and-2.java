//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int z=-1,o=-1,t=-1,ans=Integer.MAX_VALUE;
        for (int i = 0; i < S.length(); i++) {
            char ch=S.charAt(i);
            if(ch=='0'){
                z=i;
            }else if(ch=='1'){
                o=i;
            }else {
                t=i;
            }

            if(z!=-1 && o!=-1 && t!=-1){
                int min=Math.min(Math.min(z, o), t);
                int max=Math.max(Math.max(z, o), t);
                ans=Math.min(ans, max-min+1);
            }
        }
        return ans==Integer.MAX_VALUE? -1 : ans;
    }
};
