package be.vives.ti.list;

import be.vives.ti.adt.List;
import be.vives.ti.linkedlist.DoubleLinkedList;
import be.vives.ti.linkedlist.Node;

public class MyLinkedList implements List<String> {

    private final DoubleLinkedList<String> list;

    public MyLinkedList() {
        this.list = new DoubleLinkedList<>();
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String get(int i) throws IndexOutOfBoundsException {
        if (isInvalidIndex(i)) {
            throw new IndexOutOfBoundsException(i);
        }

        Node<String> current = getNodeAtIndex(i);
        return current.getElement();
    }

    private Node<String> getNodeAtIndex(int i) {
        Node<String> current = list.getFirst();
        for(int j = 0; j < i; j++){
            current = current.getNext();
        }
        return current;
    }

    @Override
    public String set(int i, String s) throws IndexOutOfBoundsException {
        if (isInvalidIndex(i)) {
            throw new IndexOutOfBoundsException(i);
        }

        Node<String> current = getNodeAtIndex(i);
        String oldValue = current.getElement();
        current.setElement(s);
        return oldValue;
    }

    @Override
    public void add(String s) {
        list.addLast(new Node<>(s));
    }

    @Override
    public void add(int i, String s) throws IndexOutOfBoundsException {
        if (i < 0 || i > size()) { // achteraan toevoegen is ook nog geldig
            throw new IndexOutOfBoundsException(i);
        }

        Node<String> nieuweNode = new Node<>(s);
        if(list.isEmpty()){
            list.addFirst(nieuweNode);
        }
        else {
            Node<String> current = getNodeAtIndex(i);
            list.addAfter(current.getPrevious(), nieuweNode);
        }
    }

    @Override
    public String remove(int i) throws IndexOutOfBoundsException {
        if (isInvalidIndex(i)) {
            throw new IndexOutOfBoundsException(i);
        }

        Node<String> current = getNodeAtIndex(i);
        return list.remove(current).getElement();

    }

    private boolean isInvalidIndex(int i) {
        return i < 0 || i >= size();
    }
}
