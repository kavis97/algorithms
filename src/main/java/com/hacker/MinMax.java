package com.hacker;

import java.util.Arrays;
import java.util.stream.Stream;

public class MinMax {
    public void minMax(int...arr) {
        long min=-1;
        long max=-1;
        long sum=0;
        for (int i=0; i<arr.length; i++)
            sum +=arr[i];
        for (int i=0; i<arr.length; i++) {
            long val = sum - arr[i];
            if (min == -1 || min > val)
                min = val;
            if (max == -1 || max < val)
                max = val;
        }
        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        new MinMax().minMax(1,2,3,4,5);
    }
}
