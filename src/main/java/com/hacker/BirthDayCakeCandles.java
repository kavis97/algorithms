package com.hacker;

import java.util.Arrays;
import java.util.stream.Stream;

public class BirthDayCakeCandles {
    static int birthdayCakeCandles(int age, int[] ar) {
        int max = Stream.of(ar).flatMapToInt(i -> Arrays.stream(i)).max().getAsInt();
        long count = Stream.of(ar).flatMapToInt(i -> Arrays.stream(i)).filter(i -> i== max).count();
        return (int)count;
    }

    public static void main(String[] args) {
        System.out.println(birthdayCakeCandles(4, new int[]{3,2,1,3, 3,2,5}));
    }

}
