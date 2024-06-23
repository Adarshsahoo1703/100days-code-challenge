//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:

    vector<int> bracketNumbers(string str) {
        // Your code goes here
          stack<pair<char,int>> stk;
        vector<int> ans;
        int count = 1;
        for(auto i:str){
            if(i=='('){
                stk.push(make_pair(i,count));
                ans.push_back(count);
                count++;
            }else if(i==')' and stk.top().first=='('){
                int x = stk.top().second;
                stk.pop();
                ans.push_back(x);
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    string tc;
    getline(cin, tc);
    t = stoi(tc);
    while (t--) {
        string s;
        getline(cin, s);

        Solution ob;

        vector<int> ans = ob.bracketNumbers(s);

        for (auto i : ans)
            cout << i << " ";

        cout << "\n";
    }

    return 0;
}
// } Driver Code Ends