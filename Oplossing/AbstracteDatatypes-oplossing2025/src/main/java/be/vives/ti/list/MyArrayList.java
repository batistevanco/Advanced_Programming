package be.vives.ti.list;

import be.vives.ti.adt.List;

public class MyArrayList implements List<String> {
    private String[] list;
    private int size;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalStateException("Ongeldige capaciteit");
        }
        this.list = new String[capacity];
        this.size = 0;
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
    public String get(int i) throws IndexOutOfBoundsException {
        if (isInvalidIndex(i)) {
            throw new IndexOutOfBoundsException(i);
        }

        return list[i];
    }

    @Override
    public String set(int i, String s) throws IndexOutOfBoundsException {
        if (isInvalidIndex(i)) {
            throw new IndexOutOfBoundsException( i);
        }

        String replacedValue = list[i];
        list[i] = s;
        return replacedValue;
    }

    @Override
    public void add(int i, String s) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) { // achteraan toevoegen is ook nog geldig
            throw new IndexOutOfBoundsException(i);
        }

        if (isArrayFull()) {
            throw new IllegalStateException("Lijst is vol");
        }

        for (int k = size - 1; k >= i; k--) {
            list[k + 1] = list[k];
        }
        list[i] = s;
        size++;
    }



    public void add(String s) {
        if (isArrayFull()) {
            throw new IllegalStateException("Lijst is vol");
        }
        list[size++] = s;
    }

    @Override
    public String remove(int i) throws IndexOutOfBoundsException {
        if (isInvalidIndex(i)) {
            throw new IndexOutOfBoundsException(i);
        }

        String removedValue = list[i];

        for (int k = i; k < size - 1; k++) {
            list[k] = list[k + 1];
        }

        list[size - 1] = null;
        size--;

        return removedValue;
    }

    private boolean isArrayFull() {
        return list.length == size;
    }

    private boolean isInvalidIndex(int i) {
        return i < 0 || i >= size;
    }

}
