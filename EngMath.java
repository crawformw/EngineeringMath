/** EngMath.java */

package engmath;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mikec
 */
public class EngMath extends JFrame implements ActionListener
{
    JPanel buttonPanel = new JPanel();
    AppJPanel currentP = null;
    protected Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
    private static EngMath master = null;
    
    private static final String UPSET 			= "Upset Cone";
    private static final String REDUCTION 		= "Reduction In Area";
    private static final String CIRCULAR 		= "Circular Segment";
    private static final String RADIUS 			= "Radius-Angle";

    JButton button1 = new JButton(UPSET);
    JButton button2 = new JButton(REDUCTION);
    JButton button3 = new JButton(CIRCULAR);
    JButton button4 = new JButton(RADIUS);
    JButton endB = new JButton("DONE");
    
    protected static CalcPad currentCalcP = null;

    public static void main(String args[])
    {
        try
        {
           EngMath engP = new EngMath();
           master = engP;
           engP.validate();
           engP.setVisible(true);
        }
        catch(Exception e) { System.out.println("main routine - "+ e.toString()); }
    }

    public EngMath()
    {
        super("Engineering Math 2.1");
        
        init();
        centerInScreen();
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
    }

    private void init()
    {
       setBounds(0,0,1000,500);
       getContentPane().setLayout(new BorderLayout());
       setupButtonPanel();
       getContentPane().add(buttonPanel, BorderLayout.SOUTH);
       
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void doDone() { System.exit(0); }

    private void setupButtonPanel()
    {
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        endB.addActionListener(this);

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(endB);
    }

    /** centerInScreen() - method used to center the frame in the middle of the screen */
    private void centerInScreen()
    {
        Dimension dim = this.getToolkit().getScreenSize();
        Rectangle bounds = this.getBounds();
        this.setLocation( (dim.width - bounds.width) / 2, (dim.height - bounds.height) / 2);
        this.requestFocus();
    }
    
    /** setCalcPad() - called by each panel to pass in their Calc Pad so keyboard values can be added
     * @param inPad 
     */
    public static void setCalcPad(CalcPad inPad) { currentCalcP = inPad; }
    
    /** showMessageDialog() - mimics the JOptionPane call for Error messages only, allows everyone to access this
     * @param errText 
     */
    public static void showMessageDialog( String errText )
    {
        master.tk.beep();			// always beep first
        JOptionPane.showMessageDialog(master, errText, "Application Error Message", JOptionPane.ERROR_MESSAGE);
    }

    /** actionPerformed() - method handling when control buttons are pressed
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
       String cmd = e.getActionCommand();

       if (currentP != null) { getContentPane().remove(currentP); }

       if ( cmd.equals(UPSET) ) { currentP = new UpsetPanel(); }
       if ( cmd.equals(REDUCTION) ) { currentP = new ReductionPanel(); }
       if ( cmd.equals(CIRCULAR) ) { currentP = new CircularPanel(); }
       if ( cmd.equals(RADIUS) ) { currentP = new RadiusAnglePanel(); }
       if ( cmd.equals("DONE") ) { doDone(); }

       getContentPane().add(currentP, BorderLayout.CENTER);
       validate(); repaint();
    }
    
    private class MyDispatcher implements KeyEventDispatcher
    {
        @Override
    	public boolean dispatchKeyEvent(KeyEvent e)
    	{
            if (e.getID() == KeyEvent.KEY_TYPED) 
            { 
                if (currentCalcP != null) { currentCalcP.addToCalc(e.getKeyChar()); }
            }
            return false;
    	}
    }
}
