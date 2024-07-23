package 二叉树;

public class BinaryTree {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void first(TreeNode node) {
        if (node != null) {
            System.out.println(node.data);
            first(node.left);
            first(node.right);
        }
    }
    public void mid(TreeNode node) {
     if(node!=null){
         mid(node.left);
         System.out.println(node.data);
         mid(node.right);
     }
    }

    public void last(TreeNode node) {
    if(node!=null){
        last(node.left);
        mid(node.right);
        System.out.println(node.data);
    }
    }
}
