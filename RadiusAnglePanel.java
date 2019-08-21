/** RadiusAnglePanel.java */

package engmath;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author mikec
 */
public class RadiusAnglePanel extends AppJPanel implements ActionListener
{
     String heading = "RADIUS-ANGLE INTERSECTION";
     NumberFormat formatter = new DecimalFormat("#.####");
     JPanel theCenter = new JPanel();

     CalcPad cPad = new CalcPad();
     JPanel col2 = new JPanel();
     JPanel col3 = new JPanel();
     
     JPanel combo1 = new JPanel();
     JPanel combo2 = new JPanel();
     JPanel combo3 = new JPanel();
     JPanel combo4 = new JPanel();
     JPanel combo5 = new JPanel();

     JButton lparm1 = new JButton("Head Diameter >>>");
     JButton lparm2 = new JButton("Shank Diameter >>>");
     JButton lparm3 = new JButton("Angle Per Side >>>");
     JButton lparm4 = new JButton("Part Radius >>>");
     JButton lparm5 = new JButton("Tool Radius >>>");

     JLabel tparm1 = new JLabel();
     JLabel tparm2 = new JLabel();
     JLabel tparm3 = new JLabel();
     JLabel tparm4 = new JLabel();
     JLabel tparm5 = new JLabel();

     JLabel answer1 = new JLabel();
     JLabel answer2 = new JLabel();
     JLabel answer3 = new JLabel();
     JLabel answer4 = new JLabel();
     
     /** RadiusAnglePanel() - main class constructor calls superclass first */
     public RadiusAnglePanel()
     {
    	 super();
    	 setup();
    	 build();
     }

     /** setup() - setup layouts, backgrounds, text color, etc... */
     private void setup()
     {
        setTitle(heading);
    	AppJPanel.enableRatiosButton(false);
         
        col2.setLayout( new GridLayout(11,1,2,2));
        col3.setLayout( new GridLayout(11,1,2,2));

        col2.setBorder(new EtchedBorder());
        col3.setBorder(new EtchedBorder());
        
        col2.setBackground(Color.lightGray);
        col3.setBackground(Color.lightGray);

        lparm1.setForeground(Color.black);
        lparm2.setForeground(Color.black);
        lparm3.setForeground(Color.black);
        lparm4.setForeground(Color.black);
        lparm5.setForeground(Color.black);
        
        answer1.setForeground(Color.blue);
        answer2.setForeground(Color.blue);
        answer3.setForeground(Color.blue);
        answer4.setForeground(Color.blue);

        lparm1.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm2.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm3.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm4.setHorizontalAlignment(SwingConstants.RIGHT);
        lparm5.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lparm1.addActionListener(this);
        lparm2.addActionListener(this);
        lparm3.addActionListener(this);
        lparm4.addActionListener(this);
        lparm5.addActionListener(this);
        
        tparm1.setOpaque(true);
        tparm2.setOpaque(true);
        tparm3.setOpaque(true);
        tparm4.setOpaque(true);
        tparm5.setOpaque(true);
        
        tparm1.setBackground(Color.white);
        tparm2.setBackground(Color.white);
        tparm3.setBackground(Color.white);
        tparm4.setBackground(Color.white);
        tparm5.setBackground(Color.white);
        
        combo1.setLayout( new GridLayout(1,2,2,2));
        combo1.setBackground(Color.lightGray);
        combo1.add( new JLabel(" ") );
        combo1.add(lparm1);
        
        combo2.setLayout( new GridLayout(1,2,2,2));
        combo2.setBackground(Color.lightGray);
        combo2.add( new JLabel(" ") );
        combo2.add(lparm2);        

        combo3.setLayout( new GridLayout(1,2,2,2));
        combo3.setBackground(Color.lightGray);
        combo3.add( new JLabel(" ") );
        combo3.add(lparm3);        

        combo4.setLayout( new GridLayout(1,2,2,2));
        combo4.setBackground(Color.lightGray);
        combo4.add( new JLabel(" ") );
        combo4.add(lparm4);        

        combo5.setLayout( new GridLayout(1,2,2,2));
        combo5.setBackground(Color.lightGray);
        combo5.add( new JLabel(" ") );
        combo5.add(lparm5);        
        
        col2.add(new JLabel(" "));
        col2.add(combo1);
        col2.add(combo2);
        col2.add(combo3);
        col2.add(combo4);
        col2.add(combo5);
        col2.add(new JLabel("Large Diameter ", JLabel.RIGHT));
        col2.add(new JLabel("End of the Angle ", JLabel.RIGHT));
        col2.add(new JLabel("End of the Radius ", JLabel.RIGHT));
        col2.add(new JLabel("Program Radius ", JLabel.RIGHT));
        col2.add(new JLabel(" "));

        col3.add(new JLabel(" "));
        col3.add(tparm1);
        col3.add(tparm2);
        col3.add(tparm3);
        col3.add(tparm4);
        col3.add(tparm5);
        col3.add(answer1);
        col3.add(answer2);
        col3.add(answer3);
        col3.add(answer4);
        col3.add(new JLabel(" "));

     }
     
     /** build() - build the panel look */
     private void build()
     {
         theCenter.setLayout( new GridLayout(1, 3, 5, 5) );
         theCenter.setBackground(Color.darkGray);
         theCenter.add(cPad);
         theCenter.add(col2);
         theCenter.add(col3);
         
         add( theCenter, BorderLayout.CENTER );
         EngMath.setCalcPad(cPad);
         validate(); repaint();
     }
     
     /** validateData()
      * @return 
      */
     public boolean validateData()
     {
     	boolean flag = true;
     	
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
     	
        if (tparm3.getText().length() == 0) 
        { 
            tparm3.setText("** Required **");     
            tparm3.setForeground(Color.red);    
            flag = false; 
        }
     	
        if (tparm4.getText().length() == 0) 
        { 
            tparm4.setText("** Required **");     
            tparm4.setForeground(Color.red);    
            flag = false; 
        }
     	
        if (tparm5.getText().length() == 0) 
        { 
            tparm5.setText("** Required **");     
            tparm5.setForeground(Color.red);    
            flag = false; 
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
        tparm4.setText("");
        tparm5.setText("");
        answer1.setText("");
        answer2.setText("");
        answer3.setText("");
        answer4.setText("");
    }
     
     /** doCalc() **/
         @Override
     public void doCalc()
     {
        Double W;
        Double y;
        Double X;
        Double S;
        Double T;
        Double Q;
        Double U;
        Double V;
        Double E;
        
        if ( validateData() )
        {
            try
            {
                Double A = new Double( tparm1.getText() );
                Double B = new Double( tparm2.getText() );
                Double C = new Double( tparm3.getText() );
                Double R = new Double( tparm4.getText() );
                Double D = new Double( tparm5.getText() );

                W = 0.0174533 * C;
                y = 2.0 * R * Math.sin( W / 2);
                X = (Math.pow(y, 2.0) / 2.0) / R;
                S = D * (1.0 - Math.cos(W));
                T = D * (1.0 - Math.sin(W));
                Q = R - D;
                U = B + 2.0 * (X - S);
                V = ((A - U) / 2.0) / Math.tan(W);
                E = V + T - D + (X / Math.tan(W / 2.0));

                answer1.setText( "     X: " +formatter.format(A) );
                answer2.setText( "     X: " +formatter.format(U)+ "      Z: " +formatter.format(V) );
                answer3.setText( "     X: " +formatter.format(B)+ "      Z: " +formatter.format(E) );
                answer4.setText( "        " +formatter.format(Q) );

                validate(); repaint();

            } 
            catch (NumberFormatException nfe)   { EngMath.showMessageDialog("Number Error Occured.\nCheck values entered."); }
            catch (Exception e)                 { EngMath.showMessageDialog("Error Occured.\nPlease check values."); }
        }

      }

    @Override
    public void actionPerformed(ActionEvent ea)
    {
        String cmd = ea.getActionCommand();

        if (cmd.equals("Calculate")) { doCalc(); }
        if (cmd.equals("Clear All")) { doClear(); }

        if ( ea.getSource().equals(lparm1)) { tparm1.setForeground(Color.black); tparm1.setText( "   "+cPad.getString() ); }
        if ( ea.getSource().equals(lparm2)) { tparm2.setForeground(Color.black); tparm2.setText( "   "+cPad.getString() ); }
        if ( ea.getSource().equals(lparm3)) { tparm3.setForeground(Color.black); tparm3.setText( "   "+cPad.getString() ); }
        if ( ea.getSource().equals(lparm4)) { tparm4.setForeground(Color.black); tparm4.setText( "   "+cPad.getString() ); }
        if ( ea.getSource().equals(lparm5)) { tparm5.setForeground(Color.black); tparm5.setText( "   "+cPad.getString() ); }

        validate(); repaint();
    }
}
