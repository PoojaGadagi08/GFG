Given a stack, delete the middle element of the stack without using any additional data structure.
Middle element:- ceil((size_of_stack+1)/2) (1-based indexing) from bottom of the stack.

Note: The output shown by the compiler is the stack from top to bottom.
 
Example 1:

Input: 
Stack = {10, 20, 30, 40, 50}
Output:
ModifiedStack = {10, 20, 40, 50}
Explanation:
If you print the stack the bottom-most element will be 10 and the top-most element will be 50. Middle element will be element at index 3 from bottom, which is 30. Deleting 30, stack will look like {10 20 40 50}.
Example 2:

Input: 
Stack = {10 20 30 40}
Output:
ModifiedStack = {10 30 40}
Explanation:
If you print the stack the bottom-most element will be 10 and the top-most element will be 40. Middle element will be element at index 2 from bottom, which is 20. Deleting 20, stack will look like {10 30 40}.
Your Task:
You don't need to read input or print anything. Complete the function deleteMid() which takes the stack and its size as input parameters and modifies the stack in-place.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)




  
//User function Template for Java

class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int N){
        // code here
        // int n=N/2;
        // ArrayDeque<Integer> st=new ArrayDeque<>();
        
        // int i=0;
        // while(!s.isEmpty()){
        //     st.push(s.pop());
        //     i++;
            
        //     if(i==n){
        //         s.pop();
        //     }
            
        // }
        // while(!st.isEmpty()){
        //     s.push(st.pop());
        // }
        
        helper(s,N,0);
    } 
    void helper(Stack<Integer>s,int N,int i){
        if(i==(N/2)){
            s.pop();
            return;
        }
        int x=s.pop();
        i++;
        helper(s,N,i);
        s.push(x);
    }
}
