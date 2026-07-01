package be.vives.ti.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FeedbackSimpleHashMapTest {
    private Student janeJones;
    private Student johnDoe;
    private Student maryBack;
    private Student mikeWilson;
    private Student julieClark;
    private SimpleHashMap shm;

    @BeforeEach
    void setUp() {
        janeJones = new Student("r004123", "Jones", "2AI");
        johnDoe = new Student("r004456", "Doe", "2AI");
        maryBack = new Student("r004789", "Back", "2SD");
        mikeWilson = new Student("r004412", "Wilson", "2SD");
        julieClark = new Student("r001199", "Clark", "2SD");

        shm = new SimpleHashMap();
    }

    @Test
    void putIntoEmptyMap() {
        assertThat(shm.size()).isEqualTo(0);
        assertThat(shm.isEmpty()).isTrue();

        shm.put(janeJones, "Opdracht Jane");

        assertThat(shm.size()).isEqualTo(1);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(janeJones)).isEqualTo("Opdracht Jane");

    }

    @Test
    void putItemWithExistingKey() {
        shm.put(janeJones, "Opdracht Jane");
        shm.put(johnDoe, "Opdracht John");
        shm.put(maryBack, "Opdracht May");
        assertThat(shm.size()).isEqualTo(3);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(janeJones)).isEqualTo("Opdracht Jane");
        assertThat(shm.get(johnDoe)).isEqualTo("Opdracht John");
        assertThat(shm.get(maryBack)).isEqualTo("Opdracht May");

        shm.put(janeJones, "Extra opdracht Jane");

        assertThat(shm.size()).isEqualTo(3);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(janeJones)).isEqualTo("Extra opdracht Jane");
        assertThat(shm.get(johnDoe)).isEqualTo("Opdracht John");
        assertThat(shm.get(maryBack)).isEqualTo("Opdracht May");

    }

    @Test
    void putItemWithSameKey() {
        shm.put(janeJones, "Opdracht Jane");
        shm.put(johnDoe, "Opdracht John");
        shm.put(maryBack, "Opdracht May");
        assertThat(shm.size()).isEqualTo(3);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(janeJones)).isEqualTo("Opdracht Jane");
        assertThat(shm.get(johnDoe)).isEqualTo("Opdracht John");
        assertThat(shm.get(maryBack)).isEqualTo("Opdracht May");

        shm.put(julieClark, "Extra opdracht Julie");

        assertThat(shm.size()).isEqualTo(3);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(julieClark)).isEqualTo("Extra opdracht Julie");
        assertThat(shm.get(johnDoe)).isEqualTo("Opdracht John");
        assertThat(shm.get(maryBack)).isEqualTo("Opdracht May");

    }

    @Test
    void putNewItem() {
        shm.put(janeJones, "Opdracht Jane");
        shm.put(johnDoe, "Opdracht John");
        shm.put(maryBack, "Opdracht May");
        assertThat(shm.size()).isEqualTo(3);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(janeJones)).isEqualTo("Opdracht Jane");
        assertThat(shm.get(johnDoe)).isEqualTo("Opdracht John");
        assertThat(shm.get(maryBack)).isEqualTo("Opdracht May");

        shm.put(mikeWilson, "Opdracht Mike");

        assertThat(shm.size()).isEqualTo(4);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(janeJones)).isEqualTo("Opdracht Jane");
        assertThat(shm.get(johnDoe)).isEqualTo("Opdracht John");
        assertThat(shm.get(maryBack)).isEqualTo("Opdracht May");
        assertThat(shm.get(mikeWilson)).isEqualTo("Opdracht Mike");
    }

    @Test
    void removeFromEmptyMap() {
        assertThat(shm.size()).isEqualTo(0);
        assertThat(shm.isEmpty()).isTrue();

        assertThat(shm.remove(mikeWilson)).isNull();
    }

    @Test
    void removeLastItem() {
        shm.put(janeJones, "Opdracht Jane");
        assertThat(shm.size()).isEqualTo(1);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(janeJones)).isEqualTo("Opdracht Jane");

        assertThat(shm.remove(janeJones)).isEqualTo("Opdracht Jane");

        assertThat(shm.size()).isEqualTo(0);
        assertThat(shm.isEmpty()).isTrue();
        assertThat(shm.get(janeJones)).isNull();

    }

    @Test
    void removeNotExistingItem() {
        shm.put(janeJones, "Opdracht Jane");
        shm.put(johnDoe, "Opdracht John");
        shm.put(maryBack, "Opdracht May");
        assertThat(shm.size()).isEqualTo(3);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(janeJones)).isEqualTo("Opdracht Jane");
        assertThat(shm.get(johnDoe)).isEqualTo("Opdracht John");
        assertThat(shm.get(maryBack)).isEqualTo("Opdracht May");

        assertThat(shm.remove(mikeWilson)).isNull();

        assertThat(shm.size()).isEqualTo(3);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(janeJones)).isEqualTo("Opdracht Jane");
        assertThat(shm.get(johnDoe)).isEqualTo("Opdracht John");
        assertThat(shm.get(maryBack)).isEqualTo("Opdracht May");
    }

    @Test
    void removeRandomItem() {
        shm.put(janeJones, "Opdracht Jane");
        shm.put(johnDoe, "Opdracht John");
        shm.put(maryBack, "Opdracht May");
        assertThat(shm.size()).isEqualTo(3);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(janeJones)).isEqualTo("Opdracht Jane");
        assertThat(shm.get(johnDoe)).isEqualTo("Opdracht John");
        assertThat(shm.get(maryBack)).isEqualTo("Opdracht May");

        assertThat(shm.remove(johnDoe)).isEqualTo("Opdracht John");

        assertThat(shm.size()).isEqualTo(2);
        assertThat(shm.isEmpty()).isFalse();
        assertThat(shm.get(janeJones)).isEqualTo("Opdracht Jane");
        assertThat(shm.get(maryBack)).isEqualTo("Opdracht May");
    }

}