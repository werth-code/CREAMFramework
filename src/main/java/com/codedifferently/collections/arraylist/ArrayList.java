package com.codedifferently.collections.arraylist;

import com.codedifferently.collections.List;
import com.codedifferently.collections.arraylist.exceptions.IndexDoesNotExistException;
import com.codedifferently.collections.arraylist.exceptions.ValueDoesNotExistException;

import java.util.Iterator;
import java.util.logging.Logger;

public class ArrayList<T> implements List<T>, Iterable<T> {

    // size of our array.
    private static final int SIZE = 10;
    private int size;

    //generics to allow any type to be passed in.
    private T[] items;
    Logger logger = Logger.getGlobal();

    public ArrayList() {
        clear();
    }

    public void clear() {
        size = 0;
        ensureCapacity(SIZE);
    }

    //returns how many items are in our arraylist
    @Override
    public Integer size() {
        return size;
    }

    @Override
    public Boolean isEmpty() {
        return size() == 0;
    }

    // pass in an index and return the value.
    public T get(int index) {
        try {
            if (index < 0 || index >= size()) throw new IndexDoesNotExistException(); // throw an exception if index does not exist
            //return our item at the index.
            return items[index];
        } catch (IndexDoesNotExistException e) {
            logger.warning(e + "Index Does Not Exist.");
        }
        return null;
    }

    // this allows us to swap out a value at a given index.

    public T set(int index, T newVal) {
        try {
            if (index < 0 || index >= size()) throw new IndexDoesNotExistException();
            T old = items[index];           //store the old value at passed in index.
            items[index] = newVal;          //set the new value at that index.
            return old;                     //return the old value.
        } catch (IndexDoesNotExistException e) {
            logger.warning(e + "Index Does Not Exist.");
        }
        return null;
    }

    @Override
    //basic add method - take in an element
    public Boolean add(T element) {
        try {
            if(element == null) throw new ValueDoesNotExistException();
            add(this.size, element); //add element at the end of the arraylist (Since we start at 0 this works!)
            return true;
        } catch (ValueDoesNotExistException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Add to our arraylist at index
    //this could also be replace
    public void add(int index, T element) {
        //if array is full
        if (items.length == this.size) ensureCapacity((this.size * 2) + 1);
        for (int i = size; i > index; i--) { // as we add move the elements one space over.
            items[i] = items[i - 1];
        }
        items[index] = element; //set the element at index
        size++; // add one to our size
    }

    // we need to dynamically resize our array as we add items. This method checks that we have enough space.
    // create new array of the correct size.
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size) return;
        T[] old = items;                        // our prev
        items = (T[]) new Object[newCapacity];  // create new array at the new capacity(double + 1 last array)
        if (this.size >= 0) { //// TODO: 1/26/21 throw exception IndexDoesNotExist
            for (int i = 0; i < size(); i++) {  // loop through and combine both arrays
                items[i] = old[i];
            }
        }
    }

    // does our arraylist contain the data
    @Override
    public Boolean contains(T data) {
        for(T val : items) {
            if(val == data) return true;
        }
        return false;
    }

    // get and return the data
    @Override
    public T get(T data) {
        for(T val : items) {
            if(val == data) return val;
        }
        return null;
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
        int index = -1;
        for(int i = 0; i < items.length; i++) {
            if(items[i] == data) {
                index = i;
            }
        }
        return remove(index);
    }

    // custom iterator to iterate through our list.
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
            ArrayList.this.remove(--current);
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