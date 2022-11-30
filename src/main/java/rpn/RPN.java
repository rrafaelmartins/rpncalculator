/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpn;


import java.util.*;

/**
 *
 * @author rafae
 */
class RPN {
    public static double evaluate(String expr) {
        if (expr.isEmpty()) return 0;

        int start = 0;

        Stack stack = new Stack();

        do
        {
            int space = expr.substring(start).indexOf(' ');
            int end = (space == -1) ? expr.length() : start + space; //if method indexOf() returns -1 => no match found
            String current = expr.substring(start,end); //current number or operator
            if("+-*/".indexOf(current.charAt(0)) != -1) //check if current is operator
            {   //pop 2 and apply operation
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(operate(current.charAt(0),b,a)); //push operation result to stack
            }
            else //otherwise, push the number to stack
            {
                stack.push(Double.parseDouble(current));
            }
            start = end + 1;//start over at index after the space
        }while(start < expr.length());

        double result = stack.pop(); //gets result of last operation by popping it and storing in "result" attribute
        
        while(!stack.isEmpty()) //stack non-empty -> return greatest val
        {
            double current = stack.pop();
            result = (current > result) ? current : result;
        }

        return result;
    }
    //return a <operand> b
    public static double operate(char operand,double a, double b){

        Hashtable<Character,Double> opHash = new Hashtable<Character,Double>();
        opHash.put('+',a + b);
        opHash.put('-',a - b);
        opHash.put('*',a * b);
        opHash.put('/',a / b);

        return opHash.get(operand);
    }
}
