#User function Template for python3

class Solution:
    def isEularCircuitExist(self, v, adj):
        # Function to count degrees of all vertices
        def countDegrees(adj):
            degrees = [0] * v
            for i in range(v):
                degrees[i] = len(adj[i])
            return degrees
        
        # Function to perform Depth First Search
        def dfs(vertex, visited):
            visited[vertex] = True
            for neighbor in adj[vertex]:
                if not visited[neighbor]:
                    dfs(neighbor, visited)
        
        # If no edges are present, return 1
        if sum(len(edges) for edges in adj) == 0:
            return 1
        
        # Count degrees of all vertices
        degrees = countDegrees(adj)
        
        # Check if all vertices have even degrees
        for degree in degrees:
            if degree % 2 != 0:
                return 0  # If any vertex has odd degree, Eulerian circuit doesn't exist
        
        # Check if the graph is connected using DFS
        visited = [False] * v
        start_vertex = -1
        for i in range(v):
            if len(adj[i]) > 0:
                start_vertex = i
                break
        dfs(start_vertex, visited)
        
        # If any vertex is not visited, the graph is not connected
        for visit in visited:
            if not visit:
                return 0  # If any vertex is not visited, Eulerian circuit doesn't exist
        
        return 1  # If both conditions are satisfied, Eulerian circuit exists


#{ 
 # Driver Code Starts
#Initial Template for python3

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
		ans = obj.isEularCircuitExist(V, adj)
		if(ans):
			print("1")
		else:
			print("0")

# } Driver Code Ends