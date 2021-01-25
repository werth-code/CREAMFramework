package com.codedifferently.collections;

public interface Set<T> {
    public Boolean add(T data);
    public Boolean contains(T data);
    public Object get(T data);
    public Object remove(T data);
    public Integer size();
    public void clear();
    public Boolean isEmpty();
}
