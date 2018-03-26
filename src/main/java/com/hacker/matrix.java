package com.hacker;

public class matrix {

    public static void main(String[] args) {
        int[][] a = new int[4][3];
        a[0][0]=3;

        a[1][0]=11;
        a[1][1]=2;
        a[1][2]=4;

        a[2][0]=4;
        a[2][1]=5;
        a[2][2]=6;

        a[3][0]=10;
        a[3][1]=8;
        a[3][2]=-12;

        findDifference(a);




    }

    private static void findDifference(int[][] a) {

        int size = a[0][0];

        int result=0;
        for (int i=1; i<=size; i++) {
            result += a[i][i-1];
            result -= a[i][size-i];
        }

        System.out.print(Math.abs(result));
    }
}
