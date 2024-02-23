In daily share trading, a buyer buys shares in the morning and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, the second transaction can only start after the first one is complete (buy->sell->buy->sell). The stock prices throughout the day are represented in the form of an array of prices. 

Given an array price of size n, find out the maximum profit that a share trader could have made.

Example 1:

Input:
n = 6
prices[] = {10,22,5,75,65,80}
Output:
87
Explanation:
Trader earns 87 as sum of 12, 75 Buy at 10, sell at 22, Buy at 5 and sell at 80.
Example 2:

Input:
n = 7
prices[] = {2,30,15,10,8,25,80}
Output:
100
Explanation:
Trader earns 100 as sum of 28 and 72 Buy at price 2, sell at 30, Buy at 8 and sell at 80,
Your Task:

Complete the function maxProfit() which takes an integer array price as the only argument and returns an integer, representing the maximum profit, if only two transactions are allowed.

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:

1 <= n <= 105
1 <= price[i] <= 105


  class Solution {
    public static int maxProfit(int n, int[] price) {
        // code here
                    // int n=price.size();
            int temp[]=new int[n];
            
            //first traversal was from right to left
            int maxi=price[n-1];
            for(int i=n-2;i>=0;i--){
                maxi=Math.max(maxi, price[i]);
                temp[i]=Math.max(temp[i+1], maxi-price[i]);
            }
            
            //second traversal
            int mini=price[0];
            for(int i=1;i<n;i++){
                mini=Math.min(price[i],mini);
                temp[i]=Math.max(temp[i-1], price[i]-mini+temp[i]);
            }
            
            return temp[n-1];

    }
}
        
