package com.vitek.jlib.challenges;

import java.util.List;
import java.util.Arrays;

public class InsertionSort {
    
    private static String[] testStrings1 = 
                            { "F", "E", "C", "D", "B", "A"};
    private static String[] testStrings2 = 
                            {"E", "C", "B", "D", "A"};

    /**
     * Sorts a list of strings in ascending order (element at index 0 should be the smallest)
     * @param inputList
     * @return
     */
    public static List<String> sortAsc(List<String> inputList) {
        String[] array = new String[inputList.size()];
        inputList.toArray(array);
        int outterIndex = 0, innerIndex = 0, oNext = 0, iNext = 0;

        try {
            for(int o = 0; o < array.length; o++) {
                outterIndex = o;
                oNext = o+1;
                String temp; 
                if (o+1 <= array.length - 1) {
                    if(array[o+1].compareTo(array[o]) < 0) {
                        temp = array[o];
                        array[o] = array[o+1];
                        array[o+1] = temp;
                    } 
                } 
                for(int i = o; i >= 0; i--) {
                    innerIndex = i;
                    int next;
                    if (i+1 > array.length-1) { next = i; }
                    else { next = i+1; }
                    iNext = next;
                    if (array[next].compareTo(array[i]) < 0) {
                        temp = array[i];
                        array[i] = array[next];
                        array[next] = temp;
                    }
                }
            }
        } catch(IndexOutOfBoundsException ioobe) {
            System.err.println(ioobe.getLocalizedMessage() +
                                "\n\to: ".concat(String.valueOf(outterIndex)) +
                                "\n\ti: ".concat(String.valueOf(innerIndex)) +
                                "\n\tonext: ".concat(String.valueOf(oNext)) +
                                "\n\tinext: ".concat(String.valueOf(iNext)));
        }
        return Arrays.asList(array);
    }

    public static void runSortAsc() {
        List<String> result = 
                     sortAsc(Arrays.asList(testStrings2));
        System.out.println(
            result.stream()
                  .reduce("", String::concat));
        
    }
}
