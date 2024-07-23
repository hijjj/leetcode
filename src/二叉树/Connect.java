package 二叉树;

import java.util.*;

public class Connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Node current = root;
        if (root == null) {
            return current;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Node> nodes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                nodes.add(node);
                Node left = node.left;
                if (left != null) {
                    queue.add(left);
                }
                Node right = node.right;
                if (right != null) {
                    queue.add(right);
                }
            }
            for (int i = 0; i < nodes.size() - 1; i++) {
                nodes.get(i).next = nodes.get(i + 1);
            }
        }
        return root;

    }
}
