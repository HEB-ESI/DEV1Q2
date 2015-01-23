/*
 * TracerBidon.java
 *
 * Created on 26 octobre 2006, 14:51
 *
 */

package test;

import java.util.ArrayList;
import java.util.Random;
import sorters.InsertionSorter;
import sorters.graphics.StateArrayTracer;

/**
 * Example of use of the simple array tracer for insertion sort on
 * random arrays.
 * @author Absil Romain
 */
public class TracerRandom
{
    public static void main(String[] args)
    {
        ArrayList<Comparable> list = new ArrayList<Comparable>();
        ArrayList<Comparable> addList = new ArrayList<Comparable>();
        for(int i = 0 ; i < 400 ; i++)
           addList.add(i+1);
        
        for(int i = 399; i >= 0; i--)
        {
            Random r = new Random();
            int n = r.nextInt(i+1);
            list.add(addList.get(n));
            addList.remove(n);
        }
        Comparable[] tab2 = new Comparable[list.size()];
        list.toArray(tab2);
        
        InsertionSorter sorter = new InsertionSorter(tab2, "Insetion Random");
        StateArrayTracer tracer = new StateArrayTracer(sorter,25L,true);
        tracer.setVisible(true);
        
    }
}
