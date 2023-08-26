Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

Example 1:

Input:
S = "aabacbebebe", K = 3
Output: 
7
Explanation: 
"cbebebe" is the longest substring with 3 distinct characters.
Example 2:

Input: 
S = "aaaa", K = 2
Output: -1
Explanation: 
There's no substring with 2 distinct characters.
Your Task:
You don't need to read input or print anything. Your task is to complete the function longestKSubstr() which takes the string S and an integer K as input and returns the length of the longest substring with exactly K distinct characters. If there is no substring with exactly K distinct characters then return -1.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).

Constraints:
1 ≤ |S| ≤ 105
1 ≤ K ≤ 26
All characters are lowercase latin characters.






  class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        if (s == null || s.length() == 0 || k <= 0) {
            return -1;
        }

        HashMap<Character, Integer> charCount = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        int uniqueCount = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

            if (charCount.get(c) == 1) {
                uniqueCount++;
            }

            while (uniqueCount > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                    uniqueCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return (uniqueCount == k) ? maxLength : -1;
    }
    }

