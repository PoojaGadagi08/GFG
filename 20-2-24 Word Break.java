Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated sequence of dictionary words. Return 1 if it is possible to break A into sequence of dictionary words, else return 0. 

Note: From the dictionary B each word can be taken any number of times and in any order.

Example 1:

Input:
n = 6
B = { "i", "like", "sam", "sung", "samsung", "mobile"}
A = "ilike"
Output:
1
Explanation:
The string can be segmented as "i like".
Example 2:

Input:
n = 6
B = { "i", "like", "sam", "sung", "samsung", "mobile"}
A = "ilikesamsung"
Output:
1
Explanation:
The string can be segmented as 
"i like samsung" or "i like sam sung".
Your Task:
Complete wordBreak() function which takes a string and list of strings as a parameter and returns 1 if it is possible to break words, else return 0. You don't need to read any input or print any output, it is done by driver code.

Expected Time Complexity: O(len(A)2)
Expected Space Complexity: O(len(A))

Constraints:
1 ≤ n ≤ 12
1 ≤ len(A) ≤ 1100

