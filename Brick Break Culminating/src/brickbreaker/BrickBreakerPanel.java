/**
 * 
 * @author Aakash Patel, Aadityah Rajput
 * Mr. Hutchison 
 * ISC4U1-01 
 * June 9, 2016 
 * 
 */
package brickbreaker; 

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.Timer;

import java.awt.Graphics;

public class BrickBreakerPanel extends javax.swing.JPanel {

    private final BrickGame game;

    /** Creates new form BrickBreakerPanel */
    public BrickBreakerPanel() {
        initComponents();
        setBackground(Color.BLACK);
        this.game = new BrickGame(); //A game object is created.
        Timer myTimer;
        myTimer = new Timer(7, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){    
                formActionPerformed(evt);
            }
        });

        myTimer.start();
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
   
    private void initComponents() {

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        game.paint(g);
        
    }
    
    private void formKeyPressed(KeyEvent evt) {
        this.game.formKeyPressed(evt);
        this.repaint();
    }

    private void formActionPerformed(ActionEvent evt) {
        this.game.formActionPerformed(evt);
        this.repaint();
    }

    
}
