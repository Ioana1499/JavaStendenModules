package AdvangedBallGame.main.Util;

import BallGame.GameWorld;
import BallGame.Util.ScreenUtil;

import java.awt.*;
import java.security.SecureRandom;

/**
 * The type Random util.
 */
public class RandomUtil
{
    private static SecureRandom random = new SecureRandom();
    private static Dimension canvasDimensions;

    /**
     * Gets canvas dimensions.
     *
     * @return the canvas dimensions
     */
    public static Dimension getCanvasDimensions()
    {
        return canvasDimensions;
    }

    /**
     * Sets canvas dimensions.
     *
     * @param canvasDimensions the canvas dimensions
     */
    public static void setCanvasDimensions( Dimension canvasDimensions )
    {
        RandomUtil.canvasDimensions = canvasDimensions;
    }

    /**
     * Sets canvas dimensions.
     */
    public static void setCanvasDimensions()
    {
        if( GameWorld.staticDimensions != null )
        {
            RandomUtil.canvasDimensions = GameWorld.staticDimensions;
        }
        else
        {
            RandomUtil.canvasDimensions = ScreenUtil.getDisplayDimensions();
        }
    }

    /**
     * Gets random integer.
     *
     * @return the random integer
     */
    public static int getInt()
    {
        return random.nextInt();
    }

    /**
     * Gets random integer.
     *
     * @param max the max
     * @return the random integer
     */
    public static int getInt( int max )
    {
        return random.nextInt( max );
    }

    /**
     * Gets random integer.
     *
     * @param min the min
     * @param max the max
     * @return the random integer
     */
    public static int getInt( int min, int max )
    {
        if( max == 0 )
        {
            return random.nextInt() + min % Integer.MAX_VALUE;
        }
        return random.nextInt( max - min ) + min;
    }

    public static float getFloat()
    {
        return random.nextFloat();
    }

    public static int getRadius()
    {
        setCanvasDimensions();
        return RandomUtil.getInt( 10, canvasDimensions.height / 20 );
    }

    /**
     * Gets random direction.
     *
     * @return the random direction
     */
    public static int getDegrees()
    {
        return getInt( 0, 360 );
    }

    /**
     * Gets random speed.
     *
     * @return the random speed
     */
    public static int getSpeed()
    {
        return getInt( 1, 10 );
    }

    /**
     * Gets random position.
     *
     * @param dimension The dimensions of the canvas.
     * @return An random point inside the dimensions of the canvas and an 10 pixel margin.
     */
    public static Point getPosition( Dimension dimension )
    {
        return new Point( getInt( 10, dimension.width - 20 ), getInt( 10, dimension.height - 20 ) );
    }

}
