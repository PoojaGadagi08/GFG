Given a linked list, you have to perform the following task:

Extract the alternative nodes starting from second node.
Reverse the extracted list.
Append the extracted list at the end of the original list.
Note: Try to solve the problem without using any extra memory.

Example 1:

Input:
LinkedList = 10->4->9->1->3->5->9->4
Output: 
10 9 3 9 4 5 1 4
Explanation: 
Alternative nodes in the given linked list are 4,1,5,4. Reversing the alternative nodes from the given list, and then appending them to the end of the list results in a list 10->9->3->9->4->5->1->4.
Example 2:

Input:
LinkedList = 1->2->3->4->5
Output: 
1 3 5 4 2 
Explanation:
Alternative nodes in the given linked list are 2 and 4. Reversing the alternative nodes from the given list, and then appending them to the end of the list results in a list 1->3->5->4->2.
Your Task:
You don't have to read input or print anything. Your task is to complete the function rearrange() which takes the head of the linked list as input and rearranges the list as required.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
0 <= Node_value <= 109



  class Solution
{
    public static void rearrange(Node odd)
    {
        // add your code here
        if(odd.next==null || odd==null)return ;
        Node first=null,second=null,p=null,q=null,temp=odd;
        
        /// creating two list fst-starts from first ,scd starts from second and adds alternate nodes
        boolean f=false;
        while(temp!=null){
           
            if(f==false){
                if(first==null){
                p=first=temp;
                }
                else{
                p.next=temp;
                 p=p.next;
                }
              
               f=true;
            }
            else{
                
                if(second==null){
                q=second=temp;
                }else{
                q.next=temp;
                q=q.next;
                }
                f=false;
            }
            
            temp=temp.next;
        }
        p.next=null;// removing last link of the lists
        q.next=null;// removing last link of the lists
        // reversing second list which are alternate 
        p=second.next;
        q=second;
        temp=null;
        
        while(p!=null){
            q.next=temp;
            temp=q;
            q=p;
            p=p.next;
        }
          
          q.next=temp;// q had list of alternate and reversed list
          
          p=first;
          //appending second list into first lists last node
          
          while(p.next!=null)
              p=p.next;
          
          p.next=q; // appending the second rversed list present in the name "q"
    }


}
