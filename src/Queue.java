import java.util.NoSuchElementException;

/**
 * Use a Linked List to implement this Queue for values of general type T.
 *
 * @param <T>
 */
public class Queue<T> {

    private Node first;
    private Node last;

    private int size;

    private class Node {
        private T item;
        private Node next;
    }

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T dequeue() {

        if (isEmpty()) throw new NoSuchElementException(Constants.emptyQueueError);

        Node node = first;
        first = node.next;
        size--;
        return node.item;
    }

    public void enqueue(T item) {

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        size++;
    }
}
