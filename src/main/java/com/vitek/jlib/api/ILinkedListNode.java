package com.vitek.jlib.api;

public interface ILinkedListNode<T> {
    public ILinkedListNode<T> getNext();
    public void setNext(ILinkedListNode<T> node);

    public ILinkedListNode<T> getPrevious();
    public void setPrevious(ILinkedListNode<T> node);

    public boolean hasNext();
    public boolean hasPrevious();

    public static <T> ILinkedListNode<T> with(T o) {
        return null;
    }

    public T get();
}