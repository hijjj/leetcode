package 二叉树;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Connect2 {
    static class Node {
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
        if (current == null) {
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node tmp = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                Node left = node.left;
                Node right = node.right;
                if (tmp != null) {
                    tmp.next = left;
                }
                tmp = right;
                if (left != null) {
                    left.next = right;
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);

                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Connect2 connect2 = new Connect2();
        Node root = new Node(1);
        Node node = new Node(2);
        root.right = node;
        connect2.connect(root);
    }
}
