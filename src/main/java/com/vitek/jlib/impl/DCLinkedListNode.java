package com.vitek.jlib.impl;

import com.vitek.jlib.api.ILinkedListNode;

/**
 * 
 * @author Victor Smolinski
 */
public class DCLinkedListNode<T> implements ILinkedListNode<T> {

    // Fields
    private ILinkedListNode<T> next;
    private ILinkedListNode<T> previous;
    private T value;

    //Constructor
    private DCLinkedListNode (T v) {
        this.value = v;
    }

    // API Methods

    /**
     * @param node
    */
    public void setNext(ILinkedListNode<T> node) {next = node;}
    
    /**
     * @param node
     */
    public void setPrevious(ILinkedListNode<T> node) {previous = node;}

    /**
     * 
     * @return
     */
    public ILinkedListNode<T> getNext() {
        try {
            return next;
        } catch (Exception e) { System.err.println(e.getLocalizedMessage());}
        return null;
    }

    /**
     * @return
     */
    public ILinkedListNode<T> getPrevious() {
        try {
            return previous;
        } catch (Exception e) { System.err.println(e.getLocalizedMessage());}
        return null;
    }

    /**
     * 
     * @return
     */
    public boolean hasNext() {
        if(this.getNext() != null) return true;
        return false;
    }

    /**
     * 
     * @return
     */
    public boolean hasPrevious() {
        if(this.getPrevious() != null) return true;
        return false;
    }

    public static <T> DCLinkedListNode<T> with(T value){
        return new DCLinkedListNode<T>(value);
    }

    public T get() {
        return value;
    }

    /**
     * 
     * @return
     */
    @Override
    public String toString() {
        return ((Object)value).toString();
    }

    /**
     * 
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        return ((Object)value).equals(o);
    }
}