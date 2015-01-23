/*
 * ArrayListener.java
 *
 * Created on 3 novembre 2006, 8:18
 *
 */

package sorters.graphics;

import java.util.EventListener;

/**
 * The listener interface for receiving array events. The class that is 
 * interested in processing an array event implements this interface, and the 
 * object created with that class is registered with an array sorter, using the 
 * sorter's {@link sorters.AbstractArraySorter#addArrayListener} method. When 
 * the array event occurs, that object's stateChanged method is invoked.
 * @author Absil Romain
 */
public interface ArrayListener extends EventListener
{
    /**
     * Invoked when the event occurs.
     * @param event the occured event.
     **/
    public void stateChanged(ArrayEvent event);
}
