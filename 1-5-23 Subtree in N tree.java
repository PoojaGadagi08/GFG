// Given the root of a n-ary tree find the number of duplicate subtrees in the n-ary tree.
//   Two trees are duplicates if they have the same structure with the same node values.



class Solution{
    Map<String,Integer> map=new HashMap<>();
    
    public int duplicateSubtreeNaryTree(Node root){
       // Code here
       int ans=0;
       slove(root);
       
       for(Map.Entry<String,Integer> e: map.entrySet())
       if(e.getValue()>1) ans++;
       
       return ans;
    }
    String slove(Node root){
        String s=root.data+"";
        for(Node nei:root.children)
        s+=slove(nei);
        
        map.put(s,map.getOrDefault(s,0)+1);
        return s;
    }
    
}
