package com.bridgelabz;

public class MyNode <T> implements INode<T> {

    private T key;
    private INode next;

    public MyNode (T key) {
        this.key = key;
        this.next = null;
    }

    @Override
    public void setKey(T Key) {
        this.key = key;
    }

    @Override
    public T getKey() {
        return key;
    }

    public INode getNext() {
        return next;
    }

    public void setNext(INode next) {
        this.next = next;
    }


}
