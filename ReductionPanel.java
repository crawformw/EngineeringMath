/** ReductionPanel.java */

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
public class ReductionPanel extends AppJPanel implements ActionListener
{
    String heading = "REDUCTION IN AREA - EXTRUSION";
    NumberFormat formatter = new DecimalFormat("#.####");
    JPanel theCenter = new JPanel();
    int shape = 1;
    int solveFor = 0;
    
    private static final int ROUND_BAR = 1;
    private static final int HEX_BAR = 2;
    
    static final int ORIGINAL = 1;
    static final int EXTRUDED = 2;
    static final int REDUCTION = 3;
    static final int DISTANCE = 4;

    private CalcPad cPad = new CalcPad();
    JPanel col2 = new JPanel();
    JPanel col3 = new JPanel();
    
    JPanel combo1 = new JPanel();
    JPanel combo2 = new JPanel();
    JPanel combo3 = new JPanel();
    
    JPanel combo4 = new JPanel();
    JPanel combo5 = new JPanel();
    JPanel combo6 = new JPanel();
    JPanel combo7 = new JPanel();
    
    ButtonGroup bGroup_shape = new ButtonGroup();
    ButtonGroup bGroup_solve = new ButtonGroup();

    JRadioButton round = new JRadioButton("Round");
    JRadioButton hex = new JRadioButton("Hex");
    
    JRadioButton originalDiameter = new JRadioButton("Solve For");
    JRadioButton extrudedDiameter = new JRadioButton("Solve For");
    JRadioButton desiredReduction = new JRadioButton("Solve For");
    JRadioButton distanceAcrossFlat = new JRadioButton("Solve For");

    JButton lparm1 = new JButton("Original Dia >>>");
    JButton lparm2 = new JButton("Extruded Dia >>>");
    JButton lparm3 = new JButton("Desired Reduct >>>");
    JButton lparm4 = new JButton("Dist Across Flat >>>");
    
    JLabel lheading1 = new JLabel("Extruded", JLabel.RIGHT);
    JLabel lheading2 = new JLabel("Shape", JLabel.LEFT);

    JLabel tparm1 = new JLabel();
    JLabel tparm2 = new JLabel();
    JLabel tparm3 = new JLabel();
    JLabel tparm4 = new JLabel();

    JLabel answer1 = new JLabel();
    JLabel answer2 = new JLabel();
    
    public ReductionPanel()
    {
        super();
        setup();
    }

    private void setup()
    {
        theCenter.setLayout( new GridLayout(1, 3, 5, 5) );
        theCenter.setBackground(Color.darkGray);
        setTitle(heading);
        
        col2.setLayout( new GridLayout(11,1,2,2));
        col2.setBackground(Color.lightGray);
        col2.setBorder(new EtchedBorder());
        
        col3.setLayout( new GridLayout(11,1,2,2));
        col3.setBackground(Color.lightGray);
        col3.setBorder(new EtchedBorder());

        round.addActionListener(this);
        round.setBackground(Color.lightGray);
        round.setActionCommand("round");
        round.setHorizontalAlignment(SwingConstants.RIGHT);
        
        hex.addActionListener(this);
        hex.setBackground(Color.lightGray);
        hex.setActionCommand("hex");
        
        originalDiameter.addActionListener(this);
        originalDiameter.setBackground(Color.lightGray);
        originalDiameter.setActionCommand("original");
        originalDiameter.setHorizontalAlignment(SwingConstants.RIGHT);
        
        extrudedDiameter.addActionListener(this);
        extrudedDiameter.setBackground(Color.lightGray);
        extrudedDiameter.setActionCommand("extruded");
        extrudedDiameter.setHorizontalAlignment(SwingConstants.RIGHT);
        
        desiredReduction.addActionListener(this);
        desiredReduction.setBackground(Color.lightGray);
        desiredReduction.setActionCommand("reduction");
        desiredReduction.setHorizontalAlignment(SwingConstants.RIGHT);
        
        distanceAcrossFlat.addActionListener(this);
        distanceAcrossFlat.setBackground(Color.lightGray);
        distanceAcrossFlat.setActionCommand("distance");
        distanceAcrossFlat.setHorizontalAlignment(SwingConstants.RIGHT);
        
        
        // set parameter button characteristics
        lheading1.setForeground(Color.black);
        lheading2.setForeground(Color.black);
        
        lparm1.addActionListener(this);
        lparm2.addActionListener(this);
        lparm3.addActionListener(this);
        lparm4.addActionListener(this);
        
        lparm1.setForeground(Color.black);
        lparm2.setForeground(Color.black);
        lparm3.setForeground(Color.black);
        lparm4.setForeground(Color.black);
        
        answer1.setForeground(Color.blue);
        answer2.setForeground(Color.blue);
        
        tparm1.setOpaque(true);
        tparm2.setOpaque(true);
        tparm3.setOpaque(true);
        tparm4.setOpaque(true);
        
        tparm1.setBackground(Color.white);
        tparm2.setBackground(Color.white);
        tparm3.setBackground(Color.white);
        tparm4.setBackground(Color.white);

        lparm1.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm2.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm3.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm4.setHorizontalAlignment(SwingConstants.RIGHT);
        
        combo1.setLayout( new GridLayout(1,2,2,2));
        combo1.setBackground(Color.lightGray);
        combo1.add(lheading1);
        combo1.add(lheading2);

        combo2.setLayout( new GridLayout(1,2,2,2));
        combo2.setBackground(Color.lightGray);
        combo2.add(round);
        combo2.add(hex);
        
        bGroup_shape.add(round);
        bGroup_shape.add(hex);

        combo3.setLayout( new GridLayout(1,2,2,2));
        combo3.setBackground(Color.lightGray);
        combo3.add( new JLabel(" ") );
        combo3.add( new JLabel(" ") );
     
        combo4.setLayout( new GridLayout(1,2,2,2));
        combo4.setBackground(Color.lightGray);
        combo4.add( originalDiameter );
        combo4.add( lparm1 );
        
        combo5.setLayout( new GridLayout(1,2,2,2));
        combo5.setBackground(Color.lightGray);
        combo5.add( extrudedDiameter );
        combo5.add( lparm2 );
        
        combo6.setLayout( new GridLayout(1,2,2,2));
        combo6.setBackground(Color.lightGray);
        combo6.add( desiredReduction );
        combo6.add( lparm3 );
        
        combo7.setLayout( new GridLayout(1,2,2,2));
        combo7.setBackground(Color.lightGray);
        combo7.add( distanceAcrossFlat );
        combo7.add( lparm4 );
        
        bGroup_solve.add(originalDiameter);
        bGroup_solve.add(extrudedDiameter);
        bGroup_solve.add(desiredReduction);
        bGroup_solve.add(distanceAcrossFlat);

        col2.add(combo1);
        col2.add(combo2);
        col2.add(combo3);
        col2.add(combo4);
        col2.add(combo5);
        col2.add(combo6);
        col2.add(combo7);
        col2.add(new JLabel(" "));
        col2.add(new JLabel("Percentage Reduction in Area", JLabel.RIGHT));
        col2.add(new JLabel("(If Orig Length=1) The Extruded Length", JLabel.RIGHT));
        col2.add(new JLabel(" "));

        col3.add(new JLabel(" "));
        col3.add(new JLabel(" "));
        col3.add(new JLabel(" "));
        col3.add(tparm1);
        col3.add(tparm2);
        col3.add(tparm3);
        col3.add(tparm4);
        col3.add(new JLabel(" "));
        col3.add(answer1);
        col3.add(answer2);
        col3.add(new JLabel(" "));

        lparm1.setVisible(true);    tparm1.setVisible(true);
        lparm2.setVisible(false);   tparm2.setVisible(false);
        lparm3.setVisible(false);   tparm3.setVisible(false);
        lparm4.setVisible(false);   tparm4.setVisible(false);

        theCenter.add(cPad);
        theCenter.add(col2);
        theCenter.add(col3);
        EngMath.setCalcPad(cPad);
        
        AppJPanel.enableRatiosButton(false);
        add( theCenter, BorderLayout.CENTER );
        
        round.setSelected(true);
        showRoundBar();
        
        desiredReduction.setSelected(true);
        setSolveFor(lparm3, tparm3, REDUCTION);
    }

    public void showRoundBar()
    {
    	originalDiameter.setVisible(true);
        extrudedDiameter.setVisible(true);      lparm2.setVisible(true);
        desiredReduction.setVisible(true);      lparm3.setVisible(true);
        distanceAcrossFlat.setVisible(false);   lparm4.setVisible(false);
        
        tparm2.setVisible(true);
        tparm3.setVisible(true);
        tparm4.setVisible(false);
    }

    public void showHexBar()
    {
    	originalDiameter.setVisible(false);
    	extrudedDiameter.setVisible(false);     lparm2.setVisible(false);
    	desiredReduction.setVisible(false);     lparm3.setVisible(false);
    	distanceAcrossFlat.setVisible(false);   lparm4.setVisible(true);
        
        tparm2.setVisible(false);
        tparm3.setVisible(false);
        tparm4.setVisible(true);
    }
    
    public void setSolveFor(JButton lp, JLabel tp, int solve)
    {
    	switch( solveFor )
    	{
            case ORIGINAL	 	: tparm1.setForeground(Color.black); 	break;
            case EXTRUDED	 	: tparm2.setForeground(Color.black); 	break;
            case REDUCTION	 	: tparm3.setForeground(Color.black); 	break;
            case DISTANCE	 	: tparm4.setForeground(Color.black); 	break;
    	}
    	
    	solveFor = solve;
    	
    	doClear();
        
    	lparm1.setEnabled(true);
        lparm2.setEnabled(true);
        lparm3.setEnabled(true);
        lparm4.setEnabled(true);

        lp.setEnabled(false);
        tp.setForeground(Color.blue);
    }
    
    public void setFields(int inShape)
    {
    	doClear();
    	switch (inShape)
    	{
            case ROUND_BAR :    showRoundBar(); break;
            case HEX_BAR :	showHexBar();	break;
    	}
    }

    /** doClear() **/
    @Override
    public void doClear()
    {
        tparm1.setText("");
        tparm2.setText("");
        tparm3.setText("");
        tparm4.setText("");
        answer1.setText("");
        answer2.setText("");
    }
    
    public boolean validateData()
    {	
    	boolean flag = true;
    	
    	switch (shape)
    	{
            case ROUND_BAR:
                switch (solveFor)
                {
                    case ORIGINAL:
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

                    case EXTRUDED:
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

                    case REDUCTION:
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
                break;

            case HEX_BAR:
                if (tparm1.getText().length() == 0)     
                { 
                    tparm1.setText("** Required **");   
                    tparm1.setForeground(Color.red);      
                    flag = false; 
                }
                
                if (tparm4.getText().length() == 0)	
                { 
                    tparm4.setText("** Required **");   
                    tparm4.setForeground(Color.red);      
                    flag = false;
                }
            break;
    	}
    	return flag;
    }

    /** doCalc() **/
    @Override
    public void doCalc()
    {
    	Double O;
    	Double S;
    	Double X = null;
    	Double R;
    	
        Double L = null;
        Double A;
        Double B;
        
        if (validateData())
        {
            try
            {
                if ( shape == HEX_BAR )
                {
                    O = new Double( tparm1.getText() );		// Original Diameter
                    R = new Double( tparm4.getText() );		// Distance across the flat
                	
                    A = Math.PI * Math.pow((O / 2), 2.0);
                    B = 0.866 * Math.pow(R, 2.0);
                    X = 100.0 * (1.0 - B/A);
                    L = A / B;
                }
                else
                {
                    switch( solveFor )
                    {
                        case ORIGINAL:
                            S = new Double( tparm2.getText() );		// Extruded 
                            X = new Double( tparm3.getText() );		// Reduction

                            O = Math.sqrt(( 100.0 * Math.pow(S,2.0)) / (100.0 - X) );
                            L = Math.pow(O, 2) / Math.pow(S,2);

                            tparm1.setText( "   "+formatter.format(O) );
                            break;

                        case EXTRUDED:
                            O = new Double( tparm1.getText() );		// Original 
                            X = new Double( tparm3.getText() );		// Reduction

                            S = Math.sqrt( ( Math.pow(O, 2) * (100.0 - X) ) / 100.0 );
                            L = Math.pow(O, 2) / Math.pow(S,2);
                            tparm2.setText( "   "+formatter.format(S) );
                            break;

                        case REDUCTION:
                            O = new Double( tparm1.getText() );		// Original 
                            S = new Double( tparm2.getText() );		// Extruded 

                            X = 100.0 * ( 1.0 - ( Math.pow(S, 2) / Math.pow(O, 2) ) );
                            L = Math.pow(O, 2) / Math.pow(S,2);
                            tparm3.setText( "   "+formatter.format(X) );
                            break;
                    }
               }

               answer1.setText( "   "+formatter.format(X) );
               answer2.setText( "   "+formatter.format(L) );
               validate(); repaint();

            }
            catch (NumberFormatException nfe)   {  EngMath.showMessageDialog("Number Error Occured.\nCheck values entered."); }
            catch (Exception e)                 {  EngMath.showMessageDialog("Error Occured.\nPlease check values."); }
        }  
   }

   @Override
   public void actionPerformed(ActionEvent ea)
   {
        String cmd = ea.getActionCommand();
	   
       if (cmd.equals("round")) { shape = ROUND_BAR; setFields(shape); }
       if (cmd.equals("hex"))	{ shape = HEX_BAR; setFields(shape); }
       
       if ( cmd.equals("Calculate")) { doCalc(); }
       if ( cmd.equals("Clear All")) { doClear(); }
       
       if (cmd.equals("original")) 		{ setSolveFor(lparm1, tparm1, ORIGINAL); }
       if (cmd.equals("extruded")) 		{ setSolveFor(lparm2, tparm2, EXTRUDED); }
       if (cmd.equals("reduction")) 		{ setSolveFor(lparm3, tparm3, REDUCTION); }
       if (cmd.equals("distance")) 		{ setSolveFor(lparm4, tparm4, DISTANCE); }

       
       if ( ea.getSource().equals(lparm1)) { tparm1.setForeground(Color.black); tparm1.setText( "   "+cPad.getString() ); }
       if ( ea.getSource().equals(lparm2)) { tparm2.setForeground(Color.black); tparm2.setText( "   "+cPad.getString() ); }
       if ( ea.getSource().equals(lparm3)) { tparm3.setForeground(Color.black); tparm3.setText( "   "+cPad.getString() ); }
       if ( ea.getSource().equals(lparm4)) { tparm4.setForeground(Color.black); tparm4.setText( "   "+cPad.getString() ); }
       
       validate(); repaint(); 
   }
}