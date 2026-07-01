package be.vives.ti.queue;

import be.vives.ti.adt.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FeedbackArrayQueueTest {

    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new ArrayQueue(5);
    }

    @Test
    void makeQueueWithInvalidCapacity() {
        assertThatThrownBy(() -> new ArrayQueue(0))
                .isInstanceOf(IllegalStateException.class);
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
    void enqueueOnFullQueue() {
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        queue.enqueue("four");
        queue.enqueue("five");

        assertThatThrownBy(() -> queue.enqueue("six"))
                .isInstanceOf(IllegalStateException.class);

        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.first()).isEqualTo("one");
        assertThat(queue.size()).isEqualTo(5);
    }

    @Test
    void dequeueOnEmptyQueue() {
        assertThat(queue.size()).isEqualTo(0);
        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue.first()).isNull();

        assertThat(queue.dequeue()).isNull();

        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue.first()).isNull();
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
    void enqueueTwoElementsThenDequeueOneAndCheckIfThereIsRoomForFourNewElements() {
        queue.enqueue("Hey");
        queue.enqueue("Hallo");
        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.size()).isEqualTo(2);

        assertThat(queue.dequeue()).isEqualTo("Hey");
        assertThat(queue.first()).isEqualTo("Hallo");
        assertThat(queue.size()).isEqualTo(1);

        queue.enqueue("hoe");
        queue.enqueue("gaat");
        queue.enqueue("het");
        queue.enqueue("?");

        assertThat(queue.size()).isEqualTo(5);

        assertThat(queue.dequeue()).isEqualTo("Hallo");
        assertThat(queue.size()).isEqualTo(4);

        assertThat(queue.dequeue()).isEqualTo("hoe");
        assertThat(queue.size()).isEqualTo(3);

        assertThat(queue.dequeue()).isEqualTo("gaat");
        assertThat(queue.size()).isEqualTo(2);

        assertThat(queue.dequeue()).isEqualTo("het");
        assertThat(queue.size()).isEqualTo(1);

        assertThat(queue.dequeue()).isEqualTo("?");
        assertThat(queue.size()).isEqualTo(0);

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