package csc223.ad;

public class TNode {
    
    protected TNode next;
    protected TNode previous;
    protected TreeNode data;

    public TNode(TNode previous, TreeNode data, TNode next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public TNode(TNode previous, TNode next) {
        this.next = next;
        this.data = null;
        this.previous = previous;
    }
}

