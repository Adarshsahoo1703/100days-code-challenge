//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
TreeMap<Integer, Integer> hm = new TreeMap<>();

for (int i = 0; i < n; i++) {
    hm.put(price[i], hm.getOrDefault(price[i], 0) + i + 1);
}

int count = 0;

for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
    int key = entry.getKey();
    int value = entry.getValue();

    int product = key * value;

    if (k - product >= 0) {
        count += value;
        k -= product;
    } else {
        int val = k / key;
        k -= key * val;
        count += val;
    }
}

return count;

        
        
    }
}
        
