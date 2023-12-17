//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        int steps = 0;
        int length = arr.length;

        if (length == 1) return 0;
        if (arr[0] == 0) return -1;

        int curr = Math.min(arr[0], length - 1);
        int mx = curr;

        for (int i = 0; i < length; i++) {
            if (arr[i] > 0) {
                mx = Math.max(mx, Math.min(arr[i] + i, length - 1));
            }

            if (i == curr) {
                steps++;
                if (curr == mx && mx != length - 1) return -1;
                curr = mx;
            }
        }

        return (mx != length - 1) ? -1 : steps;
    }
}