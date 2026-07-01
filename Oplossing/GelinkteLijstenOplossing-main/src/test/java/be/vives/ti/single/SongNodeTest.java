package be.vives.ti.single;

import be.vives.ti.domain.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SongNodeTest {

    private SongNode songNode;

    @BeforeEach
    void setUp() {
        songNode = new SongNode(new Song("Shape of You", "Ed Sheeran"));
    }

    @Test
    void songNodeToString() {
        assertThat(songNode.toString()).isEqualTo("Shape of You (Ed Sheeran)");
    }

    @Test
    void getElementFromNode() {
        Song song = songNode.getElement();
        assertThat(song.getArtist()).isEqualTo("Ed Sheeran");
        assertThat(song.getTitle()).isEqualTo("Shape of You");
    }
}