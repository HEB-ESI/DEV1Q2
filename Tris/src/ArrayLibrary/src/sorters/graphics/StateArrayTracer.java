/*
 * StateArrayTracer.java
 *
 * Created on 27 octobre 2006, 19:58
 *
 */

package sorters.graphics;

import javax.swing.JFrame;
import sorters.AbstractArraySorter;

/**
 * This class models a StateArrayTracer object that will be able to
 * @author Absil Romain
 * @version 1.5
 */
public class StateArrayTracer extends JFrame
{

    private Comparable[] array;
    private StateArrayPanel panel;
    private AbstractArraySorter sorter;
    
    /**
     * Creates a new instance of StateArrayTracer that will be able to 
     * display arrays.
     * @param millis the time you want to sorting thread to wait between each 
     * iteration of the algorithm; 25L is a good one.
     * @param toolbar if you want to display a simple toolbar with a start 
     * button wich can start the sorting algorithms.
     * @param sorter the sorter to display.
     */
    public StateArrayTracer(AbstractArraySorter sorter, long millis, 
            boolean toolbar)
    {
        this.array = sorter.getArray();
        this.sorter = sorter;
        this.panel = new StateArrayPanel(sorter, millis, toolbar);
        add(panel);
        
        setTitle("State array tracer by Absil Romain - version 1.5");
        setSize(array.length * 2 + 50, array.length * 2 + 50);
        FrameUtilities.centerFrame(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Returns the array you want to display in the frame.
     * @return the array you want to display in the frame.
     **/
    public Comparable[] getArray()
    {
        return array;
    }

    /**
     * Sets the array to display in the frame.
     * @param array the array to set.
     **/
    public void setArray(Comparable[] array)
    {
        this.array = array;
        panel.setArray(array);
        panel.repaint();
    }

    /**
     * Returns the panel of the frame, i.e. the componet in wich the array 
     * is displayed.
     * @return the panel of the frame, i.e. the componet in wich the array 
     * is displayed.
     **/
    public StateArrayPanel getPanel()
    {
        return panel;
    }

    /**
     * Returns the sorter you want to display in the frame.
     * @return the sorter you want to display in the frame.
     **/
    public AbstractArraySorter getSorter()
    {
        return sorter;
    }
}
