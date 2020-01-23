/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author jesse
 */
public class Board 
{
//variable declarations
   private Disc[][] board;
   private int darkCount;
   private int lightCount;
   private ArrayList<Player> players;
   
   public void calculateScore()
   {
       darkCount = 0;
       lightCount = 0;
       for(int row = 0; row < Constants.ROWS; row++)
       {
           for(int col = 0; col < Constants.COLUMNS; col++)
           {
              if(board[row][col].getDisColor() == Constants.DARK)
              {
                  darkCount++;
              }
              
              else if(board[row][col].getDisColor() == Constants.LIGHT)
               lightCount++;  
           }
       }
       
       players.get(Constants.PLAYER_ONE).setScore(darkCount);
       players.get(Constants.PLAYER_TWO).setScore(lightCount);        
   }
 
   public boolean isValidMove(int row, int col, Color color)
   {
       boolean valid = false;
       
       if(checkUp(row, col, color) == true)
        {
            valid = true;          
        }
    
        if(checkUpLeft(row, col, color) == true)
        {
             valid = true;
        }
        if (checkLeft(row, col, color) == true)
        {
             valid = true;
        }
        if(checkLeftDown(row, col, color) == true)
        {    
            valid = true;
        }
        if(checkDown(row, col, color) == true)
        {    
             valid = true;
        }
        if(checkDownRight(row,col, color) == true)
        {
             valid = true;
        }
        if(checkRight(row,col,color) == true)
        {
             valid = true;
        }
        if(checkUpRight(row,col, color) == true)
        {
             valid = true;
        }
        
        if(valid)
        {
             board[row][col].setDisColor(color);
             calculateScore();
        }
       
        return valid;
    } 
  
   private boolean checkUp (int row, int col, Color color)
   {
       int flipSquares = 0;
       int checkRow = row - 1;
       boolean matchFound = false;
       boolean validMove = false;
       
       while(checkRow >= 0 && !matchFound)
       {
           if (board[checkRow][col].getDisColor() == Constants.EMPTY)
           {
               return validMove;
           }
           else if (board[checkRow][col].getDisColor() != color)
           {
                flipSquares++;
           }
           else
           {
               matchFound = true;
           }
           
           checkRow--;
       }
       if(matchFound == true && flipSquares > 0)
       {
           board[row][col].setDisColor(color);
           do{
               row --;
               flipSquares --;
               board[row][col].setDisColor(color);
               
               
           }while(flipSquares > 0);
           
           validMove = true;   
       }
       else
           validMove = false;
       
       return validMove;
   }
       private boolean checkUpLeft (int row, int col, Color color)
    {
        int flipSquares = 0;
        int checkRow = row - 1;
        int checkCol = col - 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow >= 0 && checkCol >= 0 && !matchFound)
        {
            if(board[checkRow][checkCol].getDisColor() == Constants.EMPTY)
            {
                return validMove;
            }
            else if (board[checkRow][checkCol].getDisColor() != color)
            {
                flipSquares++;
            }
            else
            {
                matchFound = true;
            } 
            
            checkRow--;
            checkCol--;
        }
         if(matchFound == true && flipSquares > 0)
       {
           board[row][col].setDisColor(color);
           do{
               row--;
               col--;
               flipSquares --;
               board[row][col].setDisColor(color);
               
           }while(flipSquares > 0);
           
           validMove = true;   
       }
       else
       {
           validMove = false;
       }
      
        return validMove;
    }
           private boolean checkLeft (int row, int col, Color color)
    {
        int flipSquares = 0;
     
        int checkCol = col - 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkCol >= 0 && !matchFound)
        {
            if(board[row][checkCol].getDisColor() == Constants.EMPTY)
            {
                return validMove;
            }
            else if (board[row][checkCol].getDisColor() != color)
            {
                flipSquares++;
            }
            else
            {
                matchFound = true;
            } 
            
            checkCol--;
        }
         if(matchFound == true && flipSquares > 0)
       {
           board[row][col].setDisColor(color);
           do{
               col--;
               flipSquares--;
               board[row][col].setDisColor(color);
               
           }while(flipSquares > 0);
           
           validMove = true;   
       }
       else
       {
           validMove = false;
       }
         
        return validMove;
    }

    private boolean checkLeftDown (int row, int col, Color color)
    {
        int flipSquares = 0;
        int checkRow = row + 1;
        int checkCol = col - 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow < Constants.ROWS && checkCol >= 0 && !matchFound)
        {
            if(board[checkRow][checkCol].getDisColor() == Constants.EMPTY)
            {
                return validMove;
            }
            else if (board[checkRow][checkCol].getDisColor() != color)
            {
                flipSquares++;
            }
            else
            {
                matchFound = true;
            } 
            
            checkRow++;
            checkCol--;
        }
         if(matchFound == true && flipSquares > 0)
       {
           board[row][col].setDisColor(color);
           do{
               row++;
               col--;
               flipSquares --;
               board[row][col].setDisColor(color);
               
           }while(flipSquares > 0);
           
           validMove = true;   
       }
       else
       {
           validMove = false;
       }
         
        return validMove;
    }
    private boolean checkDown (int row, int col, Color color)
    {
        int flipSquares = 0;
        int checkRow = row + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow < Constants.ROWS && !matchFound)
        {
            if(board[checkRow][col].getDisColor() == Constants.EMPTY)
            {
                return validMove;
            }
            else if (board[checkRow][col].getDisColor() != color)
            {
                flipSquares++;
            }
            else
            {
                matchFound = true;
            } 
            
            checkRow++; 
        }
         if(matchFound == true && flipSquares > 0)
       {
           board[row][col].setDisColor(color);
           do{
               row ++;
               flipSquares --;
               board[row][col].setDisColor(color);
               
           }while(flipSquares > 0);
           
           validMove = true;   
       }
       else
       {
           validMove = false;
       }
         
        return validMove;
    }
     private boolean checkDownRight (int row, int col, Color color)
    {
        int flipSquares = 0;
        int checkRow = row + 1;
        int checkCol = col + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow < Constants.ROWS && checkCol < Constants.COLUMNS && !matchFound)
        {
            if(board[checkRow][checkCol].getDisColor() == Constants.EMPTY)
            {
                return validMove;
            }
            else if (board[checkRow][checkCol].getDisColor() != color)
            {
                flipSquares++;
            }
            else
            {
                matchFound = true;
            } 
            
            checkRow++; 
            checkCol++; 
        }
         if(matchFound == true && flipSquares > 0)
       {
           board[row][col].setDisColor(color);
           do{
               row++;
               col++;
               flipSquares --;
               board[row][col].setDisColor(color);
               
           }while(flipSquares > 0);
           
           validMove = true;   
       }
       else
       {
           validMove = false;
       }
         
        return validMove;
    }
    private boolean checkRight (int row, int col, Color color)
    {
        int flipSquares = 0;
        
        int checkCol = col + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkCol < Constants.COLUMNS && !matchFound)
        {
            if(board[row][checkCol].getDisColor() == Constants.EMPTY)
            {
               return validMove;
            }
            else if (board[row][checkCol].getDisColor() != color)
            {
                flipSquares++;
            }
            else
            {
                matchFound = true;
            } 
            
            checkCol++; 
        }
         if(matchFound == true && flipSquares > 0)
       {
           do{
               col++;
               flipSquares --;
               board[row][col].setDisColor(color);
               
           }while(flipSquares > 0);
           
           validMove = true;   
       }
       else
       {
           validMove = false;
       }
         
        return validMove;
    }
    private boolean checkUpRight (int row, int col, Color color)
    {
        int flipSquares = 0;
        int checkRow = row - 1;
        int checkCol = col + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow >= 0 && checkCol < Constants.COLUMNS && !matchFound)
        {
            if(board[checkRow][checkCol].getDisColor() == Constants.EMPTY)
            {
               return validMove;
            }
            else if (board[checkRow][checkCol].getDisColor() != color)
            {
                flipSquares++;
            }
            else
            {
                matchFound = true;
            } 
            
            checkRow--;
            checkCol++; 
        }
         if(matchFound == true && flipSquares > 0)
       {
           board[row][col].setDisColor(color);
           do{
               row --;
               col++;
               flipSquares --;
               board[row][col].setDisColor(color);
               
           }while(flipSquares > 0);
           
           validMove = true;   
       }
       else
       {
           validMove = false;
       }
         
        return validMove;
    }
 
//constuctor
   public Board()
   {
       initObjects();
   }
//method to use initObjects only used in this class so private   
   private void initObjects()
   {
 //creating a new board of  8x8 array      
       board = new Disc[Constants.ROWS][Constants.COLUMNS];
 //loops through and creates all empty discs to be filled
       for(int row = 0; row < Constants.ROWS; row++)
       {
           for(int col = 0; col < Constants.COLUMNS; col++)
           {
               board[row][col] = new Disc();
           }
       }
//initial board setup       
    board[3][3].setDisColor(Constants.LIGHT);
    board[3][4].setDisColor(Constants.DARK);
    board[4][3].setDisColor(Constants.DARK);
    board[4][4].setDisColor(Constants.LIGHT);
   
   }

    /**
     * @return the board
     */
    public Disc[][] getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Disc[][] board) {
        this.board = board;
    }

    /**
     * @return the darkCount
     */
    public int getDarkCount() {
        return darkCount;
    }

    /**
     * @param darkCount the darkCount to set
     */
    public void setDarkCount(int darkCount) {
        this.darkCount = darkCount;
    }

    /**
     * @return the lightCount
     */
    public int getLightCount() {
        return lightCount;
    }

    /**
     * @param lightCount the lightCount to set
     */
    public void setLightCount(int lightCount) {
        this.lightCount = lightCount;
    }

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



}
