package be.vives.ti.priorityqueue;

import be.vives.ti.adt.PriorityQueue;
import be.vives.ti.linkedlist.DoubleLinkedList;
import be.vives.ti.linkedlist.Node;

public class LinkedListPriorityQueue implements PriorityQueue<Patient> {

    private final DoubleLinkedList<Patient> priorityQueue;


    public LinkedListPriorityQueue() {
        priorityQueue = new DoubleLinkedList<>();
    }

    @Override
    public int size() {
        return priorityQueue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public void insert(Patient patient) {
        Node<Patient> newNode = new Node<>(patient);
        Node<Patient> firstNode = priorityQueue.getFirst();

        if (isEmpty()) {
            priorityQueue.addFirst(newNode);
        } else if (patient.urgentiecode() < firstNode.getElement().urgentiecode()) {
            priorityQueue.addFirst(newNode);
        } else {
            Node<Patient> current = priorityQueue.getLast();
            while (current != firstNode && patient.urgentiecode() < current.getElement().urgentiecode()) {
                current = current.getPrevious();
            }
            priorityQueue.addAfter(current, newNode);
        }
    }

    @Override
    public Patient remove() {
        if (isEmpty()) {
            return null;
        }
        return priorityQueue.removeFirst().getElement();
    }

    @Override
    public Patient peek() {
        if (isEmpty()) {
            return null;
        }
        return priorityQueue.getFirst().getElement();
    }
}
