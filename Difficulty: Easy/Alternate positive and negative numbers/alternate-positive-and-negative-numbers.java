//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        Queue<Integer> positiveNums = new LinkedList<>();
        Queue<Integer> negativeNums = new LinkedList<>();
        
        for (int i: arr) {
            if (i >= 0) {
                positiveNums.add(i);
            } else {
                negativeNums.add(i);
            }
        }
        
        int i;
        for (i = 0; i < arr.size() && !positiveNums.isEmpty() && !negativeNums.isEmpty(); i++) {
            if (i % 2 == 0) {
                arr.set(i, positiveNums.poll());
            } else {
                arr.set(i, negativeNums.poll());
            }
        }
        
        while (!positiveNums.isEmpty()) {
            arr.set(i++, positiveNums.poll()); 
        }
        while (!negativeNums.isEmpty()) {
            arr.set(i++, negativeNums.poll()); 
        }
    }
}