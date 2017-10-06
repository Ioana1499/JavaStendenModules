package Scribble;

import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;
    private int width = 500;
    private int height = 400;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas( "Drawing Demo", 500, 400 );
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen( 320, 260, myCanvas );
        pen.setColor( Color.BLUE );

        square( pen );
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen( 250, 200, myCanvas );
        pen.setColor( Color.RED );

        for( int i = 0; i < 36; i++ )
        {
            square( pen );
            pen.turn( 10 );
        }
    }

    /**
     * Draw triangle.
     */
    public void drawTriangle()
    {
        Pen pen = new Pen( 250, 200, myCanvas );
        pen.setColor( Color.green );
        triangle( pen, 100 );
    }

    public void hailSatan()
    {
        Pen pen = new Pen( (width / 2), height, myCanvas );

        for( int i = 0; i < 5; i++ )
        {
            pen.move( 100 );
            pen.turn( 36 );
            pen.move( 100 );
        }

    }

    /**
     * Draws an triangle.
     *
     * @param pen
     * @param size
     */
    private void triangle( Pen pen, int size )
    {
        for( int i = 0; i < 3; i++ )
        {
            pen.move( size );
            pen.turn( 60 );
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square( Pen pen )
    {
        for( int i = 0; i < 4; i++ )
        {
            pen.move( 100 );
            pen.turn( 90 );
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen( 250, 200, myCanvas );

        for( int i = 0; i < 10000; i++ )
        {
            // pick a random color
            int red = random.nextInt( 256 );
            int green = random.nextInt( 256 );
            int blue = random.nextInt( 256 );
            pen.setColor( new Color( red, green, blue ) );

            pen.randomSquiggle();
        }
    }

    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}