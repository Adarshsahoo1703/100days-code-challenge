//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(100, (a,b) -> (a-b));
        Arrays.sort(arr, new Comparator<Job>(){
            public int compare(Job j1, Job j2){
                if (j1.deadline < j2.deadline) return -1;
                if (j1.deadline > j2.deadline) return 1;
                return j1.profit - j2.profit;
            }
        });
        
        int[] ans = {0, 0};
        int ssum = 0;
        
        for (int i = 0; i < arr.length; ++i) {
            while (pq.size() >= arr[i].deadline) {
                if (pq.peek() >= arr[i].profit) {
                    break;
                }
                ssum -= pq.poll();   
            }
            
            if (pq.size() < arr[i].deadline) {
                pq.offer(arr[i].profit);
                ssum += arr[i].profit;
            }
            
            if (ans[1] < ssum) {
                ans[1] = ssum;
                ans[0] = pq.size();
            }
        }
        
        return ans;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/