Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, the node which appeared first should be kept, all others duplicates are to be removed.

Example 1:

Input:
N = 4
value[] = {5,2,2,4}
Output: 5 2 4
Explanation:Given linked list elements are
5->2->2->4, in which 2 is repeated only.
So, we will delete the extra repeated
elements 2 from the linked list and the
resultant linked list will contain 5->2->4
Example 2:

Input:
N = 5
value[] = {2,2,2,2,2}
Output: 2
Explanation:Given linked list elements are
2->2->2->2->2, in which 2 is repeated. So,
we will delete the extra repeated elements
2 from the linked list and the resultant
linked list will contain only 2.
Your Task:
You have to complete the method removeDuplicates() which takes 1 argument: the head of the linked list.  Your function should return a pointer to a linked list with no duplicate element.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= size of linked lists <= 106
0 <= numbers in list <= 104




/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/

class Solution
{
    //Function to remove duplicates from unsorted linked list.
   public Node removeDuplicates(Node head) 
    {
         // Your code here
         
		 
		 //a set st is used to store the value as set doesn't store duplicate values.
         Set<Integer> st = new HashSet<>();
         Node temp = head, prev=head;
         
		 //add the first element in the set
         st.add(temp.data);
		 
		 //point the temp to the next element
         temp = temp.next;
         
		 //continue loop as temp doesn't point to null i.e. end of element is not reached
         while(temp!=null){
		 
			//if the current element data is there in set, point the previous link to the next element
            if(st.contains(temp.data)){
                 temp = temp.next;
                 prev.next=temp;
            }
			
			//else add the data in the set and move the prev and temp pointers to the next element.
            else{
                st.add(temp.data);
                prev=temp;
                temp=temp.next;
            }
         }
        
		//return head element which points to the first element.
        return head;
    }
}
