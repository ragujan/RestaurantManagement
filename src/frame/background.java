package frame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author acer
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// the following imports are needed for pictures
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class background{ 
    // Game Window properties
    static boolean inflight;
    static JFrame gameWindow;
    static GraphicsPanel canvas;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int TOP = 0;
    static final int BOTTOM = 565;
    static final int LEFT = 0;
    static final int RIGHT = 780;    
    // key listener
    static MyKeyListener keyListener = new MyKeyListener(); 
    
    // player properties
    static final int GROUND = 565;
    static final int RUN_SPEED = 10;
    static final int JUMP_SPEED = -30;
    static final int GRAVITY = 2;

    static int objectW = 20;
    static int objectH = 40;
    static int objectX = WIDTH/2;
    static int objectY = GROUND - objectH;
    static int objectVx = 0;
    static int objectVy = 0;

    // background properties
    static BufferedImage background;
    static int backgroundX = 0;
    static int backgroundY = 0;
    static int backgroundH;
    static int backgroundW;
    
    // moving object properties
    static BufferedImage leftArrow;
    static BufferedImage rightArrow;
    static BufferedImage upArrow;
    static BufferedImage downArrow;
    static BufferedImage object;
    static int object1X = WIDTH/2;
    static int object1Y = HEIGHT/2;

    static int stepX = 5;
    static int stepY = 5;
    
//------------------------------------------------------------------------------    
    public static void main(String[] args){
        gameWindow = new JFrame("Game Window");
        gameWindow.setSize(WIDTH,HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new GraphicsPanel();
        canvas.addKeyListener(keyListener);          
        gameWindow.add(canvas); 
        
    // load the images from files
        try {                
            background = ImageIO.read(new File("BG final.png"));
        } catch (IOException ex){} 
        backgroundW = background.getWidth();
        backgroundH = background.getHeight();
        
        object = rightArrow;

        JLabel label = new JLabel();
        canvas.add(label);
        gameWindow.setVisible(true);
        runGameLoop();
        
    } // main method end
    
//------------------------------------------------------------------------------   
    public static void runGameLoop(){
        while (true) {
            gameWindow.repaint();
            try  {Thread.sleep(20);} catch(Exception e){}
            
            // object functionality
            objectX = objectX + objectVx;
            objectVy = objectVy + GRAVITY;
            objectY = objectY + objectVy;
            if (objectY+objectH >= GROUND){
                objectY = GROUND - objectH;
                objectVy = 0;
            }
        }
    } // runGameLoop method end
    
//------------------------------------------------------------------------------  
    static class GraphicsPanel extends JPanel{
        public GraphicsPanel(){
            setFocusable(true);
            requestFocusInWindow();
        }
        public void paintComponent(Graphics g){ 
            super.paintComponent(g); //required
            
        // draw the background image and the object   
            g.drawImage(background,backgroundX,backgroundY,this);
            g.drawImage(object,object1X,object1Y,this);
            
            g.setColor(Color.red);
            g.fillRect(objectX,objectY,objectW,objectH);
            // only set the velocity in horizontal direction to zero, if the cube is on the ground.
            if(inflight && objectY == (GROUND-objectH)) {
                inflight = false;
                objectVx = 0;
            }
        } // paintComponent method end
    } // GraphicsPanel class end
    
//-------------------------------------------------------------------------------------
    static class MyKeyListener implements KeyListener{
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && backgroundX <= 0){
            // move the background to the right   
                backgroundX = backgroundX + stepX;
                object = leftArrow;
            } else if (key == KeyEvent.VK_RIGHT && backgroundX >= RIGHT - backgroundW){
            // move the background to the left
                backgroundX = backgroundX - stepX;
                object = rightArrow;
            } else if (key == KeyEvent.VK_UP && backgroundY <= 0){
            // move the background down
                object = upArrow;
                if (inflight != true){
                    objectVy = JUMP_SPEED;
                    inflight = true;
                }
            } else if (key == KeyEvent.VK_DOWN && backgroundY >= BOTTOM - backgroundH){
            // move the background up
                object = downArrow;
            } else if (key == KeyEvent.VK_UP && key == KeyEvent.VK_LEFT){
                backgroundX = backgroundX - stepX;
                object = rightArrow;

                object = upArrow;
                if (inflight != true){
                    objectVy = JUMP_SPEED;
                    inflight = true;
                }
            } else{
                objectVx = 0;
            }
        }
        public void keyReleased(KeyEvent e){
            if(objectY == (GROUND-objectH)) {
                objectVx = 0;
            }
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ESCAPE){
                gameWindow.dispose();
            }
        }       
        public void keyTyped(KeyEvent e){
            char keyChar = e.getKeyChar();
        }
    } // MyKeyListener class end
    
} // RelativeMovement class end
