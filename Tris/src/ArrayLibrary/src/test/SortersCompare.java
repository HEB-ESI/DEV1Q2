/*
 * TracerAudrey.java
 *
 * Created on 9 novembre 2006, 13:08
 *
 */

package test;

import java.util.ArrayList;
import java.util.Random;
import sorters.BubbleSorter;
import sorters.HeapSorter;
import sorters.InsertionSorter;
import sorters.PermutationSorter;
import sorters.graphics.MultipleStateArrayTracer;

/**
 * Compares sort algorithms on random arrays or the bubble, permutation, 
 * insertion and heap sort algorithms.
 * @author Absil Romain
 */
public class SortersCompare
{
    public static void main(String[] args)
    {
        ArrayList<Comparable<Integer>> list = new ArrayList<Comparable<Integer>>();
        ArrayList<Comparable<Integer>> addList = new ArrayList<Comparable<Integer>>();
        for(int i = 0 ; i < 300 ; i++)
           addList.add(i+1);
        
        for(int i = 299; i >= 0; i--)
        {
            Random r = new Random();
            int n = r.nextInt(i+1);
            list.add(addList.get(n));
            addList.remove(n);
        }
        Comparable<Integer>[] tab1 = new Comparable[list.size()];
        list.toArray(tab1);
        
        Comparable<Integer>[] tab2 = new Comparable[tab1.length];
        for (int i = 0; i < tab2.length; i++)
            tab2[i] = tab1[i];
        
        Comparable<Integer>[] tab3 = new Comparable[tab1.length];
        for (int i = 0; i < tab3.length; i++)
            tab3[i] = tab1[i];
        
        Comparable<Integer>[] tab4 = new Comparable[tab1.length];
        for (int i = 0; i < tab4.length; i++)
            tab4[i] = tab1[i];
        
        InsertionSorter sorter1 = new InsertionSorter(tab1,"Insertion sort");
        BubbleSorter sorter2 = new BubbleSorter(tab2,"Bubble sort");
        PermutationSorter sorter3 = new PermutationSorter(tab3,"Permutation sort");
        HeapSorter sorter4 = new HeapSorter(tab4,"Heap sort");
        
        MultipleStateArrayTracer tracer = new MultipleStateArrayTracer(10L,true
                ,1,sorter4,sorter1,sorter2,sorter3);
        
    }
}
