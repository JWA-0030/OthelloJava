/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.Constants;
import core.Board;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jesse
 */
public class Game {
//variable declaration   
    private ArrayList<Player>players; 
    private Board board;
    private Player currentPlayer;
    
  /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    

    

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }
    
      public Game()
   {
       initObjects();
   }
     
    private void initObjects()
    {
        board = new Board();
        createPlayers();
        
        printPlayers();
        board.setPlayers(players);
        setCurrentPlayer(players.get(Constants.PLAYER_ONE));
        
    }
  

  
 //method that creates the player   
    private void createPlayers()
    {
     //creates a new player using the array list in Player
        players = new ArrayList<Player>();
    //loop through twice    
        for(int i = 0; i < Constants.MAX_PLAYERS; i++)
        {
 //like a scanf that puts user input into a string           
            String name = JOptionPane.showInputDialog(null, "Enter player's name");
 //then create a new player
            Player player= new Player(); 
 //then calls the setname function           
            player.setName(name);
 //then if else to set player one to dark and player two to light           
            if(i == Constants.PLAYER_ONE)
                player.setDisColor(Constants.DARK);
            else
                player.setDisColor(Constants.LIGHT);
 //then add player instance to variable           
            players.add(player);
        }  
    }
    private void printPlayers()
    {
//basic printf
        System.out.println("The game has the following players:");
//basically an easy for loop to loop through the two players        
        for(Player i : players)
        {
 //prints the getters of name and discolor           
            System.out.println("Player " + i.getName() +" is playing disc color " + i.getDisColor());
        }
        
    }

    /**
     * @return the currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @param currentPlayer the currentPlayer to set
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
}
