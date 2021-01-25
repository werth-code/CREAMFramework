import com.codedifferently.collections.arraylist.exceptions.IndexDoesNotExistException;
import com.codedifferently.collections.arraylist.exceptions.ValueDoesNotExistException;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AArrayList<T> {
    private Integer index;
    private T value;
    static Logger logger = Logger.getGlobal();


    public T getByIndex(Integer index) {
        try {
            if (this.index == null) throw new IndexDoesNotExistException();     //Printing all indexes instead of called index
        } catch (IndexDoesNotExistException e) {
            logger.warning ("This Index Does Not Exist");
        }
        return value;
    }

    public T getByValue(ArrayList<T> value) {
        try {
            if (this.value == null) throw new ValueDoesNotExistException();      //Printing all indexes instead of called index
        } catch (ValueDoesNotExistException e) {
            logger.warning("This Value Does Not Exist");
        }
        return (T) value;
    }

    public Boolean addValue(ArrayList<T> value){
        this.value = (T) value;
        return true;
    }


    public void setValue(ArrayList<T> value) {
        this.value = (T) value;
    }

    public Boolean contains(ArrayList<T> value) {
        for (Object val : value) {
            if (val == value) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public Integer size(ArrayList<T> value) {  //How do you get the number of values in size
        for (Object list : value) {
        }
        return value.size();
    }

    public Boolean isEmpty(ArrayList<T> value) {
        this.value = (T) value;
        if (value == null) {
            return true;
        } else {
            return false;
        }
    }

    public void clear(ArrayList<T> value) {
        this.value = (T) value;
        if (value != null) {
            value.clear();
        }
    }

    public T remove(AArrayList<T> value) {
        this.value = (T) value;
        this.index = index;
        for (int i = 0; i < value.size(); i++) {                   //Don't know how to get the length of the value
            if (index != null) {
                value.remove(index);                                                    //delete the value here
            }
        }
        return null;
    }
}

