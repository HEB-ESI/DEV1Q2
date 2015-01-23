/*
 * TracerTest.java
 *
 * Created on 24 octobre 2006, 21:50
 *
 */

package test;

import java.util.ArrayList;
import java.util.Random;
import sorters.AbstractArraySorter;
import sorters.BubbleSorter;
import sorters.InsertionSorter;
import sorters.graphics.MultipleStateArrayTracer;
import sorters.graphics.StateArrayTracer;

/**
 * Example of use of the multiple array tracer on some arrays for the
 * insertion sort algorithm.
 * @author Absil Romain
 */
public class MultiTracerTest
{
    
    public static void main(String[] args)
    {
        ArrayList<Comparable> list = new ArrayList<Comparable>();
        ArrayList<Comparable> addList = new ArrayList<Comparable>();
        for(int i = 0 ; i < 300 ; i++) // 100 -> 400
           addList.add(i+1);
        
        for(int i = 299; i >= 0; i--) //99 -> 399
        {
            Random r = new Random();
            int n = r.nextInt(i+1);
            list.add(addList.get(n));
            addList.remove(n);
        }
        Comparable[] tab1 = new Comparable[list.size()];
        list.toArray(tab1);
        
        ArrayList<Comparable> list2 = new ArrayList<Comparable>();
        for(int i = 0 ; i < 300 ; i++)
            list2.add(i+1);
        Comparable[] tab2 = new Comparable[list2.size()];
        list2.toArray(tab2);
        
        
        
        ArrayList<Comparable> list3 = new ArrayList<Comparable>();
        for(int i = 0 ; i < 300 ; i++)
            list3.add(300-i);
        
        Comparable[] tab3 = new Comparable[list3.size()];
        list3.toArray(tab3);
        
        InsertionSorter sorter1 = new InsertionSorter(tab1,"Insertion random");
        InsertionSorter sorter2 = new InsertionSorter(tab2,"Insertion ordered");
        InsertionSorter sorter3 = new InsertionSorter(tab3,"Insertion reversed");
        
        MultipleStateArrayTracer tracer = new MultipleStateArrayTracer(25L,true,1,sorter1,sorter3,sorter2);
        
    }
}