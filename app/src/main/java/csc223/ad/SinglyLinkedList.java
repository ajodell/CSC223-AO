package csc223.ad;

public class SinglyLinkedList implements LinkedList{

    protected Node head;
    protected int size;

    public SinglyLinkedList() {
        this.head = new Node(null, null);
        this.size = 0;
    }
    
    // Insert an item at the end of the list for unsorted lists
    public void insert(char item) {
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(null, item, null);
        current.next = newNode;
        this.size += 1;
    }

    // Removes an item from the list
    public void remove(char item) {
        Node current = this.head;
        while (current.next.data != item) {
            if (current.next == null) {
                return;
            }
            current = current.next;
        }
        current.next = current.next.next;
        this.size -= 1;
    }

    // Get the first item, return '☠' if the list is empty
    public char getFirst() {
        if (this.size == 0) {
            return '☠';
        }
        return this.head.next.data;
    }

    // Get the last item, return '☠' if the list is empty
    public char getLast() {
        if (this.size == 0) {
            return '☠';
        }
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
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
        this.head.next = null;
        this.size = 0;
    }

    // Check if the list contains an item
    public boolean contains(char item) {
        Node current = this.head.next;
        while (current != null) {
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
        while (current != null) {
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
        while (current != null) {
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
        char[] tempArray = new char[this.size];
        Node current = this.head.next;
        for (int i = 0; i < this.size; i++) {
            tempArray[i] = current.data;
            current = current.next;
        }
        current = this.head.next;
        for (int i = 5; i >= 0; i--) {
            current.data = tempArray[i];
            current = current.next;
        }
    }

    // Creates and returns a String representation of the list
    // e.g. `A -> B -> C -> D` should return "ABCD"
    public String toString() {
        String stringForm = "";
        Node current = this.head.next;
        while (current != null) {
            stringForm = stringForm + current.data;
            current = current.next;
        }
        return stringForm;
    }
}
