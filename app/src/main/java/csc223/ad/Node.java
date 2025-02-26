package csc223.ad;

public class Node {
    protected Node next;
    protected Node previous;
    protected char data;

    public Node(Node previous, char data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public Node(Node previous, Node next) {
        this.next = next;
        this.data = ' ';
        this.previous = previous;
    }
}

