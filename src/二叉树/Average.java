package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Average {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> lists = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list2.add(node.val);
                sum = node.val + sum;
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
            Double average = null;
            if (lists.size() != 0) {
                average = 0d;
            } else {
                average = (double) (sum / lists.size());
            }
            lists.add(average);


        }
        return lists;
    }
}
