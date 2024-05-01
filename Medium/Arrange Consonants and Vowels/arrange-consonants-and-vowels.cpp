//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct Node {
    char data;
    struct Node *next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};

void printlist(Node *head) {
    if (head == NULL)
        return;
    while (head != NULL) {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

void append(struct Node **headRef, char data) {
    struct Node *new_node = new Node(data);
    struct Node *last = *headRef;

    if (*headRef == NULL) {
        *headRef = new_node;
        return;
    }
    while (last->next != NULL)
        last = last->next;
    last->next = new_node;
    return;
}


// } Driver Code Ends
/*
Structure of the node of the linked list is as
struct Node
{
    char data;
    struct Node *next;

    Node(char x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
  public:
    // task is to complete this function
    // function should return head to the list after making
    // necessary arrangements
    struct Node* arrangeCV(Node* head) {
        // Code here
        Node *prev = NULL;
        Node *lastv = NULL;
        Node *cur = head;
        
        while(cur){
            char ch = cur->data;
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                if(lastv != prev){
                    if(lastv == NULL){
                        prev->next = cur->next;
                        cur->next = head;
                        head = cur;
                        lastv = cur;
                        cur = prev->next;
                    }
                    else{
                        prev->next = cur->next;
                        cur->next = lastv->next;
                        lastv->next = cur; 
                        lastv = cur;
                        cur = prev->next;
                    }
                }
                else{
                    lastv = cur;
                    prev = cur;
                    cur = cur->next;
                }
            }
            else{
                prev = cur;
                cur = cur->next;
            }
        }
        return head;
    }
};


//{ Driver Code Starts.

// task is to complete this function
int main() {
    int T;
    cin >> T;
    while (T--) {
        int n;
        char tmp;
        struct Node *head = NULL;
        cin >> n;
        while (n--) {
            cin >> tmp;
            append(&head, tmp);
        }
        Solution obj;
        head = obj.arrangeCV(head);
        printlist(head);
    }
    return 0;
}

// } Driver Code Ends