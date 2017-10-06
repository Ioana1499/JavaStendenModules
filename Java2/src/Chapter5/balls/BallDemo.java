package balls;

import java.awt.*;
import java.awt.geom.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Class BallDemo - provides two short demonstrations showing how to use the Canvas class.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class BallDemo
{
    private Canvas myCanvas;
    private int canvasWidth;
    private int canvasHeight;
    private SecureRandom random;
    private int ground;   // position of the ground line
    private int sceneWidth;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        this.random = new SecureRandom();
        setCanvasSize();
        myCanvas = new Canvas( "Ball Demo", this.canvasWidth, canvasHeight, Color.black );
        myCanvas.setVisible( true );
    }

    /**
     * Sets canvas size.
     */
    private void setCanvasSize()
    {
        GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        this.canvasWidth = screen.getDisplayMode().getWidth();
        this.canvasHeight = screen.getDisplayMode().getHeight();
        this.ground = this.canvasHeight - 100;
        this.sceneWidth = this.canvasWidth - 40;
    }

    public int getRandomInt( int minInclusive, int maxInclusive )
    {
        return random.nextInt( maxInclusive - minInclusive ) + minInclusive;
    }

    private Color getRandomColor()
    {
        return new Color( getRandomInt( 100, 255 ), getRandomInt( 100, 255 ), getRandomInt( 100, 255 ) );
    }

    /**
     * Demonstrate some of the drawing operations that are
     * available on a Canvas object.
     */
    public void drawDemo()
    {
        myCanvas.setFont( new Font( "helvetica", Font.BOLD, 14 ) );
        myCanvas.setForegroundColor( Color.red );

        myCanvas.drawString( "We can draw text, ...", 20, 30 );
        myCanvas.wait( 1000 );

        myCanvas.setForegroundColor( Color.black );
        myCanvas.drawString( "...draw lines...", 60, 60 );
        myCanvas.wait( 500 );
        myCanvas.setForegroundColor( Color.gray );
        myCanvas.drawLine( 200, 20, 300, 50 );
        myCanvas.wait( 500 );
        myCanvas.setForegroundColor( Color.blue );
        myCanvas.drawLine( 220, 100, 370, 40 );
        myCanvas.wait( 500 );
        myCanvas.setForegroundColor( Color.green );
        myCanvas.drawLine( 290, 10, 320, 120 );
        myCanvas.wait( 1000 );

        myCanvas.setForegroundColor( Color.gray );
        myCanvas.drawString( "...and shapes!", 110, 90 );

        myCanvas.setForegroundColor( Color.red );

        // the shape to draw and move
        int xPos = 10;
        Rectangle rect = new Rectangle( xPos, 150, 30, 20 );

        // move the rectangle across the screen
        for( int i = 0; i < 200; i++ )
        {
            myCanvas.fill( rect );
            myCanvas.wait( 10 );
            myCanvas.erase( rect );
            xPos++;
            rect.setLocation( xPos, 150 );
        }
        // at the end of the move, draw once more so that it remains visible
        myCanvas.fill( rect );
    }

    private BouncingBall getRandomBall()
    {
        return new BouncingBall(
                1 + getRandomInt( 50, 200 ),
                1 + getRandomInt( 50, 200 ),
                1 + getRandomInt( 10, 200 ),
                getRandomColor(),
                this.ground,
                myCanvas
        );
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce( int amountOfBalls )
    {
        myCanvas.setVisible( true );
        ArrayList<BouncingBall> balls = new ArrayList<>(amountOfBalls);

        // draw the ground
        myCanvas.drawLine( 20, this.ground, sceneWidth, this.ground );

        IntStream.range(0, amountOfBalls ).forEach( i -> {
            balls.add( getRandomBall() );
            balls.get( i ).draw();
        });

        // make them bounce
        boolean finished = false;
        while( !finished )
        {
            myCanvas.wait( 50 );           // small delay
            int finishedBalles = 0;

            for( int i = 0; i < balls.size(); i++ )
            {
                balls.get( i ).move();
                if( balls.get( i ).getXPosition() >= sceneWidth )
                {
                    finishedBalles++;
                }
            }
            if( balls.size() == finishedBalles )
            {
                finished = true;
            }
        }

        for( int i = 0; i < balls.size(); i++ )
        {
            balls.get( 1 ).erase();
        }
    }

    public void boxBounce( int amountOfBalls )
    {

    }
}
