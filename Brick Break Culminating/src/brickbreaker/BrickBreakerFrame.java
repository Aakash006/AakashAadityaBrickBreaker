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
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.WindowConstants;

/**
 *
 * @author 
 */
public class BrickBreakerFrame extends javax.swing.JFrame {

    /** Creates new form BrickBreakerFrame */
    public BrickBreakerFrame() {
        initComponents();
        
    }


    private void initComponents() {
        
        brickBreakerPanel1 = new brickbreaker.BrickBreakerPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout movingSquarePanel1Layout = new GroupLayout(brickBreakerPanel1);
        brickBreakerPanel1.setLayout(movingSquarePanel1Layout);
        
        movingSquarePanel1Layout.setHorizontalGroup(
            movingSquarePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        
        movingSquarePanel1Layout.setVerticalGroup(
            movingSquarePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(brickBreakerPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(brickBreakerPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        
        EventQueue.invokeLater(new Runnable() {            
            @Override
            public void run() {
                new BrickBreakerFrame().setVisible(true);
            }
        });
    }

    
    private brickbreaker.BrickBreakerPanel brickBreakerPanel1;
    

}