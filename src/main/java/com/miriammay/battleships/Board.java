/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miriammay.battleships;

/**
 * Class that handles the playing board
 * @author Miriam Smith
 * @version 1.0
 */
public class Board {
    
    //Board is a 2D array  
    private  String[][] board = new String[10][10];
    private String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    //record the number of hits and attempts as accessible to outside classes
    public int hits = 0;
    public int tries = 0;
    //array for all the possible guesses
    private int[][] guesses = new int[100][2];
    
    /**
     * Initializes the board array with empty squares.
     */
    public void initialiseBoard(){
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                this.board[i][j] = "[ ]";
            }
        }
        
    }
    
    /**
     * Draws the board complete with numbers and letters to indicate coordinates.
     */
    public void drawBoard(){
        
        for(int num = 0; num < 10; num++){
            System.out.printf("%3d", num+1);
        }
        System.out.println();
        for (int i = 0; i < 10; i++){
            System.out.print(this.letters[i]);
            for (int j = 0; j < 10; j++){
                System.out.print(this.board[i][j]);
            }
            System.out.println();
        }
        
        
    }
    
    /**
     * Method that updates the board array with a hit or miss, also checks
     * for cheating.
     * @param guess     The coordinates of the user's guess
     * @param hit       True if the user hit a ship
     */
    public void updateBoard(int[] guess, boolean hit){
        //update the coordinates to reflect that array indices start at 0
        int x = guess[0]-1;
        int y = guess[1]-1;
        boolean triedBefore = false;
        
        //check if a user has tried the same coordinate before
        for (int[] possibleGuess: this.guesses){
            if (guess[0] == possibleGuess[0] && guess[1] == possibleGuess[1]){
                triedBefore = true;
            }
        }
        
        //if so, inform the user and exit the method
        if(triedBefore){
            System.out.println("You have tried this coordinate before");
            drawBoard();
            return;
        }
        //if a hit, update the board accordingly and record the hit
        if (hit){
            this.board[x][y] = "[!]";
            this.hits++;
        }
        //else if a miss, update the board but don't record a hit
        else {
            this.board[x][y] = "[x]";
        }
        //update the guesses array with the current attempt
        this.guesses[this.tries][0] = guess[0];
        this.guesses[this.tries][1] = guess[1];
        
        //draw the updated board
        drawBoard();
        
        //record the attempt
        this.tries++;
        
    }
    
}
