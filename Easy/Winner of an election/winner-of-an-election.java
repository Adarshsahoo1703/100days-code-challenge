//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String, Integer> hm = new HashMap<>();
        String res[] = new String[2];
        int max = 0;
        
        for(int i=0; i<n; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
            max = Math.max (max, hm.get(arr[i]));
        }
        
        for (String key: hm.keySet()){
            if(hm.get(key)==max) {
                if(res[0] ==null) res [0]=key;
                    else{
                        if(res[0].compareTo (key)>0) res[0] = key;
                    }
                }
            }
            res[1] = String.valueOf(max);
            return res;
    }
}

