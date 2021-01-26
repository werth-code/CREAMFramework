package com.codedifferently.collections;

public interface Map<K, V>{
    public Boolean containsKey(K data);
    public Boolean containsValue(V value);

    public Object get(V data);
    public Object remove(V data);
    public Integer size();
    public void clear();
    public Boolean isEmpty();
}
