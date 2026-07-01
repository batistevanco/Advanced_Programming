package be.vives.ti.single;

import be.vives.ti.domain.Song;

public class SongNode {

    private final Song element;
    private SongNode next;

    public SongNode(Song song){
        this.element = song;
        this.next = null;
    }

    public Song getElement() {
        return element;
    }

    public SongNode getNext() {
        return next;
    }

    public void setNext(SongNode next) {
        this.next = next;
    }

    public String toString(){
        return element.toString();
    }
}
