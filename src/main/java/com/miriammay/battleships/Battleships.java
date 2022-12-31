/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.miriammay.battleships;
import java.util.Scanner;

/**
 *
 * @author Miriam Smith
 */
public class Battleships {

    public static void main(String[] args) {
        boolean exit = true;
        Scanner input = new Scanner(System.in);
        String choice;
        System.out.println("Hello and welcome to Battleships!");
        System.out.println("Guess the coordinates of the ships to win");
        System.out.println("An 'x' indicates a miss, a '!' means you've hit!");
        System.out.println("Here is the board:\n\n");
        
        
        Board board = new Board();
        board.initialiseBoard();
        
        Coordinates coordinates = new Coordinates();
        coordinates.start();
        Ships ships = new Ships();
        //get ship positions
        int[][] allTheShips = ships.allShips();
        
        board.drawBoard();
        do{
            String guess = coordinates.getUserCoordinates();
            int[] nextGuess = coordinates.guess(guess);
            
            boolean hit = coordinates.checkforShip(nextGuess, allTheShips);
            board.updateBoard(nextGuess, hit);
            if(board.hits == 17){
                System.out.println("Wow! You've won!");
                System.out.println("Thanks for playing. Bye!");
                exit = false;
            }
            
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
