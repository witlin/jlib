package com.vitek.jlib;

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
    public void testAddFirst() throws Exception {
        DCLinkedList list = new DCLinkedList();
        DCLinkedListNode<String> node = DCLinkedListNode.with("A");
        list.addFirst(node);

        assertTrue(list.getHead().get().equals("A"));
        assertEquals(list.getHead().get(), "A");
    }
}