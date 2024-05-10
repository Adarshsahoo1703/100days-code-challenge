//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
public:
     // Recursive function to find combinations that sum up to target
     void findsum(int index, vector<int> &arr, int target, vector<vector<int>> &ans, vector<int> &ds)
    {
        // Base case: target sum reached, add current combination to ans
        if(target == 0)
        {
            ans.push_back(ds);
            return;
        }

        // Loop through the array starting from index
        for(int i = index; i < arr.size(); i++)
        {
            // Skip duplicates to avoid duplicate combinations
            if(i > index && arr[i] == arr[i - 1])
            {
                continue;
            }

            // If current element exceeds target, break loop
            if(arr[i] > target)
            {
                break;
            }

            // Add current element to temporary combination
            ds.push_back(arr[i]);

            // Recursive call with updated parameters after adding current element
            findsum(i + 1, arr, target - arr[i], ans, ds);

            // Backtrack: remove last added element for next iteration
            ds.pop_back();
        }
    }

    // Function to find combinations that sum up to k
    vector<vector<int>> CombinationSum2(vector<int> arr, int n, int k)
    {
        // Sort the input array to handle duplicates efficiently
        sort(arr.begin(), arr.end());

        // Vector to store resulting combinations
        vector<vector<int>> ans;

        // Temporary vector for current combination
        vector<int> ds;

        // Call findsum function to find combinations starting from index 0
        findsum(0, arr, k, ans, ds);

        // Return the resulting combinations
        return ans;
    }
};

//{ Driver Code Starts.


int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,k;
        cin>>n>>k;
        vector<int> arr(n);
        for(int i=0;i<n;i++)
        {
            cin>>arr[i];
        }
        Solution ob;
        auto obj=ob.CombinationSum2(arr,n,k);
        for(int i=0;i<obj.size();i++)
        {
            for(int j=0;j<obj[i].size();j++)
            {
                cout<<obj[i][j]<<" ";
            }
            cout<<"\n";
        }
        if(obj.size()==0) cout<<"\n";
    }
    return 0;
}
// } Driver Code Ends