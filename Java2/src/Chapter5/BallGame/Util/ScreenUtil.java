package BallGame.Util;

import java.awt.*;

public class ScreenUtil
{
    private static GraphicsDevice mainDisplay = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    /**
     * Get the dimensions of the users main display.
     * @return Dimensions The width and height of the users main display.
     */
    public static Dimension getDisplayDimensions()
    {

        return new Dimension(
                mainDisplay.getDisplayMode().getWidth(),
                mainDisplay.getDisplayMode().getHeight() - 40 // For the task bar.
        );
    }

    /**
     * Gets the main display.
     * @return The main display device, it contains methods for handling the graphics on the main display like how
     * things are rendered, full screen windows and other window actions. It also contains information about the current,
     * optimal and default display settings like, resolution, color modes and if certain window modes are supported.
     */
    public static GraphicsDevice getMainDisplay()
    {
        return mainDisplay;
    }
}
