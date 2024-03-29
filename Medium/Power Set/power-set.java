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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
  public List<String> AllPossibleStrings(String s) {
        List<String> result = new ArrayList<>();
        generateSubsequences(s, "", result);
        Collections.sort(result); // Sorting the result lexicographically
        return result;
    }

    private void generateSubsequences(String original, String current, List<String> result) {
        if (!current.equals("")) { // Exclude empty string
            result.add(current);
        }
        for (int i = 0; i < original.length(); i++) {
            generateSubsequences(original.substring(i + 1), current + original.charAt(i), result);
        }
    }
}