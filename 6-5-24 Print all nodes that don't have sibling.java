


class Tree
{
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        helper(node, ans);
        if(ans.isEmpty())
        ans.add(-1);
        
        Collections.sort(ans);
        return ans;
        
        
        
    }
    
    
    void helper(Node node, ArrayList<Integer> list){
        if(node==null || node.left==null && node.right==null)
        return ;
        
        if(node.right==null){
            if(!list.contains(node.left.data)){
                list.add(node.left.data);
            }
        }
        if(node.left==null){
            if(!list.contains(node.right.data)){
                list.add(node.right.data);
            }
        }
        
        helper(node.left, list);
        helper(node.right, list);
    }
}
