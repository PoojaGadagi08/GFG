class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node == null) {
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            // Add the current node's value to the front of the ArrayList
            ans.add(0, curr.data);

            // Enqueue right child if present
            if (curr.right != null) {
                q.add(curr.right);
            }

            // Enqueue left child if present
            if (curr.left != null) {
                q.add(curr.left);
            }
        }

        return ans;
    }

    
    
    
    // public void postOrder(Node node, ArrayList<Integer> ans){
    //     if(node==null)
    //     return ;
        
    //     postOrder(node.left, ans);
    //     postOrder(node.right, ans);
    //     ans.add(node.data);
    // }
}      
