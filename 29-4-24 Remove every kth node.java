class Solution
{
    /*You are required to complete this method*/
    Node delete(Node head, int k)
    {
// Your code here 
int n =0;
    Node tem = head;
    while(tem != null){
        n++;
        tem = tem.next;
    }
    if(k>n) return head;
    if(k==1) return null;
    Node prev = null;
    Node curr = head;
    
    int count =0;
    
    while(curr != null){
        count++;
        if(count %k ==0){
            prev.next = curr.next;
            curr = curr.next;
        }else{
            prev = curr;
            curr = curr.next;
        }
    }
    
    
    return head;
    }
}
