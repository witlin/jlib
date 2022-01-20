package com.vitek.jlib.api;

import java.util.Optional;

public interface ILinkedList {
  
    public int count();
    
    public void addFirst(ILinkedListNode node) throws Exception;
    public void addLast(ILinkedListNode node) throws Exception;
    public void addBefore(ILinkedListNode ins, ILinkedListNode ref) throws Exception;
    public void addAfter(ILinkedListNode ins, ILinkedListNode ref) throws Exception;

    public Optional<ILinkedListNode> removeFirst() throws Exception;
    public Optional<ILinkedListNode> removeLast() throws Exception;
    public void delete(ILinkedListNode node) throws Exception;

    public Optional<ILinkedListNode> getFirst() throws Exception;
    public Optional<ILinkedListNode> getLast() throws Exception;
}