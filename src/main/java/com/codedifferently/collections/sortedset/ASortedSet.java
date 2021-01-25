package com.codedifferently.collections.sortedset;

import com.codedifferently.collections.unsortedset.AUnsortedSet;
import com.codedifferently.collections.unsortedset.NoDataInParameterException;

import java.util.Arrays;
import java.util.logging.Logger;

public class ASortedSet<T> extends AUnsortedSet<T> {
    Logger logger = Logger.getGlobal();

    @Override
    public Boolean add(T data){
        try {
            if (data == null) throw new NoDataInParameterException();
            for (Object element : this.getBackingArray()) {
                if (element == data) return false;
            }

            if (this.getCounter() == this.getBackingArray().length) {
                T[] newArray = Arrays.copyOf(this.getBackingArray(), this.getBackingArray().length * 2);
                newArray[this.getCounter()] = data;
                this.setCounter(this.getCounter() + 1);
                this.setBackingArray(newArray);
            } else {
                this.getBackingArray()[this.getCounter()] = data;
                this.setCounter(this.getCounter() + 1);
            }
            Arrays.sort(this.getBackingArray());
            return true;
        } catch (NoDataInParameterException e) {
            logger.warning("The Data Parameter Must Not Be Empty.");
        }
        return false;
    }

}
