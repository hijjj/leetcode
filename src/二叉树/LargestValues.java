package 二叉树;

import java.util.*;

public class LargestValues {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
          public List<Integer> largestValues(TreeNode root) {
              List<Integer> lists = new ArrayList<>();

              Queue<TreeNode> queue = new ArrayDeque<>();
              if (root != null) {
                  queue.add(root);
              }
              while (!queue.isEmpty()) {
                  int size = queue.size();
                  List<Integer> list2 = new ArrayList<>();
                  for (int i = 0; i < size; i++) {
                      TreeNode node = queue.poll();
                      list2.add(node.val);
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
                  lists.add(Collections.max(list2));
              }
              return lists;
          }
  }
}
