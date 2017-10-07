package AdvangedBallGame.main;

import BallGame.Ball;
import BallGame.Box;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.stream.IntStream;
import javax.swing.*;

public class GameWorld extends JPanel
{
    private static final int UPDATE_RATE = 60;  // Frames per second (fps)
    public static Dimension staticDimensions;
    private Dimension gameDimensions;
    private int ballAmount = 150;

    private ArrayList<BallGame.Ball> balls = new ArrayList<>(); // A single bouncing Ball's instance
    private BallGame.Ball rainbowBall;
    private BallGame.Box box;  // The container rectangular box

    private DrawCanvas canvas; // Custom canvas for drawing the box/ball
    //private int canvasWidth;
    //private int canvasHeight;

    /**
     * Constructor to create the UI components and init the game objects.
     * Set the drawing canvas to fill the screen (given its width and height).
     *
     * @param windowDimensions The width and height of the game world.
     */
    public GameWorld( Dimension windowDimensions )
    {
        gameDimensions = windowDimensions;
        staticDimensions = windowDimensions;

        // Init the custom drawing panel for drawing the game
        canvas = new DrawCanvas();
        this.setLayout( new BorderLayout() );
        this.add( canvas, BorderLayout.CENTER );

        //canvasWidth = width;
        //canvasHeight = height;

        // Init the ball at a random location (inside the box) and moveAngle
        IntStream.range( 0, ballAmount ).forEach( i -> balls.add( new BallGame.Ball( gameDimensions ) )  );
        rainbowBall = new BallGame.Ball( 100, 100,  300, 2, 45, Color.red );
        rainbowBall.rainbowBall = true;

        // Init the Container Box to fill the screen
        box = new Box( gameDimensions );

        // Handling window resize.
        this.addComponentListener( new ComponentAdapter()
        {
            @Override
            public void componentResized( ComponentEvent e )
            {
                Component c = (Component) e.getSource();
                gameDimensions = c.getSize();
                staticDimensions = c.getSize();
                box.set( new Point( 0,0 ), gameDimensions );
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
        // Create an new thread for the game engine that handles calculating and updating the game objects properties
        // and rendering the updated objects in a new frame.
        Thread gameThread = new Thread()
        {
            public void run()
            {
                while( true )
                {
                    gameUpdate(); // Calculate and update the state and position of game objects one timeOfCollision step forward.
                    repaint(); // Render the updated frame of the game world.

                    try {
                        Thread.sleep( 1000 / UPDATE_RATE );  // Delay to give other threads a chance.
                    }
                    catch( InterruptedException ex ){}
                }
            }
        };
        // Start running the game engine.
        gameThread.start();
    }

    /**
     * One game timeOfCollision-step.
     * Update the game objects, with proper collision detection and response.
     */
    public void gameUpdate()
    {
        balls.forEach( b -> b.moveOneStepWithCollisionDetection( box ) );
        rainbowBall.moveOneStepWithCollisionDetection( box );
        //ball.moveOneStepWithCollisionDetection( box );
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

            balls.forEach( b -> b.draw( graphics ) );
            rainbowBall.draw( graphics );
            //ball.draw( graphics );

            // Display ball's information
            graphics.setColor( Color.GREEN );
            graphics.setFont( new Font( "Courier New", Font.PLAIN, 20 ) );
            int lineHight = 30;
            graphics.drawString( String.format( "Amount of balls: %s", ballAmount ), 20, getHeight() - 100 );
            graphics.drawString( String.format( "Average speed of: %f", balls.stream().mapToDouble( BallGame.Ball::getSpeed ).sum() / ballAmount  ), 20, getHeight() - 70 );
            graphics.drawString( String.format( "Ball Collision count: %d", Ball.getCollisionCount()), 20, getHeight() - 40 );
            //IntStream.range( 1, balls.size() ).forEach( i -> { graphics.drawString( "Ball " + balls.get( i-1 ).toString(), 20, lineHight + i *10 );} );
            //graphics.drawString( "Ball " + ball.toString(), 20, 30 );
        }

        /**
         * Called back to get the preferred size of the component.
         */
        @Override
        public Dimension getPreferredSize()
        {
            return (gameDimensions);
        }
    }
}
