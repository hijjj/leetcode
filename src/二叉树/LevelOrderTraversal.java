package 二叉树;

import java.util.*;

public class LevelOrderTraversal {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }


    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list2.add(node.data);
                if (node != null) {
                    TreeNode left = node.left;
                    if (node.left != null) {
                        queue.add(left);
                    }
                    TreeNode right = node.right;
                    if (node.right != null) {

                        queue.add(right);
                    }
                }
            }
            lists.add(list2);


        }
        Collections.reverse(lists);
        return lists;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node.left = node2;
        node.right = node3;
        node3.left = node4;
        node3.right = node5;

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.levelOrder(node);
    }
}
