 

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;

public class Line implements GLEventListener {

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glBegin (GL2.GL_LINES);

        //drawing the v
        gl.glBegin (GL2.GL_LINES);
        gl.glVertex2f(0.0f, 0.0f);
        gl.glVertex2f(1.0f, 1.0f);
        gl.glVertex2f(0.0f, 0.0f);
        gl.glVertex2f(-1.0f, 1.0f);
        gl.glEnd();

        //drawing the right edge
        gl.glBegin (GL2.GL_LINES);
        gl.glVertex2f(0f, 0.50f );
        gl.glVertex2f(-0.50f, -0.50f );
        gl.glEnd();

        //drawing the lft edge
        gl.glBegin (GL2.GL_LINES);
        gl.glVertex2f(0f, 0.50f );
        gl.glVertex2f(0.50f, -0.50f );
        gl.glEnd();
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
        //int line
        Line l = new Line();  // display
        //add line to canvas
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(800, 800);

        //creating frame
        final JFrame frame = new JFrame ("straight Line");

        //adding canvas to frame
        frame.getContentPane().add(glcanvas);

        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }//end of main

}//end of classimport javax.media.opengl.GL2;