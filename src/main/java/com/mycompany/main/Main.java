/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.main;
import java.util.Scanner;

/**
 *
 * @author norhan
 */
public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int x,y;
        String dir,command;
        System.out.println("enter the initial point of the rover");
        System.out.print("x= ");
        x=input.nextInt();
        System.out.print("y= ");
        y=input.nextInt();
        System.out.print("direction= ");
        dir=input.next();
        MarsRover rover=new MarsRover(x,y,dir);
        System.out.print("command= ");
        command=input.next();
        rover.process(command);
    }
}
