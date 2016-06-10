/**
 * 
 * @author Aakash Patel, Aadityah Rajput
 * Mr. Hutchison 
 * ISC4U1-01 
 * June 9, 2016 
 *  the base class that creates the base and controls the ball movement
 */

package brickbreaker; 

import java.awt.Color;
import java.awt.Graphics;

public class Base {
    //instance variable and constants are created
    private int x;
    private int y;
    private final int sizeofX;
    private final int sizeofY;
    
    /* 
     * constructor that initializes all the instance variables of the ball
     * @param x for the x-coordinate of the base 
     * @param y for the y-coordinate of the base 
     * @param X for the horizontal length of the base
     * @param Y for the vertical length of the base
     */
    public Base(int x, int y, int XSize, int YSize) {
        this.x = x;
        this.y = y;
        this.sizeofX = XSize;
        this.sizeofY = YSize;
    }
    
    /* 
     * Method that accesses the x-coordinate of the base 
     * @returns the x-coordinate of the base    
     */
    public int getX() {
        return this.x;
    }
   
    /* 
     * Method that accesses the y-coordinate of the base 
     * @returns the y-coordinate of the base    
     */
    public int getY() {
        return this.y;
    }
    
    /*
     * Method that accesses the vertical size of the base 
     * @returns the vertical size of the base    
     */
    public int getYSize() {
        return this.sizeofY;
    }
    
    /*
     * Method that accesses the horizontal size of the base 
     * @returns the horizontal size of the base    
     */
    public int getXSize() {
        return this.sizeofX;
    }
    
    /*
     * Method that accesses the x-coordinate of the base
     * @param x for x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /* 
     * Method to move the base 
     * @param ChangeofX for change in x-coordinate
     * @param ChangeofY for change in y-coordinate 
     */
    public void moveBase(int ChangeofX, int ChangeofY){
        this.x += ChangeofX;
        this.y += ChangeofY;
    }
    
    /*
     * resetBase method that resets the original position of the base
     */
    public void resetBase() {
        this.x = 250;
        this.y = 570;
    }
    
    /* 
     * paint method to add graphics
     * @param g - graphics variable used to set and fill colour of base
     */
    public void paint(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(this.x, this.y, this.sizeofX, this.sizeofY);
    }
}

