//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    vector<string> v;
    string res="";
    void path(vector<vector<int>> &mat, int i, int j, int n)
    {
        if(mat[i][j]==0) return;
        if(i==n-1 && j==n-1)
        {
            v.push_back(res);
            return;
        }
        
        mat[i][j]=0;
        
        if(j<n-1 && mat[i][j+1]==1)
        {
            res+='R';
            path(mat,i,j+1,n);
            res.pop_back();
        }
        if(i<n-1 && mat[i+1][j]==1)
        {
            res+='D';
            path(mat,i+1,j,n);
            res.pop_back();
        }
        if(j>0 && mat[i][j-1]==1)
        {
            res+='L';
            path(mat,i,j-1,n);
            res.pop_back();
        }
        if(i>0 && mat[i-1][j]==1)
        {
            res+='U';
            path(mat,i-1,j,n);
            res.pop_back();
        }
        
        mat[i][j]=1;
    }
    
    vector<string> findPath(vector<vector<int>> &mat) {
        // Your code goes here
        int n=mat.size();
        path(mat,0,0,n);
        return v;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int>> m(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> m[i][j];
            }
        }
        Solution obj;
        vector<string> result = obj.findPath(m);
        sort(result.begin(), result.end());
        if (result.size() == 0)
            cout << -1;
        else
            for (int i = 0; i < result.size(); i++)
                cout << result[i] << " ";
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends