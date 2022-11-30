/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stacktest;

import java.util.Arrays;
import rpn.Node;

/**
 *
 * @author rafae
 */

//The stack class only keeps track of one thing — the last node of the stack, named top.

public class Stack {
    private Node top;
    
    public Stack(){
        
    }
    
    
    //Construtor da stack dado um array
    public Stack(int[] dataArray){
        Arrays.stream(dataArray).forEach(data -> push(data));
    }
    
    
    //Colocar dados na Pilha; primeiramente devemos checar se há algum node existente.    
    public void push(int data){
        if (top  == null){
            this.top = new Node(data);    //Declaro o primeiro node como sendo o topo.
        }
        else{
            Node current = new Node(data, this.top);  //Crio node current com ponteiro "next" apontando para o atual top.
            this.top = current;
        }
    }
    
    //remove e pega dados do topo da pilha
    public double pop(){
        if (this.top != null){
            final double data = top.getData();
            this.top = this.top.getNext();
            return data;
        }
        else{
            System.out.println("Stack is empty");
            return 0;
        }
    }
    
   
    //pega dado do top mas não remove
    public double peekTop() {
        return this.top.getData();
    }
    
    
    //print stack
    public void print(){
        if (this.top == null){
            System.out.println("Stack is empty");
        }
        else{
            Node current = this.top;
            System.out.println(current.getData() + " <--");
            current = current.getNext();
            
            while (current != null){
                System.out.println(current.getData() + " <--");
                current = current.getNext();
            }
        }
    }
}
