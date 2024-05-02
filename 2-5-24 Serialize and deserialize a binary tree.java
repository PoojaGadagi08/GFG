class Tree {
    
    void inorder(Node root, ArrayList<Integer> a){
        if(root== null) return ;
        
        inorder(root.left, a);
        a.add(root.data);
        inorder(root.right, a);
    }
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> a = new ArrayList<>();
        inorder(root, a);
        return a;
        
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A) {
        // code here
        int n=A.size();
        Node root=new Node(A.get(0));
        for(int i=1;i<n;i+=2){
            Node newNode=new Node(A.get(i));
            newNode.left=root;
            if(i+1 < n)
            newNode.right=new Node(A.get(i+1));
            
            root=newNode;
        }
        return root;
    }
};
