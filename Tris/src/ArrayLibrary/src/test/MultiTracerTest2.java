/*
 * MultiTracerTest2.java
 *
 * Created on 7 novembre 2006, 12:41
 *
 */

package test;

import java.util.ArrayList;
import java.util.Random;
import sorters.BubbleSorter;
import sorters.InsertionSorter;
import sorters.graphics.MultipleStateArrayTracer;

/**
 * Example of use of the multiple array tracer for comparing the insertion
 * and the bubble sort algorithm for some arrays.
 * @author Absil Romain
 */
public class MultiTracerTest2
{
    public static void main(String[] args)
    {
        ArrayList<Comparable<Integer>> list = new ArrayList<Comparable<Integer>>();
        ArrayList<Comparable<Integer>> addList = new ArrayList<Comparable<Integer>>();
        for(int i = 0 ; i < 150 ; i++) // 100 -> 400
           addList.add(i+1);
        
        for(int i = 149; i >= 0; i--) //99 -> 399
        {
            Random r = new Random();
            int n = r.nextInt(i+1);
            list.add(addList.get(n));
            addList.remove(n);
        }
        Comparable<Integer>[] tab1 = new Comparable[list.size()];
        list.toArray(tab1);
        
        ArrayList<Comparable<Integer>> list2 = new ArrayList<Comparable<Integer>>();
        for(int i = 0 ; i < 150 ; i++)
            list2.add(i+1);
        Comparable<Integer>[] tab2 = new Comparable[list2.size()];
        list2.toArray(tab2);
        
        
        
        ArrayList<Comparable<Integer>> list3 = new ArrayList<Comparable<Integer>>();
        for(int i = 0 ; i < 150 ; i++)
            list3.add(150-i);
        
        Comparable<Integer>[] tab3 = new Comparable[list3.size()];
        list3.toArray(tab3);
        
        Comparable<Integer>[] tab4 = new Comparable[tab1.length];
        for(int i = 0 ; i < tab1.length ; i++)
            tab4[i] = tab1[i];
        
        Comparable<Integer>[] tab5 = new Comparable[tab2.length];
        for(int i = 0 ; i < tab2.length ; i++)
            tab5[i] = tab2[i];
        
        Comparable<Integer>[] tab6 = new Comparable[tab3.length];
        for(int i = 0 ; i < tab3.length ; i++)
            tab6[i] = tab3[i];
        
        
        InsertionSorter sorter1 = new InsertionSorter(tab1,"Insertion random");
        InsertionSorter sorter2 = new InsertionSorter(tab2,"Insertion ordered");
        InsertionSorter sorter3 = new InsertionSorter(tab3,"Insertion reversed");
        
        BubbleSorter sorter4 = new BubbleSorter(tab4,"Bubble random");
        BubbleSorter sorter5 = new BubbleSorter(tab5,"Bubble ordered");
        BubbleSorter sorter6 = new BubbleSorter(tab6,"Bubble reversed");
        
        MultipleStateArrayTracer tracer = new MultipleStateArrayTracer(25L,true
                ,2,sorter1,sorter3,sorter2,sorter4,sorter6,sorter5);
    }
}
