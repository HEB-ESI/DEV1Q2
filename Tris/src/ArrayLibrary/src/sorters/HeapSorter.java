/*
 * HeapSorter2.java
 *
 * Created on 8 fevrier 2007, 20:46
 *
 */

package sorters;

/**
 * This class models a HeapSorter object that will be able to sort arrays
 * according to the heap sort algorithm.
 * @author Absil Romain
 * @param <T>
 */
public class HeapSorter<T extends Comparable<T>> extends AbstractArraySorter<T>
{
    private int heapsize;
    
    /**
     * Creates a new instance of sorter that will be able to sort arrays 
     * according to the heap sort algorithm.
     * @param array the array to sort.
     **/
    public HeapSorter(T[] array)
    {
        super(array);
        this.heapsize = array.length;                
    }
    
    /**
     * Creates a new instance of sorter that will be able to sort arrays
     * according to the heap sort algorithm.
     * @param array the array to sort.
     * @param name the name you want to give to the sorter. 
     * Used in {@link sorters.graphics.MultipleStateArrayTracer}
     * @see sorters.graphics.StateArrayTracer
     * @see sorters.graphics.MultipleStateArrayTracer
     **/
    public HeapSorter(T[] array, String name)
    {
        super(array,name);
        this.heapsize = array.length;
    }
    
    /**
     * Sorts the array according to the insertion sort algorithm.
     **/
    public void sort()
    {
        T[] array = super.getArray();
        
        buildheap(array);
        
        for (int i = array.length - 1; i >= 1; i--)
        {
            swap(0,i);
            heapsize--;
            heapify(array,0);
        }
    }
    
    /**
     * Build a heap with the given array, by ordering its elements to maintain
     * an heap property.
     * @param array the array you want to build an heap with.
     **/
    public void buildheap(T[] array)
    {
        for (int i = heapsize / 2; i >= 0; i--)
            heapify(array,i);
    }
    
    /**
     * Maintain the heap property on the given array for the element indexed
     * by the given index, i.e. assumed that the subtree rooted by the indexed
     * node is an heap.
     * @param array the array you want the heap property to be maintained for
     * the indexed element.
     * @param i the index of the element under wich you want the heap property
     * to be maintained.
     **/
    public void heapify(T[] array, int i)
    {
        boolean done = false;
        while(!done)
        {
            int indexleft = 2 * i + 1;
            int indexright = 2 * i + 2;
            int largest;
            
            if(indexleft < heapsize && 
                    array[indexleft].compareTo(array[i]) > 0)
                largest = indexleft;
            else
                largest = i;
            
            if(indexright < heapsize && 
                    array[indexright].compareTo(array[largest]) > 0)
                largest = indexright;
            
            if(i != largest)
            {
                swap(i, largest);
                i = largest;
            }
            else
                done = true;
        }
    }    
}
