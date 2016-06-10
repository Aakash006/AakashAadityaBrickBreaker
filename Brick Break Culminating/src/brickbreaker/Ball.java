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
    private int x;
    private int y;
    private int radius;
    private int dirX;
    private int dirY;
    
    /* constructor that initializes all the instance variables of the ball
     * @param x for the x-coordinate of the ball 
     * @param y for the y-coordinate of the ball 
     * @param radius for the radius of the ball
    */
    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.dirX = -1;
        this.dirY = 1;
    }
    
    /* Method that accesses the y-coordinate of the ball 
     * @returns the y-coordinate of the ball    
    */
    public int getY() {
        return this.y;
    }
    
    /* Method that accesses the x-coordinate of the ball 
     * @returns the x-coordinate of the ball    
    */
    public int getX() {
        return this.x;
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
        return this.dirY;
    }
    
    /*
     * Method that accesses the x-coordinate of the ball
     * @param x for x-coordinate
    */
    public void setX(int x) {
        this.x = x;
    }
    
    /*
     * Method that accesses the y-coordinate of the ball
     * @param y for y-coordinate
    */
    public void setY(int y) {
        this.y = y;
    }
    
    /*
     * Method that accesses the horizontal direction of the ball
     * @param x for horizontal direction
    */
    public void setXDirection(int x) {
        this.dirX = x;
    }
    
    /*
     * Method that accesses the vertical direction of the ball
     * @param y for vertical direction
    */
    public void setYDirection(int y) {
        this.dirY = y;
    }
    
    /* changeXDir method that changes the horizontal direction of the ball
    */
    public void changeXDir() {
        if (this.dirX == 1) {
            this.dirX = -1;
        } else {
            this.dirX = 1;
        }
    }
    
    /* changeYDir method that changes the vertical direction of the ball
    */
    public void changeYDir() {
        if (this.dirY == 1) {
            this.dirY = -1;
        } else {
            this.dirY = 1;
        }
    }
    
    /* resetBall method to reset the original position of the ball    
    */
    public void resetBall() {
        this.x = 300;
        this.y = 150;
    }
    
    /* update method for the change in direction of ball movement
     *@param xChange - change in x 
     *@param yChange - change in y
    */
    public void update(int xChange, int yChange){
        if (this.dirX == 1) {
            this.x += xChange;
        } else {
            this.x -= xChange;
        }
        if (this.dirY == 1) {
            this.y += yChange;
        } else {
            this.y -= yChange;
        }
    }
    
    /* paint method to add graphics
     *@param g - graphics variable used to set and fill colour of ball
     */
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(this.x, this.y, this.radius, this.radius);
    }
}
