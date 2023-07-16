Given an input stream A of n characters consisting only of lower case alphabets. While reading characters from the stream, you have to tell which character has appeared only once in the stream upto that point. If there are many characters that have appeared only once, you have to tell which one of them was the first one to appear. If there is no such character then append '#' to the answer.
 

Example 1:

Input: A = "aabc"
Output: "a#bb"
Explanation: For every character first non
repeating character is as follow-
"a" - first non-repeating character is 'a'
"aa" - no non-repeating character so '#'
"aab" - first non-repeating character is 'b'
"aabc" - first non-repeating character is 'b'
Example 2:

Input: A = "zz"
Output: "z#"
Explanation: For every character first non
repeating character is as follow-
"z" - first non-repeating character is 'z'
"zz" - no non-repeating character so '#'
 

Your Task:
You don't need to read or print anything. Your task is to complete the function FirstNonRepeating() which takes A as input parameter and returns a string after processing the input stream.
 

Expected Time Complexity: O(26 * n)
Expected Space Complexity: O(26)



  class Solution {
    public String FirstNonRepeating(String A) {
    Map<Character, Integer> countMap = new LinkedHashMap<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);

            // Append the first non-repeating character to the result
            boolean foundNonRepeating = false;
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == 1) {
                    result.append(entry.getKey());
                    foundNonRepeating = true;
                    break;
                }
            }

            // If no non-repeating character is found, append '#'
            if (!foundNonRepeating) {
                result.append("#");
            }
        }

        return result.toString();
    }
}
