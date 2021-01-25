package com.codedifferently.collections;

public interface Map<T>{
    public Boolean containsKey(T data);
    public Boolean containsValue(T value);

    public Object get(T data);
    public Object remove(T data);
    public Integer size();
    public void clear();
    public Boolean isEmpty();
}
