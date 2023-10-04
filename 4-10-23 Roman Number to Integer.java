Given a string in roman no format (s)  your task is to convert it to an integer . Various symbols and their values are given below.
I 1
V 5
X 10
L 50
C 100
D 500
M 1000

Example 1:

Input:
s = V
Output: 5
Example 2:

Input:
s = III 
Output: 3
Your Task:
Complete the function romanToDecimal() which takes a string as input parameter and returns the equivalent decimal number. 

Expected Time Complexity: O(|S|), |S| = length of string S.
Expected Auxiliary Space: O(1)

Constraints:
1<=roman no range<=3999




  class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        HashMap<Character, Integer> h=new HashMap<>();
        
        int n=str.length();
        
        h.put('I', 1);
        h.put('V', 5);
        h.put('X', 10);
        h.put('L', 50);
        h.put('C', 100);
        h.put('D', 500);
        h.put('M', 1000);
        
        int sum=0;
        for(int i=0;i<n-1;i++){
            if(h.get(str.charAt(i)) < h.get(str.charAt(i+1)))
            sum-=h.get(str.charAt(i));
            else 
            sum+=h.get(str.charAt(i));
        }
        
        sum+=h.get(str.charAt(n-1));
        
        return sum;
    }
}
