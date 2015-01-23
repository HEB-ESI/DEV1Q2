/*
 * AbstractArraySorter.java
 *
 * Created on 24 octobre 2006, 19:00
 *
 */

package sorters;

import javax.swing.event.EventListenerList;
import sorters.graphics.ArrayEvent;
import sorters.graphics.ArrayListener;

/**
 * This class models a AbstractArraySorter object that will be able to sort 
 * arrays according to subclasses implementing sort algorithms.
 * @param <T>
 * @author Absil Romain
 */
public abstract class AbstractArraySorter<T extends Comparable<T>>
{

    private T[] array;
    private String name;
    private Thread thread;
    protected EventListenerList listenerList = new EventListenerList();
    
    /**
     * Creates a new instance of sorter that will be able to sort arrays.
     * @param array the array to sort.
     **/
    public AbstractArraySorter(T[] array)
    {
        this(array, "");
    }

    /**
     * Creates a new instance of sorter that will be able to sort arrays.
     * @param array the array to sort.
     * @param name the name you want to give to the sorter. 
     * Used in {@link sorters.graphics.MultipleStateArrayTracer}
     * @see sorters.graphics.StateArrayTracer
     * @see sorters.graphics.MultipleStateArrayTracer
     **/
    public AbstractArraySorter(T[] array, String name)
    {
        this.array = array;
        this.name = name;
    }
    
    /**
     * Returns the array you want to sort.
     * @return the array you want to sort.
     **/
    public T[] getArray()
    {
        return array;
    }

    /**
     * Sets the array to sort.
     * @param array the new array to sort.
     **/
    public void setArray(T[] array)
    {
        this.thread = null;
        System.gc();
        this.array = array;
    }
    
    /**
     * Returns the name of the sorter.
     * @return the name of the sorter.
     * @see sorters.graphics.MultipleStateArrayTracer
     **/
    public String getName()
    {
        return name;
    }
    
    /**
     * Sets the name of the sorter.
     * @param name the name of the sorter.
     * @see sorters.graphics.MultipleStateArrayTracer
     **/
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Returns the thread on wich the sort algorithm is executed.
     * @return the thread on wich the sort algorithm is executed.
     **/
    public Thread getThread()
    {
        return thread;
    }
    
    /**
     * Sets the element of the given index of the array to the given value.
     * @param index the element you want to set.
     * @param object the new value of the element.
     **/
    public void set(int index, T object)
    {
        array[index] = object;
        if(listenerList.getListenerCount() != 0)
            fireArrayEvent(new ArrayEvent(array, index, false));
    }
    
    /**
     * Swaps two given datas in tha array.
     * @param i the first data to exchange.
     * @param j the second data to exchange.
     **/
    public void swap(int i, int j)
    {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        if(listenerList.getListenerCount() != 0)
            fireArrayEvent(new ArrayEvent(array, i, true));
    }
    
    /**
     * Sorts the array according to a sort algorithm. 
     * Must be overriden in subclasses.
     **/
    public abstract void sort();
    
    /**
     * Sorts the array according to a sort algorithm.
     * @param thread true if you want to sort the array on a separated thread,
     * false otherwise.
     **/
    public void sort(boolean thread)
    {
        if(!thread)
            sort();
        else
        {
            Runnable r = new Runnable()
            {
                public void run()
                {
                    sort();
                }
            };
            this.thread = new Thread(r);
            this.thread.start();
        }
    }
    
    /**
     * Adds a listener to the sorter.
     * @param listener the listeenr to add to the sorter.
     **/
    public void addArrayListener(ArrayListener listener)
    {
        listenerList.add(ArrayListener.class, listener);
    }
    
    /**
     * Removes a listener to the sorter.
     * @param listener the listener to remove.
     **/
    public void removeArrayListener(ArrayListener listener)
    {
        listenerList.remove(ArrayListener.class, listener);
    }
    
    /**
     * Returns the listeners of the sorter.
     * @return the listeners of the sorter.
     **/
    public EventListenerList getArrayListeners()
    {
        return listenerList;
    }
    
    /**
     * Removes all the listeners of the sorter.
     **/
    public void clearListeners()
    {
        listenerList = new EventListenerList();
    }
    
    /**
     * Launch the given event, wich will be caught by 
     * {@link sorters.graphics.ArrayListener#stateChanged}
     * @param event the event to launch.
     * @see sorters.graphics.ArrayListener#stateChanged
     **/
    protected void fireArrayEvent(ArrayEvent event)
    {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i+=2)
            if(listeners[i] == ArrayListener.class)
                ((ArrayListener)listeners[i+1]).stateChanged(event);
    }
}
