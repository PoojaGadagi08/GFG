You are given two four digit prime numbers Num1 and Num2. Find the distance of the shortest path from Num1 to Num2 that can be attained by altering only single digit at a time such that every number that we get after changing a digit is a four digit prime number with no leading zeros.

Example 1:

Input:
Num1 = 1033 
Num2 = 8179
Output: 6
Explanation:
1033 -> 1733 -> 3733 -> 3739 -> 3779 -> 8779 -> 8179.
There are only 6 steps reuired to reach Num2 from Num1. 
and all the intermediate numbers are 4 digit prime numbers.
Example 2:

Input:
Num1 = 1033 
Num2 = 1033
Output:
0
Your Task:  
You don't need to read input or print anything. Your task is to complete the function solve() which takes two integers Num1 and Num2 as input parameters and returns the distance of the shortest path from Num1 to Num2. If it is unreachable then return -1.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1000<=Num1,Num2<=9999
Num1 and Num2 are prime numbers.



  class Solution{
        int[] prime;
    Solution()
    {
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one means i is a prime
        prime = new int[10000];
        Arrays.fill(prime,1); // every num isprime
        prime[1]=0; 
        for(int i=2; i<=9999; i++)
        {
            if(prime[i]==1)// mark its multiple as false
            {
                for(int j=i*i; j<=9999; j+=i)
                prime[j]=0; // mark not prime
            }
        }
        
    }
    
    int solve(int num1,int num2){
        //code here
          // bfs for every poss
        
        int ans[] = new int[10000];
        Arrays.fill(ans, -1);
        boolean vis[] = new boolean[10000];
        Queue<Integer> q = new LinkedList<>();
        q.add(num1); vis[num1]=false; ans[num1]=0;
        
        while(!q.isEmpty())
        {
            int curr =  q.poll();
            // if vis , skip
            if(vis[curr]) continue;
            
            vis[curr]=true;  //marking the node visited.
            
            String x = Integer.toString(curr);
            for(int i=0; i<4; i++)
            {
                for(char ch='0'; ch<='9'; ch++)
                {
                    // should be a four digit prime number with no leading zeros.
                    if ( (ch=='0'&&i==0) || ch==x.charAt(i))
                    continue;
                    
                    String y = x.substring(0,i) + ch + x.substring(i+1);
                    
                    //conver in int and pushto Q if cond are satisfies
                    int z = Integer.valueOf(y);
                    if(prime[z]==1 && ans[z]==-1)
                    {
                        ans[z] = 1+ans[curr];
                        q.add(z);
                    }
                }
            }
        }
        return ans[num2];
    }
}
