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
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPI, 
                ba, bs, bd, bm, bpow, bsqrt, bfact, blog, be, beq, beq1, bspace,
                bbackspace;
 
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
        bPI = new JButton("𝜋");
 
        // equals button
        beq1 = new JButton("=");
 
        // create operator buttons
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        bpow = new JButton("x²");
        bsqrt = new JButton("sqrt");
        bfact = new JButton("x!");
        blog = new JButton("log");
        beq = new JButton("C");
 
        // create . button
        be = new JButton(".");
        
        //create "space" button
        bspace = new JButton("space");
        
        //create "backspace" button
        bbackspace = new JButton("backspace");
 
        // create a panel
        JPanel p = new JPanel();
 
        // add action listeners
        bm.addActionListener(c);
        bm.setMnemonic(KeyEvent.VK_MULTIPLY);
        bd.addActionListener(c);
        bm.setMnemonic(KeyEvent.VK_DIVIDE);
        bs.addActionListener(c);
        bs.setMnemonic(KeyEvent.VK_SUBTRACT);
        ba.addActionListener(c);
        ba.setMnemonic(KeyEvent.VK_ADD);
        bPI.addActionListener(c);
        
        b9.addActionListener(c);
        b9.setMnemonic(KeyEvent.VK_9);
        b9.setMnemonic(KeyEvent.VK_NUMPAD9);
        
        b8.addActionListener(c);
        b8.setMnemonic(KeyEvent.VK_8);
        b8.setMnemonic(KeyEvent.VK_NUMPAD8);
        
        b7.addActionListener(c);
        b7.setMnemonic(KeyEvent.VK_7);
        b7.setMnemonic(KeyEvent.VK_NUMPAD7);
        
        b6.addActionListener(c);
        b6.setMnemonic(KeyEvent.VK_6);
        b6.setMnemonic(KeyEvent.VK_NUMPAD6);
        
        b5.addActionListener(c);
        b5.setMnemonic(KeyEvent.VK_5);
        b5.setMnemonic(KeyEvent.VK_NUMPAD5);
        
        b4.addActionListener(c);
        b4.setMnemonic(KeyEvent.VK_4);
        b4.setMnemonic(KeyEvent.VK_NUMPAD4);
        
        b3.addActionListener(c);
        b3.setMnemonic(KeyEvent.VK_3);
        b3.setMnemonic(KeyEvent.VK_NUMPAD3);
        
        b2.addActionListener(c);
        b2.setMnemonic(KeyEvent.VK_2);
        b2.setMnemonic(KeyEvent.VK_NUMPAD2);
  
        b1.addActionListener(c);
        b1.setMnemonic(KeyEvent.VK_1);
        b1.setMnemonic(KeyEvent.VK_NUMPAD1);
        
        b0.addActionListener(c);
        b0.setMnemonic(KeyEvent.VK_0);
        b0.setMnemonic(KeyEvent.VK_NUMPAD0);
        
        be.addActionListener(c);
        be.setMnemonic(KeyEvent.VK_DECIMAL);
        beq.addActionListener(c);
        beq1.addActionListener(c);
        bspace.addActionListener(c);
        bspace.setMnemonic(KeyEvent.VK_SPACE);
        bbackspace.addActionListener(c);
        bbackspace.setMnemonic(KeyEvent.VK_BACK_SPACE);
        bpow.addActionListener(c);
        bsqrt.addActionListener(c);
        bfact.addActionListener(c);
        blog.addActionListener(c);
 
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
        p.add(bPI);
        p.add(ba);
        p.add(bs);
        p.add(bd);
        p.add(bm);
        p.add(be);
        p.add(beq);
        p.add(beq1);
        p.add(bspace);
        p.add(bbackspace);
        p.add(bpow);
        p.add(bsqrt);
        p.add(bfact);
        p.add(blog);
 
        // set Background of panel
        p.setBackground(Color.white);
 
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
        
        else if("backspace".equals(s)){
            StringBuilder pop = new StringBuilder(str);
            pop.deleteCharAt(str.length()-1);
            this.str = pop+"";
            l.setText(str);
        }
        
        else if("x²".equals(s)){
            this.str += "^";
            l.setText(str);
        }
        
        else if("sqrt".equals(s)){
            this.str += "sqrt";
            l.setText(str);
        }
        
        else if("x!".equals(s)){
            this.str += "!";
            l.setText(str);
        }
        
        else if("𝜋".equals(s)){
            this.str += "pi";
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
