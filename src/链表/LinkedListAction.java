package 链表;

public interface LinkedListAction {
    void updateNode(int oldValue, int newValue);

    void deletedNode(int data);

    void append(int data);

    int find(int data);
}
