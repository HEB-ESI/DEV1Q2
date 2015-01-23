/*
 * TracerBidonNatural.java
 *
 * Created on 26 octobre 2006, 15:23
 *
 */

package test;

import java.util.ArrayList;
import sorters.InsertionSorter;
import sorters.graphics.StateArrayTracer;
/**
 * Example of use of the simple array tracer for insertion sort on
 * ordered arrays.
 * @author Absil Romain
 */
public class TracerNatural
{
    public static void main(String[] args)
    {
        ArrayList<Comparable> list = new ArrayList<Comparable>();
        for(int i = 0 ; i < 400 ; i++)
            list.add(i+1);
        
        Comparable[] tab2 = new Comparable[list.size()];
        list.toArray(tab2);
        
        InsertionSorter sorter = new InsertionSorter(tab2,"Insertion Natural");
        
        StateArrayTracer tracer = new StateArrayTracer(sorter,25L,true);
        tracer.setVisible(true);
    }
}
