//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
  int solve(string &str1,string &str2,int i,int j,vector<vector<int>>&dp){
      
      if(i>=str1.length())
      return str2.length()-j;
      if(j>=str2.length())
      return str1.length()-i;
      if(dp[i][j]!=-1)
      return dp[i][j];
      int ans=0;
      if(str1[i]==str2[j])
      ans=solve(str1,str2,i+1,j+1,dp);
      else{
          int Insert=1+solve(str1,str2,i+1,j,dp);
          int Remove=1+solve(str1,str2,i,j+1,dp);
          int Replace=1+solve(str1,str2,i+1,j+1,dp);
          ans=min(Insert,min(Remove,Replace));
      }
      return dp[i][j]=ans;
  }
    int editDistance(string str1, string str2) {
        vector<vector<int>>dp(str1.length(),vector<int>(str2.length(),-1));
        return solve(str1,str2,0,0,dp);
    }
};

//{ Driver Code Starts.
int main() {
    int T;
    cin >> T;
    while (T--) {
        string s, t;
        cin >> s >> t;
        Solution ob;
        int ans = ob.editDistance(s, t);
        cout << ans << "\n";
    }
    return 0;
}

// } Driver Code Ends