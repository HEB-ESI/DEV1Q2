/*
 * InsertionSorter.java
 *
 * Created on 24 octobre 2006, 19:06
 *
 */

package sorters;

/**
 * This class models a InsertionSorter object that will be able to sort 
 * arrays according to the insertion sort algorithm.
 * @author Absil Romain
 * @param <T>
 */
public class InsertionSorter<T extends Comparable<T>> extends AbstractArraySorter<T>
{
    /**
     * Creates a new instance of sorter that will be able to sort arrays 
     * according to the insertion sort algorithm.
     * @param array the array to sort.
     **/
    public InsertionSorter(T[] array)
    {
        super(array);
    }
    
    /**
     * Creates a new instance of sorter that will be able to sort arrays
     * according to the insertion sort algorithm.
     * @param array the array to sort.
     * @param name the name you want to give to the sorter. 
     * Used in {@link sorters.graphics.MultipleStateArrayTracer}
     * @see sorters.graphics.StateArrayTracer
     * @see sorters.graphics.MultipleStateArrayTracer
     **/
    public InsertionSorter(T[] array, String name)
    {
        super(array,name);
    }
    
    /**
     * Sorts the array according to the insertion sort algorithm.
     **/
    public void sort()
    {
        T[] a = super.getArray();
        for (int i = 1; i < a.length; i++)
        {
            T x = a[i];
            int j = i-1;
            for(; j >= 0 && a[j].compareTo(x) > 0 ; j--)
                set(j+1,a[j]);
            set(j+1,x);
        }
    }
}
