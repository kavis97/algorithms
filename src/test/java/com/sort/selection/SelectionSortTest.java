package com.sort.selection;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

    private SelectionSort subject;
    private int[] unsortedArray;
    private int[] sortedArray;

    @Test (expected = IllegalArgumentException.class)
    public void emptyTest() {
        givenUnsortedArray(null);
        whenSorted();
        givenUnsortedArray(new int[0]);
        whenSorted();
    }

    @Test
    public void sortTest() {
        givenUnsortedArray(15,10,8,9,3,5);
        whenSorted();
        thenExpect(3,5,8,9,10,15);
    }

    @Test
    public void sortTest1() {
        givenUnsortedArray(4,2,5,1,3);
        whenSorted();
        thenExpect(1,2,3,4,5);
    }

    private void thenExpect(int...items) {
        Assert.assertArrayEquals(items, sortedArray);
    }

    private void whenSorted() {
        subject = new SelectionSort(unsortedArray);
        sortedArray = subject.sort();
    }

    private void givenUnsortedArray(int...items) {
        unsortedArray = items;
    }


}
