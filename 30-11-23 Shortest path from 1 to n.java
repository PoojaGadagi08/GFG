Consider a directed graph whose vertices are numbered from 1 to n. There is an edge from a vertex i to a vertex j if and only if either j = i + 1 or j = 3 * i. The task is to find the minimum number of edges in a path from vertex 1 to vertex n.

Example 1:

Input:
n = 9
Output:
2
Explanation:
Many paths are possible from 1 to 9.
Shortest one possible is,
1 -> 3 -> 9, of length 2.
Example 2:

Input:
n = 4
Output:
2
Explanation:
Possible paths from 1 to 4 are,
1 -> 2 -> 3 -> 4 and
1 -> 3 -> 4.
Second path of length 2 is the shortest.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function minimumStep() which takes an integer n as inputs and returns the minimum number of edges in a path from vertex 1 to vertex N.

Expected Time Complexity: O( log(n) )
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105








  class Solution{
    
    public static int help(int n){
        if(n==1 || n==0)
            return 0;
        else if(n==2)
            return 1;
        else if(n%3==0){
            return 1+help(n/3);
        }
        else if((n-1)%3==0)
            return 2+help((n-1)/3);
        else
            return 3+help((n-2)/3);
    }
    
    public int minStep(int n)
    {
        // code here
        return help(n);
    }
}

