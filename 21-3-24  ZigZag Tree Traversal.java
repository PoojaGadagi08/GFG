





//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG {
    // Function to store the zig-zag order traversal of the tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            ArrayList<Integer> subList = new ArrayList<>(levelNum);

            for (int i = 0; i < levelNum; i++) {
                Node node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (flag) {
                    subList.add(node.data);
                } else {
                    subList.add(0, node.data);
                }
            }

            flag = !flag;
            result.addAll(subList);
        }

        return result;
    }
}
