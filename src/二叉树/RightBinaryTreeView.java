package 二叉树;

import java.util.*;

public class RightBinaryTreeView {
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

        public List<Integer> rightSideView(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> newLists = new ArrayList<>();

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
            for(List<Integer> list:lists){
                List<Integer> list1 =list;
                newLists.add(list1.get(list1.size()-1));
            }

            return newLists;
    }
}
