package MyGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main Program for running the bouncing ball as a standalone application.
 */
public class Main
{
    private static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    // Entry main program
    public static void main( String[] args )
    {
        JFrame frame = new JFrame( "Balls Game" );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.setContentPane( new GameWorld( 640, 480 ) ); // GameWorld is a JPanel
        frame.pack();            // Preferred size of BallWorld
        frame.setVisible( true );  // Show it

    }
}