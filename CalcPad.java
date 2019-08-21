/** CalcPad.java */
package engmath;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author mikec
 */
public class CalcPad extends JPanel implements ActionListener 
{
	
    private JLabel filler = new JLabel("Calc Pad Data:");
    private JLabel calcField = new JLabel(" ");
    private StringBuffer calcString = new StringBuffer();
    private JPanel topPanel = new JPanel();
    private JPanel numberPadPanel = new JPanel();

    private static final String ZERO = "0";
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String FIVE = "5";
    private static final String SIX = "6";
    private static final String SEVEN = "7";
    private static final String EIGHT = "8";
    private static final String NINE = "9";
    private static final String POINT = ".";
    private static final String BKSP = "BKSP";
    private static final String CLR = "CLR";
    
    private JButton zero = new JButton(ZERO);
    private JButton one = new JButton(ONE);
    private JButton two = new JButton(TWO);
    private JButton three = new JButton(THREE);
    private JButton four = new JButton(FOUR);
    private JButton five = new JButton(FIVE);
    private JButton six = new JButton(SIX);
    private JButton seven = new JButton(SEVEN);
    private JButton eight = new JButton(EIGHT);
    private JButton nine = new JButton(NINE);
    private JButton point = new JButton(POINT);
    private JButton bksp = new JButton(BKSP);
    private JButton clr = new JButton(CLR);

    
    /** CalcPad() - main routine for this class */
    public CalcPad()
    {
        setup();
        build();
    }
	
    /** setup() - routine for panel setups... defines layouts, colors, fonts, etc */
    private void setup()
    {
        setLayout(new BorderLayout());

        topPanel.setLayout(new GridLayout(1,2,5,5));
        numberPadPanel.setLayout(new GridLayout(5,3,2,2));
        topPanel.setBackground(Color.lightGray);
        topPanel.setBorder(new EtchedBorder());
        numberPadPanel.setBackground(Color.lightGray);
        numberPadPanel.setBorder(new EtchedBorder());

        filler.setHorizontalAlignment(SwingConstants.RIGHT);
        filler.setFont(new Font("Arial", Font.PLAIN, 16));
        calcField.setForeground(Color.blue);
        calcField.setFont(new Font("Arial", Font.BOLD, 16));
        calcField.setHorizontalAlignment(SwingConstants.RIGHT);

        zero.setFont(new Font("Times", Font.BOLD, 20));
        one.setFont(new Font("Times", Font.BOLD, 20));
        two.setFont(new Font("Times", Font.BOLD, 20));
        three.setFont(new Font("Times", Font.BOLD, 20));
        four.setFont(new Font("Times", Font.BOLD, 20));
        five.setFont(new Font("Times", Font.BOLD, 20));
        six.setFont(new Font("Times", Font.BOLD, 20));
        seven.setFont(new Font("Times", Font.BOLD, 20));
        eight.setFont(new Font("Times", Font.BOLD, 20));
        nine.setFont(new Font("Times", Font.BOLD, 20));
        point.setFont(new Font("Times", Font.BOLD, 20));

        zero.setHorizontalAlignment(SwingConstants.CENTER);
        one.setHorizontalAlignment(SwingConstants.CENTER);
        two.setHorizontalAlignment(SwingConstants.CENTER);
        three.setHorizontalAlignment(SwingConstants.CENTER);
        four.setHorizontalAlignment(SwingConstants.CENTER);
        five.setHorizontalAlignment(SwingConstants.CENTER);
        six.setHorizontalAlignment(SwingConstants.CENTER);
        seven.setHorizontalAlignment(SwingConstants.CENTER);
        eight.setHorizontalAlignment(SwingConstants.CENTER);
        nine.setHorizontalAlignment(SwingConstants.CENTER);
        point.setHorizontalAlignment(SwingConstants.CENTER);
        bksp.setHorizontalAlignment(SwingConstants.CENTER);
        clr.setHorizontalAlignment(SwingConstants.CENTER);

        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);

        clr.addActionListener(this);
        point.addActionListener(this);
        bksp.addActionListener(this);
    }

    /** build() - called to pull together the objects and build the working panel */
    private void build()
    {		
        topPanel.add(filler); topPanel.add(calcField);

        numberPadPanel.add(seven); numberPadPanel.add(eight); numberPadPanel.add(nine);
        numberPadPanel.add(four); numberPadPanel.add(five); numberPadPanel.add(six);
        numberPadPanel.add(one); numberPadPanel.add(two); numberPadPanel.add(three);
        numberPadPanel.add(new JLabel(" ")); numberPadPanel.add(zero); numberPadPanel.add(point);
        numberPadPanel.add(clr); numberPadPanel.add( new JLabel(" ")); numberPadPanel.add(bksp);

        add(topPanel, BorderLayout.NORTH);
        add(numberPadPanel, BorderLayout.CENTER);
    }

    /** clrBuffer() - called each time the string buffer needs cleared */
    public void clrBuffer()
    {
        calcString = new StringBuffer();
        calcField.setText(calcString.toString());
        validate(); repaint(); 
    }

    /** getString() - necessary routine for moving string buffer data to outside elements
     * @return 
     */
    public String getString() 
    {
        String outBuffer = calcString.toString();
        clrBuffer();
        return outBuffer; 
    }

    /** addToCalc() - called to add numbers to the calc string from the keyboard
     * @param digit 
     */
    public void addToCalc(char digit) 
    {  
        calcString.append(digit);
        calcField.setText(calcString.toString());
        validate(); repaint();
    }
	
    /** actionPerformed() - required routine for all action listeners to handle function calls
     * @param ea 
     */
    @Override
    public void actionPerformed(ActionEvent ea) 
    {
        String cmd = ea.getActionCommand();

        if ( cmd.equals(ZERO) ) { calcString.append("0"); }
        if ( cmd.equals(ONE) ) { calcString.append("1"); }
        if ( cmd.equals(TWO) ) { calcString.append("2"); }
        if ( cmd.equals(THREE) ) { calcString.append("3"); }
        if ( cmd.equals(FOUR) ) { calcString.append("4"); }
        if ( cmd.equals(FIVE) ) { calcString.append("5"); }
        if ( cmd.equals(SIX) ) { calcString.append("6"); }
        if ( cmd.equals(SEVEN) ) { calcString.append("7"); }
        if ( cmd.equals(EIGHT) ) { calcString.append("8"); }
        if ( cmd.equals(NINE) ) { calcString.append("9"); }
        if ( cmd.equals(POINT) ) { calcString.append("."); }

        if ( cmd.equals(CLR) ) { clrBuffer(); }
        if ( cmd.equals(BKSP) ) { calcString.deleteCharAt( calcString.length()-1 ); }

        calcField.setText(calcString.toString());
        validate(); repaint();
    }
}
