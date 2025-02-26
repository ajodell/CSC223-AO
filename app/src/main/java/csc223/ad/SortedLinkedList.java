package csc223.ad;

public class SortedLinkedList extends DoublyLinkedList{

    public SortedLinkedList() {
        this.head = new Node(null, null);
        this.tail = new Node(this.head, null);
        this.head.next = this.tail;
        this.size = 0;
    }

    // Insert an item in its ordered position
    public void insert(char item) {
        Node current = this.head;
        while ((current.next != this.tail) && (current.next.data < item)) {
            current = current.next;
        }
        Node newNode = new Node(current, item, current.next);
        current.next.previous = newNode;
        current.next = newNode;
        this.size += 1;
    }

    // Removes an item from the list
    public void remove(char item) {
        super.remove(item);
    }

    // Get the first item, return '☠' if the list is empty
    public char getFirst() {
        return super.getFirst();
    }

    // Get the last item, return '☠' if the list is empty
    public char getLast() {
        return super.getLast();
    }

    // Get an item at a specific index, return '☠' if index is out of bounds
    public char get(int index) {
        return super.get(index);
    }

    // Get the size of the list
    public int size() {
        // int size = 0;
        // Node current = this.head;
        // while (current.next != this.tail) {
        //     size += 1;
        //     current = current.next;
        // }
        // return size;
        return super.size();
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return super.isEmpty();
    }

    // Clear the list
    public void clear() {
        super.clear();
    }

    // Check if the list contains an item
    public boolean contains(char item) {
        return super.contains(item);
    }

    // Get the index of an item, if it exists else return -1
    public int indexOf(char item) {
        return super.indexOf(item);
    }

    // Get the last index of an item, if it exists else return -1
    public int lastIndexOf(char item) {
        return super.lastIndexOf(item);
    }

    // Reverse the list
    public void reverse() {
        super.reverse();
    }

    // Creates and returns a String representation of the list
    // e.g. `A -> B -> C -> D` should return "ABCD"
    public String toString() {
        return super.toString();
    }
}
