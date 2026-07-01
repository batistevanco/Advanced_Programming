package be.vives.ti.map;

import be.vives.ti.adt.Map;

public class SimpleHashMap implements Map<Student, String> {

    private final String[] map;
    private int size;

    public SimpleHashMap() {
        map = new String[10];
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
    public String get(Student key) {
        int index = hash(key);

        return map[index];
    }

    @Override
    public String put(Student key, String value) {
        int index = hash(key);

        String oldValue = map[index];
        map[index] = value;
        if (oldValue == null) {
            size++;
        }

        return oldValue;
    }

    @Override
    public String remove(Student key) {
        int index = hash(key);

        String oldValue = map[index];
        map[index] = null;
        if (oldValue != null) {
            size--;
        }

        return oldValue;
    }

    private int hash(Student key) {
        int hashCode = key.hashCode();
        return hashCode % map.length;
    }

}
