package 二叉树;

import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Node;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {
    int deep = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode current = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            deep++;
        }
        return deep;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode.left =treeNode2;
        treeNode.right=treeNode3;
        treeNode3.left=treeNode4;
        treeNode3.right=treeNode5;
        MaxDepth maxDepth = new MaxDepth();
        maxDepth.maxDepth(treeNode);
    }

}
