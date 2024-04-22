//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution {
    ArrayList<Integer> ans = new ArrayList<>();
    int target;
    public ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        this.target = target;
        dfs(root, k);
        Collections.sort(ans);
        return ans;
    }
    
    private int dfs(Node node, int k) {
        if (node == null) {
            return -1;
        } else if (node.data == target) {
            subtreeAdd(node, 0, k);
            return 1;
        } else {
            int L = dfs(node.left, k);
            int R = dfs(node.right, k);
            if (L != -1) {
                if (L == k) ans.add(node.data);
                subtreeAdd(node.right, L + 1, k);
                return L + 1;
            } else if (R != -1) {
                if (R == k) ans.add(node.data);
                subtreeAdd(node.left, R + 1, k);
                return R + 1;
            } else {
                return -1;
            }
        }
    }
    
    private void subtreeAdd(Node node, int dist, int k) {
        if (node == null) return;
        if (dist == k) ans.add(node.data);
        else {
            subtreeAdd(node.left, dist + 1, k);
            subtreeAdd(node.right, dist + 1, k);
        }
    }
}