/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpn;
import java.util.Hashtable;

/**
 *
 * @author rafae
 */

//TO-DO: (linha 50) fazer um if para cada caso de operação entre dois números. Ex: img+real op img+real, img+real op real, img+real op img...

public class ImaginaryRPN extends RPN{
    
    public static String evaluate2(String expr) {
        System.out.println("---- (RPN) expression arg -------");
        System.out.println(expr);
        String last = "";
        String[] currentNum;
        String result;
        int countImg =0 ;
        int countReal = 0;
        double resultReal = 0;
        double resultImg = 0;
        boolean singlediv = false;
        //List <Double> real = new ArrayList <Double>();
        
        if (expr.isEmpty()) return "0";

        int start = 0;
        

        Stack stackReal = new Stack();
        Stack stackImg = new Stack();

        do
        {
            int space = expr.substring(start).indexOf(' ');
            int end = (space == -1) ? expr.length() : start + space; //if method indexOf() returns -1 => no match found
            String current = expr.substring(start,end); //current number or operator
            System.out.println("Current: " + current);
            //System.out.println(expr.length());
            //System.out.println(last.length());

            if(("+-".indexOf(current.charAt(0)) != -1) && (current.length() == 1) && (expr.length() > last.length() + 2) && (current.contains("i") == false)) //check if current is a two number operator and if it's NOT a unary negative
            {   //pop 2 and apply operation
                //System.out.println("aaaaaaaa");
                if ((countImg == 2) && (countReal ==2)){
                    System.out.println("2 e 2");
                    Double a = stackReal.pop();
                    Double b = stackReal.pop();
                    Double c = stackImg.pop();
                    Double d = stackImg.pop();
                    stackReal.push(operate(current.charAt(0),b,a)); //push operation result to stack
                    stackImg.push(operate(current.charAt(0), c, d));
                }
                else if ((countImg == 2) && (countReal == 1)){
                    System.out.println("2 e 1");
                    Double a = stackReal.pop();
                    Double c = stackImg.pop();
                    Double d = stackImg.pop();
                    stackReal.push(operate(current.charAt(0),0,a)); //push operation result to stack
                    stackImg.push(operate(current.charAt(0), c, d));
                }
                else if ((countImg == 2) && (countReal == 0)){
                    System.out.println("2 e 0");
                    Double c = stackImg.pop();
                    Double d = stackImg.pop();
                    stackImg.push(operate(current.charAt(0), c, d));
                }
                else if((countImg == 1) && (countReal == 2)){
                    System.out.println("1 e 2");
                    Double a = stackReal.pop();
                    Double b = stackReal.pop();
                    Double c = stackImg.pop();
                    stackReal.push(operate(current.charAt(0),b,a)); //push operation result to stack
                    stackImg.push(operate(current.charAt(0), c, 0));
                }
                else{
                    System.out.println("1 e 1");
                    Double a = stackReal.pop();
                    Double c = stackImg.pop();
                    stackReal.push(operate(current.charAt(0),0,a)); //push operation result to stack
                    stackImg.push(operate(current.charAt(0), c, 0));
                }
            }
            else if ("*".indexOf(current.charAt(0)) != -1){
                if ((countImg == 2) && (countReal ==0)){
                    System.out.println("2 e 2");
                    Double c = stackImg.pop();
                    Double d = stackImg.pop();
                    stackImg.push(operate(current.charAt(0), c, d));
                }
                else if((countImg == 1) && (countReal == 1)){
                    System.out.println("1img e 1real");
                    Double b = stackReal.pop();
                    Double c = stackImg.pop();
                    countReal -= 1;
                    stackImg.push(b*c);
                    stackImg.print();
                }
                else if((countImg == 2) && (countReal == 2)){
                    System.out.println("1img e 1real");
                    Double a = stackReal.pop();
                    Double b = stackReal.pop();
                    Double c = stackImg.pop();
                    Double d = stackImg.pop();
                    stackReal.push(a*b - c*d);
                    stackImg.push(a*d + b*c);
                }
            }
            else if ("/".indexOf(current.charAt(0)) != -1){
                if ((countImg == 2) && (countReal ==0)){
                    System.out.println("2 e 2");
                    Double c = stackImg.pop();
                    Double d = stackImg.pop();
                    stackImg.push(operate(current.charAt(0), d, c));
                    singlediv = true;
                }
                else if((countImg == 1) && (countReal == 1)){
                    System.out.println("1img e 1real");
                    Double b = stackReal.pop();
                    Double c = stackImg.pop();
                    countReal -= 1;
                    stackImg.push(b/c);
                    stackImg.print();
                }
                else if((countImg == 2) && (countReal == 2)){
                    System.out.println("1img e 1real");
                    Double c = stackReal.pop(); //real do numero 2
                    Double a = stackReal.pop(); //real do numero 1
                    Double d = stackImg.pop(); //img do numero 2
                    Double b = stackImg.pop(); //img do numero 1
                    stackReal.push((a*c+b*d)/(c*c+d*d));
                    stackImg.push((b*c-a*d)/(c*c+d*d));
                }
            }
            
            else if(("-".indexOf(current.charAt(0)) != -1) && (current.length() == 1) && (expr.length() == last.length() + 2)) //check if it's a unary minus
            {   //pop 2 and apply operation
                Double a = stackReal.pop();
                Character operand = 'u';
                stackReal.push(operate(operand,a,-1)); //push operation result to stack

            }

            else if ("=".equals(current)){
                start = end + 1;//start over at index after the space
                continue;
            }
            
            else //otherwise, push the number to stack
            {
                if (current.contains("i")){
                    if (current.length() == 1){
                        stackImg.push(1);
                    }
                    else{
                        currentNum = current.split("i");
                        System.out.println("Parte imaginária de current: " + currentNum[0]);
                        if (currentNum.length > 1){
                            System.out.println("Parte real de current: " + currentNum[1]);
                            stackReal.push(Double.parseDouble(currentNum[1]));
                            countReal += 1;
                        }
                        stackImg.push(Double.parseDouble(currentNum[0]));
                    }
                    countImg += 1;
                }
                else{
                    stackReal.push(Double.parseDouble(current));
                    System.out.println("real: "+current);
                    countReal += 1;
                }
            }
            start = end + 1;//start over at index after the space
        }while(start < expr.length());
        
        System.out.println("---- (RPN) stack aft evaluate -------");
        System.out.println("------------------------------");
        
        if ((countReal > 0) && (countImg > 0)){
            System.out.println("flag1");
            resultReal = stackReal.pop(); //gets result of last operation by popping it and storing in "result" attribute
            resultImg = stackImg.pop(); 
        }
        else if ((countReal > 0) && (countImg == 0)){
            System.out.println("flag2");
            resultReal = stackReal.pop(); //gets result of last operation by popping it and storing in "result" attribute
        }
        else if ((countReal == 0) && (countImg > 0)){
            System.out.println("flag3");
            resultImg = stackImg.pop(); //gets result of last operation by popping it and storing in "result" attribute
        }
        
       
        
        System.out.println(resultReal);
        System.out.println(resultImg);

        if (Double.isInfinite(resultReal)){
            return "error";
        }
        else{
            if ((resultReal >= 0) && (singlediv == false)){
                result = resultImg + "i" + "+" + resultReal;
            }
            else if(singlediv == true){
                result = ""+resultImg;
            }
            else{
                result = resultImg + "i" + resultReal;
            }
            return result;
        }
    }
    
    //return a <operand> b
    public static double operate(char operand,double a, double b){
        
        Hashtable<Character,Double> opHash = new Hashtable<Character,Double>();
        opHash.put('+',a + b);
        opHash.put('-',a - b);
        opHash.put('*',a * b * (-1));
        opHash.put('/',a / b);
        opHash.put('^',Math.pow(a, b));
        opHash.put('r', Math.pow(a, 0.5));
        opHash.put('!', factorial(a));
        opHash.put('l', Math.log(a));
        opHash.put('u',a * (-1));

        return opHash.get(operand);
    }
} 

