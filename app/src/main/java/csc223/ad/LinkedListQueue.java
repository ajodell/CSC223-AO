package csc223.ad;

public class LinkedListQueue {

    protected TNodeLinkedList queue;
    protected int size;
    
    public LinkedListQueue() {
        this.queue = new TNodeLinkedList();
        this.size = 0;
    }

    public void enqueue(TreeNode item) {
        this.queue.insert(item);
        this.size += 1;
    }

    public TreeNode dequeue() {
        if (this.size == 0) {
            return null;
        }
        TreeNode data = this.queue.getFirst();
        this.queue.remove(data);
        this.size -= 1;
        return data;
    }

    public TreeNode peek() {
        return this.queue.getFirst();
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int size() {
        return this.size;
    }

}
