package com.min23asdwPhu.testbase;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import java.io.File;
import java.io.IOException;

public class background implements GLEventListener {

    private int textureId;


    private float rotation = 0.0f;

    @Override
    public void display( GLAutoDrawable drawable ) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glBindTexture(GL2.GL_TEXTURE_2D , textureId);

        gl.glPushMatrix();


        gl.glOrtho(0,1,0,1,0,1);

        gl.glLoadIdentity();

        try{
            File im = new File("C:\\Users\\intel\\github\\Game_java\\OnlyThreeColors\\src\\test.png");
            Texture t2 = TextureIO.newTexture(im,true);
            textureId = t2.getTextureObject(gl);

        } catch (IOException e) {
            e.printStackTrace();
        }

        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord2f(0f,0f);gl.glVertex2f(0,0);
            gl.glTexCoord2f(0f,1f);gl.glVertex2f(0,1f);
            gl.glTexCoord2f(1f,1f);gl.glVertex2f(1,1);
            gl.glTexCoord2f(1f,0f);gl.glVertex2f(1,0);
        gl.glEnd();

        gl.glDepthMask(true);
        gl.glPopMatrix();




    }

    public void reshape(GLAutoDrawable drawable, int x, int y,
                        int width, int height) {

    }
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
                               boolean deviceChanged) {
    }
    @Override
    public void dispose(GLAutoDrawable arg0) {


    }
    @Override
    public void init(GLAutoDrawable arg0) {


    }

    public static void main( String[] args ) {

        final GLProfile gp = GLProfile.get( GLProfile.GL2 );
        GLCapabilities cap = new GLCapabilities( gp );


        final GLCanvas gc = new GLCanvas(cap);
        background obj = new background();

        gc.addGLEventListener( obj );
        gc.setSize( 800, 800 );

        final JFrame frame = new JFrame ("back ground");
        frame.add(gc);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

        final FPSAnimator animator = new FPSAnimator(gc, 200,true);
        animator.start();
    }

}  