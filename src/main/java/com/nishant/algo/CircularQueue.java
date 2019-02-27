package com.nishant.algo;


public class CircularQueue {
    int[] arr;

    int front;
    int tail;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public CircularQueue(int k) {
        this.arr = new int[k];
        front = -1;
        tail = -1;
    }

    public static void main(String[] args) {
        CircularQueue obj = new CircularQueue(5);
        boolean param_1 = obj.enQueue(8);
        boolean param_11 = obj.enQueue(3);
        boolean param_12 = obj.enQueue(9);
        boolean param_13 = obj.enQueue(5);
        boolean param_14 = obj.enQueue(0);

        boolean param_4 = obj.deQueue();
        boolean param_45 = obj.deQueue();
        boolean ads = obj.isEmpty();
        boolean ads1 = obj.isEmpty();

        int param_2 = obj.Rear();
        int param_22 = obj.Rear();
        boolean param_451 = obj.deQueue();

    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (tail == -1) {
            tail = 0;
            front = 0;
            arr[0] = value;
            return true;
        } else {
            int newTail = (tail + 1) % arr.length;
            if (newTail == front)
                return false;
            tail = newTail;
            arr[tail] = value;
            return true;
        }
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (front == -1)
            return false;
        if (front == tail) {
            front = -1;
            tail = -1;
            return true;
        }
        front = (front + 1) % arr.length;
        return true;


    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (front == -1)
            return -1;
        else
            return arr[front];

    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (tail == -1)
            return -1;
        else
            return arr[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == -1;

    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % arr.length == front;
    }

}