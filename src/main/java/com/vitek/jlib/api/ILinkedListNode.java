package com.vitek.jlib.api;

public interface ILinkedListNode {
    public ILinkedListNode getNext();
    public void setNext(ILinkedListNode node);

    public ILinkedListNode getPrevious();
    public void setPrevious(ILinkedListNode node);

    public boolean hasNext();
    public boolean hasPrevious();
}