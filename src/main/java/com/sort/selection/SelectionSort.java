package com.sort.selection;

public class SelectionSort {

    int[] array;

    public SelectionSort(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("");

        for (int i=0; i<array.length-1; i++) {
            for (int j=i+1; j<array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        return array;
    }
}
