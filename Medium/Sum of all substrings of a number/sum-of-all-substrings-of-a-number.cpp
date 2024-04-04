//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution
{
    public:
    long long sumSubstrings(string s){
        
        int MOD = 1000000007;
        long long res = 0;
        long long curr = 0;
        
        for(int i = 0; i < s.length(); i++) {
            curr = (curr * 10 + (i + 1) * (s[i] - '0')) % MOD;
            res = (res + curr) % MOD;
        }
        
        return res;
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
        //taking string
        string s;
        cin>>s;
        Solution ob;
        //calling sumSubstrings() function
        cout << ob.sumSubstrings(s) << endl;
        
    }
    return 0;
}

// } Driver Code Ends