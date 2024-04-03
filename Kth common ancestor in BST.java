class Solution {
    public void putParents(Node root,Node p,Map<Node,Node> hm){
        if(root==null) return;
        hm.put(root,p);
        putParents(root.left,root,hm);
        putParents(root.right,root,hm);
    }
    public Node lowestCommonAncestor(Node root,int x,int y){
        if(root==null || root.data==x || root.data==y) return root;
        Node l=lowestCommonAncestor(root.left,x,y);
        Node r=lowestCommonAncestor(root.right,x,y);
        if(l==null) return r;
        else if(r==null) return l;
        return root;
    }
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        // code here
        Map<Node,Node> parents=new HashMap<>();
        Node LCA=lowestCommonAncestor(root,x,y);
        putParents(root,null,parents);
        Node curr=LCA;
        while(k-->1 && parents.containsKey(curr)){
            curr=parents.get(curr);
        }
        return k==0 && curr!=null?curr.data:-1;
    }
}
 
