/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teststack;

/**
 *
 * @author rafae
 */

import teststack.Stack;
import java.util.Scanner;

public class TestStack {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[]{1,3,2,5,3};
        
        
        //criando stack vazio e dps adicionando 5 umeros
        Stack stack = new Stack();
        for (int i =0; i<5; i++){
            System.out.println("Add element to stack: ");
            stack.push(scanner.nextInt()); }
        System.out.println("------------------------------------------------------------------------");
        

        //pegando e imprimindo item no topo da stack
        System.out.println("Top of the stack: " + stack.peekTop());
        System.out.println("------------------------------------------------------------------------");
        
        
        //printando todo o stack
        stack.print();
       
        
        //removendo itens do stack
        System.out.println("Popped " + stack.pop() + " from the stack.");
        System.out.println("Popped " + stack.pop() + " from the stack.");
        System.out.println("------------------------------------------------------------------------");
        stack.print();
        System.out.println("------------------------------------------------------------------------");
        
        //creating stack from array
        Stack stack2 = new Stack(array);
        System.out.println("New stack made from existing array: ");
        stack2.print();
        
        //
        Stack emptyStack = new Stack();
        emptyStack.pop();
        
        String expr = "7 3.14159265359 *";
        System.out.println(expr.length());
    }
}
