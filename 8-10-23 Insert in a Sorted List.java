Given a linked list sorted in ascending order and an integer called data, insert data in the linked list such that the list remains sorted.

Example 1:

Input:
LinkedList: 25->36->47->58->69->80
data: 19
Output: 
19 25 36 47 58 69 80
Explanation:
After inserting 19 the sorted linked list will look like the one in the output.
Example 2:

Input:
LinkedList: 50->100
data: 75
Output: 
50 75 100
Explanation:
After inserting 75 the sorted linked list will look like the one in the output.
Your Task:
The task is to complete the function sortedInsert() which should insert the element in sorted Linked List and return the head of the linked list

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104
-99999 <= A[i] <= 99999, for each valid i






  /*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head, int key) {
        // Add your code here.
        Node temp=head;
        Node newNode=new Node(key);  // DUPLICATE NODE  for  temporary usage

      //INSERT AT FIRST

       if(newNode.data<=head.data){
                newNode.next=head;
                head=newNode;
                return head;
        }

      //INSERT AT MIDDLE
        while(temp.next!=null){
            if(temp.data<=newNode.data && temp.next.data>=newNode.data){
                newNode.next=temp.next;
                temp.next=newNode;
                return head;
            }
            else{
                temp=temp.next;
            }
        }

       //INSERT AT END
        temp.next=newNode;
        return head;
    }


    
}
