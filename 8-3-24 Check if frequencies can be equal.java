Given a string s which contains only lower alphabetic characters, check if it is possible to remove at most one character from this string in such a way that frequency of each distinct character becomes same in the string. Return true if it is possible to do else return false.

Note: The driver code print 1 if the value returned is true, otherwise 0.

Example 1:

Input:
s = "xyyz"
Output: 
1 
Explanation: 
Removing one 'y' will make frequency of each character to be 1.
Example 2:

Input:
s = "xxxxyyzz"
Output: 
0
Explanation: 
Frequency can not be made same by removing at most one character.
Your Task:  
You dont need to read input or print anything. Complete the function sameFreq() which takes a string as input parameter and returns a boolean value denoting if same frequency is possible or not.

Expected Time Complexity: O(|s|) 
Expected Auxiliary Space: O(1)

Constraints:
1 <= |s| <= 105



  class Solution {
    boolean sameFreq(String s) {
        // code here
        if (s.length() == 0) return false;
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (map.size() == 1) return true;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            min = Math.min(min, entry.getValue());
            max = Math.max(max, entry.getValue());
        }
        if (max == min) return true;
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (max == entry.getValue()) maxCount++;
        }
        return (max == min + 1 && maxCount == 1);
    }
}
