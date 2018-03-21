package com.sort.bubble;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
    BubbleSort subject;
    int[] unsortedArray;
    int[] sortedArray;
    int size;

    @Test(expected = IllegalArgumentException.class)
    public void emptyTest() {
        givenUnsortedArray(null);
        whenSorted();
        givenUnsortedArray(new int[0]);
        whenSorted();
    }

    @Test
    public void ascendingTest() {
        givenUnsortedArray(10,2,8,6,7,3);
        whenSorted();
        thenExpect(2,3,6,7,8,10);
    }

    @Test
    public void testWithNegatives() {
        givenUnsortedArray(-10,2,-8,6,-7,0, 3);
        whenSorted();
        thenExpect(-10,-8,-7,0,2,3,6);
    }

    private void thenExpect(int...expected) {
        Assert.assertArrayEquals(expected, sortedArray);
    }

    private void whenSorted() {
        subject = new BubbleSort(unsortedArray);
        sortedArray = subject.sort();
    }

    private void givenUnsortedArray(int...items) {
        unsortedArray = items;
    }
}
