/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
      private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        
        Node Cdummy = new Node('v');   //consonant dummy
        Node Vdummy = new Node('v');
        
        Node ct=Cdummy;   //consonant tail
        Node vt=Vdummy;   //vowel tail
        
        Node curr=head;
        
        while(curr != null){
            if(!isVowel(curr.data)){
                ct.next=new Node(curr.data);
                ct=ct.next;
            }
            else{
                  vt.next=new Node(curr.data);
                vt=vt.next;
            }
            
            curr=curr.next;
            }
            
            vt.next=Cdummy.next;
            
            Node ans=Vdummy.next;
            return ans;
    }
}




// class Solution {
   

//     public Node arrangeCV(Node head) {
//         //write code here and return the head of changed linked list
//         if (head == null || head.next == null) {
//             return head;
//         }

//         Node dummyVowel = new Node('0'); // Dummy node for vowels
//         Node dummyConsonant = new Node('0'); // Dummy node for consonants
//         Node vowelTail = dummyVowel; // Pointer to the last node of the vowel list

//         Node curr = head;
//         while (curr != null) {
//             if (isVowel(curr.data)) {
//                 vowelTail.next = curr;
//                 vowelTail = curr;
//             } else {
//                 dummyConsonant.next = curr;
//                 dummyConsonant = curr;
//             }
//             curr = curr.next;
//         }

//         // Append the consonant list to the end of the vowel list
//         vowelTail.next = dummyConsonant.next;

//         // Ensure the end of the consonant list points to null to avoid cycles
//         dummyConsonant.next = null;

//         // Return the organized list starting from the first vowel node
//         return dummyVowel.next;
//     }

//     private static boolean isVowel(char c) {
//         return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
//     }
// }
