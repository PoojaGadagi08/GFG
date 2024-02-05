class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
      
        if(head == null){
            Node temp = new Node(data);
            temp.next = temp;
            return temp;
        }
        else if(head.data > data){
            Node first = head ;
            while(head.next != first){
                head = head.next ;
            }
            head.next = new Node(data);
            head = head.next;
            head.next = first ;
            return head ;
        }
        else{
            Node first = head;
            Node previous = first;
            first = first.next;
            
            while(first != head){
                if(first.data >= data){
                    previous.next = new Node(data);
                    previous = previous.next;
                    previous.next = first ;
                    return head;
                }
                else{
                    previous = first;
                    first = first.next;
                }
            }
            previous.next = new Node(data);
            previous = previous.next;
            previous.next = head ;
            return head ;
        }
    }  // code here
    
}

