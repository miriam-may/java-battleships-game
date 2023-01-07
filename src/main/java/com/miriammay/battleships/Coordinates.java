/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miriammay.battleships;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Class that controls the actions to do with coordinates
 * @author Miriam Smith
 * @version 1.0
 */
public class Coordinates {
   private final int[][] coordinatesArray = new int[100][2];
   private HashMap map = new HashMap();
   
   /**
    * Method that sets up game necessities.
    */
   public void start(){
       createCoordinates();
       addMap();
   }
   
   /**
    * Method that validates the letter part of the user's guess 
    * @param answer     the user's guess
    * @return           true if the letter is a to j, false otherwise
    */
   private boolean checkFirstCoordinate(String answer){
       boolean check = false;
       //grab the letter at the start of the guess
       char thisCheck = answer.charAt(0);
       //check it against the valid letters
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
   
   /**
    * Method that validates the number part of the user's guess
    * @param answer     the user's guess
    * @return           true if the number is between 1 and 10, false otherwise
    */
   private boolean checkNumber(String answer){
       boolean check = false;
       //create an array of the valid numbers as Strings (to reduce the amount
       //of error reduction required)
       String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
       //make sure there is 2 or less numbers
       if(answer.length()<=3){
           //loop over the numbers in the array
           for (int c = 0; c < nums.length; c++){
               //check them against the last 1 or 2 characters in the answer
               if (answer.substring(1).equals(nums[c])){
                   check = true;
                   break;
               }
               //this is redundant, but makes the code more readable I think
               else{
                   check = false;
               }
           }
       }
       
       return check;
   }
   
   /**
    * Method that prompts user for coordinate guess, then calls the validation
    * methods
    * @return   the user's answer once it has been validated
    */
   public String getUserCoordinates(){
       boolean correctFirst;
       boolean correctSecond;
       boolean exit = true;
       String answer = "";
       Scanner input = new Scanner(System.in);
       //loop until the user enters a valid guess
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
   
 
   /**
    * Method that creates the 100 possible coordinates on a 10x10 playing board,
    * this method turned out to be not necessary for the running of the game. 
    */
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
  
   /**
    * Method that maps the letters on the board to numbers.
    */
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
   
   /**
    * Method that takes a guess and turns it into usable coordinates that can
    * be checked against the board array
    * @param g  The user's guess
    * @return   The usable coordinates
    */
   public int[] guess(String g){
       int[] nextGuess = new int[2];
       String subg;
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
   
   /**
    * Method that checks whether a guess "hits" a ship or misses
    * @param ship       the coordinates of the user's guess
    * @param allShips   all the coordinates of the ships
    * @return           true if a hit, false if a miss
    */
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
