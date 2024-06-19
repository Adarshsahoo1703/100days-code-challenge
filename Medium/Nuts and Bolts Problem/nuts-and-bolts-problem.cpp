//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:

    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
                 char arr[] = { '!', '#', '$' , '%', '&', '*', '?', '@' , '^'};
    unordered_set<char> set;  


    for (int i = 0; i < n; ++i) {
        set.insert(nuts[i]);
    }
    
    int k = 0;
    for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); ++i) {
        if (set.find(arr[i]) != set.end()) {
            nuts[k] = arr[i];
            bolts[k] = arr[i];
            ++k;
        }
    }

    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        char nuts[n], bolts[n];
        for (int i = 0; i < n; i++) {
            cin >> nuts[i];
        }
        for (int i = 0; i < n; i++) {
            cin >> bolts[i];
        }
        Solution ob;
        ob.matchPairs(n, nuts, bolts);
        for (int i = 0; i < n; i++) {
            cout << nuts[i] << " ";
        }
        cout << "\n";
        for (int i = 0; i < n; i++) {
            cout << bolts[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends