package 链表;

import java.util.List;

public class RemoveLinkedListElements implements LinkedListAction {
    ListNode head = null;

    @Override
    public void updateNode(int oldValue, int newValue) {

    }

    @Override
    public void deletedNode(int data) {

    }

    @Override
    public void append(int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(data);
    }

    @Override
    public int find(int data) {
        return 0;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
       while (current.next!=null){
           if(current.next.val==val){
               current.next=current.next.next;
           }else {
               current = current.next;
           }
       }
       if(head.val==val){
           head= head.next;
       }

        return head;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        removeLinkedListElements.append(7);
        removeLinkedListElements.append(7);
        removeLinkedListElements.append(7);
        removeLinkedListElements.append(7);
        removeLinkedListElements.removeElements(removeLinkedListElements.head, 7);
    }
}
