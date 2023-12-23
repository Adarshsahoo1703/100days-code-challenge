//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends















class Solution
{
    public:
    //Function to return max value that can be put in knapsack of capacity W.
    int dp[1005][1005];
    int f(int *wt,int *val,int i,int W,int n)
    {
        if(W<=0 || i==n)return 0;
        if(dp[i][W]!=-1)return dp[i][W];
        return dp[i][W]=max({f(wt,val,i+1,W,n),(W>=wt[i]?(val[i]+f(wt,val,i+1,W-wt[i],n)):INT_MIN)});
    }
    int knapSack(int W, int wt[], int val[], int n) 
    { 
       memset(dp,-1,sizeof dp);
       return f(wt,val,0,W,n);
    }
};
















//{ Driver Code Starts.

int main()
 {
    //taking total testcases
    int t;
    cin>>t;
    while(t--)
    {
        //reading number of elements and weight
        int n, w;
        cin>>n>>w;
        
        int val[n];
        int wt[n];
        
        //inserting the values
        for(int i=0;i<n;i++)
            cin>>val[i];
        
        //inserting the weights
        for(int i=0;i<n;i++)
            cin>>wt[i];
        Solution ob;
        //calling method knapSack()
        cout<<ob.knapSack(w, wt, val, n)<<endl;
        
    }
	return 0;
}
// } Driver Code Endsclass Solution
