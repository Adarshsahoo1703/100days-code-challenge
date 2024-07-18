//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int alternatingMaxLength(vector<int>& arr) {
        // Code here
           for(int i=0;i<arr.size()-1;i++){
           
           if(arr[i]==arr[i+1]){
               arr.erase(arr.begin()+i);
               i--;
               
               
           }
           
       }
       
       
       int n=arr.size();
       if(n==1|| n==2){return n;}
       int peaks=2;
       
       
       for(int i=1;i<n-1;i++){
           
           if((arr[i-1]>arr[i] && arr[i+1]>arr[i]) || (arr[i-1]<arr[i] && arr[i+1]<arr[i]) ){
               
               peaks++;
           }
           
           
       }
       
       
       return peaks;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    cin.ignore();
    while (tc--) {
        string s;
        getline(cin, s);
        stringstream ss(s);
        vector<int> arr;
        string temp;
        while (ss >> temp) {
            arr.push_back(stoi(temp));
        }
        Solution obj;
        int ans = obj.alternatingMaxLength(arr);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends