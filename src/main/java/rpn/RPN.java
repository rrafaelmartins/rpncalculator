package rpn;


import java.util.*;

/**
 *
 * @author rafae
 */
class RPN {
    
    public static double evaluate(String expr) {
        System.out.println("---- (RPN) expression arg -------");
        System.out.println(expr);
        String last = "";
        double pi = 3.14159265359;
        String pistring = pi+"";
        
        if (expr.isEmpty()) return 0;

        int start = 0;
        

        Stack stack = new Stack();

        do
        {
            int space = expr.substring(start).indexOf(' ');
            int end = (space == -1) ? expr.length() : start + space; //if method indexOf() returns -1 => no match found
            String current = expr.substring(start,end); //current number or operator
            System.out.println(current);
            System.out.println(expr.length());
            System.out.println(last.length());
            if ("pi".equals(current)){
                current = pi+"";
            }
            else if ("-pi".equals(current)){
                current = -pi+"";
            }
            if(("+-*/^".indexOf(current.charAt(0)) != -1) && (current.length() == 1) && (expr.length() > last.length() + 2)) //check if current is a two number operator and if it's NOT a unary negative
            {   //pop 2 and apply operation
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(operate(current.charAt(0),b,a)); //push operation result to stack
            }
            else if(("-".indexOf(current.charAt(0)) != -1) && (current.length() == 1) && (expr.length() == last.length() + 2)) //check if it's a unary minus
            {   //pop 2 and apply operation
                Double a = stack.pop();
                Character operand = 'u';
                stack.push(operate(operand,a,-1)); //push operation result to stack
            }
            else if ("sqrt".indexOf(current.charAt(0)) != -1){ //check if current is unary operator
                Double a = stack.pop();
                Character operand = 'r';
                stack.push(operate(operand,a,0.5));
            }
            else if ("!".indexOf(current.charAt(0)) != -1){
                Double a = stack.pop();
                Character operand = '!';
                stack.push(operate(operand,a, 0));
            }
            else if ("log".indexOf(current.charAt(0)) != -1){
                Double a = stack.pop();
                Character operand = 'l';
                stack.push(operate(operand,a, 0));
            }
            else if ("=".equals(current)){
                start = end + 1;//start over at index after the space
                continue;
            }
            
            else //otherwise, push the number to stack
            {
                System.out.println("here");
                if (pistring.equals(current)){
                    last = "pi";
                }
                else{
                    last = current;
                }
                stack.push(Double.parseDouble(current));
            }
            start = end + 1;//start over at index after the space
        }while(start < expr.length());
        
        System.out.println("---- (RPN) stack aft evaluate -------");
        stack.print();
        System.out.println("------------------------------");

        double result = stack.pop(); //gets result of last operation by popping it and storing in "result" attribute
        
        //while(!stack.isEmpty()) //stack non-empty -> return greatest val
        //{
        //    double current = stack.pop();
        //    result = (current > result) ? current : result;
        //}
        if (Double.isInfinite(result)){
            return 0;
        }
        else{
            return result;
        }
    }
    
    //return a <operand> b
    public static double operate(char operand,double a, double b){

        Hashtable<Character,Double> opHash = new Hashtable<Character,Double>();
        opHash.put('+',a + b);
        opHash.put('-',a - b);
        opHash.put('*',a * b);
        opHash.put('/',a / b);
        opHash.put('^',Math.pow(a, b));
        opHash.put('r', Math.pow(a, 0.5));
        opHash.put('!', factorial(a));
        opHash.put('l', Math.log(a));
        opHash.put('u',a * (-1));

        return opHash.get(operand);
    }
    
    public static double factorial(double number) {
        double result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
}

