//{ Driver Code Starts
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
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
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
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    public static boolean isleaf(Node root){
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }
    
    //Adding left boundary
    public static void addleft(Node node,ArrayList<Integer> ars){
        Node temp=node.left;
        while(temp!=null){
            if(isleaf(temp)==false){
                ars.add(temp.data);
            }
            
            if(temp.left!=null){
                temp=temp.left;
            }
            else{
                temp=temp.right;
            }
        }
    }
    
    //Inorder traversal to get the bottom leaves
    public static void addleaf(Node node,ArrayList<Integer> ars){
        if(node==null) return;
        Node temp=node;
        if(isleaf(temp)){
            ars.add(temp.data);
            return;
        }
        
        addleaf(temp.left,ars);
        addleaf(temp.right,ars);
    }
    
    //Adding right boundary
    public static void addright(Node node,ArrayList<Integer> ars){
        Node temp=node.right;
        Stack<Integer> st=new Stack<Integer>();
        
        while(temp!=null){
            
            if(isleaf(temp)==false){
                st.push(temp.data);
            }
            
            if(temp.right!=null){
                temp=temp.right;
            }
            else{
                temp=temp.left;
            }
        }
        
        while(!st.isEmpty()){
            ars.add(st.pop());
        }
    }
    ArrayList <Integer> boundary(Node node)
    {
      ArrayList<Integer> ars=new ArrayList<Integer>();
      if(isleaf(node)==true){
          ars.add(node.data);
          return ars;
      }
      
      ars.add(node.data);
      addleft(node,ars);
      addleaf(node,ars);
      addright(node,ars);
      
      return ars;
      
    }
}