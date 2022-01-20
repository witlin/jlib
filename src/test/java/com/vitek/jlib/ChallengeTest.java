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
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ChallengeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ChallengeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
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
