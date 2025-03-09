package java.leetcode.maxDepth;

import java.util.LinkedList;
import java.util.Queue;

public class solution {

    // Maximum Depth of Binary Tree
    /*
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int len = 0;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (var i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return len;
    }

    // drugi nacin
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
    }
}
