package com.codedifferently.collections.arraylist;

import com.codedifferently.collections.AList;
import com.codedifferently.collections.arraylist.exceptions.IndexDoesNotExistException;
import com.codedifferently.collections.arraylist.exceptions.ValueDoesNotExistException;

import java.util.Iterator;
import java.util.logging.Logger;

public class AArrayList<T> implements AList<T>, Iterable<T> {
    private static final int SIZE = 10;
    private int size;
    private T[] items;
    Logger logger = Logger.getGlobal();

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size) return;
        T[] old = items;
        items = (T[]) new Object[newCapacity];
        if (size() >= 0) {
            for (int i = 0; i < size(); i++) {
                items[i] = old[i];
            }
        }
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public Boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        try {
            if (index < 0 || index >= size()) throw new IndexDoesNotExistException();
            return items[index];
        } catch (IndexDoesNotExistException e) {
            logger.warning(e + "Index Does Not Exist.");
        }
        return null;
    }

    public T set(int index, T newVal) {
        try {
            if (index < 0 || index >= size()) throw new IndexDoesNotExistException();
            T old = items[index];
            items[index] = newVal;
            return old;
        } catch (IndexDoesNotExistException e) {
            logger.warning(e + "Index Does Not Exist.");
        }
        return null;
    }

    public void add(int index, T element) {
        if (items.length == size()) ensureCapacity(size() * 2 + 1);
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = element;
        size++;
    }

    @Override
    public Boolean add(T element) {
        try {
            if(element == null) throw new ValueDoesNotExistException();
            add(this.size(), element);
            return true;
        } catch (ValueDoesNotExistException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean contains(T data) {
        return null;
    }

    @Override
    public T get(T data) {
        return null;
    }

    public AArrayList() {
        clear();
    }

    public void clear() {
        size = 0;
        ensureCapacity(SIZE);
    }

    public T remove(int index) {
        T removeItem = items[index];
        for (int i = index; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return removeItem;
    }

    @Override
    public T remove(T data) {
        return null;
    }


    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<T> {

        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public T next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return items[current++];
        }

        public void remove() {
            AArrayList.this.remove(--current);
        }
    }



//    private Integer index;
//    private T[] data;
//    private int size;
//    private static final int SIZE_FACTOR = 10;
//    static Logger logger = Logger.getGlobal();
//
//
//    public AArrayList() {
//        this.data = (T[]) new Object[SIZE_FACTOR];
//        this.size = SIZE_FACTOR;
//    }
//
//
//    public void add(T item) {
//        if(this.index == this.size -1){ // we need to add spaces in our array[]
//            increaseSizeAndReallocate();
//        }
//        data[this.index] = item;
//        this.index++;
//    }
//
//    private void increaseSizeAndReallocate() {
//        this.size = this.size + SIZE_FACTOR;
//        Object newData[] = new Object[this.size];
//        for (int i = 0; i < data.length; i++) {
//            newData[i] = data[i];
//        }
//        this.data = (T[]) newData;
//    }
//
//    public Object get(Integer i) {
//        try {
//            if (i > this.index - 1) throw new ArrayIndexOutOfBoundsException();
//            if (i < 0) throw new ValueDoesNotExistException();
//            return this.data[i];
//        } catch (ArrayIndexOutOfBoundsException | ValueDoesNotExistException e) {
//            logger.warning(e + "Could Not getByIndex");
//        }
//        return null;
//    }
//
//    public void removeByIndex(Integer index) throws Exception {
//        if (index > this.index - 1) {
//            throw new Exception("ArrayIndexOutOfBound");
//        }
//        if (index < 0) {
//            throw new Exception("NoValuePresent...Go Fish");
//        }
//        logger.info("Object getting removed:" + this.data[index]);
//        for (int x = index; x < this.data.length - 1; x++) {
//            data[x] = data[x + 1];
//        }
//        this.index--;
//    }
//
//    public void setIndex(Integer index) {
//        this.index = index;
//        logger.info("Index is now set");
//        if (index != null) {
//            logger.warning("This index already exist");
//        }
//    }
//
//    public Integer size(Integer index) {
//        for (int x = index; x < this.data.length; x++) {
//            if (index == null) {
//                return 0;
//            }
//        }
//        return index;
//    }
//
//    public Boolean areYouEmpty(T[] data) {
//        this.data = data;
//        for (int x = index; x < this.data.length; x++) {
//            if (x == 0) {
//                logger.info("NothingToSeeHereFolksMoveAlong");
//                return true;
//            }
//        }
//        return false;
//    }
}