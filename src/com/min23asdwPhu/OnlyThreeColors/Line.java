package com.min23asdwPhu.OnlyThreeColors;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;

public class Line implements GLEventListener {

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl1 = drawable.getGL().getGL2();
        final GL2 gl2 = drawable.getGL().getGL2();
        final GL2 gl3 = drawable.getGL().getGL2();

        gl1.glBegin (GL2.GL_LINES);//static field
        gl2.glBegin (GL2.GL_LINES);//static field
        gl3.glBegin (GL2.GL_LINES);//static field

        // red laser
        gl1.glVertex2f(0.50f,-0.50f);
        gl1.glVertex2f(-0.50f,0.50f);
        gl1.glColor3f(1f,0f,0f);

        // green laser
        gl2.glVertex2f(4.0f,-1.50f);
        gl2.glVertex2f(-5.50f,2.50f);
        gl2.glColor3f(0f,1f,0f);

        //blue laser
        gl3.glVertex2f(2.0f,-6.50f);
        gl3.glVertex2f(-1.50f,3.50f);
        gl3.glColor3f(0f,0f,1f);
        gl1.glEnd();
        gl2.glEnd();
        gl3.glEnd();

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

        Line l = new Line();  // display

        glcanvas.addGLEventListener(l);
        glcanvas.setSize(400, 400);

        //creating frame
        final JFrame frame = new JFrame ("straight Line");

        //adding canvas to frame
        frame.getContentPane().add(glcanvas);

        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }//end of main

}//end of classimport javax.media.opengl.GL2;