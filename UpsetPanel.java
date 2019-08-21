/** UpsetPanel.java */

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
public class UpsetPanel extends AppJPanel implements ActionListener
{
    String heading = "CONE UPSET CALCULATIONS";
    NumberFormat formatter = new DecimalFormat("#.####");
    JPanel theCenter = new JPanel();
    int solveFor = 0;
    
    private CalcPad cPad = new CalcPad();
    private JPanel col2 = new JPanel();
    private JPanel col3 = new JPanel();
    
    private JPanel combo1 = new JPanel();
    private JPanel combo2 = new JPanel();
    private JPanel combo3 = new JPanel();
    private JPanel combo4 = new JPanel();
    private JPanel combo5 = new JPanel();
    private JPanel combo6 = new JPanel();
    private JPanel combo7 = new JPanel();

    private ButtonGroup bGroup = new ButtonGroup();

    static final int SMALL_END = 1;
    static final int BIG_END = 2;
    static final int CONE_HEIGHT = 3;
    static final int DIA_STRAIGHT = 4;
    static final int LEN_STRAIGHT = 5;
    static final int VOLUME = 6;

    JRadioButton smallEndDia = new JRadioButton("Solve For");
    JRadioButton bigEndDia = new JRadioButton("Solve For");
    JRadioButton coneHeight = new JRadioButton("Solve For");
    JRadioButton diaOfStraight = new JRadioButton("Solve For");
    JRadioButton lengthOfStraight = new JRadioButton("Solve For");
    JRadioButton volume = new JRadioButton("Solve For");

    JButton lparm1 = new JButton("Small Diameter >>>");
    JButton lparm2 = new JButton("Big Diameter >>>");
    JButton lparm3 = new JButton("Cone Height >>>");
    JButton lparm4 = new JButton("Dia. of Straight >>>");
    JButton lparm5 = new JButton("Len. of Straight >>>");
    JButton lparm6 = new JButton("Volume >>>");
    JButton lparm7 = new JButton("Blank Diameter >>>");

    JLabel ratio1 = new JLabel("");
    JLabel ratio2 = new JLabel("");
    JLabel ratio3 = new JLabel("");

    JLabel blankHeading = new JLabel("Blank Length for this Diameter");
    JLabel blankAnswer = new JLabel(" ");

    JLabel tparm1 = new JLabel();
    JLabel tparm2 = new JLabel();
    JLabel tparm3 = new JLabel();
    JLabel tparm4 = new JLabel();
    JLabel tparm5 = new JLabel();
    JLabel tparm6 = new JLabel();
    JLabel tparm7 = new JLabel();
        
    public UpsetPanel()
    {
        super();
        setup();
    }

    private void setup()
    {
        theCenter.setLayout(new GridLayout(1, 3, 5, 5));
        theCenter.setBackground(Color.darkGray);
        setTitle(heading);
        
    	col2.setLayout(new GridLayout(11, 1, 5, 2));
    	col2.setBackground(Color.lightGray);
    	col2.setBorder(new EtchedBorder());
    	
    	col3.setLayout(new GridLayout(11, 1, 5, 2));
    	col3.setBackground(Color.lightGray);
        col3.setBorder(new EtchedBorder());

        smallEndDia.addActionListener(this);
        bigEndDia.addActionListener(this);
        coneHeight.addActionListener(this);
        diaOfStraight.addActionListener(this);
        lengthOfStraight.addActionListener(this);
        volume.addActionListener(this);

        smallEndDia.setActionCommand("small");
        bigEndDia.setActionCommand("big");
        coneHeight.setActionCommand("cone");
        diaOfStraight.setActionCommand("dia");
        lengthOfStraight.setActionCommand("length");
        volume.setActionCommand("volume");
        
        smallEndDia.setBackground(Color.lightGray);
        bigEndDia.setBackground(Color.lightGray);
        coneHeight.setBackground(Color.lightGray);
        diaOfStraight.setBackground(Color.lightGray);
        lengthOfStraight.setBackground(Color.lightGray);
        volume.setBackground(Color.lightGray);
        
        smallEndDia.setHorizontalAlignment(SwingConstants.RIGHT);
        bigEndDia.setHorizontalAlignment(SwingConstants.RIGHT);
        coneHeight.setHorizontalAlignment(SwingConstants.RIGHT);
        diaOfStraight.setHorizontalAlignment(SwingConstants.RIGHT);
        lengthOfStraight.setHorizontalAlignment(SwingConstants.RIGHT);
        volume.setHorizontalAlignment(SwingConstants.RIGHT);

        lparm1.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm2.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm3.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm4.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm5.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm6.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm7.setHorizontalAlignment(SwingConstants.RIGHT);
        blankHeading.setHorizontalAlignment(SwingConstants.RIGHT);

        lparm1.setForeground(Color.black);
        lparm2.setForeground(Color.black);
        lparm3.setForeground(Color.black);
        lparm4.setForeground(Color.black);
        lparm5.setForeground(Color.black);
        lparm6.setForeground(Color.black);
        lparm7.setForeground(Color.black);
        
        tparm1.setOpaque(true);
        tparm2.setOpaque(true);
        tparm3.setOpaque(true);
        tparm4.setOpaque(true);
        tparm5.setOpaque(true);
        tparm6.setOpaque(true);
        tparm7.setOpaque(true);
        
        tparm1.setBackground(Color.white);
        tparm2.setBackground(Color.white);
        tparm3.setBackground(Color.white);
        tparm4.setBackground(Color.white);
        tparm5.setBackground(Color.white);
        tparm6.setBackground(Color.white);
        tparm7.setBackground(Color.white);
        
        lparm1.addActionListener(this);
        lparm2.addActionListener(this);
        lparm3.addActionListener(this);
        lparm4.addActionListener(this);
        lparm5.addActionListener(this);
        lparm6.addActionListener(this);
        lparm7.addActionListener(this);
        
        ratio1.setForeground(Color.blue);
        ratio2.setForeground(Color.blue);
        ratio3.setForeground(Color.blue);

        bGroup.add(smallEndDia);
        bGroup.add(bigEndDia);
        bGroup.add(coneHeight);
        bGroup.add(diaOfStraight);
        bGroup.add(lengthOfStraight);
        bGroup.add(volume);
        
        combo1.setLayout( new GridLayout(1,2,2,2));
        combo1.setBackground(Color.lightGray);
        combo1.add(smallEndDia);
        combo1.add(lparm1);
        
        combo2.setLayout( new GridLayout(1,2,2,2));
        combo2.setBackground(Color.lightGray);
        combo2.add(bigEndDia);
        combo2.add(lparm2);

        combo3.setLayout( new GridLayout(1,2,2,2));
        combo3.setBackground(Color.lightGray);
        combo3.add(coneHeight);
        combo3.add(lparm3);
        
        combo4.setLayout( new GridLayout(1,2,2,2));
        combo4.setBackground(Color.lightGray);
        combo4.add(diaOfStraight);
        combo4.add(lparm4);
        
        combo5.setLayout( new GridLayout(1,2,2,2));
        combo5.setBackground(Color.lightGray);
        combo5.add(lengthOfStraight);
        combo5.add(lparm5);
        
        combo6.setLayout( new GridLayout(1,2,2,2));
        combo6.setBackground(Color.lightGray);
        combo6.add(volume);
        combo6.add(lparm6);
        
        combo7.setLayout( new GridLayout(1,2,2,2));
        combo7.setBackground(Color.lightGray);
        combo7.add(new JLabel(" "));
        combo7.add(lparm7);

        col2.add(combo1);
        col2.add(combo2);
        col2.add(combo3);
        col2.add(combo4);
        col2.add(combo5);
        col2.add(combo6);
        col2.add(combo7);
        col2.add(blankHeading);
        col2.add(new JLabel(" "));
        col2.add(new JLabel(" "));
        col2.add(new JLabel(" "));

        col3.add(tparm1);
        col3.add(tparm2);
        col3.add(tparm3);
        col3.add(tparm4);
        col3.add(tparm5);
        col3.add(tparm6);
        col3.add(tparm7);
        col3.add(blankAnswer);
        col3.add(ratio1);
        col3.add(ratio2);
        col3.add(ratio3);

        theCenter.add(cPad);
        theCenter.add(col2);
        theCenter.add(col3);
        EngMath.setCalcPad(cPad);
        
        AppJPanel.enableRatiosButton(true);
        add(theCenter, BorderLayout.CENTER);
        
        smallEndDia.setSelected(true);
        setSolveFor(lparm1, tparm1, SMALL_END);
    }

    public void setSolveFor(JButton lp, JLabel tp, int solve)
    {
    	switch( solveFor )
    	{
            case SMALL_END	 	: tparm1.setForeground(Color.black); 	break;
            case BIG_END	 	: tparm2.setForeground(Color.black); 	break;
            case CONE_HEIGHT            : tparm3.setForeground(Color.black); 	break;
            case DIA_STRAIGHT           : tparm4.setForeground(Color.black); 	break;
            case LEN_STRAIGHT           : tparm5.setForeground(Color.black); 	break;
            case VOLUME 		: tparm6.setForeground(Color.black); 	break;
    	}
    	
    	solveFor = solve;
    	
    	doClear();
        
    	lparm1.setEnabled(true);
        lparm2.setEnabled(true);
        lparm3.setEnabled(true);
        lparm4.setEnabled(true);
        lparm5.setEnabled(true);
        lparm6.setEnabled(true);

        lp.setEnabled(false);
        tp.setForeground(Color.blue);
    }

    /** doClear() **/
    @Override
    public void doClear()
    {
        tparm1.setText("");
        tparm2.setText("");
        tparm3.setText("");
        tparm4.setText("");
        tparm5.setText("");
        tparm6.setText("");
        tparm7.setText("");
        blankAnswer.setText("");
        ratio1.setText("");
        ratio2.setText("");
        ratio3.setText("");
    }

    /** showRatios **/
    @Override
    public void showRatios()
    {
        Double AA;
        Double AB;
        Double AC;

        if (tparm1.getText().length() > 0)
        {
            Double B = new Double(tparm1.getText());

            AA = B * 1.2;
            AB = B * 1.3;
            AC = B * 1.4;

            ratio1.setText("   1.2 B = " + formatter.format(AA) );
            ratio2.setText("   1.3 B = " + formatter.format(AB) );
            ratio3.setText("   1.4 B = " + formatter.format(AC) );

            validate();  repaint();
        }
    }
    
    /** validateData()
     * @return 
     */
    public boolean validateData()
    {
    	boolean flag = true;
    	
    	switch(solveFor)
    	{
            case SMALL_END :
                if (tparm2.getText().length() == 0)     
                { tparm2.setText("** Required **");   tparm2.setForeground(Color.red); flag = false; }
                
                if (tparm3.getText().length() == 0)	
                { tparm3.setText("** Required **");   tparm3.setForeground(Color.red); flag = false; }
                
                if (tparm4.getText().length() == 0)	
                { tparm4.setText("** Required **");   tparm4.setForeground(Color.red); flag = false; }
                
                if (tparm5.getText().length() == 0)	
                { tparm5.setText("** Required **");   tparm5.setForeground(Color.red); flag = false; }
                
                if (tparm6.getText().length() == 0)	
                { tparm6.setText("** Required **");   tparm6.setForeground(Color.red); flag = false; }
                
                if (tparm7.getText().length() == 0)	
                { tparm7.setText("** Required **");   tparm7.setForeground(Color.red); flag = false; }
            break;

            case BIG_END :
                if (tparm1.getText().length() == 0)     
                { tparm1.setText("** Required **");   tparm1.setForeground(Color.red); flag = false; }
                
                if (tparm3.getText().length() == 0)	
                { tparm3.setText("** Required **");   tparm3.setForeground(Color.red); flag = false; }
                
                if (tparm4.getText().length() == 0)	
                { tparm4.setText("** Required **");   tparm4.setForeground(Color.red); flag = false; }
                
                if (tparm5.getText().length() == 0)	
                { tparm5.setText("** Required **");   tparm5.setForeground(Color.red); flag = false; }
                
                if (tparm6.getText().length() == 0)	
                { tparm6.setText("** Required **");   tparm6.setForeground(Color.red); flag = false; }
                
                if (tparm7.getText().length() == 0)	
                { tparm7.setText("** Required **");   tparm7.setForeground(Color.red); flag = false; }
            break;

            case CONE_HEIGHT :
                if (tparm1.getText().length() == 0)     
                { tparm1.setText("** Required **");   tparm1.setForeground(Color.red); flag = false; }
                
                if (tparm2.getText().length() == 0)	
                { tparm2.setText("** Required **");   tparm2.setForeground(Color.red); flag = false; }
                
                if (tparm4.getText().length() == 0)	
                { tparm4.setText("** Required **");   tparm4.setForeground(Color.red); flag = false; }
                
                if (tparm5.getText().length() == 0)	
                { tparm5.setText("** Required **");   tparm5.setForeground(Color.red); flag = false; }
                
                if (tparm6.getText().length() == 0)	
                { tparm6.setText("** Required **");   tparm6.setForeground(Color.red); flag = false; }
                
                if (tparm7.getText().length() == 0)	
                { tparm7.setText("** Required **");   tparm7.setForeground(Color.red); flag = false; }
            break;

            case DIA_STRAIGHT :
                if (tparm1.getText().length() == 0)     
                { tparm1.setText("** Required **");   tparm1.setForeground(Color.red); flag = false; }
                
                if (tparm2.getText().length() == 0)	
                { tparm2.setText("** Required **");   tparm2.setForeground(Color.red); flag = false; }
                
                if (tparm3.getText().length() == 0)	
                { tparm3.setText("** Required **");   tparm3.setForeground(Color.red); flag = false; }
                
                if (tparm5.getText().length() == 0)	
                { tparm5.setText("** Required **");   tparm5.setForeground(Color.red); flag = false; }
                
                if (tparm6.getText().length() == 0)	
                { tparm6.setText("** Required **");   tparm6.setForeground(Color.red); flag = false; }
                
                if (tparm7.getText().length() == 0)	
                { tparm7.setText("** Required **");   tparm7.setForeground(Color.red); flag = false; }
            break;

            case LEN_STRAIGHT :
                if (tparm1.getText().length() == 0)     
                { tparm1.setText("** Required **");   tparm1.setForeground(Color.red); flag = false; }
                
                if (tparm2.getText().length() == 0)	
                { tparm2.setText("** Required **");   tparm2.setForeground(Color.red); flag = false; }
                
                if (tparm3.getText().length() == 0)	
                { tparm3.setText("** Required **");   tparm3.setForeground(Color.red); flag = false; }
                
                if (tparm4.getText().length() == 0)	
                { tparm4.setText("** Required **");   tparm4.setForeground(Color.red); flag = false; }
                
                if (tparm6.getText().length() == 0)	
                { tparm6.setText("** Required **");   tparm6.setForeground(Color.red); flag = false; }
                
                if (tparm7.getText().length() == 0)	
                { tparm7.setText("** Required **");   tparm7.setForeground(Color.red); flag = false; }
            break;

            case VOLUME :
                if (tparm1.getText().length() == 0)     
                { tparm1.setText("** Required **");   tparm1.setForeground(Color.red); flag = false; }
                
                if (tparm2.getText().length() == 0)	
                { tparm2.setText("** Required **");   tparm2.setForeground(Color.red); flag = false; }
                
                if (tparm3.getText().length() == 0)	
                { tparm3.setText("** Required **");   tparm3.setForeground(Color.red); flag = false; }
                
                if (tparm4.getText().length() == 0)	
                { tparm4.setText("** Required **");   tparm4.setForeground(Color.red); flag = false; }
                
                if (tparm5.getText().length() == 0)	
                { tparm5.setText("** Required **");   tparm5.setForeground(Color.red); flag = false; }
                
                if (tparm7.getText().length() == 0)	
                { tparm7.setText("** Required **");   tparm7.setForeground(Color.red); flag = false; }
            break;
    	}
    	
    	return( flag );
    }

    /** doCalc() **/
    @Override
    public void doCalc()
    {
        Double A;
        Double B;
        Double H;
        Double D;
        Double L;
        Double V;
        Double M;

        Double Q;
        Double N;
        
        if ( validateData() )
        {
            try
            {
                switch (solveFor)
                {
                    case SMALL_END :
                        B = new Double(tparm2.getText());
                        H = new Double(tparm3.getText());
                        D = new Double(tparm4.getText());
                        L = new Double(tparm5.getText());
                        V = new Double(tparm6.getText());
                        M = new Double(tparm7.getText());

                        Q = ((V - (Math.PI * Math.pow(D / 2.0, 2.0) - Math.pow(B, 2.0)) * L) / (.2618 * H)) - Math.pow(B, 2.0);
                        A = (Math.sqrt(Math.pow(B, 2.0) + 4.0 * Q) - B) / 2.0;
                        N = V / (Math.PI * Math.pow(M / 2.0, 2.0));

                        tparm1.setText("   "+formatter.format(A));
                        blankAnswer.setText("   "+formatter.format(N));
                        validate(); repaint();
                        break;

                    case BIG_END :
                        A = new Double(tparm1.getText());
                        H = new Double(tparm3.getText());
                        D = new Double(tparm4.getText());
                        L = new Double(tparm5.getText());
                        V = new Double(tparm6.getText());
                        M = new Double(tparm7.getText());

                        Q = ((V - (Math.PI * Math.pow(D / 2.0, 2.0) * L)) / (.2618 * H)) - Math.pow(A, 2.0);
                        B = (Math.sqrt(Math.pow(A, 2.0) + 4.0 * Q) - A) / 2.0;
                        N = V / (Math.PI * Math.pow(M / 2.0, 2.0));

                        tparm2.setText( "   "+formatter.format(B) );
                        blankAnswer.setText( "   "+formatter.format(N) );
                        validate();  repaint();
                        break;

                    case CONE_HEIGHT :
                        A = new Double(tparm1.getText());
                        B = new Double(tparm2.getText());
                        D = new Double(tparm4.getText());
                        L = new Double(tparm5.getText());
                        V = new Double(tparm6.getText());
                        M = new Double(tparm7.getText());

                        H = (V - Math.pow(D / 2.0, 2.0) * L) / (.2618 * (Math.pow(A, 2.0) + A * B + Math.pow(B, 2.0)));
                        N = V / (Math.PI * Math.pow(M / 2.0, 2.0));

                        tparm3.setText( "   "+formatter.format(H) );
                        blankAnswer.setText( "   "+formatter.format(N) );
                        validate();  repaint();
                        break;

                    case DIA_STRAIGHT :
                        A = new Double(tparm1.getText());
                        B = new Double(tparm2.getText());
                        H = new Double(tparm3.getText());
                        L = new Double(tparm5.getText());
                        V = new Double(tparm6.getText());
                        M = new Double(tparm7.getText());

                        D = Math.sqrt( (4.0 * (V - .2618 * H * (Math.pow(A, 2.0) + A * B + Math.pow(B, 2.0)) / (Math.PI * L))));
                        N = V / (Math.PI * Math.pow(M / 2.0, 2.0));

                        tparm4.setText( "   "+formatter.format(D) );
                        blankAnswer.setText( "   "+formatter.format(N) );
                        validate();  repaint();
                        break;

                    case LEN_STRAIGHT :
                        A = new Double(tparm1.getText());
                        B = new Double(tparm2.getText());
                        H = new Double(tparm3.getText());
                        D = new Double(tparm4.getText());
                        V = new Double(tparm6.getText());
                        M = new Double(tparm7.getText());

                        L = (V - (.2618 * H) * (Math.pow(A, 2.0) + A * B + Math.pow(B, 2.0))) / (Math.PI * Math.pow(D / 2.0, 2.0));
                        N = V / (Math.PI * Math.pow(M / 2.0, 2.0));

                        tparm5.setText( "   "+formatter.format(L) );
                        blankAnswer.setText( "   "+formatter.format(N) );
                        validate(); repaint();
                        break;

                    case VOLUME :
                        A = new Double(tparm1.getText());
                        B = new Double(tparm2.getText());
                        H = new Double(tparm3.getText());
                        D = new Double(tparm4.getText());
                        L = new Double(tparm5.getText());
                        M = new Double(tparm7.getText());

                        V =  (Math.PI * Math.pow(D / 2.0, 2.0) * L) + (.2618 * H * (Math.pow(A, 2.0) + A * B + Math.pow(B, 2.0)));
                        N = V / (Math.PI * Math.pow(M / 2.0, 2.0));

                        tparm6.setText( "   "+formatter.format(V) );
                        blankAnswer.setText( "   "+formatter.format(N) );
                        validate(); repaint();
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
      
      if (cmd.equals("Calculate")) 		{ doCalc(); }
      if (cmd.equals("Clear All")) 		{ doClear(); }
      if (cmd.equals("Show Ratios"))            { showRatios(); }
      if (cmd.equals("small")) 			{ setSolveFor(lparm1, tparm1, SMALL_END); }
      if (cmd.equals("big")) 			{ setSolveFor(lparm2, tparm2, BIG_END); }
      if (cmd.equals("cone")) 			{ setSolveFor(lparm3, tparm3, CONE_HEIGHT); }
      if (cmd.equals("dia")) 			{ setSolveFor(lparm4, tparm4, DIA_STRAIGHT); }
      if (cmd.equals("length")) 		{ setSolveFor(lparm5, tparm5, LEN_STRAIGHT);  }
      if (cmd.equals("volume")) 		{ setSolveFor(lparm6, tparm6, VOLUME); }
      
      if ( ea.getSource().equals(lparm1)) { tparm1.setForeground(Color.black); tparm1.setText( "   "+cPad.getString() ); }
      if ( ea.getSource().equals(lparm2)) { tparm2.setForeground(Color.black); tparm2.setText( "   "+cPad.getString() ); }
      if ( ea.getSource().equals(lparm3)) { tparm3.setForeground(Color.black); tparm3.setText( "   "+cPad.getString() ); }
      if ( ea.getSource().equals(lparm4)) { tparm4.setForeground(Color.black); tparm4.setText( "   "+cPad.getString() ); }
      if ( ea.getSource().equals(lparm5)) { tparm5.setForeground(Color.black); tparm5.setText( "   "+cPad.getString() ); }
      if ( ea.getSource().equals(lparm6)) { tparm6.setForeground(Color.black); tparm6.setText( "   "+cPad.getString() ); }
      if ( ea.getSource().equals(lparm7)) { tparm7.setForeground(Color.black); tparm7.setText( "   "+cPad.getString() ); }
   
      validate(); repaint();
   }
}
