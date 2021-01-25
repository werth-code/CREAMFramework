package com.codedifferently.collections.linkedlist;

import com.codedifferently.collections.List;
import com.codedifferently.collections.linkedlist.exceptions.ListHasNoElementsException;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class WerthLinkedList<T> implements List<T>, Iterable<T> {
    static Logger logger = Logger.getGlobal();
    private LinkNode<T> head;
    private Integer count = 0;

    @Override
    public Iterator<T> iterator() {
        return new ALinkedListIterator<>(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) action.accept(t);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Spliterators.spliterator(iterator(), size(), Spliterator.ORDERED);
    }

    static class ALinkedListIterator <T> implements Iterator<T> {
        LinkNode<T> current;

        public ALinkedListIterator(WerthLinkedList<T> list) {
            current = list.getHeadNode();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.getData();
            current = current.getNextNode();
            return data;
        }
    }

    @Override
    public T get(T data) {                                                  // Should retrieve the object being passed in - or null. If no items are present throw an exception
        try {
            if(this.head == null) throw new ListHasNoElementsException();   // If the list has no elements throw our custom exception.

            LinkNode<T> currentNode = this.head;

            while (currentNode != null) {
                if (currentNode.getData() == data) return currentNode.getData();
                currentNode = currentNode.getNextNode();
            }

        } catch (ListHasNoElementsException e) {
            logger.warning(e + " ALinkedList Has No Values.");
        }
        return null;
    }


    @Override
    public LinkNode<T> remove(Object data) {
        LinkNode<T> currentNode = this.head;
        LinkNode<T> previousNode = null;

        if(currentNode != null && currentNode.getData().equals(data)) {          // If the key is the head node
            this.head = currentNode.getNextNode();
            logger.info(data + " has been deleted.");
            count--;
            return currentNode;
        }

        while (currentNode != null && currentNode.getData() != data) {          // If the key is not the head node, move along searching until...
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        if(currentNode != null && previousNode != null) {
            previousNode.setNextNode(currentNode.getNextNode());
            logger.info(data + " has been deleted.");
            count--;
        }
        else logger.info(data + " not found.");

        return currentNode;
    }


    public Integer size() {                                                             // Count all of our nodes.
        return this.count;
    }

    public void printALinkedList() {
        LinkNode<T> currentNode = this.head;
        while(currentNode != null) {
            logger.info(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
        }

    }

    public LinkNode<T> getLast() {
        try {
            if(this.head == null) throw new ListHasNoElementsException();
            LinkNode<T> current = this.head;

            while (true) {
                if (current.getNextNode() == null) return current;

                current = current.getNextNode();
            }
        } catch (ListHasNoElementsException e) {
            logger.info(e + " ALinkedList Has No Values.");
        }
        return null;
    }

    @Override
    public void clear() {
        this.head = null;
        count = 1;
    }

    @Override
    public Boolean isEmpty() {
        return count == 1;
    }

    @Override
    public Boolean add(T data) {
        LinkNode<T> node = new LinkNode<>(data);                            //Create a new node
        node.setNextNode(null);                                             //Set the next node to null

        if(this.head == null) this.head = node;                             //if we have no head(its null)then we set our new node as the head.
        else {
            LinkNode<T> last = this.head;                                      //set our last element to the head.. traverse the list to get to the end...insert as the last element.
            while(last.getNextNode() != null) {
                last = last.getNextNode();
            }
            last.setNextNode(node);
        }
        count++;
        return true;
    }

    @Override
    public Boolean contains(T data) {
        try {
            if(this.head == null) throw new ListHasNoElementsException();   // If the list has no elements throw our custom exception.

            LinkNode<T> currentNode = this.head;

            while (currentNode != null) {
                if (currentNode.getData() == data) return true;
                currentNode = currentNode.getNextNode();
            }

        } catch (ListHasNoElementsException e) {
            logger.warning(e + " ALinkedList Has No Values.");
        }
        return false;
    }

    public LinkNode<T> getHeadNode() {
        return head;
    }
}
