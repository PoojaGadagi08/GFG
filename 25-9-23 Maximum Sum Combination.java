Given two integer array A and B of size N each.
A sum combination is made by adding one element from array A and another element of array B.
Return the maximum K valid sum combinations from all the possible sum combinations.

Note : Output array must be sorted in non-increasing order.

Example 1:

Input:
N = 2
K = 2
A [ ] = {3, 2}
B [ ] = {1, 4}
Output: {7, 6}
Explanation: 
7 -> (A : 3) + (B : 4)
6 -> (A : 2) + (B : 4)
Example 2:

Input:
N = 4
K = 3
A [ ] = {1, 4, 2, 3}
B [ ] = {2, 5, 1, 6}
Output: {10, 9, 9}
Explanation: 
10 -> (A : 4) + (B : 6)
9 -> (A : 4) + (B : 5)
9 -> (A : 3) + (B : 6)
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxCombinations() which takes the interger N,integer K and two integer arrays A [ ] and B [ ] as parameters and returns the maximum K valid distinct sum combinations .

Expected Time Complexity: O(Nlog(N))
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤  105
1 ≤ K ≤  N
1 ≤ A [ i ] , B [ i ] ≤ 104






  class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        Arrays.sort(A);
        Arrays.sort(B);
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=N-1;i>N-K-1;i--){
            for(int j=N-1;j>N-K-1;j--){
                int n=A[i]+B[j];
                
                if(pq.size()<K){
                    pq.add(n);
                }else{
                    if(pq.peek()<n){
                        pq.poll();
                        pq.add(n);
                    }
                else break;
                }
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        
        while(!pq.isEmpty()){
            if(ans.isEmpty())
            ans.add(pq.poll());
            else
            ans.add(0,pq.poll());
        }
        
        return ans;
    }
}
