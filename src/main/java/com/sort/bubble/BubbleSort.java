package com.sort.bubble;

import java.util.function.BiPredicate;

public class BubbleSort {
    private int[] array;

    BubbleSort(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Empty input array");
        for (int i=0; i<array.length-1; i++) {
            for (int j=0; j<array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j +1];
                    array[j +1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
