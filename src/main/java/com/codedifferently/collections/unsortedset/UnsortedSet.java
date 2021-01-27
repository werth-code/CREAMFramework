package com.codedifferently.collections.unsortedset;

import com.codedifferently.collections.Set;
import com.codedifferently.collections.arraylist.exceptions.IndexDoesNotExistException;

import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class UnsortedSet<T> implements Set<T>, Iterable<T> {
    private T[] backingArray;
    private int counter;

    private static final Integer SIZE = 10;
    Logger logger = Logger.getGlobal();

    public UnsortedSet(){
        backingArray = (T[]) new Object[SIZE]; // This is our container array
        counter = 0; // This is how many items are inside our set
    }

    // Matt is insane and decided to go off road...
    private class AUnsortedSetIterator<T> implements Iterator<T> {
        private int current;
        private T lastElement;

        private AUnsortedSetIterator() {
            current = 0;
            lastElement = (T) backingArray[current];
        }

        @Override
        public boolean hasNext() {
            if (current < backingArray.length && lastElement != null) return true;
            else return false;
        }

        @Override
        public T next() {
            try {
                if (!hasNext()) throw new IndexDoesNotExistException();
                return assembleNextElement();
            } catch (IndexDoesNotExistException e) {
                logger.warning(e + "Index Does Not Exist");
            }
            return null;
        }

        public T assembleNextElement() {
            T element = (T) backingArray[current];
            current++;
            lastElement = element;
            return element;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new AUnsortedSetIterator<>();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) action.accept(t);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Spliterators.spliterator(iterator(), size(), Spliterator.ORDERED);
    }


    // Danielle is back on track...

    @Override
    public Boolean add(T data){
        try {
            if (data == null) throw new NoDataInParameterException(); // if they pass in a null value throw exception
            for (Object element : backingArray) {  // looping through all elements
                if (element == data) return false; // don't add if it exists
            }

            if (counter == backingArray.length) expandArray(data); // if we fill our array, expand it.
            else {
                backingArray[counter] = data; //add the data
                counter++;
            }
            return true; // if item is successfully added return true

        } catch (NoDataInParameterException e) {
            logger.warning("The Data Parameter Must Not Be Empty.");
        }
        return false;
    }

    public void expandArray(T data) {
        T[] newArray = Arrays.copyOf(backingArray, backingArray.length * 2); // double the size of the array/
        newArray[counter] = data; // insert the new data at last index
        counter++;
        backingArray = newArray; // set the old array to the new array
    }

    @Override
    public Boolean contains(T value) {
        for(T val : this.getBackingArray()) { // check if the value is present in our array
            if(val == value) return true;
        }
        return false;
    }

    @Override
    public Object get(T data) {
        for(T val : this.getBackingArray()) { // same as contains, return the value.
            if(val == data) return data;
        }
        return null;
    }

    public Boolean remove(T data) {
        for(int i = 0; i < this.getBackingArray().length; i++) {  // remove the item from list
            if(data == backingArray[i]) {
                backingArray[i] = null;
                return true;
            }
        }
        return false;
    }

    public Integer size() { // tell you the size based on our counter
        return this.counter;
    }

    @Override
    public void clear() {
        this.backingArray = (T[]) new Object[SIZE]; // set our array to a new empty array
    }

    @Override
    public String toString() {
        return
                "set = " + Arrays.toString(backingArray) +
                ", counter=" + counter +
                '}';
    }

    @Override
    public Boolean isEmpty() {
        return this.counter == 0;
    }

    public Object[] toArray() {
        return this.getBackingArray();
    }
    public T[] getBackingArray() {
        return backingArray;
    }
    public void setBackingArray(T[] backingArray) {
        this.backingArray = backingArray;
    }
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
}


