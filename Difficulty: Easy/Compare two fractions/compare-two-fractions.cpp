//{ Driver Code Starts

#include <iostream>
#include <regex>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    string compareFrac(string str) {

        // Code here
        vector<string> result;
        stringstream ss(str);
        string item;
    
        while (getline(ss, item, ',')) {
            result.push_back(item);
        }
        
        vector<string>r2;
        if(result[0][0]==' '){
            result[0] = result[0].substr(1);
        }
        if(result[1][0]==' '){
            result[1] = result[1].substr(1);
        }
        string p = result[0];
        string q = result[1];
        
        stringstream tt(p);
        string t;
        while(getline(tt,t,'/')){
            r2.push_back(t);
        }
        
        stringstream ll(q);
        while(getline(ll,t,'/')){
            r2.push_back(t);
        }
        
        float x = stoi(r2[0]);
        float y = stoi(r2[1]);
        float z = stoi(r2[2]);
        float w = stoi(r2[3]);
        if((x/y)==(z/w))return "equal";
        if((x/y)>(z/w)) return result[0];
        else return result[1];
    }
};


//{ Driver Code Starts.

int main() {
    Solution ob;
    int t;
    cin >> t;
    cin.ignore();
    for (int i = 0; i < t; i++) {

        string str;
        getline(cin, str);

        cout << ob.compareFrac(str) << endl;
    }
    return 0;
}

// } Driver Code Ends