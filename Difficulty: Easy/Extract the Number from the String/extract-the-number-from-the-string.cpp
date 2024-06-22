//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    long long ExtractNumber(string sentence) {

        // code here
         vector<long long> ans;
        string temp = "";       
        for(int i = 0; i < sentence.size(); i++)
        {
            while(sentence[i] - '0' >= 0 and
                  sentence[i] - '0' <= 9 and 
                  i < sentence.size())
            {
                temp +=  sentence[i];   
                //cout << sentence[i] << " ";
                i++;
            }
            //cout << endl << temp << endl;
            if(temp.size() and temp.find(to_string(9)) == string::npos)
                ans.push_back((long)(long)atol(temp.c_str()));
            temp = "";
        }
        sort(ans.begin(), ans.end());
        if(ans.size())
            return ans[ans.size() -1];
        else
            return -1;
        
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
        cout << ob.ExtractNumber(s) << "\n";
    }

    return 0;
}

// } Driver Code Ends