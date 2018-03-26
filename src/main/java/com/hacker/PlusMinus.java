package com.hacker;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Stream;

public class PlusMinus {

    public float[] parse8(int[] items) {
        int plus = (int) Stream.of(items).flatMapToInt(x -> Arrays.stream(x)).filter(i -> i > 0).count();
        int minus = (int) Stream.of(items).flatMapToInt(x -> Arrays.stream(x)).filter(i -> i < 0).count();
        int zero = (int) Stream.of(items).flatMapToInt(x -> Arrays.stream(x)).filter(i -> i == 0).count();

        float f[] = new float[3];
        double divisor = items.length/1.0;
        f[0] = (float) (plus / divisor);
        f[1] = (float) (minus / divisor);
        f[2] = (float) (zero / divisor);

        return f;
    }

    public String[] parse(int[] items) {
        int length = items.length;
        if (items == null || length == 0)
            return null;

        int plus=0;
        int minus=0;
        int zero=0;
        for (int i=0; i< length; i++) {
            if (items[i] < 0)
                minus++;
            if (items[i] > 0)
                plus++;
            if (items[i] == 0)
                zero++;
        }
        String f[] = new String[3];
        double divisor = length/1.0;
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(6);
        format.setMinimumFractionDigits(6);
        f[0] = format.format((float) (plus / divisor));
        f[1] = format.format((float) (minus / divisor));
        f[2] = format.format((float) (zero / divisor));
        System.out.println(format.format((float) (plus / divisor)));
        return f;
    }

    public static void main(String[] args) {
        int[] items = new int[]{-4, 3, -9, 0, 4, 1};
        String[] s = new PlusMinus().parse(items);
        for (int i=0; i<s.length; i++)
            System.out.println(s[i]);

//        float[] result = new PlusMinus().parse8(items);
//        for (int i=0; i<result.length; i++)
//            System.out.println(result[i]);


    }
}
