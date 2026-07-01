package be.vives.ti.priorityqueue;

import be.vives.ti.adt.PriorityQueue;

public class ArrayPriorityQueue implements PriorityQueue<Patient> {

    private final Patient[] priorityQueue;
    private int size;

    public ArrayPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalStateException("Ongeldige capaciteit");
        }
        priorityQueue = new Patient[capacity];
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
    public void insert(Patient patient) {
        if (isPriorityQueueFull()) {
            throw new IllegalStateException("PriorityQueue is vol");
        }

        int i = size - 1; // achteraan beginnen
        while (i >= 0 && priorityQueue[i].urgentiecode() <= patient.urgentiecode()) {
            priorityQueue[i + 1] = priorityQueue[i];
            i--;
        }
        priorityQueue[i + 1] = patient;
        size++;
    }

    @Override
    public Patient remove() {
        if (isEmpty()) {
            return null;
        }

        int indexLastElement = size - 1;
        Patient removedItem = priorityQueue[indexLastElement];
        priorityQueue[indexLastElement] = null;
        size--;
        return removedItem;
    }

    @Override
    public Patient peek() {
        if (isEmpty()) {
            return null;
        }
        return priorityQueue[size - 1];
    }

    private boolean isPriorityQueueFull() {
        return size == priorityQueue.length;
    }
}
