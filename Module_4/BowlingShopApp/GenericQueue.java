package Module_4.BowlingShopApp;

import java.util.LinkedList;

/**
 * GenericQueue is a simple generic queue implementation
 * that uses Java's LinkedList internally.
 *
 * @param <T> the type of elements stored in the queue
 * Assignment 4.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class GenericQueue<T> {
    /** Internal LinkedList to store elements */
    private LinkedList<T> list = new LinkedList<>();

    /**
     * Adds an item to the front of the queue.
     * @param item the item to enqueue
     */
    public void enqueue(T item) {
        list.addFirst(item);
    }

    /**
     * Removes and returns the first item in the queue.
     * @return the dequeued item
     */
    public T dequeue() {
        return list.removeFirst();
    }

    /**
     * Returns the number of items in the queue.
     * @return size of the queue
     */
    public int size() {
        return list.size();
    }
}

