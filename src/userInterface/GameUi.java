/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Constants;
import core.Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author jesse
 */
public class GameUi extends JPanel {
    
    private JLabel nameOne;
    private JLabel nameTwo;
    private JLabel scoreOne;
    private JLabel scoreTwo;
    private Game game;
    
    public GameUi(Game game)
    {
        this.game = game;
        initComponents();
    }
    private ImageIcon imageResize(ImageIcon icon)
        {
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            return icon;
        }
    
    private void initComponents()
    {
        this.setPreferredSize(new Dimension(50, 50));
        this.setMinimumSize(new Dimension(50, 50));
        this.setBackground(Color.LIGHT_GRAY);
        
        ImageIcon discOne = new ImageIcon( getClass().getResource("../images/BlackDisc.jpg"));
        discOne = imageResize(discOne);
        
        setNameOne(new JLabel());
        getNameOne().setIcon(discOne);
        getNameOne().setText(getGame().getPlayers().get(Constants.PLAYER_ONE).getName());
        getNameOne().setPreferredSize(new Dimension(150, 50));
        getNameOne().setMinimumSize(new Dimension(150, 50));
        getNameOne().setBackground(Color.LIGHT_GRAY);
        getNameOne().setFont(new Font("Serif", Font.BOLD, 22));
        
        ImageIcon discTwo = new ImageIcon( getClass().getResource("../images/WhiteDisc.png"));
        discTwo = imageResize(discTwo);
        
        setNameTwo(new JLabel());
        getNameTwo().setIcon(discTwo);
        getNameTwo().setText(getGame().getPlayers().get(Constants.PLAYER_TWO).getName());
        getNameTwo().setPreferredSize(new Dimension(150, 50));
        getNameTwo().setMinimumSize(new Dimension(150, 50));
        getNameTwo().setBackground(Color.LIGHT_GRAY);
        getNameTwo().setFont(new Font("Serif", Font.BOLD, 22));  
        
        setScoreOne(new JLabel());
        getScoreOne().setText(String.valueOf(getGame().getPlayers().get(Constants.PLAYER_ONE).getScore()));
        getScoreOne().setMinimumSize(new Dimension(100, 50));
        getScoreOne().setPreferredSize(new Dimension(100, 50));
        getScoreOne().setBackground(Color.LIGHT_GRAY);
        getScoreOne().setFont(new Font("Serif", Font.BOLD, 22));
        
        setScoreTwo(new JLabel());
        getScoreTwo().setText(String.valueOf(getGame().getPlayers().get(Constants.PLAYER_TWO).getScore()));
        getScoreTwo().setMinimumSize(new Dimension(100, 50));
        getScoreTwo().setPreferredSize(new Dimension(100, 50));
        getScoreTwo().setBackground(Color.LIGHT_GRAY);
        getScoreTwo().setFont(new Font("Serif", Font.BOLD, 22));
        
        this.add(getNameOne());
        this.add(getScoreOne());
        this.add(getNameTwo());
        this.add(getScoreTwo());
    }

    /**
     * @return the nameOne
     */
    public JLabel getNameOne() {
        return nameOne;
    }

    /**
     * @param nameOne the nameOne to set
     */
    public void setNameOne(JLabel nameOne) {
        this.nameOne = nameOne;
    }

    /**
     * @return the nameTwo
     */
    public JLabel getNameTwo() {
        return nameTwo;
    }

    /**
     * @param nameTwo the nameTwo to set
     */
    public void setNameTwo(JLabel nameTwo) {
        this.nameTwo = nameTwo;
    }

    /**
     * @return the scoreOne
     */
    public JLabel getScoreOne() {
        return scoreOne;
    }

    /**
     * @param scoreOne the scoreOne to set
     */
    public void setScoreOne(JLabel scoreOne) {
        this.scoreOne = scoreOne;
    }

    /**
     * @return the scoreTwo
     */
    public JLabel getScoreTwo() {
        return scoreTwo;
    }

    /**
     * @param scoreTwo the scoreTwo to set
     */
    public void setScoreTwo(JLabel scoreTwo) {
        this.scoreTwo = scoreTwo;
    }

    /**
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(Game game) {
        this.game = game;
    }
}

    

