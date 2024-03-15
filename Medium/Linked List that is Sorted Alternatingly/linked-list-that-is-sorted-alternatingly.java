//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
   public Node sort(Node head){
        //your code here, return the head of the sorted list
        if (head.next == null || head.next.next == null) {
            return head;
        }
        
        Node c1 = head, c2 = head.next;
        Node c11 = null, c22 = null, h1 = null, h2 = null;
        while (c1 != null) {
            Node temp = new Node(c1.data);
            if (h1 == null) {
                h1 = temp;
                c11 = temp;
            } else {
                c11.next = temp;
                c11 = c11.next;
            }
            
            if (c1.next != null)
                c1 = c1.next.next;
            else break;
        }
        
        while (c2 != null) {
            Node temp = new Node(c2.data);
            if (h2 == null) {
                h2 = temp;
                c22 = temp;
            } else {
                temp.next = h2;
                h2 = temp;
            }
            
            if (c2.next != null)
                c2 = c2.next.next;
            else break;
        }
        
        c1 = h1;
        c2 = h2;
        
        Node newHead = null, curr = null;
        while (c1 != null && c2 != null) {
            Node temp;
            if (c1.data <= c2.data) {
                temp = new Node(c1.data);
                c1 = c1.next;
            } else {
                temp = new Node(c2.data);
                c2 = c2.next;
            }
            if (newHead == null) {
                newHead = temp;
                curr = temp;
            } else {
                curr.next = temp;
                curr = curr.next;
            }
        }
        
        while (c1 != null) {
            Node temp = new Node(c1.data);
            curr.next = temp;
            curr = curr.next;
            c1 = c1.next;
        }
        
        while (c2 != null) {
            Node temp = new Node(c2.data);
            curr.next = temp;
            curr = curr.next;
            c2 = c2.next;
        }
        
        return newHead;
   }


}