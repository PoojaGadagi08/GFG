The cost of stock on each day is given in an array price[] of size n. Each day you may decide to either buy or sell the stock i at price[i], you can even
  buy and sell the stock on the same day, Find the maximum profit which you can get.

Note: You can only hold one stock at a time.

Example 1:

Input:
n = 4
a = {3, 4, 1, 5}
Output:
5
Explanation:
We can buy stock on day 1 (at price 3) and sell it on 
day 2 (at price 4) profit will be 4-3=1, 
We can buy another stock on day 3 (at price 1) and sell 
it on day 4 (at price 5) profit will be 5-1=4, 
which will give us maximum profit of 5.
Example 2:

Input:
n = 5
a = {1, 3, 5, 7, 9}
Output:
8
Explanation:
We can buy stock on day 1 (at price 1) and sell it on 
day 5 (at price 9), 
which will give us maximum profit of 8.



  
class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
         int profit=0;
        for(int i=1; i<n ;i++)
        {
            if(prices[i] > prices[i-1])
            profit+= prices[i] - prices[i-1];
        }
        return profit;
    }
}
