package 链表;

public class MyLinkedList implements LinkedList {
    Node head;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }
        int i = 0;
        Node current = head;
        while (i < index) {
            if (current == null) {
                break;
            }
            current = current.next;
            i++;
        }
        if (i == 0) {
            return head.data;
        }
        if (current == null) {
            return -1;
        }

        return current.data;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(val);

    }

    public void addAtIndex(int index, int val) {
        if (head == null && index == 0) {
            head = new Node(val);
            return;
        }
        if (head == null && index != 0) {
            return;
        }
        int i = 0;
        Node current = head;
        Node current1 = current;
        while (i < index) {
            current1 = current;
            if (current == null) {
                break;
            }
            current = current.next;
            i++;
        }

        if (i != 0 && current1 != null) {
            current1.next = new Node(val);

            current1.next.next = current;
            return;
        }
        if (i == 0) {
            Node newhead = new Node(val);
            newhead.next = head;
            head = newhead;
        }
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        int i = 0;
        Node current = head;
        Node current1 = current;
        while (i < index) {
            current1 = current;
            if (current == null) {
                break;
            }
            current = current.next;
            i++;
        }
        if (i != 0 && current1 != null && current1.next != null) {
            current1.next = current1.next.next;

        } else if (i == 0) {
            head = head.next;
        }
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtIndex(1, 0);


        myLinkedList.get(0);


    }

}
