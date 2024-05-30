//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
    int mod = 1e9+7;
  public:
    int countWays(string s1, string s2) {
        if(s1.size() < s2.size()){
            auto temp = s1;
            s1 = s2;
            s2 = temp;
        }
        vector<vector<int>> dp(s2.size(),vector<int>(s1.size(),-1));
        //return calc(0,0,s1,s2,dp);
        return tabulation(s1,s2);
    }
    int tabulation(string &s1,string &s2){
        int n = s1.size(),m=s2.size();
        
        vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        
        for(int i=0; i<=n; i++) dp[i][0] = 1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = ((dp[i-1][j-1]%mod) + (dp[i-1][j]%mod))%mod;
                }else{
                    dp[i][j] = dp[i-1][j]%mod;
                }
            }
        }
        
        return dp[n][m];
    }
    int calc(int p1,int p2,string &s1,string &s2,vector<vector<int>> &dp){
        if(p2==s2.size()) return 1;
        if(p1 == s1.size()) return p2 == s2.size();
        
        if(dp[p2][p1] != -1) return dp[p2][p1];
        int cnt = 0;
        
        if(s1[p1] == s2[p2]){
            cnt = (cnt + (calc(p1+1,p2+1,s1,s2,dp) % mod)) % mod;
        }
        cnt = (cnt + (calc(p1+1,p2,s1,s2,dp) % mod)) % mod;
        
        return dp[p2][p1] = cnt%mod;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        string s1;
        getline(cin, s1);

        string s2;
        getline(cin, s2);

        Solution obj;
        int res = obj.countWays(s1, s2);

        cout << res << endl;
    }
}

// } Driver Code Ends