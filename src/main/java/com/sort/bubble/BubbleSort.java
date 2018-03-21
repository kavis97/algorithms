package com.sort.bubble;

import java.util.function.BiPredicate;

public class BubbleSort {
    private static final BiPredicate<Integer, int[]> ASCENDING = (index, array) -> array[index] > array[index+1];
    public enum ORDER {
        ASC {
            @Override
            boolean validate(int index, int[] array) {
                return ASCENDING.test(index, array);
            }
        }, DESC {
            @Override
            boolean validate(int index, int[] array) {
                return ASCENDING.negate().test(index, array);
            }
        };
        abstract boolean validate(int index, int[] array);
    }
    int[] array;
    ORDER order;

    BubbleSort(int[] array, ORDER order) {
        this.array = array;
        this.order = order == null ? ORDER.ASC : order;
    }

    public int[] sort() {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Empty input array");
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array.length-1; j++) {
                if (order.validate(j, array)) {
                    int temp = array[j +1];
                    array[j +1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


}
