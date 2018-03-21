package com.sort.bubble;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
    BubbleSort subject;
    int[] unsortedArray;
    int[] sortedArray;
    int size;
    private BubbleSort.ORDER order;

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
        givenOrder(BubbleSort.ORDER.ASC);
        whenSorted();
        thenExpect(2,3,6,7,8,10);

        givenUnsortedArray(100, 89, 75, 64, 15);
        whenSorted();
        thenExpect(15,64,75,89,100);
    }

    @Test
    public void testWithNegatives() {
        givenUnsortedArray(-10,2,-8,6,-7,0, 3);
        givenOrder(BubbleSort.ORDER.ASC);
        whenSorted();
        thenExpect(-10,-8,-7,0,2,3,6);

        givenOrder(BubbleSort.ORDER.DESC);
        whenSorted();
        thenExpect(6,3,2,0,-7,-8,-10);
    }

    @Test
    public void descendingTest() {
        givenUnsortedArray(10,2,8,6,7,3);
        givenOrder(BubbleSort.ORDER.DESC);
        whenSorted();
        thenExpect(10,8,7,6,3,2);
    }

    private void givenOrder(BubbleSort.ORDER order) {
        this.order = order;
    }

    private void thenExpect(int...expected) {
        Assert.assertArrayEquals(expected, sortedArray);
    }

    private void whenSorted() {
        subject = new BubbleSort(unsortedArray, order);
        sortedArray = subject.sort();
    }

    private void givenUnsortedArray(int...items) {
        unsortedArray = items;
    }
}
