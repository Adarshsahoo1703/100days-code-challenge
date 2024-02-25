//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        // Add your code here.
        int[] table = new int[n + 1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for(int i = 3; i <= n; i++){
            table[i] += table[i - 3];
        }
        for(int i = 5; i <= n; i++){
            table[i] += table[i - 5];
        }
        for(int i = 10; i <= n; i++){
            table[i] += table[i - 10];
        }
        return table[n];
    }
}