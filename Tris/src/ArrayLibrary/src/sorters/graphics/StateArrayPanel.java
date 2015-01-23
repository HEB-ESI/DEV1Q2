/*
 * StateArrayPanel.java
 *
 * Created on 27 octobre 2006, 19:59
 *
 */

package sorters.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import sorters.AbstractArraySorter;
import sorters.graphics.ArrayEvent;
import sorters.graphics.ArrayListener;
import sorters.InsertionSorter;

/**
 * This class models a StateArrayPanel object that will be able to be displayed
 * in a frame and to draw an array encapsuled by a sorter object.
 * @author Absil Romain
 */
public class StateArrayPanel extends JPanel
{

    private int current;
    private int last;
    private Comparable[] array;
    private long millis;
    private AbstractArraySorter sorter;
    //private Thread sorterThread;
    
    /**
     * Creates a new instance of StateArrayPanel that will draw an array.
     * @param sorter the sorter you will display on the panel.
     * @param millis the time you want to sorting thread to wait between each 
     * iteration of the algorithm; 25L is a good one.
     * @param toolbar if you want to display a simple toolbar with a start 
     * button wich can start the sorting algorithms.
     **/
    public StateArrayPanel(AbstractArraySorter sorter, long millis, boolean toolbar)
    {
        this.sorter = sorter;
        this.array = sorter.getArray();
        this.current = 0;
        this.last = 0;
        this.millis = millis;
        //this.sorterThread = null;
        if(toolbar)
        {
            TracerToolBar toolBar = new TracerToolBar(this);
            add(toolBar);
        }
    }
    
    /**
     * Sets the current element of the panel, i.e. the element that just has 
     * been modified in the array.
     * @param i the index of the element.
     **/
    public void setCurrent(int i)
    {
        current = i;
    }
    
    /**
     * Gets the current element of the panel, i.e. the element that just has 
     * been modified in the array.
     * @return the index of the element.
     **/
    public int getCurrent()
    {
        return current;
    }
    
    /**
     * Sets the last element of the array that has been analysed, i.e. the 
     * index of the last sorted element in the array.
     * @param i the index of the element.
     **/
    public void setLast(int i)
    {
        last = i;
    }
    
    /**
     * Returns the last element of the array that has been analysed, i.e. the 
     * index of the last sorted element in the array.
     **/
    public int getLast()
    {
        return last;
    }
    
    /**
     * Returns the array displayed in the panel.
     * @return the array displayed in the panel.
     **/
    public Comparable[] getArray()
    {
        return array;
    }

    /**
     * Sets the array displayed in the panel.
     * @param array the new array to set.
     **/
    public void setArray(Comparable[] array)
    {
        this.array = array;
        sorter.setArray(array);
        setCurrent(0);
        setLast(0);
        repaint();
    }
    
    /**
     * Sets the time you want to sorting thread to wait between each 
     * iteration of the algorithm; 25L is a good one.
     * @param millis the time you want to sorting thread to wait between each 
     * iteration of the algorithm; 25L is a good one.
     **/
    public void setMillis(long millis)
    {
        this.millis = millis;
    }
    
    /**
     * Returns the time you want to sorting thread to wait between each 
     * iteration of the algorithm; 25L is a good one.
     * @return the time you want to sorting thread to wait between each 
     * iteration of the algorithm; 25L is a good one.
     **/
    public long getMillis()
    {
        return millis;
    }
    
    /**
     * Returns the sorter displayed in the panel.
     * @return the sorter displayed in the panel.
     **/
    public AbstractArraySorter getSorter()
    {
        return sorter;
    }
    
    /**
     * Launch the sorting of the array on a separated thread.
     **/
    public void initSorting()
    {
        sorter.sort(true);
    }
    
    /**
     * Displays the array on the panel.
     * @param g the graphics on wich you will display the array.
     **/
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        for (int i = 0; i < array.length ; i++)
        {
            if(i == current)
                g2.setColor(java.awt.Color.RED);
            else if(i == last)
                g2.setColor(java.awt.Color.BLUE);
            else
                g2.setColor(java.awt.Color.BLACK);
            g2.drawLine(0,40 + i * 2 , array[i].hashCode(), 40 + i * 2);
        }
    }

}

class TracerToolBar extends JToolBar
{
    private Comparable[] array;
    private StateArrayPanel panel;
    private final long millis;
    private AbstractArraySorter sorter;
    public TracerToolBar(final StateArrayPanel panel)
    {
        this.array = panel.getArray();
        this.panel = panel;
        this.millis = panel.getMillis();
        this.sorter = panel.getSorter();
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               sorter.addArrayListener(new ArrayListener()
               {
                    public void stateChanged(ArrayEvent event)
                    {
                        panel.setCurrent(event.getIndex());
                        if(panel.getLast() < event.getIndex())
                            panel.setLast(event.getIndex());
                        panel.repaint();
                        try
                        {
                            if(!event.isExchange())
                                Thread.sleep(millis);
                            else
                                Thread.sleep((long)(millis * 1.5));
                        }
                        catch(Exception e)
                        {}
                    }
               });
               panel.initSorting();
           }
        });
        add(start);
        
        add(new Separator());
        
        JButton random = new JButton("Random Array");
        random.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sorter.clearListeners();
                ArrayList<Comparable> list = new ArrayList<Comparable>();
                ArrayList<Comparable> addList = new ArrayList<Comparable>();
                for(int i = 0 ; i < array.length ; i++)
                    addList.add(i+1);
                
                for(int i = array.length - 1; i >= 0; i--)
                {
                    Random r = new Random();
                    int n = r.nextInt(i+1);
                    list.add(addList.get(n));
                    addList.remove(n);
                }
                Comparable[] newarray = new Comparable[list.size()];
                list.toArray(newarray);
                panel.setArray(newarray);
            }
        });
        add(random);
        
        JButton ordered = new JButton("Natural Array");
        ordered.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sorter.clearListeners();
                ArrayList<Comparable> list = new ArrayList<Comparable>();
                for(int i = 0 ; i < 400 ; i++)
                    list.add(i+1);
                Comparable[] newarray = new Comparable[list.size()];
                list.toArray(newarray);
                panel.setArray(newarray);
            }
        });
        add(ordered);
        
        JButton reversed = new JButton("Reversed Array");
        reversed.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sorter.clearListeners();
                ArrayList<Comparable> list = new ArrayList<Comparable>();
                for(int i = 0 ; i < 400 ; i++)
                    list.add(400-i);
                Comparable[] newarray = new Comparable[list.size()];
                list.toArray(newarray);
                panel.setArray(newarray);
            }
        });
        add(reversed);
    }
}
