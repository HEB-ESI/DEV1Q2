/*
 * BubbleSorter.java
 *
 * Created on 4 novembre 2006, 12:20
 *
 */

package sorters;

/**
 * This class models a BubbleSorter object that will be able to sort arrays 
 * according to the bubble sort algorithm.
 * @author Absil Romain
 * @param <T>
 */
public class BubbleSorter<T extends Comparable<T>> extends AbstractArraySorter<T>
{
    /**
     * Creates a new instance of sorter that will be able to sort arrays 
     * according to the bubble sort algorithm.
     * @param array the array to sort.
     **/
    public BubbleSorter(T[] array)
    {
        super(array);
    }
    
    /**
     * Creates a new instance of sorter that will be able to sort arrays 
     * according to the bubble sort algorithm.
     * @param array the array to sort.
     * @param name the name you want to give to the sorter. 
     * Used in {@link sorters.graphics.MultipleStateArrayTracer}
     * @see sorters.graphics.StateArrayTracer
     * @see sorters.graphics.MultipleStateArrayTracer
     **/
    public BubbleSorter(T[] array, String name)
    {
        super(array, name);
    }
    
    /**
     * Sorts the array according to the bubble sort algorithm.
     **/
    public void sort()
    {
        T[] array = super.getArray();
        for (int i = array.length - 1; i >= 0; i--)
            for (int j = 0; j < i; j++)
                if(array[j].compareTo(array[j+1]) >= 0)
                    swap(j,j+1);
    }
    
}
