package com.codedifferently.collections.arraylist;

import com.codedifferently.collections.arraylist.exceptions.ValueDoesNotExistException;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AArrayList<T> {
    private Integer index;
    private Object data[];
    private int size;
    private static final int SIZE_FACTOR = 10;
    static Logger logger = Logger.getGlobal();


    public AArrayList() {
        this.data = (T[]) new Object[SIZE_FACTOR];
        this.size = SIZE_FACTOR;
    }


    public void addToIndex(Object index, Object element) {
        if (this.index == this.size - 1) {           //we need to increase the size of data[]
            increaseSizeAndReallocate();
        }
        data[this.index] = element;
        this.index++;

    }

    private void increaseSizeAndReallocate() {
        this.size = this.size + SIZE_FACTOR;
        Object newData[] = new Object[this.size];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        this.data = (T[]) newData;
    }

    public Object getByIndex(Integer i) throws Exception {
        if (i > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        }
        if (i < 0) {
            throw new ValueDoesNotExistException();
        }
        return this.data[i];
    }

    public void removeByIndex(Integer index) throws Exception {
        if (index > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        }
        if (index < 0) {
            throw new Exception("NoValuePresent...Go Fish");
        }
        logger.info("Object getting removed:" + this.data[index]);
        for (int x = index; x < this.data.length - 1; x++) {
            data[x] = data[x + 1];
        }
        this.index--;
    }

    public void setIndex(Integer index) {
        this.index = index;
        logger.info("Index is now set");
        if (index != null) {
            logger.warning("This index already exist");
        }
    }

    public Integer size(Integer index) {
        for (int x = index; x < this.data.length; x++) {
            if (index == null) {
                return 0;
            }
        }
        return index;
    }

    public Boolean areYouEmpty(Object data[]) {
        this.data = data;
        for (int x = index; x < this.data.length; x++) {
            if (x == 0) {
                logger.info("NothingToSeeHereFolksMoveAlong");
                return true;
            }
        }
        return false;
    }
}