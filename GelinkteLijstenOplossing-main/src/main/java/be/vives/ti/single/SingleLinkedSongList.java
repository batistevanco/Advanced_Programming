package be.vives.ti.single;

import be.vives.ti.domain.Song;

public class SingleLinkedSongList {

    private SongNode head;
    private int size;

    public SingleLinkedSongList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public SongNode getFirst() {
        return head;
    }

    public void addFirst(Song song) {
        SongNode songNode = new SongNode(song);
        songNode.setNext(head);
        head = songNode;
        size++;
    }

    //getLast

    public void addLast(Song song) {
        SongNode songNode = new SongNode(song);

        if (isEmpty()) {
            head = songNode;
        } else {
            SongNode tail = head;
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }

            tail.setNext(songNode);
        }
        size++;
    }

    public SongNode removeFirst() {
        if (isEmpty()) {
            return null;
        }

        SongNode removedNode = head;
        head = head.getNext();
        removedNode.setNext(null);
        size--;
        return removedNode;
    }

    public SongNode removeLast() {
        if (isEmpty()) {
            return null;
        }

        SongNode tail = head;
        SongNode secondLast = head;
        while (tail.getNext() != null) {
            secondLast = tail;
            tail = tail.getNext();
        }

        if (tail == secondLast) {
            head = null;
        }

        secondLast.setNext(null);
        size--;

        return tail;
    }

    public String toString() {
        if (isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        SongNode current = head;
        while (current != null) {
            sb.append(current);
            sb.append("->");
            current = current.getNext();
        }
        sb.append("null");

        return sb.toString();
    }

}
