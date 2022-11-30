/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stacktest;

import rpn.*;

/**
 *
 * @author rafae
 */

//The node class contains an element and a pointer to the next node.

public class Node {
    private double data;
    private Node next;
    
    //Construtor simples
    public Node(){
        
    }
    
    //Construtor passando dados
    public Node(double data){
        this.data = data;
    }
    
    //Construtor passando dado e ponteiro
    public Node(double data, Node next){
        this.data = data;
        this.next = next;
    }
    
    public double getData(){
        return this.data;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    
}
