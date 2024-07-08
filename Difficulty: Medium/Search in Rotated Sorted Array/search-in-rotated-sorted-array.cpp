//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int search(vector<int>& arr, int key) {
        // complete the function here
         int n = arr.size();
        if (n == 1) {
            return arr[0] == key ? 0 : -1;
        }
    
        int i = -1;
        int hi = n - 1;
        int lo = 0;
        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= arr[0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        i = lo;
        if (key >= arr[0] && key <= arr[i - 1]) {
            auto it = lower_bound(arr.begin(), arr.begin() + i, key);
            if (it != arr.begin() + i && *it == key) {
                return it - arr.begin();
            }
        } else {
            auto it = lower_bound(arr.begin() + i, arr.end(), key);
            if (it != arr.end() && *it == key) {
                return it - arr.begin();
            }
        }
    
        return -1;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        cin.ignore();
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        int key;
        cin >> key;
        Solution ob;
        cout << ob.search(arr, key) << endl;
    }
    return 0;
}
// } Driver Code Ends