package BallGame;

import BallGame.Util.ScreenUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Universe42DP Simulator
 *------------------------------------
 * Hitchhikers Guide to: 42 DP
 * This scientific physics and quantum mechanics computer modelling simulator thing program simulates an two dimensional
 * parallel universe that consists of multiple moving balls and where there is no gravity, atoms are replaced by
 * squares about 1/2.073.600 th the size of your screen and the quantum uncertainty principle is replaced by an
 * SecureRandom instance so no boxes with living, dead and undeadornotliving cats anymore.
 *
 * @author <a href="mailto:jorisrietveld@gmail.com">Joris Rietveld</a> <a href="https://github.com/jorisrietveld">Github</a> <a href="https://jorisrietveld.ml">Personal Website</a>
 * @version 0.1
 */
public class Main
{
    /**
     * The main entry point of the Ball Game.
     *
     * @param args TODO add some functionality to pass commandline arguments.
     */
    public static void main( String[] args )
    {
        // Create an new EDT (Event Dispatch Thread ) for the graphical user interface components so the interface
        // won't freeze or become unresponsive when the game engine is  calculating something.
        javax.swing.SwingUtilities.invokeLater( () -> {
            JFrame frame = new JFrame( "Universe42 Don't Panic!" );
            frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

            // Add the game world to the window
            frame.setContentPane(
                    new GameWorld( ScreenUtil.getDisplayDimensions()  )
            );
            frame.pack(); // Preferred size of BallWorld
            frame.setVisible( true ); // Show it
        } );
    }
}