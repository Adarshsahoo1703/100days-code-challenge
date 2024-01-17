//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        ArrayList<Integer> currentPermutation = new ArrayList<>();
        
        Collections.sort(arr); // Sort the array to generate permutations in sorted order
        
        generatePermutations(arr, used, currentPermutation, result);
        
        return result;
    }
    
    private static void generatePermutations(ArrayList<Integer> arr, boolean[] used, ArrayList<Integer> currentPermutation, ArrayList<ArrayList<Integer>> result) {
        if (currentPermutation.size() == arr.size()) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        
        for (int i = 0; i < arr.size(); i++) {
            if (used[i] || (i > 0 && arr.get(i) == arr.get(i - 1) && !used[i - 1])) {
                // Skip if the element is already used or if it's a duplicate and the previous duplicate is not used
                continue;
            }
            
            used[i] = true;
            currentPermutation.add(arr.get(i));
            
            generatePermutations(arr, used, currentPermutation, result);
            
            used[i] = false;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}
