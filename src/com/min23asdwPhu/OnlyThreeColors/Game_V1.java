 

import com.jogamp.graph.geom.Vertex;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.JFrame;

import static com.jogamp.opengl.GL2GL3.GL_LINE;
import static java.lang.Math.*;

public class Game_V1 implements GLEventListener {

    private static final int GL_FRONT_AND_BACK = 1;
    private float rtri;  //for angle of line  rotation

    @Override
    public void display(GLAutoDrawable drawable) {
        //800px 800px
        // 40 part per axis x , y
        // 1 part = 0.05f = 20px

//        glPushMatrix(); // Save the current working matrix.
//        glLoadIdentity(); // Makes the new working matrix the identity.
//        glTrans… // Translate you cude.
//        drawCUBE_1; // Draw your cube.
//        glPopMatrix(); // Restore you previous matrix.
//        gl.glBegin(GL2.GL_LINES); // Drawing Using Line (2 point)
//        gl.glBegin(GL2.GL_POLYGON); // Drawing Using POLYGON
//        gl.glBegin( GL2.GL_TRIANGLES ); // Drawing Using Triangles

        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

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


//        //##   drawing the circle
//        //{***********************************************
//        int numVertices = 20;
//        double radius = 0.5;
//        // approximate  a circle with a polygon
//        gl.glBegin(GL2.GL_POLYGON);
//
//        {
//            double angle = 0;
//            double angleIncrement = 2 * Math.PI / numVertices;
//            for (int i = 0; i < numVertices; i++) {
//                angle = i * angleIncrement;
//                double x = radius * Math.cos(angle);
//                double y = radius * Math.sin(angle);
//                gl.glVertex2d(x, y);
//            }
//        }
//        gl.glEnd();
//        // ***********************************************}

        // Push the bordor out of Rotated eff.  by push
        gl.glPushMatrix();
        // Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();  // Reset The View

        //##   laser soure
        //{***********************************************
        //line rotation
//        gl.glRotatef(rtri, 0.0f, 0.0f, 1.0f);



       // Drawing polygon box Using point
//        gl.glBegin(GL2.GL_POLYGON);// approximate  a  box with a polygon
//        for (int j = 1; j <= 4; j++) {
//            float point_x = 0.05f;
//            float point_y = 0.05f;
//
//            if (j == 1) { // point a
//                gl.glVertex2f(point_x, point_y);
//                gl.glVertex2f(-point_x, point_y);
//            }
//            if (j == 2) {  // point b
//                gl.glVertex2f(-point_x, point_y);
//                gl.glVertex2f(-point_x, -point_y);
//            }
//            if (j == 3) {
//                gl.glVertex2f(-point_x, -point_y);
//                gl.glVertex2f(point_x, -point_y);
//            }
//            if (j == 4) {
//                gl.glVertex2f(point_x, -point_y);
//                gl.glVertex2f(point_x, point_y);
//            }
//
//        }
//        gl.glEnd();

        // laser drawn
        float length_laser = 0.5f;
        float point_Ax = 0.2f;
        float point_Ay = 0.0f;

        float point_Bx = -0.2f;
        float point_By = 0.0f;

        float point_Cx = (point_Ax + point_Bx) * 0.5f;
        float point_Cy = (point_Ay + point_By) * 0.5f;

        float zeta = (float) (atan((point_Ay - point_By) / (point_Bx - point_Ax)));
        zeta = (float) ((Math.PI/2)- zeta);
        float point_Dx = (float) (point_Cx + length_laser * (cos(zeta)));
        float point_Dy = (float) (point_Cy + length_laser * (sin(zeta)));

        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2f(point_Ax, point_Ay);
        gl.glVertex2f(point_Bx, point_By);

        gl.glVertex2f(point_Cx, point_Cy);
        // Cal where D x y
        gl.glVertex2f(point_Dx, point_Dy);

//        if(point_By == point_Ay){  // 0 or 180 degreee
//            if(point_Bx > point_Ax){
//                gl.glVertex2f(point_Dx, point_Dy);
//            }
//            else {
//                gl.glVertex2f(-point_Dx, -point_Dy);
//            }
//        }
//        else if(point_Bx == point_Ax){  // 90 ro 270 degreee
//            if(point_By > point_Ay){
//                gl.glVertex2f(point_Dx, point_Dy);
//            }
//            else {
//                gl.glVertex2f(-point_Dx, -point_Dy);
//            }
//        }else {  // another degree use y axis to known
//
//            if(point_By > point_Ay){
//                gl.glVertex2f(point_Dx, point_Dy);
//            }else if(point_By < point_Ay) {
//                gl.glVertex2f(-point_Dx, -point_Dy);
//            }
//
//        }

        gl.glEnd();

        gl.glFlush();


        rtri += 0.2f;  //assigning the angle
        // ***********************************************}

        //Put the frame back on without being affected.  by pop
        gl.glPopMatrix();

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
        final FPSAnimator animator = new FPSAnimator(glcanvas, 60, true);
        System.out.println("fps = " + animator.getFPS());
        animator.start();

    }//end of main

}//end of classimport javax.media.opengl.GL2;