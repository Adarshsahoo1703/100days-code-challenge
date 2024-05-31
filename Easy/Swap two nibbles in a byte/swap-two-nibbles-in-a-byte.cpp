//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int swapNibbles(int n) {
        // code here
          int ans = 0;
        int p = 4, t = 4;
        
        while(t--)
        {
            if(n&1) ans +=  (int)pow(2 , p);
            n = n>>1;
            p++;
        }
        
        t = 4;
        p=0;
        while(t--)
        {
            if(n&1)  ans += (int)pow(2,p);
            n = n>>1;
            p++;
        }
        
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.swapNibbles(n) << endl;
    }
    return 0;
}
// } Driver Code Ends