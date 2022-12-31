/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miriammay.battleships;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author Miriam Smith
 */
public class Coordinates {
   private final int[][] coordinatesArray = new int[100][2];
   private HashMap map = new HashMap();
   
   public void start(){
       createCoordinates();
       addMap();
   }
   
   private boolean checkFirstCoordinate(String answer){
       boolean check = false;
       char thisCheck = answer.charAt(0);
       switch(thisCheck){
           case 'a':
           case 'b':
           case 'c':
           case 'd':
           case 'e':
           case 'f':
           case 'g':
           case 'h':
           case 'i':
           case 'j':
               check = true;
               break;
           default:
               System.out.println("First coordinate value not valid");
               break;
       }
       return check;    
   }
   
   private boolean checkNumber(String answer){
       boolean check = false;
       String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
       if(answer.length()<=3){
           for (int c = 0; c < nums.length; c++){
               if (answer.substring(1).equals(nums[c])){
                   check = true;
                   break;
               }
               else{
                   check = false;
               }
           }
       }
       
       return check;
   }
   
   public String getUserCoordinates(){
       boolean correctFirst = false;
       boolean correctSecond = false;
       boolean exit = true;
       String answer = "";
       Scanner input = new Scanner(System.in);
       
       do {
            System.out.println("Enter your guess: ");
            answer = input.nextLine();
            correctFirst = checkFirstCoordinate(answer);
            correctSecond = checkNumber(answer);
            if(correctFirst && correctSecond){
               exit = false;
            }
            else {
               System.out.println("Please enter valid coordinates");
            }
        } while(exit);
       
       return answer;
   }
   
   //Creates the 100 possible coordinates on a 10x10 playing board. 
   //"mun" will be mapped to letters in a different method
   private void createCoordinates(){
       int num = 1;
       int mun = 1;
       
       for(int j = 0; j < 100; j++){
           if(j > 0 && j % 10 == 0){
               num+=1;
           }
           if(mun == 11){
               mun = 1;
           }
           this.coordinatesArray[j][0] = num;
           this.coordinatesArray[j][1] = mun;
           mun++;   
           
       }
      
   }
  
   private void addMap(){
       this.map.put('a', 1);
       this.map.put('b', 2);
       this.map.put('c', 3);
       this.map.put('d', 4);
       this.map.put('e', 5);
       this.map.put('f', 6);
       this.map.put('g', 7);
       this.map.put('h', 8);
       this.map.put('i', 9);
       this.map.put('j', 10);
   }
   
   public int[] guess(String g){
       int[] nextGuess = new int[2];
       String subg = "";
       char coord = g.charAt(0);
       int f = (int)this.map.get(coord);
       
       nextGuess[0] = f;
       if (g.length()<3){
           char c = g.charAt(1);
           subg = String.valueOf(c);
       }
       else{
           subg = g.substring(1);
       }
       nextGuess[1] = Integer.parseInt(subg);
       return nextGuess;
       
   }
   
   public boolean checkforShip(int[] ship, int[][] allShips){
       boolean isThere = false;
       for (int[] allShip : allShips) {
           if (ship[0] == allShip[0] && ship[1] == allShip[1]){
               isThere = true;
               break;
           }
       }
       
       return isThere;
   }
   
}
