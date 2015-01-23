/*
 * FrameUtilities.java
 *
 * Created on 26 aout 2006, 21:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package sorters.graphics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JDialog;

/**
 * This simple class is useful for some graphical operation on components.
 * @author Absil Romain
 */
public class FrameUtilities
{
    /**
     * Center a frame on the screen.
     * @param frame the frame to center on the screen.
     **/
    public static void centerFrame(Frame frame)
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screen = kit.getScreenSize();
        frame.setLocation((int)((screen.getWidth() - frame.getWidth()) /2  ), 
                (int)((screen.getHeight() - frame.getHeight()) /2 ));
    }
    
    /**
     * Center a dialog box on a component.
     * @param frame the dialog to center.
     * @param parent to component on wich you want to center the frame.
     **/
    public static void centerFrame(JDialog frame, Component parent)    
    {
        Dimension screen = parent.getSize();
        int x = parent.getX();
        int y = parent.getY();
        frame.setLocation((int)(x + screen.getWidth() /2 - frame.getWidth() /2 ), 
                (int)( y + screen.getHeight() / 2 - frame.getHeight() /2 ));
    }
}
