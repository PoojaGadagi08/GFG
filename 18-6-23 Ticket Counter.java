N people from 1 to N are standing in the queue at a movie ticket counter. It is a weird counter, as it distributes tickets to the first K people and then 
the last K people and again first K people and so on, once a person gets a ticket moves out of the queue. The task is to find the last person to get the ticket.

Example 1:

Input:
N = 9
K = 3
Output:
6
Explanation:
Starting queue will like {1, 2, 3, 4, 5, 6, 7, 8, 9}. After the first distribution queue will look like {4, 5, 6, 7, 8, 9}. And after the second distribution 
queue will look like {4, 5, 6}. The last person to get the ticket will be 6.
Example 2:

Input:
N = 5
K = 1
Output:
3
Explanation:
Queue start as {1, 2, 3, 4, 5} -> {2, 3, 4, 5} -> {2, 3, 4} -> {3, 4} -> {3}
Last person to get ticket will be 3.
  
  
  
  
//User function Template for Java
class Solution {
    public static int distributeTicket(int n,int k)
    {
       int i=1;
       int j=n;
       boolean a=false;
       int ans=0;
       
       while(i<=j){
           if(a==false){
               i+=k;
              ans=j;
           }
           if(a==true){
               j-=k;
               ans=i;
           }
           a=!a;
       }
        return ans;
    }
}



//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int K)
    {
        int step = N/K;
        int left = step/2;
        int right = left;
        if(step%2==1)left++;
        int i = K*left;
        int j = N+1-K*right;
        if(step%2==1){
            if(N%K==0)return i;
            return i+1;
        }
        if(N%K==0)return j;
        return j-1;
    }
}
