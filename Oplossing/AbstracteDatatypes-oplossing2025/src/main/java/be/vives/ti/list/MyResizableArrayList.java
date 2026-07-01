package be.vives.ti.list;

import be.vives.ti.adt.List;

public class MyResizableArrayList implements List<String> {
    private String[] array;
    private int size;

    public MyResizableArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalStateException("Ongeldige capaciteit");
        }
        this.array = new String[capacity];
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
        if (isNoValidIndex(i)) {
            throw new IndexOutOfBoundsException(i);
        }

        return array[i];
    }

    @Override
    public String set(int i, String s) throws IndexOutOfBoundsException {
        if (isNoValidIndex(i)) {
            throw new IndexOutOfBoundsException(i);
        }

        String replacedValue = array[i];
        array[i] = s;
        return replacedValue;
    }

    @Override
    public void add(int i, String s) throws IndexOutOfBoundsException {
        if ((isNoValidIndex(i) && i != size)) { // achteraan toevoegen is ook nog geldig
            throw new IndexOutOfBoundsException(i);
        }

        if (isArrayFull()) {
            grow();
        }

        for (int k = size - 1; k >= i; k--) {
            array[k + 1] = array[k];
        }
        array[i] = s;
        size++;
    }

    public void add(String s) {
        if (isArrayFull()) {
            grow();
        }
        array[size++] = s;
    }


    private void grow(){
        int newLength = array.length + (array.length / 2);
        newLength = newLength < 2 ? newLength + 1 : newLength;

        String[] newArray = new String[newLength];
        for (int j = 0; j < array.length; j++) {
            newArray[j] = array[j];
        }
        this.array = newArray;
    }

    @Override
    public String remove(int i) throws IndexOutOfBoundsException {
        if (isNoValidIndex(i)) {
            throw new IndexOutOfBoundsException(i);
        }

        String removedValue = array[i];

        for (int k = i; k < size - 1; k++) {
            array[k] = array[k + 1];
        }

        array[size - 1] = null;
        size--;

        return removedValue;
    }

    private boolean isArrayFull() {
        return array.length == size;
    }

    private boolean isNoValidIndex(int i) {
        return i < 0 || i >= size;
    }

}
