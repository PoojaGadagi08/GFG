Given Pointer/Reference to the head of a doubly linked list of n nodes, the task is to Sort the given doubly linked list using Merge Sort in both non-decreasing and non-increasing order.

Example 1:

Input:
n = 8
value[] = {7,3,5,2,6,4,1,8}
Output:
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
Explanation: After sorting the given
linked list in both ways, resultant
matrix will be as given in the first
two line of output, where first line
is the output for non-decreasing
order and next line is for non-
increasing order.
Example 2:

Input:
n = 5
value[] = {9,15,0,-1,0}
Output:
-1 0 0 9 15
15 9 0 0 -1
Explanation: After sorting the given
linked list in both ways, the
resultant list will be -1 0 0 9 15
in non-decreasing order and 
15 9 0 0 -1 in non-increasing order.
Your Task:
The task is to complete the function sortDoubly() which takes reference to the head of the doubly linked and Sort the given doubly linked list using Merge Sort in both non-decreasing and non-increasing. The printing is done automatically by the driver code.

Expected Time Complexity: O(nlogn)
Expected Space Complexity: O(logn)

Constraints:
1 <= n <= 104
0 <= values[i] <= 105



  // User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node h1) {
        // add your code here
        
        if(h1==null || h1.next == null){
            return h1;
        }
        
        Node h2 = fun(h1);
        h1=sortDoubly(h1);
        h2=sortDoubly(h2);
        
        return merge(h1, h2);
        
    }
    
    static Node fun(Node h1){
        Node fast=h1, slow=h1;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node temp=slow.next;
        slow.next=null;
        return temp;
    }
    
    static Node merge(Node h1, Node h2){
        Node dummy = new Node(-1);
        Node curr=dummy;
        while(h1 != null && h2 != null){
            if(h1.data<h2.data){
                curr.next=h1;
                h1.prev=curr;
                h1=h1.next;
            }
            else{
                 curr.next=h2;
                h2.prev=curr;
                h2=h2.next;
            }
            curr=curr.next;
        }
        
        if(h1 != null){
            curr.next=h1;
            h1.prev=curr;
        }
        
        if(h2 != null){
            curr.next=h2;
            h2.prev=curr;
        }
        
        Node ans=dummy.next;
        ans.prev=null;
        
        return ans;
    }
}


















