/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Color;

/**
 *
 * @author jesse
 */
public class Player {
    private Color disColor;
    private String name;
    private int score;

    /**
     * @return the disColor
     */
    public Color getDisColor() {
        return disColor;
    }

    /**
     * @param disColor the disColor to set
     */
    public void setDisColor(Color disColor) {
        this.disColor = disColor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    
    
}
