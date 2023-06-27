Given two linked lists, your task is to complete the function makeUnion(), that returns the union list of two linked lists. This union list should include all the distinct elements
  only and it should be sorted in ascending order.

Example 1:

Input:
L1 = 9->6->4->2->3->8
L2 = 1->2->8->6->2
Output: 
1 2 3 4 6 8 9
Explaination: 
All the distinct numbers from two lists, when sorted forms the list in the output. 
Example 2:

Input:
L1 = 1->5->1->2->2->5
L2 = 4->5->6->7->1
Output: 
1 2 4 5 6 7
Explaination: 
All the distinct numbers from two lists, when sorted forms the list in the output.




  class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Add your code here.
	     //Add your code here.
	    Set<Integer> set = new TreeSet<>();
	    while(head1!=null)
	    {
	        set.add(head1.data);
	        head1=  head1.next;
	    }
	    
	    while(head2!=null)
	    {
	        set.add(head2.data);
	        head2 =  head2.next;
	    }
	    Node curr=null;
	    Node start = null;
	   
	    for(int x : set)
	    {
	       if(start==null) // will run just once
	       {
	           start = new Node(x);
	           curr = start;
	       }
	       else
	       {
	       curr.next = new Node(x);
	       curr = curr.next;
	       }
	    }
	    return start;
	
	}
}
