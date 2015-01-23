/*
 * ArrayEvent.java
 *
 * Created on 3 novembre 2006, 8:07
 *
 */

package sorters.graphics;

import java.util.EventObject;
import java.util.List;

/**
 * This class models a semantic event which indicates that a array-defined 
 * action occurred. This high-level event is generated by an sorter 
 * (such as a {@link sorters.AbstractArraySorter}) when the array-specific 
 * action occurs (such as state changing). The event is passed to every 
 * ArrayListener object that registered to receive such events using the 
 * sorter's {@link sorters.AbstractArraySorter#addArrayListener} method.
 * @author Absil Romain
 */
public class ArrayEvent extends EventObject
{
    private int i;
    private boolean exchange;
    
    /**
     * Creates a new ArrayEvent object.
     * @param array tha source of the event.
     * @param i the index the event occured.
     **/
    public ArrayEvent(int[] array, int i, boolean exchange)
    {
        super(array);
        this.i = i;
        this.exchange = exchange;
    }
    
    /**
     * Creates a new ArrayEvent object.
     * @param array tha source of the event.
     * @param i the index the event occured.
     **/
    public ArrayEvent(double[] array, int i, boolean exchange)
    {
        super(array);
        this.i = i;
        this.exchange = exchange;
    }
    
    /**
     * Creates a new ArrayEvent object.
     * @param array tha source of the event.
     * @param i the index the event occured.
     **/
    public ArrayEvent(float[] array, int i, boolean exchange)
    {
        super(array);
        this.i = i;
        this.exchange = exchange;
    }
    
    /**
     * Creates a new ArrayEvent object.
     * @param array tha source of the event.
     * @param i the index the event occured.
     **/
    public ArrayEvent(long[] array, int i, boolean exchange)
    {
        super(array);
        this.i = i;
        this.exchange = exchange;
    }
    
    /**
     * Creates a new ArrayEvent object.
     * @param array tha source of the event.
     * @param i the index the event occured.
     **/
    public ArrayEvent(short[] array, int i, boolean exchange)
    {
        super(array);
        this.i = i;
        this.exchange = exchange;
    }
    
    /**
     * Creates a new ArrayEvent object.
     * @param array tha source of the event.
     * @param i the index the event occured.
     **/
    public ArrayEvent(byte[] array, int i, boolean exchange)
    {
        super(array);
        this.i = i;
        this.exchange = exchange;
    }
    
    /**
     * Creates a new ArrayEvent object.
     * @param array tha source of the event.
     * @param i the index the event occured.
     **/
    public ArrayEvent(Object[] array, int i, boolean exchange)
    {
        super(array);
        this.i = i;
        this.exchange = exchange;
    }
    
    /**
     * Creates a new ArrayEvent object.
     * @param array tha source of the event.
     * @param i the index the event occured.
     **/
    public ArrayEvent(List array, int i, boolean exchange)
    {
        super(array);
        this.i = i;
        this.exchange = exchange;
    }
    
    /**
     * Returs the index the event occurs.
     * @return the index the event occurs.
     **/
    public int getIndex()
    {
        return i;
    }
    
    public boolean isExchange()
    {
        return exchange;
    }
}
