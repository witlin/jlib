package com.vitek.jlib;

import java.util.Arrays;
import com.vitek.jlib.challenges.InsertionSort;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ChallengeTest 
    extends TestCase
{
    
    public void testInsertionSort()
    {
        String resultString = 
                InsertionSort.sortAsc(
                Arrays.asList(new String[]{"E", "C", "B", "D", "A"}))
                      .stream()
                      .reduce("", String::concat);         
        assertTrue( resultString.equals("ABCDE"));
    }
}
