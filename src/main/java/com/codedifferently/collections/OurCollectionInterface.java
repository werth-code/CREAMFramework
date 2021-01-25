package com.codedifferently.collections;

public interface OurCollectionInterface<T>{

    public Object get(T data);
    public Object remove(T data);
    public Integer size();
    public void clear();
    public Boolean isEmpty();

}
