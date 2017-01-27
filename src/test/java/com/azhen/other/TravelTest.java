package com.azhen.other;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by azhen on 17-1-27.
 */
public class TravelTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int length = 100000;
        for(int i = 0; i < length; i ++) {
            list.add(1);
        }
        long start = 0L;

        start = System.currentTimeMillis();
        for(int i = 0; i < list.size(); i ++) {
            list.get(i);
        }
        System.out.println("size() : " + (System.currentTimeMillis() - start));


        start = System.currentTimeMillis();
        for(int i = 0,size = list.size(); i < size; i ++) {
            list.get(i);
        }
        System.out.println("size : " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for(int i = 0; i < list.size(); i ++) {
            list.get(i);
        }
        System.out.println("size() : " + (System.currentTimeMillis() - start));


        start = System.currentTimeMillis();
        for(int i = 0,size = list.size(); i < size; i ++) {
            list.get(i);
        }
        System.out.println("size : " + (System.currentTimeMillis() - start));
    }

}
