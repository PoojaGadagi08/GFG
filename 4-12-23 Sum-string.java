Given a string of digits, the task is to check if it is a ‘sum-string’. A string S is called a sum-string when it is broken down into more than one substring and the rightmost substring can be written as a sum of two substrings before it and the same is recursively true for substrings before it.

Example 1:

Input:
S = "12243660"
Output:
1
Explanation:
"12243660" can be broken down as {"12", "24", "36", "60"}.
We can get 60 from 24 and 36 as 24 + 36 = 60. Similarly 36 can be written as 12 + 24.
Example 2:

Input:
1111112223
Output:
1
Explanation:
"1111112223" can be broken down as {"1", "111", "112", "223"}.
We can get 223 from 111 and 1112 as 111 + 112 = 223. Similarly 112 can be written as 1 + 111.
Your Task:

You don't need to read input or print anything. Your task is to complete the function isSumString() which takes the string S and returns 1 is S is a sum-string otherwise returns 0.

Expected Time Complexity: O(|S|3)
Expected Auxiliary Space: O(|S|)

Constraints:
1 <= |S| <= 500
String consists of characters from '0' to '9'.






  class Solution {
    public String sumStrings(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1;
        StringBuilder ans = new StringBuilder();
        int carry = 0;

        while (i >= 0 && j >= 0) {
            int x = Character.getNumericValue(s1.charAt(i));
            int y = Character.getNumericValue(s2.charAt(j));
            int res = x + y + carry;
            int rem = res % 10;
            carry = res / 10;
            ans.append(rem);
            i--;
            j--;
        }

        while (i >= 0) {
            int x = Character.getNumericValue(s1.charAt(i));
            int res = x + carry;
            int rem = res % 10;
            carry = res / 10;
            ans.append(rem);
            i--;
        }

        while (j >= 0) {
            int y = Character.getNumericValue(s2.charAt(j));
            int res = y + carry;
            int rem = res % 10;
            carry = res / 10;
            ans.append(rem);
            j--;
        }

        while (carry > 0) {
            int rem = carry % 10;
            ans.append(rem);
            carry /= 10;
        }

        return ans.reverse().toString();
    }

    public boolean solve(String s, int pos, int l1, int l2) {
        String s1 = s.substring(pos, pos + l1);
        String s2 = s.substring(pos + l1, pos + l1 + l2);
        String s3 = sumStrings(s1, s2);
        int n = s3.length();

        if (n > s.length() - pos - l1 - l2) {
            return false;
        }

        if (s.substring(pos + l1 + l2, pos + l1 + l2 + n).equals(s3)) {
            if (pos + l1 + l2 + n == s.length()) {
                return true;
            }
            return solve(s, pos + l1, l2, n);
        }

        return false;
//@pankaj_meharchandai
    }

    public int isSumString(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (solve(s, 0, i, j)) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
