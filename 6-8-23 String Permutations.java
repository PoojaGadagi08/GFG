Given a string S. The task is to find all permutations (need not be different) of a given string.

Example 1:

Input:
S = AAA
Output: AAA AAA AAA AAA AAA AAA
Explanation: There are total 6 permutations, as given in the output.
Example 2:

Input:
S = ABSG
Output: ABGS ABSG AGBS AGSB ASBG ASGB
BAGS BASG BGAS BGSA BSAG BSGA GABS
GASB GBAS GBSA GSAB GSBA SABG SAGB
SBAG SBGA SGAB SGBA
Explanation: There are total 24 permutations, as given in the output.
Your Task:
This is a function problem. You only need to complete the function permutation that takes S as parameter and returns the list of permutations in lexicographically increasing order. The newline is automatically added by driver code.

Constraints:
1 ≤ size of string ≤ 5

Expected Time Complexity: O(N * N!), N = length of string.
Expected Auxiliary Space: O(1)





  
//User function Template for Java


class Solution
 
{
    ArrayList<String> res;
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        res = new ArrayList<>();
        slv(S,"");
        Collections.sort(res);
        return res;
    }
  
public void slv(String S,String s)
{
     if(S.equals(""))
     {
         res.add(s);
     }
     for(int i=0;i<S.length();i++)
     {
        slv(S.substring(0,i)+S.substring(i+1),s+S.charAt(i));
     }
}

	   
}
