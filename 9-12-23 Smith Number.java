Given a number n, the task is to find out whether this number is a Smith number or not. A Smith number is a composite number whose sum of digits is equal to the sum of digits of its prime factors.

Example 1:

Input:
n = 4
Output:
1
Explanation:
The sum of the digits of 4 is 4, and the sum of the digits of its prime factors is 2 + 2 = 4.
Example 2:

Input:
n = 378
Output:
1
Explanation:
378 = 21*33*71 is a Smith number since 3+7+8 = 2*1+3*3+7*1.
Your Task:
You don't need to read input or print anything. Your task is to complete the function smithNum() which takes an Integer n as input and returns the answer.

Expected Time Complexity: O(n * log(n))
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 105




  class Solution {
    static int smithNum(int n)
    {
        // code here
        if(n==1)
        return 0;
        int m =n;
        int sum1=0;
        int sum2=0;
        int i=2;
        while(i<=n/2)
        {
            if(m%i==0)
            {
                if(i<10)
                sum1+=i;
                else
                {
                int j=i;
                while(j>0)
                {
                    sum1+=(j%10);
                    j=j/10;
                }
                }
                m=m/i;
            }
            else
            i++;
        }
        while(n>0)
        {
            sum2=sum2+(n%10);
            n=n/10;
        }
        if(sum1==0)
        return 0;
        if(sum1==sum2)
        return 1;
        return 0;
    }
};

