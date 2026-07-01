package be.vives.ti.queue;

import be.vives.ti.adt.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;




class FeedbackLinkedListQueueTest {

    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new LinkedListQueue();
    }
    @Test
    void enqueueOnEmptyQueue() {
        assertThat(queue.size()).isEqualTo(0);
        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue.first()).isNull();

        queue.enqueue("one");

        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.size()).isEqualTo(1);
        assertThat(queue.first()).isEqualTo("one");

    }

    @Test
    void enqueueOnNotEmptyQueue() {
        queue.enqueue("one");
        assertThat(queue.size()).isEqualTo(1);
        assertThat(queue.first()).isEqualTo("one");

        queue.enqueue("two");

        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.size()).isEqualTo(2);
        assertThat(queue.first()).isEqualTo("one");
    }

    @Test
    void dequeueOnEmptyQueue() {
        assertThat(queue.size()).isEqualTo(0);
        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue.first()).isNull();

        assertThat(queue.dequeue()).isNull();

        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    void dequeueOnQueue() {
        queue.enqueue("one");
        queue.enqueue("two");
        assertThat(queue.size()).isEqualTo(2);
        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.first()).isEqualTo("one");

        assertThat(queue.dequeue()).isEqualTo("one");

        assertThat(queue.first()).isEqualTo("two");
        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.size()).isEqualTo(1);
    }

    @Test
    void enqueueTwoElementsThenKeepDequeueAndEnqueueUntil50ElementsWereAddedInQueueOfLength5() {
        int i = 1;

        queue.enqueue(String.valueOf(i++));
        queue.enqueue(String.valueOf(i++));
        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.size()).isEqualTo(2);
        assertThat(queue.first()).isEqualTo("1");

        while(i <= 50){
            queue.enqueue(String.valueOf(i++));
            assertThat(queue.size()).isEqualTo(3);
            queue.dequeue();
            assertThat(queue.size()).isEqualTo(2);
        }

        assertThat(queue.dequeue()).isEqualTo("49");
        assertThat(queue.size()).isEqualTo(1);
        assertThat(queue.first()).isEqualTo("50");

        assertThat(queue.dequeue()).isEqualTo("50");
        assertThat(queue.size()).isEqualTo(0);
        assertThat(queue.first()).isNull();
    }

}