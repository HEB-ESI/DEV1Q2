/*
 * PermutationSorter.java
 *
 * Created on 4 novembre 2006, 12:36
 *
 */

package sorters;

/**
 * This class models a InsertionSorter object that will be able to sort 
 * arrays according to the permutation sort algorithm.
 * @author Absil Romain
 */
public class PermutationSorter<T extends Comparable<T>> extends AbstractArraySorter<T>
{
    /**
     * Creates a new instance of sorter that will be able to sort arrays 
     * according to the permutation sort algorithm.
     * @param array the array to sort.
     **/
    public PermutationSorter(T[] array)
    {
        super(array);
    }
    
    /**
     * Creates a new instance of sorter that will be able to sort arrays
     * according to the permutation sort algorithm.
     * @param array the array to sort.
     * @param name the name you want to give to the sorter. 
     * Used in {@link sorters.graphics.MultipleStateArrayTracer}
     * @see sorters.graphics.StateArrayTracer
     * @see sorters.graphics.MultipleStateArrayTracer
     **/
    public PermutationSorter(T[] array, String name)
    {
        super(array, name);
    }
    
    /**
     * Sorts the array according to the permutation sort algorithm.
     **/
    public void sort()
    {
        T[] array = super.getArray();
        for(int i = 0 ; i < array.length -1; i++)
        {
            int min = i;
            for(int j = i+1 ; j < array.length; j++)
            {
                set(j,array[j]); //necessaire pour affichage correct
                if(array[min].compareTo(array[j]) > 0)
                    min = j;
            }
            swap(i,min);
        }
    }
}
