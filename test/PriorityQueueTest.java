import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {
    private PriorityQueue<Integer> priorityQueue;

    @BeforeEach
    public void initializeClassPriorityQueue() {
        priorityQueue = new PriorityQueue<>();
    }

    @Test
    public void testInstantiation() {
        assertNotNull(priorityQueue);
    }

    @Test
    public void pqEmptyOnCreate() {
        assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void pqNotEmptyAfterEnqueue() {
        priorityQueue.enqueue(1, 1);

        assertFalse(priorityQueue.isEmpty());
    }

    @Test
    public void pqShouldShowSize() {
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(2, 2);

        assertEquals(priorityQueue.size(), 2);
    }

    @Test
    public void pqShouldNotStoreDuplicatePriorities() {
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(1, 2);

        assertEquals(priorityQueue.numClasses(), 1);
        assertEquals(priorityQueue.size(), 2);
    }

    @Test
    public void pqDequeueShouldReturnHighestPriority() {
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(2, 2);

        assertEquals(priorityQueue.dequeue(), 1);
    }

    @Test
    public void pqDequeueShouldRemoveClassIfItsQueueIsEmpty() {
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(2, 2);

        assertEquals(priorityQueue.numClasses(), 2);

        priorityQueue.dequeue();

        assertEquals(priorityQueue.numClasses(), 1);
    }

    @Test
    public void pqShouldDequeueLowerPriorityAfterReachingBurstRate() {
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(2, 2);

        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 2);
    }

    @Test
    public void pqSamePriorityDequeueShouldBeFIFO() {
        priorityQueue.enqueue(1, 00);
        priorityQueue.enqueue(1, 11 );
        priorityQueue.enqueue(1, 22 );
        priorityQueue.enqueue(1, 33 );

        assertEquals(priorityQueue.dequeue(), 00);
        assertEquals(priorityQueue.dequeue(), 11);
        assertEquals(priorityQueue.dequeue(), 22);
        assertEquals(priorityQueue.dequeue(), 33);
    }

    // Examples from the Problem Description

    @Test
    public void example1() {
        priorityQueue.enqueue(4, 4);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(3, 3);
        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(2, 2);

        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 1);

        priorityQueue.enqueue(1, 1);

        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 3);

    }

    @Test
    public void example2() {
        priorityQueue.enqueue(4, 4);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(3, 3);
        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(2, 2);

        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 2);

        priorityQueue.enqueue(1, 1);

        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 3);
        assertEquals(priorityQueue.dequeue(), 4);
    }

    @Test
    public void example3() {
        // Enqueue
        priorityQueue.enqueue(4, 4);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(3, 3);
        priorityQueue.enqueue(2, 2);

        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(4, 4);
        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(3, 3);

        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(4, 4);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(3, 3);

        priorityQueue.enqueue(3, 3);
        priorityQueue.enqueue(5, 5);
        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(1, 1);

        priorityQueue.enqueue(3, 3);
        priorityQueue.enqueue(6, 6);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(2, 2);

        priorityQueue.enqueue(4, 4);
        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(4, 4);
        priorityQueue.enqueue(1, 1);

        priorityQueue.enqueue(3, 3);
        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(5, 5);

        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(2, 2);

        priorityQueue.enqueue(3, 3);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(1, 1);

        // Dequeue
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 3);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 3);
        assertEquals(priorityQueue.dequeue(), 4);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 1);
        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 3);
        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 3);
        assertEquals(priorityQueue.dequeue(), 4);
        assertEquals(priorityQueue.dequeue(), 5);
        assertEquals(priorityQueue.dequeue(), 2);
        assertEquals(priorityQueue.dequeue(), 3);
        assertEquals(priorityQueue.dequeue(), 3);
        assertEquals(priorityQueue.dequeue(), 4);
        assertEquals(priorityQueue.dequeue(), 3);
        assertEquals(priorityQueue.dequeue(), 4);
        assertEquals(priorityQueue.dequeue(), 5);
        assertEquals(priorityQueue.dequeue(), 6);
        assertEquals(priorityQueue.dequeue(), 4);
    }

    @Test
    public void pqShouldFetchLowPriority() {
        /**
         * This is to solve the scenario I came up with for Problem A.
         */

        // I choose 50 but this number can be higher to represent longer periods of time.
        int numIterations = 50;

        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(2, 2);

        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(3, 3);
        priorityQueue.enqueue(4, 4);
        priorityQueue.enqueue(9, 9);

        int num = 0;

        for(int i = 0; i < numIterations; i++) {
            priorityQueue.enqueue(1, 1);
            priorityQueue.enqueue(2, 2);
            num = priorityQueue.dequeue();

            if (num == 9) {
                break;
            }

        }

        assertEquals(num, 9);
    }
}
