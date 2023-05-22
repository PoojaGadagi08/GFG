You are given a tree containing N nodes in the form of an array P where Pi represents the parent of the 
i-th node and P0 = -1 as the tree is rooted at node 0. In one move, you can merge any two adjacent nodes. 
  Calculate the minimum number of moves required to turn the tree into a star tree.

-> Merging adjacent nodes means deleting the edge between them and considering both the nodes as a single one.
-> A Star tree is a tree with a center node, and all other nodes are connected to the center node only.

Example 1:

Input:
N = 5
p[] = {-1, 0, 0, 1, 1}
Output:
1
  
  
  // class Solution {
//     public static int solve(int N, int[] p) {
//         // code here
        
//         int con[]=new int[N];  ///Connection array
//         // i-->Nodes , con[i]-->connection that perticular node have
//         for(int i=1;i<N;i++){
//             con[i]++;
//             con[p[i]]++;
//         }
//         int ans=0;
        
//         //if connection is one then it is a leaf node 
//         //And in star tree they are deleting the internal nodes only 
//         //except root and leaf node 
//         //so, after the intenal node the tree will become the star tree
//         for(int x: con){
//             if(x==1)
//             ans++;
//         }
//         return N-ans-1;
//     }
// }
        

class Solution {
   public static int solve(int N, int[] p) {
        // code here
        int temp[] = new int[N];
        Arrays.fill(temp,0);
        for(int i=1;i<N;i++){
            temp[p[i]]++;
            temp[i]++;
        }
        int ans=0;
        for(int x:temp)if(x==1)ans++;
        if(ans==N)return 0;
        return N-1-ans;
    }
}
