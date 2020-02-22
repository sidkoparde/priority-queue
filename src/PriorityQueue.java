import java.util.*;

/**
 * Use a TreeMap to implement a Priority Queue for values of general type T.
 *
 * @param <T>
 */
public class PriorityQueue<T> {

    private TreeMap<Integer, Queue<T>> priorityQueue;

    private int size;

    // Keep track of number of dequeues for dequeued priorities
    private HashMap<Integer, Integer> dequeuCounter;

    // Save priority that has reached burst rate after removing it from dequeCounter
    private int priorityConstraintB;

    private Set<Integer> prioritiesInQueue;

    public PriorityQueue() {
        priorityQueue = new TreeMap<>();
        size = 0;
        priorityConstraintB = 0;
        dequeuCounter = new HashMap<>();
        prioritiesInQueue = new HashSet<>();
    }

    public void enqueue(int priority, T value) {

        if (prioritiesInQueue.contains(priority)) {
            priorityQueue.get(priority).enqueue(value);
        } else {
            Queue<T> queue = new Queue<>();
            queue.enqueue(value);
            priorityQueue.put(priority, queue);
            prioritiesInQueue.add(priority);
        }
        size++;
    }

    private int getCurrentPriority() {
        int priority = priorityQueue.firstKey();;

        if (priorityConstraintB != 0) {
            // Find next lowest priority
            // higherKey can return null
            Integer nextPriority = priorityQueue.higherKey(priorityConstraintB);
            if (nextPriority != null) {
                priority = nextPriority;
            }
            priorityConstraintB = 0;
        } else {
            priority = priorityQueue.firstKey();
        }

        return priority;
    }

    private void trackBurstRate(int priority) {
        int dequeueCount = 0;

        if (dequeuCounter.containsKey(priority)) {
            dequeueCount = dequeuCounter.get(priority);
        }

        dequeueCount++;

        if (dequeueCount == Constants.BURST_RATE) {
            dequeuCounter.remove(priority);
            priorityConstraintB = priority;
        } else {
            dequeuCounter.put(priority, dequeueCount);
        }
    }

    private void removePriorityFromPQ(int priority) {
        priorityQueue.remove(priority);
        prioritiesInQueue.remove(priority);
    }

    public T dequeue() {

        if (isEmpty()) throw new NoSuchElementException(Constants.emptyPriorityQueueError);

        Queue<T> queue;

        int priority = getCurrentPriority();

        queue = priorityQueue.get(priority);
        T item = queue.dequeue();

        trackBurstRate(priority);

        if (queue.isEmpty()) {
           removePriorityFromPQ(priority);
        }

        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    public int numClasses() {
        return priorityQueue.size();
    }
}
