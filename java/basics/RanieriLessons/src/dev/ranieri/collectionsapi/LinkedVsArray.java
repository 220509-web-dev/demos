package dev.ranieri.collectionsapi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedVsArray {

    public static void main(String[] args) {

        List<Object> objectList = new LinkedList<Object>();

        long start;
        long end;

        // create 100,000 objects and add them to the end
        start = System.nanoTime();
        for(int i = 0; i<100_000;i++){
            objectList.add(new Object());
        }
        end = System.nanoTime();
        System.out.println("Time to add 100,00 objects to the end Milleseconds:" + ((end-start)/1_000_000));


        start = System.nanoTime();
        for(int i = 0; i<100_000;i++){
            objectList.get(50_000);
        }
        end = System.nanoTime();
        System.out.println("Time to get middle object 100,000 times  Milleseconds:" + ((end-start)/1_000_000));

        start = System.nanoTime();
        for(int i = 0; i<100_000;i++){
            objectList.add(0,new Object());
        }
        end = System.nanoTime();
        System.out.println("Time to add an object 100,000 times to the begining  Milleseconds:" + ((end-start)/1_000_000));


    }
}
