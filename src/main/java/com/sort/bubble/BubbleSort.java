package com.sort.bubble;

import java.util.Arrays;
import java.util.logging.Logger;

public class BubbleSort {
    private static final Logger LOG = Logger.getLogger(BubbleSort.class.getName());
    private int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Empty input array");
        for (int i=0; i<array.length-1; i++) {
            print("Start: ", i);
            for (int j=0; j<array.length-1-i; j++) {
                print("\t Internal: i: " +i, j);
                if (array[j] > array[j+1]) {
                    int temp = array[j +1];
                    array[j +1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    private void print(String s, int i) {
        LOG.info(s + i + " : "  + Arrays.toString(array));
    }
}
