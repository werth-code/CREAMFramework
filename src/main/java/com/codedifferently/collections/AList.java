package com.codedifferently.collections;

import com.codedifferently.collections.linkedlist.LinkNode;

public interface AList <T>{
    public Boolean add(T data);
    public Boolean contains(T data);


    public T get(T data);
    public T remove(T data);
    public Integer size();
    public void clear();
    public Boolean isEmpty();
}
