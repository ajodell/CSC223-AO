package csc223.ad;

public class ArrayQueue implements Queue{

    int[] queue;
    int current;

    public ArrayQueue(int capacity) {
        this.queue = new int[capacity];
        this.current = 0;
    }

    // Adds an integer to the queue
    public void enqueue(int item) {
        if (this.current < this.queue.length) {
            this.queue[this.current] = item;
            this.current += 1;
        }
    }

    // Removes an integer from the queue, returning the max integer if there's nothing left
    public int dequeue() {
        if (this.current <= 0) {
            return Integer.MAX_VALUE;
        }
        else {
            current -= 1;
            return this.queue[current+1];
        }
    }

    // Returns the topmost item
    public int peek() {
        return this.queue[0];
    }

    // Returns whether the queue is empty
    public boolean isEmpty() {
        if (this.current == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // Returns the size of the queue
    public int size() {
        return current - 1;
    }

}
