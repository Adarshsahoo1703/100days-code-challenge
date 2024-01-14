
from typing import List


class Solution:
    def __init__(self):
        self.dp = []

    def solve(self, i, total, cost):
        if i == len(cost):
            return 0
        if self.dp[i][total] != -1:
            return self.dp[i][total]

        pick = float('-inf')
        if total >= cost[i]:
            t = total - cost[i] + (cost[i] * 9) // 10
            pick = 1 + self.solve(i + 1, t, cost)

        not_pick = self.solve(i + 1, total, cost)
        self.dp[i][total] = max(pick, not_pick)
        return self.dp[i][total]

    def max_courses(self, n, total, cost):
        self.dp = [[-1] * (total + 1) for _ in range(n + 1)]
        return self.solve(0, total, cost)
        



#{ 
 # Driver Code Starts

class IntArray:
    def __init__(self) -> None:
        pass
    def Input(self,n):
        arr=[int(i) for i in input().strip().split()]#array input
        return arr
    def Print(self,arr):
        for i in arr:
            print(i,end=" ")
        print()


if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        n = int(input())
        
        
        total = int(input())
        
        
        cost=IntArray().Input(n)
        
        obj = Solution()
        res = obj.max_courses(n, total, cost)
        
        print(res)
        

# } Driver Code Ends