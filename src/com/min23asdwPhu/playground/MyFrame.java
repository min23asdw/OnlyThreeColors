package com.min23asdwPhu.playground;

import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements GLEventListener  {

    @Override
    public void display(GLAutoDrawable drawable) {
//        final GL2 gl = drawable.getGL().getGL2();
//        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
//        // Clear The Screen And The Depth Buffer
////        gl.glLoadIdentity();  // Reset The View
//        gl.glBegin(GL2.GL_POLYGON);
//
//
//        gl.glEnd();
//        gl.glFlush();

    }

    @Override
    public void init(GLAutoDrawable drawable) {
        drawable.getAnimator().setUpdateFPSFrames(3, null);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

    }
//    DragPanel dragPanel = new DragPanel();

//    MyFrame(){
//
//        this.add(dragPanel);
//        this.setTitle("Drag & Drop demo");
//        this.setSize(600, 600);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//
//    }
//    JFrame j = new JFrame();
//
    public static void main(String[] args) {

//        MyFrame myFrame = new MyFrame();
        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        //int Game_V1
        MyFrame obj = new  MyFrame();  // display

        //add obj to canvas
        glcanvas.addGLEventListener(obj);
//        glcanvas.setSize(800, 800);

        //creating frame
        final JFrame frame = new JFrame("Drag");
        DragPanel contex = new DragPanel();
        //adding canvas to frame
        frame.getContentPane().add(contex);  // or use frame.add(contex)


        frame.setSize(1900,1080);
        frame.setVisible(true);

        // make it refresh (fps)
        final FPSAnimator animator = new FPSAnimator(glcanvas, 60, true);
        System.out.println("fps = " + animator.getFPS());
        animator.start();


    }
}