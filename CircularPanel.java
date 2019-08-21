/** CircularPanel.java */

package engmath;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author mikec
 */
public class CircularPanel extends AppJPanel implements ActionListener
{
    private String heading = "CIRCULAR SEGMENTS";
    NumberFormat formatter = new DecimalFormat("#.####");
    private JPanel theCenter = new JPanel();
    private int solveFor = 1;
    
    private String[] solveStrings = {"Chord Length >>>", "Arc Height >>>", "Segment Radius >>>"};
    
    private CalcPad cPad = new CalcPad();
    private JPanel col2 = new JPanel();
    private JPanel col3 = new JPanel();
    
    private JPanel combo1 = new JPanel();
    private JPanel combo2 = new JPanel();
    private JPanel combo3 = new JPanel();

    private ButtonGroup bGroup = new ButtonGroup();

    private JRadioButton chordLength = new JRadioButton("Solve For");
    private JRadioButton arcHeight = new JRadioButton("Solve For");
    private JRadioButton segmentRadius = new JRadioButton("Solve For");

    private JButton lparm1 = new JButton(solveStrings[0]);
    private JButton lparm2 = new JButton(solveStrings[1]);
    private JButton lparm3 = new JButton(solveStrings[2]);

    private JLabel tparm1 = new JLabel();
    private JLabel tparm2 = new JLabel();
    private JLabel tparm3 = new JLabel();
    

    /** CircularPanel() - main class constructor */
    public CircularPanel()
    {
    	super();
    	setup();	
    }

    private void setup()
    {
        theCenter.setLayout( new GridLayout(1, 3, 5, 5) );
    	theCenter.setBackground(Color.darkGray);
    	setTitle(heading);
        
    	// set Panel characteristics
        col2.setLayout( new GridLayout(11,1,2,2));
        col2.setBackground(Color.lightGray);
        col2.setBorder(new EtchedBorder());
        
        col3.setLayout( new GridLayout(11,1,2,2));
        col3.setBackground(Color.lightGray);
        col3.setBorder(new EtchedBorder());

        // set radio button characteristics
        chordLength.setBackground(Color.lightGray);
        arcHeight.setBackground(Color.lightGray);
        segmentRadius.setBackground(Color.lightGray);
        
        // set each radio button with an action listener
        chordLength.addActionListener(this);
        arcHeight.addActionListener(this);
        segmentRadius.addActionListener(this);
        
        // set the action command here,so we know which radio button gets selected
        chordLength.setActionCommand("chord");
        arcHeight.setActionCommand("arc");
        segmentRadius.setActionCommand("segment");
        
        chordLength.setHorizontalAlignment(SwingConstants.RIGHT);
        arcHeight.setHorizontalAlignment(SwingConstants.RIGHT);
        segmentRadius.setHorizontalAlignment(SwingConstants.RIGHT);
        
        tparm1.setOpaque(true);
        tparm2.setOpaque(true);
        tparm3.setOpaque(true);
        
        tparm1.setBackground(Color.white);
        tparm2.setBackground(Color.white);
        tparm3.setBackground(Color.white);

        // set parameter button characteristics
        lparm1.addActionListener(this);
        lparm2.addActionListener(this);
        lparm3.addActionListener(this);
        
        lparm1.setForeground(Color.black);
        lparm2.setForeground(Color.black);
        lparm3.setForeground(Color.black);
        
        lparm1.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm2.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm3.setHorizontalAlignment(SwingConstants.RIGHT);

        // add the radio buttons to the button group
        bGroup.add(chordLength);
        bGroup.add(arcHeight);
        bGroup.add(segmentRadius);
        
        combo1.setLayout( new GridLayout(1,2,2,2));
        combo1.setBackground(Color.lightGray);
        combo1.add(chordLength);
        combo1.add(lparm1);
        
        combo2.setLayout( new GridLayout(1,2,2,2));
        combo2.setBackground(Color.lightGray);
        combo2.add(arcHeight);
        combo2.add(lparm2);

        combo3.setLayout( new GridLayout(1,2,2,2));
        combo3.setBackground(Color.lightGray);
        combo3.add(segmentRadius);
        combo3.add(lparm3);

        // create the panel look by adding all the pieces to each
        col2.add(new JLabel(" "));
        col2.add(new JLabel(" "));
        col2.add(new JLabel(" "));
        col2.add(combo1);
        col2.add(combo2);
        col2.add(combo3);
        col2.add(new JLabel(" "));
        col2.add(new JLabel(" "));
        col2.add(new JLabel(" "));
        col2.add(new JLabel(" "));
        col2.add(new JLabel(" "));

        col3.add(new JLabel(" "));
        col3.add(new JLabel(" "));
        col3.add(new JLabel(" "));
        col3.add(tparm1);
        col3.add(tparm2);
        col3.add(tparm3);
        col3.add(new JLabel(" "));
        col3.add(new JLabel(" "));
        col3.add(new JLabel(" "));
        col3.add(new JLabel(" "));
        col3.add(new JLabel(" "));

        // add the calcPad and both panels to the center
        theCenter.add(cPad);
        theCenter.add(col2);
        theCenter.add(col3);
        
        EngMath.setCalcPad(cPad);
        
        AppJPanel.enableRatiosButton(false);
    	add( theCenter, BorderLayout.CENTER );
    	chordLength.setSelected(true);
        setSolveFor(lparm1, tparm1, 1);
    }
    
    /** validateData()
     * @return 
     */
    public boolean validateData()
    {
    	boolean flag = true;
    	
    	switch(solveFor)
    	{
            case 0: flag = false; break;
            case 1 :
                if (tparm2.getText().length() == 0) 
                { 
                    tparm2.setText("** Required **");     
                    tparm2.setForeground(Color.red);   
                    flag = false; 
                }
                
                if (tparm3.getText().length() == 0) 
                { 
                    tparm3.setText("** Required **");     
                    tparm3.setForeground(Color.red);    
                    flag = false;
                }
            break;

            case 2 :
                if (tparm1.getText().length() == 0) 
                { 
                    tparm1.setText("** Required **");     
                    tparm1.setForeground(Color.red);    
                    flag = false; 
                }
                
                if (tparm3.getText().length() == 0) 
                { 
                    tparm3.setText("** Required **");     
                    tparm3.setForeground(Color.red);    
                    flag = false; 
                }
            break;

            case 3 :
                if (tparm1.getText().length() == 0) 
                { 
                    tparm1.setText("** Required **");     
                    tparm1.setForeground(Color.red);    
                    flag = false; 
                }
                
                if (tparm2.getText().length() == 0) 
                { 
                    tparm2.setText("** Required **");     
                    tparm2.setForeground(Color.red);    
                    flag = false; 
                }
            break;
    	}
    	
    	return( flag );
    }

    /** doClear() **/
    @Override
    public void doClear()
    {
        tparm1.setText("");
        tparm2.setText("");
        tparm3.setText("");
    }
    
    /** setSolveFor() - determine which parameter will be solved
     * @param lp
     * @param tp
     * @param solve 
     */
    public void setSolveFor(JButton lp, JLabel tp, int solve)
    {
    	switch( solveFor )
    	{
            case 1	: tparm1.setForeground(Color.black); 	break;
            case 2	: tparm2.setForeground(Color.black); 	break;
            case 3 	: tparm3.setForeground(Color.black); 	break;
    	}
    	solveFor = solve;
    	
    	doClear();
    	
        lparm1.setEnabled(true);
        lparm2.setEnabled(true);
        lparm3.setEnabled(true);
        
        lp.setEnabled(false);
        tp.setForeground(Color.blue);
     }

     /** doCalc() **/
    @Override
    public void doCalc()
    {    	
        Double C;
        Double H;
        Double R;
        Double D;
        Double M;
        Double S;

        if (validateData() )
        {
            try
            {
                switch(solveFor)
                {
                    case 0: break;
                    case 1:
                        H = new Double( tparm2.getText() );
                        R = new Double( tparm3.getText() );
                        D = 2.0 * Math.sqrt( H * ( ( 2.0 * R ) - H ) );

                        tparm1.setText( "   "+formatter.format(D) );
                        validate();    repaint();
                        break;

                    case 2:
                        C = new Double( tparm1.getText() );
                        R = new Double( tparm3.getText() );
                        M = R - 0.5 * Math.sqrt( (4.0 * Math.pow(R, 2)) - Math.pow(C, 2) );
                        
                        tparm2.setText( "   "+formatter.format(M) );
                        validate(); 	repaint();
                        break;

                    case 3:
                        H = new Double( tparm2.getText() );
                        C = new Double( tparm1.getText() );
                        S = ( Math.pow(C, 2) + 4.0 * Math.pow(H, 2) ) / (8.0 * H);
                        
                        tparm3.setText( "   "+formatter.format(S) );
                        validate(); 	repaint();
                        break;

                }
            }
            catch (NumberFormatException nfe)   { EngMath.showMessageDialog("Number Error Occured.\nCheck values entered."); }
            catch (Exception e)                 { EngMath.showMessageDialog("Error Occured.\nPlease check values."); }
        }
    }
     
    @Override
     public void actionPerformed(ActionEvent ea)
     {
         String cmd = ea.getActionCommand();

     	if (cmd.equals("chord")) 	{ setSolveFor(lparm1, tparm1, 1); }
    	if (cmd.equals("arc"))  	{ setSolveFor(lparm2, tparm2, 2); }
        if (cmd.equals("segment")) 	{ setSolveFor(lparm3, tparm3, 3); }
         
        if (cmd.equals("Calculate")) { doCalc(); }
        if (cmd.equals("Clear All")) { doClear(); }

        if ( ea.getSource().equals(lparm1)) { tparm1.setForeground(Color.black); tparm1.setText( "   "+cPad.getString() ); }
        if ( ea.getSource().equals(lparm2)) { tparm2.setForeground(Color.black); tparm2.setText( "   "+cPad.getString() ); }
        if ( ea.getSource().equals(lparm3)) { tparm3.setForeground(Color.black); tparm3.setText( "   "+cPad.getString() ); }
         
        validate(); repaint();
     }

}
