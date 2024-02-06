class Solution {
    int count = 0;
    int printKDistantfromLeaf(Node root, int k) {
        if (root == null) {
            return 0;
        }

        HashSet<Node> uniqueNodes = new HashSet<>();
        HashMap<Integer, Node> levelMap = new HashMap<>();
        int level = 0;

        printKDistantfromLeafHelper(root, k, level, levelMap, uniqueNodes);
        return count;
    }

    private void printKDistantfromLeafHelper(Node root, int k, int level, HashMap<Integer, Node> levelMap, HashSet<Node> uniqueNodes) {
        if (root == null) {
            return;
        }
        level += 1;
        levelMap.put(level, root);
        if (root.left == null && root.right == null && level >= k + 1) {
            if (!uniqueNodes.contains(levelMap.get(level - k))) {
                count += 1;
                uniqueNodes.add(levelMap.get(level - k));
            }
        }
        printKDistantfromLeafHelper(root.left, k, level, levelMap, uniqueNodes);
        printKDistantfromLeafHelper(root.right, k, level, levelMap, uniqueNodes);
    }
}
