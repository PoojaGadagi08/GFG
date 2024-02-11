Given an integer n, return the first n elements of Recaman’s sequence.
It is a function with domain and co-domain as whole numbers. It is recursively defined as below:
Specifically, let a(n) denote the (n+1)th term. (0 being the 1st term).
The rule says:
a(0) = 0
a(n) = a(n-1) - n, if a(n-1) - n > 0 and is not included in the sequence previously
       =  a(n-1) + n otherwise.

Example 1:

Input: 
n = 5
Output: 
0 1 3 6 2
Explaination: 
a(0) = 0,
a(1) = a(0)-1 = 0-1 = -1 and -1<0, therefore a(1) = a(0)+1 = 1,
a(2) = a(1)-2 = 1-2 = -1 and -1<0, therefore a(2) = a(1)+2 = 3,
a(3) = a(2)-3 = 3-3 = 0 but since 0 is already present in the sequence, a(3) = a(2)+3 = 3+3 = 6,
a(4) = a(3)-4 = 6-4 = 2.
Therefore the first 5 elements of Recaman's sequence will be 0 1 3 6 2.
Example 2:

Input: 
n = 3
Output: 
0 1 3
Explaination: 
As seen in example 1, the first three elements will be 0 1 3.
Your Task:
You do not need to read input or print anything. Your task is to complete the function recamanSequence() which takes n as the input parameter and returns the sequence.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 105



User function Template for Java

// class Solution{
//     static ArrayList<Integer> recamanSequence(int n){
//         // code here
//         ArrayList<Integer> ans = new ArrayList<>();
//         ans.add(0);
//         int cnt=1;
//         for(int i=1;i<n;i++){
//             ans.add(ans.get(i-1)+cnt);
//             cnt++;
//         }
//         return ans;
//     }
// }



class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        HashSet<Integer> h = new HashSet<>();
        al.add(0);
        h.add(0);
        for (int i=1;i<n;i++){
            if(al.get(i-1)-i>0 && h.contains(al.get(i-1)-i)==false){
                al.add(al.get(i-1)-i);
                h.add(al.get(i-1)-i);
            }else{
                al.add(al.get(i-1)+i);
                h.add(al.get(i-1)+i);
            }
        }
        return al;
    }
}

