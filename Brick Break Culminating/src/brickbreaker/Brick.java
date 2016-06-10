/**
 * 
 * @author Aakash Patel, Aadityah Rajput
 * Mr. Hutchison 
 * ISC4U1-01 
 * June 9, 2016 
 * the brick class that creates the brick and controls the bricks
 */

package brickbreaker; 

import java.awt.Color;
import java.awt.Graphics;

public class Brick {
    //instance variables and constants are created
    private final int xvalue;
    private final int yvalue;
    private final int XSize;
    private final int YSize;
    private boolean brick;
    
     /* 
     * constructor that initializes all the instance variables of the base
     * @param x for the x-coordinate of the brick 
     * @param y for the y-coordinate of the brick
     * @param X for the horizontal length of the brick
     * @param Y for the vertical length of the brick
     */
    public Brick(int xvalue, int yvalue, int XSize, int YSize) {
        this.xvalue = xvalue;
        this.yvalue = yvalue;
        this.XSize = XSize;
        this.YSize = YSize;
        this.brick = true;
    }
    
    /* 
     * Method that accesses the brick 
     * @returns the brick    
     */
    public boolean getBrick() {
        return this.brick;
    }
    
    /*
     * Method that accesses the brick
     * @param life for initializing the brick
     */
    public void setBrick(boolean life) {
        this.brick = life;
    }
    
    /*
     * Method that accesses the x-coordinate of the brick
     * @returns the x-coordinate of the brick   
     */
    public int getX() {
        return this.xvalue;
    }
    
    /*
     * Method that accesses the y-coordinate of the brick 
     * @returns the y-coordinate of the brick   
     */
    public int getY() {
        return this.yvalue;
    }
    
    /*
     * Method that accesses the horizontal size of the brick 
     * @returns the horizontal size of the brick  
     */
    public int getXSize() {
        return this.XSize;
    }
    
    /*
     * Method that accesses the vertical size of the brick 
     * @returns the vertical size of the brick
     */
    public int getYSize() {
        return this.YSize;
    }
    
    /* 
     * paint method to add graphics
     * @param a - graphics variable used to set and fill colour of bricks
     */    
    public void paint(Graphics a) {
        a.setColor(Color.BLUE);
        a.fillRect(this.xvalue, this.yvalue, this.XSize, this.YSize);
    }
}

