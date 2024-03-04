//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        for(int i = 0; i  <size; i++){
            
            int index = 0;
            boolean updated = false;
            
            while(!list.isEmpty() && index < list.size()){
                if(a[i] <= list.get(index) ){
                 list.remove(index);
                 list.add(index, a[i]);
                 updated = true;
                  break;
                    
                }
                
               index++;
            }
            
             if(updated != true)
                 list.add(a[i]);
        }
        
        return list.size();
    }
} 