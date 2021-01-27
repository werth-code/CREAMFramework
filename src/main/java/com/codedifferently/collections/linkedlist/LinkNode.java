package com.codedifferently.collections.linkedlist;

import java.util.function.Consumer;

// This is our LinkedList Node

public class LinkNode<T>  {
    private T data;
    private LinkNode<T> nextNode;

    LinkNode(T data) {
        this.data = data;
        this.nextNode = null;
    }

    public T getData() {
        return data;
    }

    public LinkNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "data=" + data +
                ", nextNode=" + getNextNode() +
                '}';
    }

}
