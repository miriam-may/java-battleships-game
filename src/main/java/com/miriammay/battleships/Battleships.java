/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.miriammay.battleships;
import java.util.Scanner;

/**
 * Driver class of the Battleships program
 * @author Miriam Smith
 * @version 1.0
 * 
 */
public class Battleships {

    /**
     * Method that runs program and calls the other classes' methods
     * @param args  The system arguments
     */
    public static void main(String[] args) {
        boolean exit = true;
        Scanner input = new Scanner(System.in);
        String choice;
        //welcome message and game explanation
        System.out.println("Hello and welcome to Battleships!");
        System.out.println("Guess the coordinates of the ships to win");
        System.out.println("An 'x' indicates a miss, a '!' means you've hit!");
        System.out.println("Here is the board:\n\n");
        
        //create the playing board class
        Board board = new Board();
        board.initialiseBoard();
        
        Coordinates coordinates = new Coordinates();
        coordinates.start();
        Ships ships = new Ships();
        //get ship positions
        int[][] allTheShips = ships.allShips();
        //draw the board
        board.drawBoard();
        //loop over the game turns
        do{
            //get the user's guess
            String guess = coordinates.getUserCoordinates();
            int[] nextGuess = coordinates.guess(guess);
            //check for a hit
            boolean hit = coordinates.checkforShip(nextGuess, allTheShips);
            //update the board at the user's guess with the x or !
            board.updateBoard(nextGuess, hit);
            //check to see if they've won
            if(board.hits == 17){
                System.out.println("Wow! You've won!");
                System.out.println("Thanks for playing. Bye!");
                exit = false;
            }
            //if not, ask if they would like to continue
            else { 
                System.out.println("Continue game? N for no");
                choice = input.next();
                if(choice.toLowerCase().equals("n")){
                    System.out.println("Goodbye!");
                    exit = false;
                }
            }
        } while(exit);
    }
}
