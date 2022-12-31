/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miriammay.battleships;

/**
 *
 * @author Miriam Smith
 */
public class Board {
    
    String[][] board = new String[10][10];
    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    public int hits = 0;
    
    
    public void initialiseBoard(){
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                this.board[i][j] = "[ ]";
            }
        }
        
    }
    
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
    
    public void updateBoard(int[] guess, boolean hit){
        int x = guess[0]-1;
        int y = guess[1]-1;
        if (hit){
            this.board[x][y] = "[!]";
            this.hits++;
        }
        else {
            this.board[x][y] = "[x]";
        }
        drawBoard();
        
    }
    
}
