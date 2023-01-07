/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miriammay.battleships;
import java.util.Random;
/**
 * Class that sets the location of the ships
 * @author Miriam Smith
 * @version 1.0
 */
public class Ships {
    //CARRIER size = 5
    //BATTLESHIP size = 4
    //CRUISER size = 3
    //SUBMARINE size = 3
    //DESTROYER size = 2
    
    
    /**
     * Method that creates random positions for the ships
     * @return  the coordinates of the ship positions
     */
    public int[][] allShips(){
        
        Random random = new Random();
        
        //set first random start position
        int carrierNum = (random.nextInt(5)+1);
        
        //create variables for other random start positions
        int battleshipNum = (random.nextInt(4)+1);
        int cruiserNum = (random.nextInt(4)+1);
        int subNum = (random.nextInt(4)+1);
        int destroyerNum = (random.nextInt(4)+1);
        
        //go through each ship, making sure each has a unique random number
        do {
            if (battleshipNum == carrierNum){
                    battleshipNum = (random.nextInt(5)+1);
            }
        } while(battleshipNum==carrierNum);
        
        
        do {
            if (cruiserNum == carrierNum || cruiserNum == battleshipNum){
                    cruiserNum = (random.nextInt(5)+1);
            }
        } while(cruiserNum == carrierNum || cruiserNum == battleshipNum);
        
        do {
            if (subNum == cruiserNum ||
                subNum == carrierNum ||
                subNum == battleshipNum) { 
                    subNum = (random.nextInt(5)+1);
            }
        }
        while ( subNum == cruiserNum ||
                subNum == carrierNum ||
                subNum == battleshipNum);
        
        do {
            if (destroyerNum == subNum ||
                destroyerNum == cruiserNum ||
                destroyerNum == carrierNum ||
                destroyerNum == battleshipNum) { 
                    destroyerNum = (random.nextInt(5)+1);
            }
        }
        while ( destroyerNum == subNum ||
                destroyerNum == cruiserNum ||
                destroyerNum == carrierNum ||
                destroyerNum == battleshipNum);
        
        //flip a coin to see what orientation the ships are on
        int flip = random.nextInt(2);
        
        if(flip == 2){
            //create coordinates for each ship. Two coordinates, for rows and
            //columns, with a random start point for each ship. The incrementing
            //number denotes the length of the ship
            int[][] allTheShips = {
                {6, carrierNum},
                {7, carrierNum},
                {8, carrierNum},
                {9, carrierNum},
                {10, carrierNum},
                {9, battleshipNum},
                {8, battleshipNum},
                {7, battleshipNum},
                {6, battleshipNum},
                {cruiserNum, 6},
                {cruiserNum, 7},
                {cruiserNum, 8},
                {subNum, 9},
                {subNum, 8},
                {subNum, 7},
                {10, destroyerNum},
                {9, destroyerNum}
            };
            
            return allTheShips;
        }
        
        else {
            int[][] allTheShips = {
                {carrierNum, 6},
                {carrierNum, 7},
                {carrierNum, 8},
                {carrierNum, 9},
                {carrierNum, 10},
                {battleshipNum, 7},
                {battleshipNum, 8},
                {battleshipNum, 9},
                {battleshipNum, 10},
                {7, cruiserNum},
                {8, cruiserNum},
                {9, cruiserNum},
                {6, subNum},
                {7, subNum},
                {8, subNum},
                {destroyerNum, 7},
                {destroyerNum, 8}
            };
            
            return allTheShips;
        }
 
        
        
    }
    
    
   
    
    
}
