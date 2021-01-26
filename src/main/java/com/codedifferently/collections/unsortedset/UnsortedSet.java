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
        backingArray = (T[]) new Object[SIZE];
        counter = 0;
    }

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

    @Override
    public Boolean add(T data){
        try {
            if (data == null) throw new NoDataInParameterException();
            for (Object element : backingArray) {
                if (element == data) return false;
            }

            if (counter == backingArray.length) expandArray(data);
            else {
                backingArray[counter] = data;
                counter++;
            }
            return true;

        } catch (NoDataInParameterException e) {
            logger.warning("The Data Parameter Must Not Be Empty.");
        }
        return false;
    }

    public void expandArray(T data) {
        T[] newArray = Arrays.copyOf(backingArray, backingArray.length * 2);
        newArray[counter] = data;
        counter++;
        backingArray = newArray;
    }

    @Override
    public Boolean contains(T value) {
        for(T val : this.getBackingArray()) {
            if(val == value) return true;
        }
        return false;
    }

    @Override
    public Object get(T data) {
        for(T val : this.getBackingArray()) {
            if(val == data) return data;
        }
        return null;
    }

    public Boolean remove(T data){
        for(int i = 0; i < this.getBackingArray().length; i++) {
            if(data == backingArray[i]) {
                backingArray[i] = null;
                return true;
            }
        }
        return false;
    }

    public Integer size() {
        return this.counter;
    }

    @Override
    public void clear() {
        this.backingArray = (T[]) new Object[SIZE];
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


    public Object[] toArray() { //// TODO: 1/25/21 this should remove null values
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


