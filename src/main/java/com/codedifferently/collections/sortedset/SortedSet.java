package com.codedifferently.collections.sortedset;

import com.codedifferently.collections.unsortedset.UnsortedSet;
import com.codedifferently.collections.unsortedset.NoDataInParameterException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

public class SortedSet<T> extends UnsortedSet<T> implements Comparable<T> {
    Logger logger = Logger.getGlobal();

    @Override
    public Boolean add(T data){
        try {
            if (data == null) throw new NoDataInParameterException();
            for (Object element : this.getBackingArray()) {
                if (element == data) return false;
            }
            if (this.getCounter() == this.getBackingArray().length) expandArray(data);
            else {
                //add sort method
                this.getBackingArray()[this.getCounter()] = data;
                this.setCounter(this.getCounter() + 1);
            }

            //Arrays.sort(this.getBackingArray(), Comparator.nullsLast(Comparator.naturalOrder()));
            return true;

        } catch (NoDataInParameterException e) {
            logger.warning("The Data Parameter Must Not Be Empty.");
        }
        return false;
    }


    @Override
    public int compareTo(T o) {
        return 0;
    }
}
