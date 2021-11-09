package com.min23asdwPhu.OnlyThreeColors;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;
import static java.lang.Math.*;

public class Game_V1 implements GLEventListener {

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glBegin (GL2.GL_LINES);

        //800px 800px
        // 40 part per axis x , y
        // 1 part = 0.05f = 20px

        //drawing the bordor
        for(int i = 1 ; i <= 20 ; i++){
            float point_x = i*0.05f;
            float point_y = i*0.05f;

            for (int j = 1 ; j<= 4 ; j++){
                gl.glBegin (GL2.GL_LINES);
                if(j == 1){
                    gl.glVertex2f(point_x, point_y);
                    gl.glVertex2f(-point_x, point_y);
                }
                if(j == 2){
                    gl.glVertex2f(-point_x, point_y);
                    gl.glVertex2f(-point_x, -point_y);
                }
                if(j == 3){
                    gl.glVertex2f(-point_x, -point_y);
                    gl.glVertex2f(point_x, -point_y);
                }
                if(j == 4){
                    gl.glVertex2f(point_x, -point_y);
                    gl.glVertex2f(point_x, point_y);
                }
                gl.glEnd();
            }
        }





        // gl.glFlush();

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        //method body
    }

    @Override
    public void init(GLAutoDrawable arg0) {
        // method body
    }

    public static void main(String[] args) {

        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        //int Game_V1
        Game_V1 l = new Game_V1();  // display
        //add line to canvas
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(800, 800);

        //creating frame
        final JFrame frame = new JFrame ("frame");

        //adding canvas to frame
        frame.getContentPane().add(glcanvas);

        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }//end of main

}//end of classimport javax.media.opengl.GL2;