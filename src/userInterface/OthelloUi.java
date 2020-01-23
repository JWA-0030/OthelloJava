/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author jesse
 */
public class OthelloUi extends JFrame {
    
    private Game game;
    private GameUi gameUi;
    private BoardUi boardUi;
    
    public OthelloUi(Game game){
        this.game = game;
        
        initComponents();
    }

    private void initComponents(){
        
        this.setPreferredSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(600, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        gameUi = new GameUi(game);
        boardUi = new BoardUi(game, gameUi);
        
        this.add(gameUi, BorderLayout.NORTH);
        this.add(boardUi, BorderLayout.CENTER);
        this.setVisible(true);

    }
}
