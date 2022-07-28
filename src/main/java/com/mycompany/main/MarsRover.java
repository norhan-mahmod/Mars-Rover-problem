/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.Scanner;
/**
 *
 * @author norhan
 */
public class MarsRover {
    private int x;
    private int y;
    private String direction;
    private String dirArr[]={"NORTH","EAST","SOUTH","WEST"};
    private int obstacles[][]=new int[3][2];
    private boolean flag=true;
    Scanner input=new Scanner(System.in);
    public MarsRover(int x,int y,String direction){
        this.x=x;
        this.y=y;
        this.direction=direction;
        System.out.println("enter the obstacles positions");
        readObstacles();
    }
    public void setx(int x){
        this.x=x;
    }
    public int getx(){
        return x;
    }
    public void sety(int y){
        this.y=y;
    }
    public int gety(){
        return y;
    }
    public void setdir(String dir){
        direction=dir;
    }
    public String getdir(){
        return direction;
    }
    public void incrementx(){
        x++;
    }
    public void incrementy(){
        y++;
    }
    public void decrementx(){
        x--;
    }
    public void decrementy(){
        y--;
    }
    public void printPosition(){
        System.out.println("( "+x+" , "+y+" ) "+direction);
    }
    public void process(String command){
        for(int i=0;i<command.length();i++){
            process(command.charAt(i));
        }
        if(flag==true)
            printPosition();
    }
    public void process(char c){
        switch(c){
            case 'F':
                moveForward();
                break;
            case 'B':
                moveBackward();
                break;
            case'L':
                rotateLeft();
                break;
            case 'R':
                rotateRight();
                break;
            default:
                System.out.println("error instruction");
        }
    }
    private void moveForward(){
        switch(direction){
            case "NORTH":
                checkIncy();
                break;
            case "EAST":
                checkIncx();
                break;
            case "SOUTH":
                checkDecy();
                break;
            case "WEST":
                checkDecx();
                break;
            default:
                System.out.println("error direction");
        }
    }
    private void moveBackward(){
        switch(direction){
            case "NORTH":
                checkDecy();
                break;
            case "EAST":
                checkDecx();
                break;
            case "SOUTH":
                checkIncy();
                break;
            case "WEST":
                checkIncx();
                break;
            default:
                System.out.println("error direction");
        }
    }
    private void rotateLeft(){
       for(int i=0;i<dirArr.length;i++){
           if(direction.equals(dirArr[i])&&i==0){
               direction=dirArr[3];
               break;
           }
               
           else if(direction.equals(dirArr[i])&&i!=0){
               direction=dirArr[i-1];
               break;
           }
       }
    }
    private void rotateRight(){
       for(int i=0;i<dirArr.length;i++){
           if(direction.equals(dirArr[i])&&i==3){
               direction=dirArr[0];
               break;
           }
           
           else if(direction.equals(dirArr[i])&&i!=3){
               direction=dirArr[i+1];
               break;
           }
       }
    }
    
    //part 2
    
    public void readObstacles(){
        System.out.print("[ ");
        for(int i=0;i<obstacles.length;i++){
            System.out.print("[");
            for(int j=0;j<obstacles[i].length;j++){
                obstacles[i][j]=input.nextInt();
                if(j==0)
                    System.out.print(",");
            }
            System.out.println("], ");
        }
        System.out.println("]");
    }
    //check the position is valid or not due to obtacles after increment x
    public void checkIncx(){
        for(int i=0;i<obstacles.length;i++){
            if(x+1==obstacles[i][0]&&y==obstacles[i][1]){
                printPosition();
                System.out.println("STOPPED");
                flag=false;
                break;
            }
        }
        incrementx();
    }
    
    //check the position is valid or not due to obtacles after increment y
    public void checkIncy(){
        for(int i=0;i<obstacles.length;i++){
            if(x==obstacles[i][0]&&y+1==obstacles[i][1]){
                printPosition();
                System.out.println("STOPPED");
                flag=false;
                break;
            }
        }
        incrementy();
    }
    
    //check the position is valid or not due to obtacles after decrement x
    public void checkDecx(){
        for(int i=0;i<obstacles.length;i++){
            if(x-1==obstacles[i][0]&&y==obstacles[i][1]){
                printPosition();
                System.out.println("STOPPED");
                flag=false;
                break;
            }
        }
        decrementx();
    }
    
    //check the position is valid or not due to obtacles after decrement y
    public void checkDecy(){
        for(int i=0;i<obstacles.length;i++){
            if(x==obstacles[i][0]&&y-1==obstacles[i][1]){
                printPosition();
                System.out.println("STOPPED");
                flag=false;
                break;
            }
        }
        decrementy();
    }
}
