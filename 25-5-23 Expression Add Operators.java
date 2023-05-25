//if constraints is less than 25  use recursion.


Given a string S that contains only digits (0-9) and an integer target, return all possible strings to insert the binary
operator ' + ', ' - ', or ' * ' between the digits of S so that the resultant expression evaluates to the target value.

Note:

Operands in the returned expressions should not contain leading zeros. For example, 2 + 03 is not allowed whereas 20 + 3 is fine. 
  It is allowed to not insert any of the operators.

If no solution is found, return an empty string array.
Example 1:

Input:
S = "123"
target = 6
Output: { "1*2*3", "1+2+3"}
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
  
  
  
  class Solution {
   
    public static ArrayList<String> addOperators(String num, int target) {
        // code here
     ArrayList<String> ans = new ArrayList<String>();
        if (num == null || num.length() == 0) return ans;
        helper(ans, "", num, target, 0, 0, 0); //path, string_giv, target, index, p_val, prev 
        return ans;
    }
    static void helper( ArrayList<String> ans, String path, String num, int target,
                       int ind, long p_val, long prev) {

        //no elements left, check p_val==target add the path and return
        if (ind == num.length()) 
        {
            if (target == p_val) ans.add(path);
            return;
        }
        //itr for each ele and recur for all possibilities
        for (int i = ind; i < num.length(); i++) 
        {
            
            long cur = Long.parseLong(num.substring(ind, i + 1));
            if (ind == 0) 
            {
                //   System.out.print(path+cur + " ");
                // eg"123"  - forming 1, 12,123 and tring all poss for each
                helper( ans, path + cur, num, target, i + 1, cur, cur);
             
            } else 
            {
                helper( ans, path + "+" + cur, num, target, i + 1, p_val + cur,
                       cur);

                helper(ans,  path + "-" + cur, num, target, i + 1, p_val - cur,
                       -cur);

                helper( ans, path + "*" + cur, num, target, i + 1,
                       p_val - prev + prev * cur, prev * cur);
            }
 	    if (num.charAt(ind) == '0') break;
        }
    }
}
