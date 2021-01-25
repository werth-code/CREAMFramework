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
            if (element == null || data == null || element.equals(data)) return false;
        }
        if(counter == backingArray.length){
            T[] newArray = Arrays.copyOf(backingArray,backingArray.length * 2);
            newArray[counter] = data; // TODO: may need +1 numElements
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

    //loop through to find value?
    public boolean contains(T value) {
        return false;
    }

    public boolean equals() {

        String str1 = "Strings are fun";
        String str2 = "Strings are fun";


        if (str1.equals(str2)) {
            return true;
        } else {
            return false;
        }

    }
        public boolean remove(T data){
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




