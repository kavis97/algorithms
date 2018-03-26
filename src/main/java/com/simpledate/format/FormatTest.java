package com.simpledate.format;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormatTest {


    public static void main(String[] args) {
        SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(f.format(new GregorianCalendar(2017,11, 31).getTime()));
        System.out.println(f.format(new Date(1514678400000L)));

    }
}
