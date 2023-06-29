For a given non-negative integer N, find the next smallest Happy Number. A number is called Happy if it leads to 1 after a sequence of steps. Wherein at each step the number is 
  replaced by the sum of squares of its digits that is, if we start with Happy Number and keep replacing it with sum of squares of its digits, we reach 1 at some point.
 
Example 1:

Input:
N = 8
Output:
10
Explanation:
Next happy number after 8 is 10 since
1*1 + 0*0 = 1
Example 2:

Input:
N = 10
Output
13
Explanation:
After 10, 13 is the smallest happy number because
1*1 + 3*3 = 10, so we replace 13 by 10 and 1*1 + 0*0 = 1.




  
//User function Template for Java


class Solution { 
  
     static int isHappy(int N) { 
        if (N == 1 || N == 7) 
            return 1; 
        int sum = N, curr = N; 
  
        // make the sum of square of digits equals a sngle digit num
        while(sum > 9) { 
            sum = 0;  // reset sum for every itr
  
            // this loop finds the sum of square of digits 
            while (curr > 0) { 
                int d = curr%10; // last digit 
                sum += d*d; 
                curr/=10; 
            } 
            
            if (sum == 1) 
                return 1;
            //else make the new number are curr numnber and proceed ahead.
            curr = sum; 
        } 
        if(sum == 7) 
            return 1; 
        return 0; 
    } 
    
    static int nextHappy(int N)
    {   
        int next=N+1;
        int res=next;
        // check for every num
        while(true)
        {
            if(isHappy(next)==1)
                return next;
            next++;
            res=next;
        }
    }
}
