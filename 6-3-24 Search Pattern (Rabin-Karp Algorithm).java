Given two strings, one is a text string and other is a pattern string. The task is to print the indexes of all the occurences of pattern string in the text string. For printing, Starting Index of a string should be taken as 1. The strings will only contain lowercase English alphabets ('a' to 'z').

Example 1:

Input: 
text = "birthdayboy"
pattern = "birth"
Output: 
[1]
Explanation: 
The string "birth" occurs at index 1 in text.
Example 2:

Input:
text = "geeksforgeeks"
pattern = "geek"
Output: 
[1, 9]
Explanation: 
The string "geek" occurs twice in text, one starts are index 1 and the other at index 9.
Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string text and the string pattern as input and returns an array denoting the start indices (1-based) of substring pattern in the string text. 

Expected Time Complexity: O(|text| + |pattern|).
Expected Auxiliary Space: O(1).

Constraints:
1<=|text|<=5*105
1<=|pattern|<=|text|



  ArrayList<Integer> search(String pattern, String text)
    {
		// Compute pattern hashValue
		int patternHashValue = 0;
		for (int i = 0; i < pattern.length(); i++) {
			patternHashValue += (int) pattern.charAt(i);
		}
		int currentHashValue = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < text.length(); i++) {
			if (i < pattern.length()) {
				currentHashValue += (int) text.charAt(i);
				if (i == pattern.length() - 1 && currentHashValue == patternHashValue) {
					Boolean match = Boolean.TRUE;
					for (int j = i - pattern.length() + 1, k = 0; k < pattern.length(); j++, k++) {
						if (pattern.charAt(k) != text.charAt(j)) {
							match = Boolean.FALSE;
							break;
						}
					}

					if (match) {
						ans.add(i + 1 - (pattern.length() - 1));
					}
				}
			} else {
				currentHashValue -= (int) text.charAt(i - pattern.length());
				currentHashValue += (int) text.charAt(i);
				if (currentHashValue == patternHashValue) {
					Boolean match = Boolean.TRUE;
					for (int j = i - pattern.length() + 1, k = 0; k < pattern.length(); j++, k++) {
						if (pattern.charAt(k) != text.charAt(j)) {
							match = Boolean.FALSE;
							break;
						}
					}

					if (match) {
						ans.add(i + 1 - (pattern.length() - 1));
					}
				}
			}
		}
		return ans;
    }
