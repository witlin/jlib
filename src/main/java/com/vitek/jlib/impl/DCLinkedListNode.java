package com.vitek.jlib.impl;

import com.vitek.jlib.api.ILinkedListNode;

/**
 * 
 * @author Victor Smolinski
 */
public class DCLinkedListNode<T> implements ILinkedListNode {

    // Fields
    private ILinkedListNode next;
    private ILinkedListNode previous;

    // API Methods

    /**
     * @param node
    */
    public void setNext(ILinkedListNode node) {next = node;}
    
    /**
     * @param node
     */
    public void setPrevious(ILinkedListNode node) {previous = node;}

    /**
     * 
     * @return
     */
    public ILinkedListNode getNext() {
        try {
            return next;
        } catch (Exception e) { System.err.println(e.getLocalizedMessage());}
        return null;
    }

    /**
     * @return
     */
    public ILinkedListNode getPrevious() {
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

    /**
     * 
     * @return
     */
    @Override
    public String toString() {
        //TODO
        return null;
    }

    /**
     * 
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        //TODO
        return false;
    }
}