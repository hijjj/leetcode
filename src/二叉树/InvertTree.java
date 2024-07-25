package 二叉树;

public class InvertTree {


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

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode = new TreeNode(2);
        treeNode1.right = treeNode;
        InvertTree invertTree = new InvertTree();
        invertTree.invertTree(treeNode1);
    }
}
