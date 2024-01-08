//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int pref[] = new int[txt.length()];
        pref[0] = (int)txt.charAt(0);
        for(int i=1;i<txt.length();i++){
            pref[i] = pref[i-1] + (int)txt.charAt(i);
        }
        int sum = 0;
        for(int i=0;i<pat.length();i++){
            sum = sum + (int)pat.charAt(i);
        }
        
        for(int i=0;i<txt.length();i++){
            if((i+pat.length()-1) <= txt.length()-1){
                int temp = pref[i+pat.length()-1] - ((i==0) ? 0 : pref[i-1]);
                if(sum==temp){
                    boolean flag = true;
                    for(int j=0,k=i;j<pat.length();j++,k++){
                        if(pat.charAt(j)!=txt.charAt(k)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        ans.add(i+1);
                }
                    
            }
            else 
                break;
        }
        
        if(ans.isEmpty())
            ans.add(-1);
        
        return ans;
    }
}