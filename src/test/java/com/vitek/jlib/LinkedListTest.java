package com.vitek.jlib;

import java.util.Arrays;
import java.util.Optional;

import com.vitek.jlib.api.ILinkedList;
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
    @DisplayName("Add elements from the top and" + 
                 " check that all refs are good traversing the list" +
                 " in both directions.")
    public void testAddFirst() throws Exception {
        String word = "A B C D E F";
        ILinkedList list = new DCLinkedList();

        // Fill the list with values.
        Arrays.stream(word.split(" ")).forEach( e -> {
            try {
                list.addFirst(DCLinkedListNode.with(e));
            } catch (Exception exception) { 
                System.err.println("[error] splitting word - testAddFirst..."
                                    .concat(exception.getLocalizedMessage())); 
                                                            }
        });

        // Traverse the list forward.
        StringBuilder sbf = new StringBuilder();
        Optional<ILinkedListNode> optf = list.getFirst();
        while (optf.isPresent()) {
            sbf.append(optf.get().get());
            if (!optf.get().hasNext()) break;
            optf = Optional.ofNullable(optf.get().getNext());
        }
        assertEquals("FEDCBA", sbf.toString());

        // Traverse the list backwards.
        StringBuilder sbb = new StringBuilder();
        Optional<ILinkedListNode> optb = list.getLast();
        while(optb.isPresent()) {
            sbb.append(optb.get().get());
            if (!optb.get().hasPrevious()) break;
            optb = Optional.ofNullable(optb.get().getPrevious());
        }
        assertEquals("ABCDEF", sbb.toString());
    }

    @Test
    @DisplayName ("Add elements from the bottom and verify refs traversing" +
                  "in both directions.")
    public void testAddLast() throws Exception {

    }
}
