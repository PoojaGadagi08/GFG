Given an array locations[] of size n where locations[i] represents the location of the ith fruit on the x-axis and also given an array types[]  
where types[i] is an integer which represents the type of the ith fruit. You are initially at coordinate 0 and you have to collect all the fruits and then return back to coordinate 0 again.
  To move 1 unit on the x-axis requires 1 second of time. The only condition is that you have to collect the fruits in a non-decreasing order of their types[i] 
  (for example if ith fruit has type[i]=1 and jth fruit has type[j]=2 then ith fruit has to be picked before jth fruit). Find minimum time to collect all fruits in the non-decreasing order
  of their types and return back to coordinate 0.

Note: You can assume it takes no time to pick up fruit and the location of a fruit can be negative also.

Example 1:

Input:
n=4
locations={1,3,5,7}
types={1,2,3,1}
Output:
18
Explanation:
You start at x=0 and move to x=7 and 
in the way pick fruits of type 1 at x=1 
and x=7 and it took total 7 seconds to 
move from 0->7 now you move to x=3 
in 4 seconds and than to x=5 in 2 seconds 
and than return back to x=0 in 5 seconds.
So overall it took 18 seconds(7+4+2+5).
Example 2:

Input:
n=4
locations={-4,-3,1,-8}
types={4,2,4,5}
Output:
24
Explanation:
The optimal way is to way go to x=-3 
in starting than 1 and follow path 
like this  (1)->(-4)->(-8)->(0) and 
total time it takes is 24 .
  
  
  
  
  
  
class Solution {
     static Map<Integer,Integer> mm1;
    static Map<Integer,Integer> mm2;
    static List<Integer> temp;
    static long help(int pos,int index,long dp[][],int indication){
        if(index==temp.size())return 0;
        if(dp[index][indication]!=-1)return dp[index][indication];
        int left = mm1.get(temp.get(index));
        int right = mm2.get(temp.get(index));
        long one=0,two=0;
        one = Math.abs(pos-left)+Math.abs(left-right)+help(right,index+1,dp,1);
        if(index==temp.size()-1)one+=Math.abs(right-0);
        two = Math.abs(pos-right)+Math.abs(right-left)+help(left,index+1,dp,0);
        if(index==temp.size()-1)two+=Math.abs(left-0);
        return dp[index][indication]= Math.min(one,two);
    }
    public static long minTime(int n, int[] locations, int[] types) {
        // code here
        temp = new ArrayList<>();
        mm1 = new HashMap<>();
        mm2 = new HashMap<>();
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)mx=Math.max(mx,types[i]);
        int ele[] = new int[mx+1];
        Arrays.fill(ele,0);
        for(int i=0;i<n;i++){
            if(mm1.get(types[i])==null){
                ele[types[i]]=1;
                mm1.put(types[i],locations[i]);
                mm2.put(types[i],locations[i]);
            }
            else{
                mm1.put(types[i],Math.min(mm1.get(types[i]),locations[i]));
                mm2.put(types[i],Math.max(mm2.get(types[i]),locations[i]));
            }
        }
        for(int i=0;i<=mx;i++){
            if(ele[i]==1)temp.add(i);
        } 
        int a=temp.size();
        long dp[][]=new long[a][2];
        for(long t[]:dp){
            Arrays.fill(t,-1);
        }
        return help(0,0,dp,0);
    }
}
        
