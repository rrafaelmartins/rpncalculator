package rpn;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author rafae
 */
public class Calculator extends JFrame implements ActionListener {

    // create a frame
    static JFrame f;
 
    // create a textfield
    static JTextField l;
 
    // store operator and operands
    private String str;
    
    
    
    // default constructor
    public Calculator(){
        this.str = "";
    }
 
    // main function
    public static void main(String args[])
    {
        // create a frame
        f = new JFrame("calculator");
 
        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
 
        // create a object of class
        Calculator c = new Calculator();
 
        // create a textfield
        l = new JTextField(16);
 
        // set the textfield to non editable
        l.setEditable(false);
 
        // create number buttons and some operators
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1, bspace;
 
        // create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
 
        // equals button
        beq1 = new JButton("=");
 
        // create operator buttons
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");
 
        // create . button
        be = new JButton(".");
        
        //create "space" button
        bspace = new JButton("space");
 
        // create a panel
        JPanel p = new JPanel();
 
        // add action listeners
        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        be.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);
        bspace.addActionListener(c);
 
        // add elements to panel
        p.add(l);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b0);
        p.add(ba);
        p.add(bs);
        p.add(bd);
        p.add(bm);
        p.add(be);
        p.add(beq);
        p.add(beq1);
        p.add(bspace);
 
        // set Background of panel
        p.setBackground(Color.green);
 
        // add panel to frame
        f.add(p);
 
        f.setSize(200, 370);
        f.show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        String resultstr;
        double d;
        
        
        if ("C".equals(s)){
            this.str = "";
            l.setText(str);
        }
        
        else if("space".equals(s)){
            this.str += " ";
            l.setText(str);
        }
        
        else if ("=".equals(s)){
            try{
                d = RPN.evaluate(str);
                resultstr = (d%1==0) ? String.format("%.0f", d) : d+"";
                System.out.println("---- (Calculator) resultstr (evaluate return) -------");
                System.out.println(resultstr);
                str = resultstr;
                l.setText(str);
            }
            catch(Exception exc){
                System.out.println(exc);
                this.str = "";
                l.setText("error");
            }
        }
        else {
            if ("0".equals(this.str)){
                this.str = "";
                l.setText(str);
            }
            else{
                this.str += s;
            }
            System.out.println("---- (Calculator) string aft pressing last button -------");
            System.out.println(this.str);
            l.setText(str);
            }
        }
    }
