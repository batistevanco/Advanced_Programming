package be.vives.ti.priorityqueue;

import be.vives.ti.adt.PriorityQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FeedbackArrayPriorityQueueTest {

    private PriorityQueue<Patient> priorityQueue;
    private Patient jules_100 = new Patient("Jules", "Meerschaert", 100);
    private Patient freek_50 = new Patient("Freek", "Wispelaere", 50);
    private Patient mo_150 = new Patient("Mo", "Ad", 150);
    private Patient jan_200 = new Patient("Jan", "Peeters", 200);

    private Patient ella_100 = new Patient("Ella", "Vermeers", 100);
    private Patient jordy_200 = new Patient("Jordy", "Vermeulen", 200);

    @BeforeEach
    void setUp() {
        priorityQueue = new ArrayPriorityQueue(5);
    }

    @Test
    void makePriorityQueueWithInvalidCapacity() {
        assertThatThrownBy(() -> new ArrayPriorityQueue(0))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void insertIntoEmptyPriorityQueue() {
        assertThat(priorityQueue.isEmpty()).isTrue();

        priorityQueue.insert(jules_100);

        assertThat(priorityQueue.isEmpty()).isFalse();
        assertThat(priorityQueue.size()).isEqualTo(1);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);
    }

    @Test
    void insertItemWithHighestPrioToPriorityQueue() {
        priorityQueue.insert(jules_100);
        assertThat(priorityQueue.size()).isEqualTo(1);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);

        priorityQueue.insert(freek_50);

        assertThat(priorityQueue.size()).isEqualTo(2);
        assertThat(priorityQueue.peek()).isEqualTo(freek_50);
    }

    @Test
    void insertItemWithLowestPrioToPriorityQueue() {
        priorityQueue.insert(jules_100);
        assertThat(priorityQueue.size()).isEqualTo(1);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);

        priorityQueue.insert(mo_150);

        assertThat(priorityQueue.size()).isEqualTo(2);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);
    }

    @Test
    void insertItemWithSomeRandomPriorityToPriorityQueue() {
        priorityQueue.insert(jules_100);
        priorityQueue.insert(jan_200);
        assertThat(priorityQueue.size()).isEqualTo(2);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);

        priorityQueue.insert(mo_150);

        assertThat(priorityQueue.size()).isEqualTo(3);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);
    }

    @Test
    void insertItemWithSameLowestPriorityToPriorityQueue() {
        priorityQueue.insert(jules_100);
        priorityQueue.insert(jan_200);
        assertThat(priorityQueue.size()).isEqualTo(2);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);

        priorityQueue.insert(ella_100);

        assertThat(priorityQueue.size()).isEqualTo(3);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);
    }

    @Test
    void insertItemWithSameHighestPriorityToPriorityQueue() {
        priorityQueue.insert(jules_100);
        priorityQueue.insert(jan_200);
        assertThat(priorityQueue.size()).isEqualTo(2);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);

        priorityQueue.insert(jordy_200);

        assertThat(priorityQueue.size()).isEqualTo(3);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);
    }

    @Test
    void insertIntoFullPriorityQueue() {
        priorityQueue.insert(jules_100);
        priorityQueue.insert(freek_50);
        priorityQueue.insert(mo_150);
        priorityQueue.insert(jan_200);
        priorityQueue.insert(ella_100);

        assertThatThrownBy(() -> priorityQueue.insert(jordy_200))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void removeFromEmptyPriorityQueue() {
        assertThat(priorityQueue.isEmpty()).isTrue();

        priorityQueue.remove();

        assertThat(priorityQueue.peek()).isNull();
        assertThat(priorityQueue.isEmpty()).isTrue();
        assertThat(priorityQueue.size()).isEqualTo(0);
    }

    @Test
    void removeFromPriorityQueue() {
        priorityQueue.insert(jules_100);
        priorityQueue.insert(jan_200);
        assertThat(priorityQueue.size()).isEqualTo(2);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);

        priorityQueue.remove();

        assertThat(priorityQueue.size()).isEqualTo(1);
        assertThat(priorityQueue.peek()).isEqualTo(jan_200);
    }

    @Test
    void removeFromPriorityQueueWithAllSamePrio() {
        priorityQueue.insert(jules_100);
        priorityQueue.insert(ella_100);
        assertThat(priorityQueue.size()).isEqualTo(2);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);

        priorityQueue.remove();

        assertThat(priorityQueue.size()).isEqualTo(1);
        assertThat(priorityQueue.peek()).isEqualTo(ella_100);
    }

    @Test
    void removeLastItemFromPriorityQueue() {
        priorityQueue.insert(jules_100);
        assertThat(priorityQueue.size()).isEqualTo(1);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);

        priorityQueue.remove();

        assertThat(priorityQueue.peek()).isNull();
        assertThat(priorityQueue.isEmpty()).isTrue();
        assertThat(priorityQueue.size()).isEqualTo(0);
    }

    @Test
    void completeTestPriorityQueue() {
        priorityQueue.insert(jules_100);
        priorityQueue.insert(freek_50);
        priorityQueue.insert(mo_150);
        priorityQueue.insert(jan_200);
        priorityQueue.insert(ella_100);

        assertThat(priorityQueue.size()).isEqualTo(5);
        assertThat(priorityQueue.peek()).isEqualTo(freek_50);
        assertThat(priorityQueue.remove()).isEqualTo(freek_50);

        assertThat(priorityQueue.size()).isEqualTo(4);
        assertThat(priorityQueue.peek()).isEqualTo(jules_100);
        assertThat(priorityQueue.remove()).isEqualTo(jules_100);

        assertThat(priorityQueue.size()).isEqualTo(3);
        assertThat(priorityQueue.peek()).isEqualTo(ella_100);
        assertThat(priorityQueue.remove()).isEqualTo(ella_100);

        assertThat(priorityQueue.size()).isEqualTo(2);
        assertThat(priorityQueue.peek()).isEqualTo(mo_150);
        assertThat(priorityQueue.remove()).isEqualTo(mo_150);

        assertThat(priorityQueue.size()).isEqualTo(1);
        assertThat(priorityQueue.peek()).isEqualTo(jan_200);
        assertThat(priorityQueue.remove()).isEqualTo(jan_200);

        assertThat(priorityQueue.peek()).isNull();
        assertThat(priorityQueue.isEmpty()).isTrue();
        assertThat(priorityQueue.size()).isEqualTo(0);
    }

}
