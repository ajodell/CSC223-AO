package csc223.ad;

public class DoublyLinkedList implements LinkedList {

    protected Node head;
    protected Node tail;
    protected int size;

    public DoublyLinkedList() {
        this.head = new Node(null, null);
        this.tail = new Node(this.head, null);
        this.head.next = this.tail;
        this.size = 0;
    }
    
    // Insert an item at the end of the list for unsorted lists
    public void insert(char item) {
        Node newNode = new Node(this.tail.previous, item, this.tail);
        this.tail.previous.next = newNode;
        this.tail.previous = newNode;
        this.size += 1;
    }

    // Removes an item from the list
    public void remove(char item) {
        Node current = this.head.next;
        while (current.data != item) {
            if (current == this.tail) {
                return;
            }
            current = current.next;
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
        this.size -= 1;
    }

    // Get the first item, return '☠' if the list is empty
    public char getFirst() {
        if (this.head.next == this.tail) {
            return '☠';
        }
        return this.head.next.data;
    }

    // Get the last item, return '☠' if the list is empty
    public char getLast() {
        if (this.size == 0) {
            return '☠';
        }
        return this.tail.previous.data;
    }

    // Get an item at a specific index, return '☠' if index is out of bounds
    public char get(int index) {
        if (index-1 > this.size) {
            return '☠';
        }
        Node current = this.head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Get the size of the list
    public int size() {
        return this.size;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return (this.size == 0);
    }

    // Clear the list
    public void clear() {
        this.head.next = this.tail;
        this.tail.previous = this.head;
        this.size = 0;
    }

    // Check if the list contains an item
    public boolean contains(char item) {
        Node current = this.head.next;
        while (current != this.tail) {
            if (current.data == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Get the index of an item, if it exists else return -1
    public int indexOf(char item) {
        int idx = 0;
        Node current = this.head.next;
        while (current != this.tail) {
            if (current.data == item) {
                return idx;
            }
            idx += 1;
            current = current.next;
        }
        return -1;
    }

    // Get the last index of an item, if it exists else return -1
    public int lastIndexOf(char item) {
        int idx = 0;
        int last_idx = -1;
        Node current = this.head.next;
        while (current != this.tail) {
            if (current.data == item) {
                last_idx = idx;
            }
            idx += 1;
            current = current.next;
        }
        return last_idx;
    }

    // Reverse the list
    public void reverse() {
        Node front = this.head.next;
        Node back = this.tail.previous;
        char temp = ' ';
        for (int i = 0; i < (this.size / 2); i++) {
            temp = back.data;
            back.data = front.data;
            front.data = temp;
            front = front.next;
            back = back.previous;
        }
    }

    // Creates and returns a String representation of the list
    // e.g. `A -> B -> C -> D` should return "ABCD"
    public String toString() {
        String stringForm = "";
        Node current = this.head.next;
        while (current != this.tail) {
            stringForm = stringForm + current.data;
            current = current.next;
        }
        return stringForm;
    }

}
