#User function Template for python3

class Solution:
    def criticalConnections(self, v, adj):
        # code here
        ans=[]
        dis=[-1 for _ in range(v)]
        low=[-1 for _ in range(v)]
        visited=[False for _ in range(v)]
        timer=[0]
        def dfs(node,parent,timer):
            visited[node]=True
            dis[node]=timer[0]
            low[node]=timer[0]
            timer[0]+=1
            #child=0
            for ngh in adj[node]:
                if(ngh==parent):
                    continue
                if(visited[ngh]==False):
                    dfs(ngh,node,timer)
                    low[node]=min(low[node],low[ngh])
                    if(dis[node]<low[ngh]):
                        if(node>ngh):ans.append(tuple([ngh,node]))
                        else:ans.append(tuple([node,ngh]))
                else:
                    low[node]=min(low[node],dis[ngh])
                
        for i in range(v):
            if(visited[i]==False):
                dfs(i,-1,timer)
        ans=list(set(ans))
        ans.sort()
        return ans

#{ 
 # Driver Code Starts
#Initial Template for Python 3

import sys
sys.setrecursionlimit(10**6)

if __name__ == '__main__':

	T=int(input())
	for i in range(T):
		V, E = map(int, input().split())
		adj = [[] for i in range(V)]
		for _ in range(E):
			u, v = map(int, input().split())
			adj[u].append(v)
			adj[v].append(u)
		obj = Solution()
		ans = obj.criticalConnections(V, adj)
		for i in range(len(ans)):
		    print(ans[i][0],ans[i][1])

# } Driver Code Ends