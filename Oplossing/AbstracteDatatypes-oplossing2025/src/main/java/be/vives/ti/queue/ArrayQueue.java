package be.vives.ti.queue;

import be.vives.ti.adt.Queue;

public class ArrayQueue implements Queue<String> {
    private final String[] queue;
    private int front;
    private int size;

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalStateException("Ongeldige capaciteit");
        }
        queue = new String[capacity];
        front = 0;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(String s) {
        if (isQueueFull()) {
            throw new IllegalStateException("Queue is vol");
        }
        int nieuweIndex = (front + size) % queue.length;
        queue[nieuweIndex] = s;
        size++;
    }

    @Override
    public String first() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }

        String element = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
        size--;

        return element;
    }

    private boolean isQueueFull() {
        return size == queue.length;
    }
}
