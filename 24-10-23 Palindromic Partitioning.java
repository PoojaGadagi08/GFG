Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts needed for palindrome partitioning of the given string.


Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings 
are "a", "babbbab", "b", "ababa".
Example 2:

Input: str = "aaabba"
Output: 1
Explaination: The substrings after 1
partitioning are "aa" and "abba".

Your Task:
You do not need to read input or print anything, Your task is to complete the function palindromicPartition() which takes the string str as the input parameter and returns the minimum number of partitions required.


Expected Time Complexity: O(n*n) [n is the length of the string str]
Expected Auxiliary Space: O(n*n)


Constraints:
1 ≤ length of str ≤ 500




  
//User function Template for Java

class Solution{
    
    // Palindrome function
    static boolean isPalindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
    
    // Recursive function
    static int numberOfPartition(int i, int n, String s,int dp[]){
        int minCost=Integer.MAX_VALUE;
        
        if(i==n)
        return 0;
        
        if(dp[i]!=-1)
        return dp[i];
        
        for(int j=i;j<n;j++){
            if(isPalindrome(i, j, s)){
                int cost=1+numberOfPartition(j+1, n, s,dp);
                minCost=Math.min(minCost, cost);
            }
        }
        return dp[i]=minCost;
    }
    
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return numberOfPartition(0, n, str,dp)-1;
        
    }
}
