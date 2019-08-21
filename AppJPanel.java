/** AppJPanel.java */

package engmath;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author mikec
 */
public class AppJPanel extends JPanel implements ActionListener
{
    private String panelTitle = "Panel Title";
    JPanel top = new JPanel();
    JPanel center = new JPanel();
    JPanel bottom = new JPanel();
    JLabel title = new JLabel();

    protected static JButton calcB = new JButton("Calculate");
    protected static JButton clearB = new JButton("Clear All");
    protected static JButton ratioB = new JButton("Show Ratios");

    Color topColor = new Color(75, 75, 120);
    Color centerColor = new Color(170, 170, 170);

    Font courierB14 = new Font("courier", Font.BOLD, 14);
    Font courierB16 = new Font("courier", Font.BOLD, 16);

    public AppJPanel(String in)
    {
        title.setText(in);
        setup();
    }
    
    public AppJPanel() 
    { 
        title.setText(panelTitle);
        setup(); 
    }
    
    private void setup()
    {
        setLayout( new BorderLayout() );
        setBorder( new EtchedBorder() );
        
        title.setFont( courierB16 );
        title.setForeground( Color.yellow );
        
    	top.setBackground( topColor );
    	top.add(title);

    	center.setBackground( Color.darkGray );
    	center.setLayout( new BorderLayout() );

    	bottom.setBackground( Color.darkGray );
    	calcB.addActionListener(this);
    	clearB.addActionListener(this);
    	ratioB.addActionListener(this);
    	bottom.add(calcB);
    	bottom.add(clearB);
    	bottom.add(ratioB);
        
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    public void doCalc() { }
    public void doClear() { }
    public void showRatios() { }
    
    public static void enableRatiosButton( boolean flag ) { ratioB.setEnabled(flag); }
    
    public String getTitle() { return panelTitle; }
    public void setTitle(String t) 
    { 
    	panelTitle = t; 
    	title.setText(panelTitle);
    } 

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        if (cmd.equals("Calculate")) { doCalc(); }
        if (cmd.equals("Clear All")) { doClear(); }
        if (cmd.equals("Show Ratios")) { showRatios(); }
    }
}
