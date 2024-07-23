package 链表;

public interface LinkedList {

    public int get(int index);

    public void addAtHead(int val);

    public void addAtTail(int val);

    public void addAtIndex(int index, int val);

    public void deleteAtIndex(int index);
}
