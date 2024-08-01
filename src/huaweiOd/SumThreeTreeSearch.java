package huaweiOd;

import java.util.Scanner;
//计算三叉树搜素树高度 good
public class SumThreeTreeSearch {

    TreeNode head;
     int height;
    static class TreeNode {
        TreeNode left;
        TreeNode right;

        int value;

        TreeNode mid;

        int height;

        public TreeNode(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    public void sumThreeTreeSeach(int value) {
        TreeNode treeNode = new TreeNode(value);
        if (this.head == null) {
            this.head = treeNode;
            this.height = 1;
        } else {
            TreeNode tn = this.head;
            while (true) {
                treeNode.height =tn.height+1;
                this.height= Math.max(treeNode.height,this.height);
                if (tn.value - 500 > value) {
                    if (tn.left == null) {
                        tn.left = treeNode;
                        break;
                    } else {
                        tn = tn.left;
                    }
                } else if (tn.value + 500 < value) {
                    if (tn.right == null) {
                        tn.right = treeNode;

                        break;
                    } else {
                        tn = tn.right;
                    }
                } else {
                    if (tn.mid == null) {
                        tn.mid = treeNode;
                        break;
                    } else {
                        tn = tn.mid;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        SumThreeTreeSearch sumThreeTreeSearch = new SumThreeTreeSearch();
        for (int i = 0; i < num; i++) {
            sumThreeTreeSearch.sumThreeTreeSeach(scanner.nextInt());
        }
        System.out.println(sumThreeTreeSearch.height);
    }
}
