package be.vives.ti.queue;

import be.vives.ti.adt.Queue;
import be.vives.ti.linkedlist.DoubleLinkedList;
import be.vives.ti.linkedlist.Node;

public class LinkedListQueue implements Queue<String> {

    private final DoubleLinkedList<String> queue;

    public LinkedListQueue() {
        queue = new DoubleLinkedList<>();
    }

    @Override
    public int size() {
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(String s) {
        queue.addLast(new Node<>(s));
    }

    @Override
    public String first() {
        if (isEmpty()) {
            return null;
        }
        Node<String> first = queue.getFirst();
        return first.getElement();
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node<String> first = queue.removeFirst();
        return first.getElement();
    }

}
