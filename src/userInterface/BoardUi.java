/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Constants;
import core.Disc;
import core.Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jesse
 */
public class BoardUi extends JPanel{
    
    private JButton[][] board;
    private BoardListener listener;
    private Game game;
    private GameUi gameUi;
    
        
        public BoardUi(Game game, GameUi gameUi)
        {
            this.game = game;
            this.gameUi = gameUi;
        
            initComponents();
            
            listener.updateUi();
        }
        
        private void initComponents(){
           this.setPreferredSize(new Dimension(400,400));
           this.setMinimumSize(new Dimension(400,400));
           
           this.setLayout(new GridLayout(Constants.ROWS, Constants.COLUMNS));
           
           board = new JButton[Constants.ROWS][Constants.COLUMNS];
           listener = new BoardListener();
           
           for(int row = 0; row < Constants.ROWS; row++)
           {
               for(int col = 0; col < Constants.COLUMNS; col++)
               {
                   board[row][col] = new JButton();
                   board[row][col].putClientProperty("row", row);
                   board[row][col].putClientProperty("col", col);
                   board[row][col].putClientProperty("color", Constants.EMPTY);
                   board[row][col].setBackground(Color.GREEN);
                   
                   board[row][col].addActionListener(listener);
                   
                   this.add(board[row][col]);
               }
           }
        }

    

private class BoardListener implements ActionListener
{

        @Override
        public void actionPerformed(java.awt.event.ActionEvent ae) {
            
        if(ae.getSource() instanceof JButton){
            
            JButton button = (JButton)ae.getSource();
            int row = (int)button.getClientProperty("row");
            int col = (int)button.getClientProperty("col");
            Color color = (Color)button.getClientProperty("color");
            
             if(isValidMove(row, col, game.getCurrentPlayer().getDisColor()))
            {
                updateUi();
                changePlayer();
            }     
            else
            {
                JOptionPane.showMessageDialog(button, "Move is not valid, select again.");
            }
        }
        }
       
        
            
            private boolean isValidMove(int row, int col, Color color)
            {
                boolean valid = false;
                
                if(board[row][col].getClientProperty("color") != Constants.EMPTY)
                {
                    valid = false; 
                }
                else if(game.getBoard().isValidMove(row, col, color))
                {
                    valid = true;
                }
               
                return valid;
            }
            
            private void changePlayer()
            {
                if(game.getCurrentPlayer() == game.getPlayers().get(Constants.PLAYER_ONE))
                    game.setCurrentPlayer(game.getPlayers().get(Constants.PLAYER_TWO));
                else 
                    game.setCurrentPlayer(game.getPlayers().get(Constants.PLAYER_ONE));
            }
            
            private void updateUi()
            {
                Disc [][] discs = game.getBoard().getBoard();
                ImageIcon disc = null;
                
                for(int row = 0; row < Constants.ROWS; row++)
                {
                    for(int col = 0; col < Constants.COLUMNS; col++)
                    {
                        if(discs[row][col].getDisColor() == Constants.DARK)
                        {
                            disc = new ImageIcon( getClass().getResource("../images/BlackDisc.jpg"));
                            disc = imageResize(disc);
                            
                            board[row][col].setIcon(disc);   
                        }
                        else if(discs[row][col].getDisColor() == Constants.LIGHT)
                        {
                            disc = new ImageIcon(getClass().getResource("../images/WhiteDisc.png"));
                            disc = imageResize(disc);
                            
                            board[row][col].setIcon(disc);
                        }   
                    }      
                }
                
                gameUi.getScoreOne().setText(String.valueOf(game.getPlayers().get(Constants.PLAYER_ONE).getScore()));
                gameUi.getScoreTwo().setText(String.valueOf(game.getPlayers().get(Constants.PLAYER_TWO).getScore()));

            }
    
        private ImageIcon imageResize(ImageIcon icon)
        {
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            return icon;
        }
}
}