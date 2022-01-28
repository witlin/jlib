package com.vitek.jlib;

import java.util.Arrays;

import com.vitek.jlib.api.ILinkedListNode;
import com.vitek.jlib.impl.DCLinkedList;
import com.vitek.jlib.impl.DCLinkedListNode;

import org.junit.gen5.api.DisplayName;
import org.junit.gen5.api.Assertions;
import org.junit.gen5.api.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LinkedListTest extends TestCase {

    @Test
    @DisplayName("Add first element to an empty list.")
    public void testAddFirst1() throws Exception {
        DCLinkedList list = new DCLinkedList();
        DCLinkedListNode<String> node = DCLinkedListNode.with("A");
        list.addFirst(node);

        assertTrue(list.getHead().get().equals("A"));
        assertEquals(list.getHead().get(), "A");
    }

    @Test
    @DisplayName("Add first element to a non-empty list.")
    public void testAddFirst2() throws Exception {
        String word = "A B C D E F";
        DCLinkedList list = new DCLinkedList();
        Arrays.stream(word.split(" ")).forEach(e -> {
            try {
                list.addFirst(DCLinkedListNode.with(e));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        StringBuilder sb = new StringBuilder();
        ILinkedListNode<String> node = list.getHead();
        
        assertEquals(list.count(), 6);

        assertEquals("F", node.get());

        assertEquals("E", node.getNext().get());

        assertEquals("D", node.getNext()
                              .getNext().get());

        assertEquals("C", node.getNext()
                              .getNext()
                              .getNext().get());

        assertEquals("B", node.getNext()
                              .getNext()
                              .getNext()
                              .getNext().get());
                              
        assertEquals("A", node.getNext()
                              .getNext()
                              .getNext()
                              .getNext()
                              .getNext().get());
        
        assertEquals("A", list.getTail().get());
    }
}