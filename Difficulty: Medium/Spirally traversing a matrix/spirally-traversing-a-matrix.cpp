//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<int> spirallyTraverse(vector<vector<int> > &matrix) {
        // code here
        int r = matrix.size();
        int c = matrix[0].size();
        
        int startingrow = 0;
        int startingcol = 0;
        int endingrow = r-1;
        int endingcol = c-1;
        int count =0;
        int total = r*c;
        
        vector<int> ans;
        while(count<total){
            // Print first row 
            for(int i=startingcol; count<total && i<=endingcol; i++){
                ans.push_back(matrix[startingrow][i]);
                count++;
            }
            startingrow++;
            
            
            //Print ending col
            for(int i=startingrow; count<total && i<=endingrow; i++){
                ans.push_back(matrix[i][endingcol]);
                count++;
            }
            endingcol--;
            
            //print ending row
            for(int i=endingcol; count<total && i>=startingcol; i--){
                ans.push_back(matrix[endingrow][i]);
                count++;
            }
            endingrow--;
            
            //print startingcol
            for(int i=endingrow; count<total && i>=startingrow; i--){
                ans.push_back(matrix[i][startingcol]);
                count++;
            }
            startingcol++;
        }
        
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;

    while (t--) {
        int r, c;
        cin >> r >> c;
        vector<vector<int>> matrix(r, vector<int>(c, 0));

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cin >> matrix[i][j];
            }
        }

        Solution ob;
        vector<int> result = ob.spirallyTraverse(matrix);
        for (int i = 0; i < result.size(); ++i)
            cout << result[i] << " ";
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends