package Collections;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyCollection<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(E element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if ((o == null && elements[i] == null) ||
                    (o != null && o.equals(elements[i]))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public E remove(int index) {
        checkIndex(index);
        E oldValue = (E) elements[index];

        // Shift elements left
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Clear reference for GC
        return oldValue;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if ((o == null && elements[i] == null) ||
                    (o != null && o.equals(elements[i]))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public MyIterator<E> iterator() {
        return new ArrayListIterator();
    }

    // Inner class for iterator
    private class ArrayListIterator implements MyIterator<E> {
        private int cursor = 0;
        private int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastRet = cursor;
            return (E) elements[cursor++];
        }

        @Override
        public void remove() {
            if (lastRet < 0) throw new IllegalStateException();
            MyArrayList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }
    }
}
