package com.vitek.jlib.impl;

import java.util.Optional;
import java.util.stream.Stream;

import com.vitek.jlib.api.ILinkedList;
import com.vitek.jlib.api.ILinkedListNode;
import com.vitek.jlib.api.ISort;

/**
 * Example of Doubly Linked List implementation
 * @author Victor Smolinski
 * 01-19-2022
 */
public class DCLinkedList implements ILinkedList, ISort {
    /**
     * Fields
     */
    private int count = 0;
    private ILinkedListNode head = null, tail = null;

    /**
     * Constructors
     */
    public DCLinkedList() {}
    public DCLinkedList(ILinkedListNode head){
        this.head = head;
    }
    public DCLinkedList(ILinkedListNode head, ILinkedListNode tail){
        this.head = head;
        this.tail = tail;
    }

    public ILinkedListNode getHead() {
        return head;
    } 
    public ILinkedListNode getTail() {
        return tail;
    }

    /**
     * 
     * @return
     */
    public int count() { return count;}

    /**
     * 
     * @param node
     * @throws Exception
     */

    public void addFirst(ILinkedListNode node) throws Exception {
        node.setPrevious(null);
      // if the head is null, the list is empty
      if (this.head == null){
          this.head = node;
          this.count ++;
          return;
      }
      ILinkedListNode temp = this.head;
      this.head = node;
      this.head.setNext(temp);
      if (tail == null) tail = temp;
      this.count++;
    }

    /**
     * 
     * @param node
     * @throws Exception
     */
    public void addLast(ILinkedListNode node) throws Exception {
        node.setNext(null);
        // if the tail is null there's only one item in the list
        if(this.tail == null) {
            this.head.setNext(node);
            this.tail = node;
            this.count++;
            return;
        }
        this.tail.setNext(node);
        ILinkedListNode temp = this.tail;
        this.tail = node;
        this.tail.setPrevious(temp);
        this.count++;
    }

    public void addBefore(ILinkedListNode insertee, 
                          ILinkedListNode reference) throws Exception {
        this.count++;
        insertee.setPrevious(reference.getPrevious());
        reference.setPrevious(insertee);
        insertee.setNext(reference);
    }

    public void addAfter(ILinkedListNode insertee, ILinkedListNode reference) throws Exception {
        this.count++;
        reference.getNext().setPrevious(insertee);
        insertee.setNext(reference.getNext());
        reference.setNext(insertee);
        insertee.setPrevious(reference);
    }

    /**
     * 
     * @return
     * @throws Exception
     */
    public Optional<ILinkedListNode> removeFirst() throws Exception {
        Optional<ILinkedListNode> out  = null;
        if(this.head == null) return out;
        out = Optional.of(this.head);
        this.head = this.head.getNext();
        this.count--;
        return out;
    }

    /**
     * 
     * @return
     * @throws Exception
     */
    public Optional<ILinkedListNode> removeLast() throws Exception {
        Optional<ILinkedListNode> out = null;
        if(this.tail == null) return out;
        out = Optional.of(this.tail);
        this.tail = this.tail.getPrevious();
        count--;
        return out;
    } 

    /**
     * 
     * @param node
     * @throws Exception
     */
    public void delete(ILinkedListNode node) throws Exception {
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
        node.setPrevious(null);
        node.setNext(null);
        node = null;
        this.count--;
    }

    /**
     * 
     * @return
     * @throws Exception
     */
    public Optional<ILinkedListNode> getFirst() throws Exception {
        return Optional.of(this.head);
    }

    /**
     * 
     * @return
     * @throws Exception
     */
    public Optional<ILinkedListNode> getLast() throws Exception {
        return Optional.of(this.tail);
    }

    /**
     * 
     * @return
     */
    @SuppressWarnings ("unchecked")
    public Stream<ILinkedListNode> toStream() {
        ILinkedListNode item = this.head;
        Stream<ILinkedListNode> stream = null;
        Stream.Builder<ILinkedListNode> builder = Stream.builder();
        while(item.hasNext()) {
            builder.accept(item);
            item = item.getNext();
        }
        try {
        stream = builder.build();
        } catch (IllegalStateException e) { e.printStackTrace(); }
        return stream;
    }

    /**
     * 
     */
    public void sort() {
        //TODO

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