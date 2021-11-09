package com.min23asdwPhu.OnlyThreeColors;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.JFrame;

import static java.lang.Math.*;

public class Game_V1 implements GLEventListener {

    private float rtri;  //for angle of line  rotation

    @Override
    public void display(GLAutoDrawable drawable) {
        //800px 800px
        // 40 part per axis x , y
        // 1 part = 0.05f = 20px

        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear (GL2.GL_COLOR_BUFFER_BIT |  GL2.GL_DEPTH_BUFFER_BIT );

        // Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();  // Reset The View

        // Drawing Using line

        //##   laser soure
        //{***********************************************
        gl.glBegin(GL2.GL_LINES);

        gl.glVertex2f(-0.5f, 0.6f);
        gl.glVertex2f(-0.6f, -0.6f);

        //push to int rotation
        gl.glPushMatrix();
        //line rotation

        gl.glRotatef( rtri, 0.0f, 1.0f, 0.0f );
        //pop to out of rotation
        gl.glPopMatrix();

        gl.glEnd();
        gl.glFlush();
        rtri += 0.2f;  //assigning the angle
        // ***********************************************}


        //##   drawing the bordor
        //{***********************************************
        for (int j = 1; j <= 4; j++) {
            float point_x = 0.7f;
            float point_y = 0.7f;
            gl.glBegin(GL2.GL_LINES);
            if (j == 1) {
                gl.glVertex2f(point_x, point_y);
                gl.glVertex2f(-point_x, point_y);
            }
            if (j == 2) {
                gl.glVertex2f(-point_x, point_y);
                gl.glVertex2f(-point_x, -point_y);
            }
            if (j == 3) {
                gl.glVertex2f(-point_x, -point_y);
                gl.glVertex2f(point_x, -point_y);
            }
            if (j == 4) {
                gl.glVertex2f(point_x, -point_y);
                gl.glVertex2f(point_x, point_y);
            }
            gl.glEnd();
        }
        // ***********************************************}



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
        final JFrame frame = new JFrame("frame");

        //adding canvas to frame
        frame.getContentPane().add(glcanvas);

        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);


        // make it refresh (fps)
        final FPSAnimator animator = new FPSAnimator(glcanvas, 60,true);
        System.out.println("fps = "+ animator.getFPS());
        animator.start();

    }//end of main

}//end of classimport javax.media.opengl.GL2;