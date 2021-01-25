package UnsortedSet;

import java.util.Arrays;
import java.util.logging.Logger;


public class AUnsortedSet<T> {

    private T[] backingArray;
    private int counter;

    private static final Integer SIZE = 10;
    Logger logger = Logger.getGlobal();

    /**
     * Constructor for objects of class MySet
     */
    public AUnsortedSet(){
        backingArray=(T[]) new Object[SIZE];
            counter = 0;
        }


    public boolean add(T data){
        for(Object element : backingArray){
            if (data == null || element == data) return false; //TODO:
        }
        if(counter == backingArray.length){
            T[] newArray = Arrays.copyOf(backingArray,backingArray.length * 2);
            newArray[counter] = data;
            counter = counter +1;
            backingArray = newArray;
            return true;
        }
        else{
            backingArray[counter] = data;
            counter = counter+1;
            return true;
        }
    }

    public boolean remove(T data){
        return false;
    }

    //loop through to find value?
    public boolean contains(T value) {
        return false;
    }


        public Integer size() {

        //loop keep track of count
            return counter;

        }

        public Object[] toArray() {
            return new Object[0];
        }

    public T[] getBackingArray() {
        return backingArray;
    }
}




