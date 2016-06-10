/**
 * 
 * @author Aakash Patel, Aadityah Rajput
 * Mr. Hutchison 
 * ISC4U1-01 
 * June 9, 2016 
 * the BrickGame class that contains the update method and controls how the whole game works
 */

package brickbreaker; 

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class BrickGame {
    
    private int score;
    private int lives;
    private final Base base;
    private final Ball ball;
    private final Brick [] brick;
    private  int x;
    private  int y;     
    private boolean collide, endGame, win; 
    
     /* 
     * constructor that initializes all the instance variables of the base and creates the bricks
     */
    public BrickGame() {
        
        ball = new Ball(300,200,15); //creates the ball 
        base = new Base(250,570,80,10); //creates the base
        brick = new Brick[34]; //creates the array of brick
        this.score = 0;
        this.collide = false; 
        this.endGame = false;
        this.win = false; 
        this.lives = 4; 
        this.x = 20;
        this.y = 60; 
        //creates all the bricks in the game
        for (int i = 0; i< 34; i++){
            brick[i] = new Brick(x,y,50,10);
            x+=60;
            //sets the bricks in 4 lines 
            if (i == 8){ 
                x = 50;
                y = 80;
            }
            if (i == 16){
                x = 20;
                y = 100;
            }
            if (i == 25){
                x = 50; 
                y = 120; 
            }
        } 
        
       
    }
    
    /*
     * checkPaddle method that checks if the ball has hit the paddle 
    */
    public void checkPaddle() {
        //calculates coordinate differences between the ball and the paddle position
        int yDifference = base.getY() - (ball.getY()+ball.getRadius());
        int xDiffOne = (ball.getX()+ball.getRadius()) - base.getX();
        int xDiffTwo = (base.getX()+base.getXSize()) - ball.getX();
        
        //changes direction of the ball if it collides with the paddle
        if ((yDifference <= 1) && (xDiffOne >= 1) && (xDiffTwo >= 1)) {
            if (!collide) {
                ball.changeYDir();
                collide = true;
            }
        }
    }
    
    /*
     * checkBrick method that checks if the ball has hit the brick
    */
    public boolean checkBrick(Brick brick) {
        
        int yDiff;
        if ((ball.getYDirection() == 1) &&
                (ball.getY()+ball.getRadius() < brick.getY())) {
            yDiff = brick.getY() - (ball.getY()+ball.getRadius());
        } else {
            yDiff = ball.getY() - (brick.getY()+brick.getYSize());
        }
        
        int xDiffFirst = (ball.getX()+ball.getRadius()) - brick.getX();
        int xDiffSecond = (brick.getX()+brick.getXSize()) - ball.getX();        
        if ((yDiff <= 0) && (xDiffFirst>= 0) && (xDiffSecond >= 0)) {
            collide = false;
            ball.changeYDir();
            this.score += 10;
            if (score == 340){
                this.win = true; 
                ball.resetBall();
            }
            return true;
        }
        return false;
    }
    
    /*
     * checkBrick method to see which brick is hit by the ball 
    */
    public void checkBrick() {
        for (int i = 0; i<34;i++){
            if (brick[i].getBrick() == true) {
                 if (checkBrick(brick[i])) {
                     brick[i].setBrick(false);
                }
            }
        }      
    }
    
    /*
     * checkWall method to check if the ball collides with the walls
    */
    public void checkWall() {
        if (ball.getX() <= 0) {
            ball.changeXDir();
            collide = false;
        } else if ((ball.getX() + ball.getRadius()) >= 580) {
            ball.changeXDir();
            collide = false;
        } else if (ball.getY() <= 40) {
            ball.changeYDir();
            collide = false;
        } else if ((ball.getY() + ball.getRadius()) >= 580) {
            base.resetBase();
            ball.resetBall();
            //player loses one life if they miss the ball 
            if ((this.lives <1)&&(this.score!=340)){
                endGame = true;
            }else {
                this.lives--;
            }
        }
    }
    
    /*
     * checkCollisions method that checks all types of possible collisions 
    */
    public void checkCollisions() {
        checkPaddle();
        checkBrick();
        checkWall();
    }
    
    /* 
     * paint method to add graphics
     * @param g - graphics variable used to set boundaries and draw strings
     */    
    public void paint(Graphics g) {
       g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
       if ((endGame == false)&&(win == false)){
            this.ball.paint(g);
            this.base.paint(g);
            g.setColor(Color.orange);
            g.drawString("Score: ",20,30);
            g.drawString(Integer.toString(this.score),80,30);
            g.drawString("Lives: ",480,30);
            g.drawString(Integer.toString(this.lives),540,30);
            g.setColor(Color.green);
            g.drawString("BRICK BREAKER ",230,30);
            
            drawBricks(g);
            g.drawLine(0,40,580,40);
       }else if (endGame == true){
            g.setColor(Color.green);
            g.drawString("You lost, better luck next time :D",180,300);
       }
       if (win == true){
            g.setColor(Color.green);
            g.drawString("CONGRATULATIONS!! YOU WONN !! :D", 160, 300);
       }
    }
    
    /* 
     * paint method to add graphics for bricks
     * @param g - graphics variable used to call the paint method from the Brick class
     */    
    public void drawBricks(Graphics g) {
        for (int i = 0; i<34; i++){
            if (brick[i].getBrick() == true) {
                this.brick[i].paint(g);
            }
        }       
    }
   
    /*
     * update method that calls the update method in the Ball class
    */
    public void update() {         
        ball.update(2,2);
    }
    
      /* formKeyPressed method allows the paddle to move side to side
     * @param e - used as a variable for keyboard recognizition
     */
    public void formKeyPressed(KeyEvent evt) {
        if ((this.base.getX() == 0)) {
            if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                this.base.moveBase(40,0);
            }
        } else if (((this.base.getX() + this.base.getXSize())
                == 580)) {
            if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                this.base.moveBase(-40,0);
            } 
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            this.base.moveBase(-40,0);
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.base.moveBase(40,0);
        }
    }

    public void formActionPerformed(ActionEvent evt) {
        update();
        checkCollisions();
    }
}

