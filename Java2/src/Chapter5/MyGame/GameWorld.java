package MyGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWorld extends JPanel
{
    private static final int UPDATE_RATE = 30;  // Frames per second (fps)

    private Ball ball; // A single bouncing Ball's instance
    private Box box;  // The container rectangular box

    private DrawCanvas canvas; // Custom canvas for drawing the box/ball
    private int canvasWidth;
    private int canvasHeight;

    /**
     * Constructor to create the UI components and init the game objects.
     * Set the drawing canvas to fill the screen (given its width and height).
     *
     * @param width  : screen width
     * @param height : screen height
     */
    public GameWorld( int width, int height )
    {
        // Init the custom drawing panel for drawing the game
        canvas = new DrawCanvas();
        this.setLayout( new BorderLayout() );
        this.add( canvas, BorderLayout.CENTER );

        canvasWidth = width;
        canvasHeight = height;

        // Init the ball at a random location (inside the box) and moveAngle
        ball = new Ball( canvasWidth, canvasHeight );

        // Init the Container Box to fill the screen
        box = new Box( 0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.WHITE );

        // Handling window resize.
        this.addComponentListener( new ComponentAdapter()
        {
            @Override
            public void componentResized( ComponentEvent e )
            {
                Component c = (Component) e.getSource();
                Dimension dim = c.getSize();
                canvasWidth = dim.width;
                canvasHeight = dim.height;
                // Adjust the bounds of the container to fill the window
                box.set( 0, 0, canvasWidth, canvasHeight );
            }
        } );

        // Start the ball bouncing
        gameStart();
    }

    /**
     * Start the ball bouncing.
     */
    public void gameStart()
    {
        // Run the game logic in its own thread.
        Thread gameThread = new Thread()
        {
            public void run()
            {
                while( true )
                {
                    // Execute one time-step for the game
                    gameUpdate();
                    // Refresh the display
                    repaint();
                    // Delay and give other thread a chance
                    try
                    {
                        Thread.sleep( 1000 / UPDATE_RATE );
                    }
                    catch( InterruptedException ex )
                    {
                        ex.printStackTrace();
                    }
                }
            }
        };
        gameThread.start();  // Invoke GaemThread.run()
    }

    /**
     * One game time-step.
     * Update the game objects, with proper collision detection and response.
     */
    public void gameUpdate()
    {
        ball.moveOneStepWithCollisionDetection( box );
    }

    /**
     * The custom drawing panel for the bouncing ball (inner class).
     */
    class DrawCanvas extends JPanel
    {
        /**
         * Custom drawing codes
         */
        @Override
        public void paintComponent( Graphics graphics )
        {
            super.paintComponent( graphics ); // Paint background

            // Draw the box and the ball
            box.draw( graphics );
            ball.draw( graphics );

            // Display ball's information
            graphics.setColor( Color.WHITE );
            graphics.setFont( new Font( "Courier New", Font.PLAIN, 12 ) );
            graphics.drawString( "Ball " + ball.toString(), 20, 30 );
        }

        /**
         * Called back to get the preferred size of the component.
         */
        @Override
        public Dimension getPreferredSize()
        {
            return (new Dimension( canvasWidth, canvasHeight ));
        }
    }
}
