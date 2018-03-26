package com.hacker;

public class StairCase {
    public static void main(String[] args) {
        new StairCase().stairCase(6);
    }

    public void stairCase(int size) {
        for (int i=0; i<size; i++) {
            int index = size - (i+1);
            for (int j=0; j<size; j++)
                System.out.print( j < index ? ' ' : '#');
            System.out.println();
        }
    }
}
