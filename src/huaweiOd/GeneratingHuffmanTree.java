package huaweiOd;

import java.util.*;
//生成哈夫曼树 good
public class GeneratingHuffmanTree {
    static int sum = 0;

    static class TreeNode {
        TreeNode mid;
        int weight;
        int height;

        TreeNode left;
        TreeNode right;

        public TreeNode(int weight, int height, TreeNode left, TreeNode right, TreeNode mid) {
            this.weight = weight;
            this.height = height;
            this.left = left;
            this.right = right;
            this.mid = mid;
        }
    }

    public void generatingHuffmanTree(List<TreeNode> lists) {
        Comparator<TreeNode> comparator = new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                int weight1 = o1.weight;
                int weight2 = o2.weight;

                int height1 = o1.height;
                int height2 = o2.height;

                if (weight1 != weight2) {
                    return weight1 - weight2;
                } else {
                    return height1 - height2;
                }
            }
        };
        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<>(comparator);

        for (int i = 0; i < lists.size(); i++) {
            priorityQueue.add(lists.get(i));
        }

        while (priorityQueue.size() > 1) {
            TreeNode left = priorityQueue.poll();
            TreeNode right = priorityQueue.poll();
            int maxLength = Math.max(left.height, right.height) + 1;
            int weight = left.weight + right.weight;
            TreeNode mid = new TreeNode(weight, maxLength, left, right, null);
            left.mid = mid;
            right.mid = mid;
            priorityQueue.add(mid);
        }

        TreeNode head = priorityQueue.poll();

        midIntertor(head);
    }

    public void midIntertor(TreeNode head) {
        if (head != null) {
            midIntertor(head.left);
           if(head.mid!=null){
               System.out.print(head.weight+" ");
           }else {
               System.out.print(head.weight+" ");
           }
            midIntertor(head.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<TreeNode> lists = new ArrayList<>();
        for (int i = 0; i < num; i++) {
         TreeNode treeNode = new TreeNode(scanner.nextInt(),0,null,null,null);
         lists.add(treeNode);
        }
        GeneratingHuffmanTree g  = new GeneratingHuffmanTree();
        g.generatingHuffmanTree(lists);
    }
}
