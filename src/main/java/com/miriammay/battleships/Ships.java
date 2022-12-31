/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miriammay.battleships;
import java.util.Random;
/**
 *
 * @author Miriam Smith
 */
public class Ships {
    //private final int CARRIER = 5;
    //private final int BATTLESHIP = 4;
    //private final int CRUISER = 3;
    //private final int SUBMARINE = 3;
    //private final int DESTROYER = 2;
    
    
    
    public int[][] allShips(){
        
        Random random = new Random();
        
        //set first random start position
        int carrierNum = (random.nextInt(10)-1);
        
        //create variables for other random start positions
        int battleshipNum = (random.nextInt(10)-1);
        int cruiserNum = (random.nextInt(10)-1);
        int subNum = (random.nextInt(10)-1);
        int destroyerNum = (random.nextInt(10)-1);
        
        //go through each ship, making sure each has a unique random number
        do {
            if (battleshipNum == carrierNum){
                    battleshipNum = (random.nextInt(10)-1);
            }
        } while(battleshipNum==carrierNum);
        
        
        do {
            if (cruiserNum == carrierNum || cruiserNum == battleshipNum){
                    cruiserNum = (random.nextInt(10)-1);
            }
        } while(cruiserNum == carrierNum || cruiserNum == battleshipNum);
        
        do {
            if (subNum == cruiserNum ||
                subNum == carrierNum ||
                subNum == battleshipNum) { 
                    subNum = (random.nextInt(10)-1);
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
                    destroyerNum = (random.nextInt(10)-1);
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
                {1, carrierNum},
                {2, carrierNum},
                {3, carrierNum},
                {4, carrierNum},
                {5, carrierNum},
                {0, battleshipNum},
                {1, battleshipNum},
                {2, battleshipNum},
                {3, battleshipNum},
                {cruiserNum, 0},
                {cruiserNum, 1},
                {cruiserNum, 2},
                {subNum, 2},
                {subNum, 3},
                {subNum, 4},
                {1, destroyerNum},
                {2, destroyerNum}
            };
            
            return allTheShips;
        }
        
        else {
            int[][] allTheShips = {
                {carrierNum, 1},
                {carrierNum, 2},
                {carrierNum, 3},
                {carrierNum, 4},
                {carrierNum, 5},
                {battleshipNum, 0},
                {battleshipNum, 1},
                {battleshipNum, 2},
                {battleshipNum, 3},
                {0, cruiserNum},
                {1, cruiserNum},
                {2, cruiserNum},
                {2, subNum},
                {3, subNum},
                {4, subNum},
                {destroyerNum, 1},
                {destroyerNum, 2}
            };
            
            return allTheShips;
        }
 
        
        
    }
    
    
   
    
    
}
