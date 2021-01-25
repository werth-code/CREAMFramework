package com.codedifferently.collections.arraylist;

import com.codedifferently.collections.arraylist.exceptions.IndexDoesNotExistException;
import com.codedifferently.collections.arraylist.exceptions.ValueDoesNotExistException;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AArrayList<T> {
    private Integer index;
    private Object data[];
    private int size;
    private static final int SIZE_FACTOR=10;
    static Logger logger = Logger.getGlobal();


    public AArrayList(){
        this.data= (T[]) new Object [SIZE_FACTOR];
        this.size=SIZE_FACTOR;
    }


    public void addToIndex(T data){
        if(this.index==this.size-1){           //we need to increase the size of data[]
            increaseSizeAndReallocate();
        }
        data[this.index] = data;
        this.index++;

    }

    private void increaseSizeAndReallocate() {
        this.size=this.size+SIZE_FACTOR;
        Object newData[]=new Object[this.size];
        for(int i=0; i<data.length;i++){
            newData[i]=data[i];
        }
        this.data= (T[]) newData;
    }

    public Object getByIndex(int i) throws Exception {
        if(i>this.index-1){
            throw new Exception("ArrayIndexOutOfBound");
        }
        if(i<0){
            throw new Exception("Negative Value");
        }
        return this.data[i];

    }

    public void removeByIndex(int i) throws Exception{
        if(i>this.index-1){
            throw new Exception("ArrayIndexOutOfBound");
        }
        if(i<0){
            throw new Exception("Negative Value");
        }
        System.out.println("Object getting removed:"+this.data[i]);
        for(int x=i; x<this.data.length-1;x++){
            data[x]=data[x+1];
        }
        this.index--;
    }
}

