//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        HashSet<String> seen = new HashSet<>();
        for (String w : B){
            seen.add(w);
        }
        
        if (rec(0,A,seen))
            return 1;
        return 0;
    }
    public static boolean rec(int i, String A, HashSet<String> seen){
        if (i >= A.length())
            return true;
        
        for (int j = i + 1; j <= A.length(); j++){
            String temp = A.substring(i,j);
            if (seen.contains(temp) && rec(j,A,seen) == true)
                return true;
        }
        
        return false;
    }
}