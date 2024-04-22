#User function Template for python3

class Solution:
    def minRow(self,n,m,a):
        #code here
        ans,count = 0,a[0].count(1)
        for i in range(1,n):
            k = a[i].count(1)
            if k<count:
                count=k
                ans=i+1
        return ans if ans!=0 else 1



#{ 
 # Driver Code Starts
#Initial Template for Python 3

import math
        
if __name__=='__main__':
    t=int(input())
    for _ in range(t):
        N,M=map(int,input().strip().split(" "))
        A=[]
        for i in range(N):
            B=list(map(int,input().strip().split(" ")))
            A.append(B)
        ob=Solution()
        print(ob.minRow(N,M,A))
# } Driver Code Ends