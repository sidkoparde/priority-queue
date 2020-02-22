import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    public void initializeQueue() {
        queue = new Queue<>();
    }

    @Test
    public void testInitialization() {
        assertNotNull(queue);
    }

    @Test
    public void queueEmptyOnCreate() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void queueNotEmptyAfterEnqueue() {
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void queueShouldShowSize() {

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.size(), 2);
    }

    @Test
    public void queueShouldDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.size(), 2);
        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.size(), 1);
    }

}
