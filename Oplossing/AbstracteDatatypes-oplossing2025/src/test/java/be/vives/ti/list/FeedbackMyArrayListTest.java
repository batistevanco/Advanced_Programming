package be.vives.ti.list;

import be.vives.ti.adt.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FeedbackMyArrayListTest {
    private List<String> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList(5);
    }

    @Test
    void makeListWithInvalidCapacity() {
        assertThatThrownBy(() -> new MyArrayList(0))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void addToEmptyList() {
        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isTrue();

        list.add(0, "Joe");

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
    }

    @Test
    public void addInFrontInList() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        list.add(0, "Averell");

        assertThat(list.size()).isEqualTo(4);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Averell");
        assertThat(list.get(1)).isEqualTo("Joe");
        assertThat(list.get(2)).isEqualTo("Jack");
        assertThat(list.get(3)).isEqualTo("Jill");
    }

    @Test
    public void addToBackInList() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        list.add(3, "Averell");

        assertThat(list.size()).isEqualTo(4);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");
        assertThat(list.get(3)).isEqualTo("Averell");
    }

    @Test
    public void addRandomToList() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        list.add(1, "Averell");

        assertThat(list.size()).isEqualTo(4);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Averell");
        assertThat(list.get(2)).isEqualTo("Jack");
        assertThat(list.get(3)).isEqualTo("Jill");

    }

    @Test
    public void addToFullList() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        assertThatThrownBy(() -> list.add("six"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void addToFullListWithAddIndex0() {
        list.add(0,"one");
        list.add(0,"two");
        list.add(0,"three");
        list.add(0,"four");
        list.add(0,"five");

        assertThatThrownBy(() -> list.add(0,"six"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void addOnNegativePosition() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        assertThatThrownBy(() -> list.add(-1, "Averell"))
                .isInstanceOf(IndexOutOfBoundsException.class);

    }

    @Test
    public void addToListWithGap() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        assertThatThrownBy(() -> list.add(4, "Averell"))
                .isInstanceOf(IndexOutOfBoundsException.class);

    }

    @Test
    public void setOnNegativePosition() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        assertThatThrownBy(() -> list.set(-1, "Averell"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void setOnNotExistingPosition() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        assertThatThrownBy(() -> list.set(3, "Averell"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void getOnNegativePosition() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        assertThatThrownBy(() -> list.get(-1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void getOnNotExistingPosition() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        assertThatThrownBy(() -> list.get(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void setInEmptyList() {
        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isTrue();

        assertThatThrownBy(() -> list.set(0, "Averell"))
                .isInstanceOf(IndexOutOfBoundsException.class);

    }

    @Test
    public void setInListWithOneItem() {
        list.add(0, "Joe");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");

        list.set(0, "Averell");

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Averell");
    }

    @Test
    public void setFirstItemInList() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        list.set(0, "Averell");

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Averell");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

    }

    @Test
    public void setLastItemInList() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        list.set(2, "Averell");

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Averell");
    }

    @Test
    public void setRandomItemInList() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        list.set(1, "Averell");

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Averell");
        assertThat(list.get(2)).isEqualTo("Jill");
    }

    @Test
    public void removeInEmptyList() {
        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isTrue();

        assertThatThrownBy( () -> list.remove(0))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void removeInListWithOneItem() {
        list.add(0, "Joe");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");

        list.remove(0);

        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isTrue();

    }

    @Test
    public void removeFirstItemInList() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        list.remove(0);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Jack");
        assertThat(list.get(1)).isEqualTo("Jill");
    }

    @Test
    public void removeLastItemInList() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        list.remove(2);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
    }

    @Test
    public void removeRandomItemInList() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        list.remove(1);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jill");
    }

    @Test
    public void removeOnNegativePosition() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        assertThatThrownBy(() -> list.remove(-1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void removeOnNonExistingPosition() {
        list.add(0, "Joe");
        list.add(1, "Jack");
        list.add(2, "Jill");
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.get(0)).isEqualTo("Joe");
        assertThat(list.get(1)).isEqualTo("Jack");
        assertThat(list.get(2)).isEqualTo("Jill");

        assertThatThrownBy( () -> list.remove(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

}