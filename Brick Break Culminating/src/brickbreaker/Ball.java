/**
 * 
 * @author Aakash Patel, Aadityah Rajput
 * Mr. Hutchison 
 * ISC4U1-01 
 * June 9, 2016 
 * the ball class that creates the ball and controls the ball movement
 */
package brickbreaker; 

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    
    //instance variable are created
    private int valueofX;
    private int valueofY;
    private int radius;
    private int directionofX;
    private int directionofY;
    
    /* constructor that initializes all the instance variables of the ball
     * @param x for the x-coordinate of the ball 
     * @param y for the y-coordinate of the ball 
     * @param radius for the radius of the ball
    */
    public Ball(int valueofX, int valueofY, int radius) {
        this.valueofX = valueofX;
        this.valueofY = valueofY;
        this.radius = radius;
        this.directionofX = -1;
        this.directionofY = 1;
    }
    
    /* Method that accesses the y-coordinate of the ball 
     * @returns the y-coordinate of the ball    
    */
    public int getY() {
        return this.valueofY;
    }
    
    /* Method that accesses the x-coordinate of the ball 
     * @returns the x-coordinate of the ball    
    */
    public int getX() {
        return this.valueofX;
    }
    
    /* Method that accesses the radius of the ball 
     * @returns the radius of the ball    
    */
    public int getRadius() {
        return this.radius;
    }
    
    /* Method that accesses the vertical direction of the ball 
     * @returns the vertical direction of the ball    
    */
    public int getYDirection() {
        return this.directionofY;
    }
    
    /*
     * Method that accesses the x-coordinate of the ball
     * @param x for x-coordinate
    */
    public void setX(int valueofX) {
        this.valueofX = valueofX;
    }
    
    /*
     * Method that accesses the y-coordinate of the ball
     * @param y for y-coordinate
    */
    public void setY(int valueofY) {
        this.valueofY = valueofY;
    }
    
    /*
     * Method that accesses the horizontal direction of the ball
     * @param x for horizontal direction
    */
    public void setXDirection(int valueofX) {
        this.directionofX = valueofX;
    }
    
    /*
     * Method that accesses the vertical direction of the ball
     * @param y for vertical direction
    */
    public void setYDirection(int valueofY) {
        this.directionofY = valueofY;
    }
    
    /* changeXDir method that changes the horizontal direction of the ball
    */
    public void changeXDir() {
        if (this.directionofX == 1) {
            this.directionofX = -1;
        } else {
            this.directionofX = 1;
        }
    }
    
    /* changeYDir method that changes the vertical direction of the ball
    */
    public void changeYDir() {
        if (this.directionofY == 1) {
            this.directionofY = -1;
        } else {
            this.directionofY = 1;
        }
    }
    
    /* resetBall method to reset the original position of the ball    
    */
    public void resetBall() {
        this.valueofX = 300;
        this.valueofY = 150;
    }
    
    /* update method for the change in direction of ball movement
     *@param xChange - change in x 
     *@param yChange - change in y
    */
    public void update(int xChange, int yChange){
        if (this.directionofX == 1) {
            this.valueofX += xChange;
        } else {
            this.valueofX -= xChange;
        }
        if (this.directionofY == 1) {
            this.valueofY += yChange;
        } else {
            this.valueofY -= yChange;
        }
    }
    
    /* paint method to add graphics
     *@param u - graphics variable used to set and fill colour of ball
     */
    public void paint(Graphics u) {
        u.setColor(Color.white);
        u.fillOval(this.valueofX, this.valueofY, this.radius, this.radius);
    }
}
