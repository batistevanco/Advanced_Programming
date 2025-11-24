package be.vives.ti.single;

import be.vives.ti.domain.Song;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SingleLinkedSongListWithTailTest {


    @Test
    void printEmptyList() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        assertThat(list.toString()).isEqualTo("");
        assertThat(list.getFirst()).isNull();
        assertThat(list.getLast()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void addFirstInEmptyList() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        list.addFirst(new Song("Blinding Lights", "The Weeknd"));
        assertThat(list.toString()).isEqualTo("Blinding Lights (The Weeknd)->null");
        assertThat(list.getFirst().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getLast().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void addFirstMultipleTimes() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        list.addFirst(new Song("Blinding Lights", "The Weeknd"));
        list.addFirst(new Song("Shape of You", "Ed Sheeran"));
        list.addFirst(new Song("Someone You Loved", "Lewis Capaldi"));
        assertThat(list.toString()).isEqualTo("Someone You Loved (Lewis Capaldi)->Shape of You (Ed Sheeran)->Blinding Lights (The Weeknd)->null");
        assertThat(list.getFirst().toString()).isEqualTo("Someone You Loved (Lewis Capaldi)");
        assertThat(list.getLast().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getSize()).isEqualTo(3);
    }

    @Test
    void addLastInEmptyList() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        list.addLast(new Song("Blinding Lights", "The Weeknd"));
        assertThat(list.toString()).isEqualTo("Blinding Lights (The Weeknd)->null");
        assertThat(list.getFirst().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getLast().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void addLastMultipleTimes() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        list.addLast(new Song("Blinding Lights", "The Weeknd"));
        list.addLast(new Song("Shape of You", "Ed Sheeran"));
        list.addLast(new Song("Someone You Loved", "Lewis Capaldi"));
        assertThat(list.toString()).isEqualTo("Blinding Lights (The Weeknd)->Shape of You (Ed Sheeran)->Someone You Loved (Lewis Capaldi)->null");
        assertThat(list.getFirst().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getLast().toString()).isEqualTo("Someone You Loved (Lewis Capaldi)");
        assertThat(list.getSize()).isEqualTo(3);
    }


    @Test
    void isEmpty() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getFirst()).isNull();
        assertThat(list.getLast()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void isNotEmpty() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        list.addLast(new Song("Blinding Lights", "The Weeknd"));
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getFirst().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getLast().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void removeFirstEmptyList() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.removeFirst()).isNull();
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getFirst()).isNull();
        assertThat(list.getLast()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void removeFirstOneItem() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        list.addLast(new Song("Blinding Lights", "The Weeknd"));
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(1);

        SongNode removedTheWeeknd = list.removeFirst();
        assertThat(removedTheWeeknd.toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(removedTheWeeknd.getNext()).isNull();

        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getFirst()).isNull();
        assertThat(list.getLast()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void removeFirstMultipleTimes() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        list.addFirst(new Song("Blinding Lights", "The Weeknd"));
        list.addFirst(new Song("Shape of You", "Ed Sheeran"));
        list.addFirst(new Song("Someone You Loved", "Lewis Capaldi"));
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(3);

        assertThat(list.toString()).isEqualTo("Someone You Loved (Lewis Capaldi)->Shape of You (Ed Sheeran)->Blinding Lights (The Weeknd)->null");
        assertThat(list.getFirst().toString()).isEqualTo("Someone You Loved (Lewis Capaldi)");

        SongNode removedLewis = list.removeFirst();
        assertThat(removedLewis.toString()).isEqualTo("Someone You Loved (Lewis Capaldi)");
        assertThat(removedLewis.getNext()).isNull();

        SongNode removedEd = list.removeFirst();
        assertThat(removedEd.toString()).isEqualTo("Shape of You (Ed Sheeran)");
        assertThat(removedEd.getNext()).isNull();

        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(1);
        assertThat(list.toString()).isEqualTo("Blinding Lights (The Weeknd)->null");
        assertThat(list.getFirst().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getLast().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void removeLastEmptyList() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        assertThat(list.removeLast()).isNull();
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getFirst()).isNull();
        assertThat(list.getLast()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void removeLastOneItem() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        list.addLast(new Song("Blinding Lights", "The Weeknd"));

        SongNode removedSongNode = list.removeLast();
        assertThat(removedSongNode.toString()).isEqualTo("Blinding Lights (The Weeknd)");

        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getFirst()).isNull();
        assertThat(list.getLast()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void removeLastMultipleTimes() {
        SingleLinkedSongListWithTail list = new SingleLinkedSongListWithTail();
        list.addFirst(new Song("Blinding Lights", "The Weeknd"));
        list.addFirst(new Song("Shape of You", "Ed Sheeran"));
        list.addFirst(new Song("Someone You Loved", "Lewis Capaldi"));
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(3);

        assertThat(list.toString()).isEqualTo("Someone You Loved (Lewis Capaldi)->Shape of You (Ed Sheeran)->Blinding Lights (The Weeknd)->null");
        assertThat(list.getLast().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.removeLast().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getLast().toString()).isEqualTo("Shape of You (Ed Sheeran)");
        assertThat(list.removeLast().toString()).isEqualTo("Shape of You (Ed Sheeran)");
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(1);
        assertThat(list.toString()).isEqualTo("Someone You Loved (Lewis Capaldi)->null");
        assertThat(list.getLast().toString()).isEqualTo("Someone You Loved (Lewis Capaldi)");
        assertThat(list.getFirst().toString()).isEqualTo("Someone You Loved (Lewis Capaldi)");
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(1);
    }

}