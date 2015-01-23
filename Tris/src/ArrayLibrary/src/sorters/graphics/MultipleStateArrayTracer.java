/*
 * MultipleStateArrayTracer.java
 *
 * Created on 5 novembre 2006, 17:46
 *
 */

package sorters.graphics;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import sorters.AbstractArraySorter;

/**
 * This class models a MultipleStateArrayTracer object that will be able to
 * display multiple array sorters in a single frame so that you can see and
 * compare the different sorting algorithms.
 * @author Absil Romain
 */
public class MultipleStateArrayTracer extends JFrame
{
    
    private ArrayList<AbstractArraySorter> sorters;
    private long millis;
    private JDesktopPane desktop;
    
    /**
     * Creates a new instance of MultipleArrayTracer that will be able to
     * display multiple array sorters in a single frame so that you can see and
     * compare the different sorting algorithms.
     * @param millis the time you want to sorting thread to wait between each
     * iteration of the algorithm; 25L is a good one.
     * @param toolbar if you want to display a simple toolbar with a start
     * button wich can start the sorting algorithms.
     * @param sorters the sorters to display.
     **/
    public MultipleStateArrayTracer(final long millis, boolean toolbar, int row,
            final AbstractArraySorter ... sorters)
    {
        this.millis = millis;
        this.desktop = new JDesktopPane();
        row = row <= sorters.length ? row : sorters.length;
        desktop.setLayout(new GridLayout(row,sorters.length / row));
        this.sorters = new ArrayList<AbstractArraySorter>();
        
        for(AbstractArraySorter e : sorters)
        {
            this.sorters.add(e);
            String title = e.getName() != null ? e.getName() : "";
            
            InternalArrayFrame frame = new InternalArrayFrame(title,e,millis);
            
            desktop.add(frame);
        }
        add(desktop);
        
        if(toolbar)
        {
            JMenuBar menuBar = new JMenuBar();
            JButton start = new JButton("Start");
            start.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    JInternalFrame[] iframes = desktop.getAllFrames();
                    for(int i = 0 ; i < sorters.length ; i++)
                    {
                        InternalArrayFrame frame = (InternalArrayFrame)iframes[i];
                        AbstractArraySorter sorter = sorters[i];
                        //sorter.setTracable(true);
                        final StateArrayPanel panel = frame.getPanel();
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
                }
            });
            menuBar.add(start);
            this.setJMenuBar(menuBar);
        }
        
        setTitle("State array tracer by Absil Romain - version 1.5");
        setSize(1024,768);
        FrameUtilities.centerFrame(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}

class InternalArrayFrame extends JInternalFrame
{
    
    private StateArrayPanel panel;
    
    public InternalArrayFrame(String title, AbstractArraySorter sorter, long millis)
    {
        super(title);
        this.panel = new StateArrayPanel(sorter,millis,false);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        reshape(0,0,100,200);
    }
    
    public StateArrayPanel getPanel()
    {
        return panel;
    }
}
