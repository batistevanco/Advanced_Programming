package be.vives.ti.single;

import be.vives.ti.domain.Song;

public class SingleLinkedSongListWithTail {

    private SongNode head;
    private SongNode tail;
    private int size;

    public SingleLinkedSongListWithTail() {
        head = null;
        tail = null;
        size = 0;
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
        if (isEmpty()) {
            tail = songNode;
        }

        songNode.setNext(head);
        head = songNode;
        size++;
    }

    public SongNode getLast() {
        // O(n) -> O(1)
        return tail;
    }

    public void addLast(Song song) {
        // O(n) -> O(1)
        SongNode songNode = new SongNode(song);

        if (isEmpty()) {
            head = songNode;
        } else {
            tail.setNext(songNode);
        }
        tail = songNode;
        size++;
    }

    public SongNode removeFirst() {
        if (isEmpty()) {
            return null;
        }

        SongNode removedSongNode = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        removedSongNode.setNext(null);
        size--;
        return removedSongNode;
    }

    public SongNode removeLast() {
        if (isEmpty()) {
            return null;
        }

        SongNode removedNode = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            SongNode secondLast = head;
            while (secondLast.getNext() != tail) {
                secondLast = secondLast.getNext();
            }

            secondLast.setNext(null);
            tail = secondLast;
        }
        removedNode.setNext(null);
        size--;
        return removedNode;
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
