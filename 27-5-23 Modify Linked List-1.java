Given a singly linked list containing N nodes. Modify the Linked list as follows:

1. Modify the value of the first half nodes such that 1st node's new value is equal to the value of the last node minus the first node's current value, 
2nd node's new value is equal to the second last nodes value minus 2nd nodes current value, likewise for first half nodes.
2. Replace the second half of nodes with the initial values of the first half nodes(values before modifying the nodes).
3. If N is odd then the value of the middle node remains unchanged.

Example 1:

Input:
N = 5
linked list = 10 -> 4 -> 5 -> 3 -> 6
Output:
-4 -1 5 4 10
Explanation:
For first half nodes modified list will be:
-4 -> -1 -> 5 -> 3 -> 6
For second half nodes modified list will be:
-4 -> -1 -> 5 -> 4 -> 10



class Solution
{
    public static Node modifyTheList(Node head)
    {
     Node mid = get_m(head);
     
     //partion 2nd list
     Node backlist = mid.next;  // 3->6 -> N
     
     //mark next as null for last node of first list
     mid.next=null;  //10 > 4 > 5> N
     
     backlist = reverse(backlist);  //6 >3 >N
     
     //itr in both list , store diff in 1st and copy 1st list data to 2nd
     Node curr1 = head; Node curr2 = backlist;
     while(curr2!=null)
     {
         int temp = curr1.data;
         curr1.data = curr2.data-temp;
         curr2.data = temp;
         
         curr1 = curr1.next; curr2=curr2.next;
     }
    //  1st : -4, -1, 5 -> N  || 2nd : 10>4>N
     //3. reverse 2nd list and append in 1st(last node of 1st list is mid)
     mid.next  = reverse(backlist);
     return head;
    }
   static Node get_m(Node head)
    {
        Node f=head;
        Node s=head;
        while(f.next!=null && f.next.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
   static Node reverse(Node head)
    {
        Node prev=null;
        Node curr=head;
        Node next=null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next=prev;
            prev=curr;
            
            curr=next; // repeat the above three lines for next nodes;
        }
        return prev;
    }
}
