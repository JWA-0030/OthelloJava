//Jesse Alsing
//UCF
//COP330 Object Oriented Programming
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Othello;

import core.Game;
import userInterface.OthelloUi;

/**
 *
 * @author jesse
 */
public class Othello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//create new game      
        Game game = new Game();
        OthelloUi othelloUi = new OthelloUi(game); 
    }
    
}
