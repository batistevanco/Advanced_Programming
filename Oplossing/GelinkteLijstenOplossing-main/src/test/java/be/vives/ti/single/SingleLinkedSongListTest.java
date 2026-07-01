package be.vives.ti.single;

import be.vives.ti.domain.Song;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SingleLinkedSongListTest {

    @Test
    void printEmptyList() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        assertThat(list.toString()).isEqualTo("");
        assertThat(list.getFirst()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void addFirstInEmptyList() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        list.addFirst(new Song("Blinding Lights", "The Weeknd"));
        assertThat(list.toString()).isEqualTo("Blinding Lights (The Weeknd)->null");
        assertThat(list.getFirst().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void addFirstMultipleTimes() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        list.addFirst(new Song("Blinding Lights", "The Weeknd"));
        list.addFirst(new Song("Shape of You", "Ed Sheeran"));
        list.addFirst(new Song("Someone You Loved", "Lewis Capaldi"));
        assertThat(list.toString()).isEqualTo("Someone You Loved (Lewis Capaldi)->Shape of You (Ed Sheeran)->Blinding Lights (The Weeknd)->null");
        assertThat(list.getFirst().toString()).isEqualTo("Someone You Loved (Lewis Capaldi)");
        assertThat(list.getSize()).isEqualTo(3);
    }

    @Test
    void addLastInEmptyList() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        list.addLast(new Song("Blinding Lights", "The Weeknd"));
        assertThat(list.toString()).isEqualTo("Blinding Lights (The Weeknd)->null");
        assertThat(list.getFirst().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void addLastMultipleTimes() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        list.addLast(new Song("Blinding Lights", "The Weeknd"));
        list.addLast(new Song("Shape of You", "Ed Sheeran"));
        list.addLast(new Song("Someone You Loved", "Lewis Capaldi"));
        assertThat(list.toString()).isEqualTo("Blinding Lights (The Weeknd)->Shape of You (Ed Sheeran)->Someone You Loved (Lewis Capaldi)->null");
        assertThat(list.getFirst().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getSize()).isEqualTo(3);
    }

    @Test
    void isEmpty() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getFirst()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void isNotEmpty() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        list.addLast(new Song("Blinding Lights", "The Weeknd"));
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getFirst().toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void removeFirstEmptyList() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getSize()).isEqualTo(0);
        assertThat(list.removeFirst()).isNull();
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getSize()).isEqualTo(0);
        assertThat(list.getFirst()).isNull();
    }

    @Test
    void removeFirstOneItem() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        list.addLast(new Song("Blinding Lights", "The Weeknd"));
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(1);

        SongNode removedTheWeeknd = list.removeFirst();
        assertThat(removedTheWeeknd.toString()).isEqualTo("Blinding Lights (The Weeknd)");
        assertThat(removedTheWeeknd.getNext()).isNull();

        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getFirst()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void removeFirstMultipleTimes() {
        SingleLinkedSongList list = new SingleLinkedSongList();
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
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void removeLastEmptyList() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        assertThat(list.removeLast()).isNull();
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getFirst()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void removeLastOneItem() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        list.addLast(new Song("Blinding Lights", "The Weeknd"));

        SongNode removedSongNode = list.removeLast();
        assertThat(removedSongNode.toString()).isEqualTo("Blinding Lights (The Weeknd)");

        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getFirst()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void removeLastMultipleTimes() {
        SingleLinkedSongList list = new SingleLinkedSongList();
        list.addFirst(new Song("Blinding Lights", "The Weeknd"));
        list.addFirst(new Song("Shape of You", "Ed Sheeran"));
        list.addFirst(new Song("Someone You Loved", "Lewis Capaldi"));
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(3);
        assertThat(list.toString()).isEqualTo("Someone You Loved (Lewis Capaldi)->Shape of You (Ed Sheeran)->Blinding Lights (The Weeknd)->null");

        SongNode removedTheWeeknd = list.removeLast();
        assertThat(removedTheWeeknd.toString()).isEqualTo("Blinding Lights (The Weeknd)");

        SongNode removedEd = list.removeLast();
        assertThat(removedEd.toString()).isEqualTo("Shape of You (Ed Sheeran)");

        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(1);
        assertThat(list.toString()).isEqualTo("Someone You Loved (Lewis Capaldi)->null");
        assertThat(list.getFirst().toString()).isEqualTo("Someone You Loved (Lewis Capaldi)");
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getSize()).isEqualTo(1);
    }
}