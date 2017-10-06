package MyGame;

import java.awt.*;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * The type Game helper.
 */
public class Helper
{
    private static SecureRandom random = new SecureRandom();
    static float colorOneRGB[] = new float[ 3 ]; // An float array for storing rgb color values.
    static float colorTwoRGB[] = new float[ 3 ]; // An float array for storing rgb color values.

    /**
     * Gets random integer.
     *
     * @return the random integer
     */
    public static int getRandomInteger()
    {
        return random.nextInt();
    }

    /**
     * Gets random integer.
     *
     * @param max the max
     * @return the random integer
     */
    public static int getRandomInteger( int max )
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
    public static int getRandomInteger( int min, int max )
    {
        if( max == 0 )
        {
            return random.nextInt() + min % Integer.MAX_VALUE;
        }
        return random.nextInt( max - min ) + min;
    }

    /**
     * Gets random direction.
     *
     * @return the random direction
     */
    public static int getRandomDirection()
    {
        return getRandomInteger( 0, 360 );
    }

    /**
     * Gets random speed.
     *
     * @return the random speed
     */
    public static int getRandomSpeed()
    {
        return getRandomInteger( 10, 20 );
    }

    /**
     * Gets random position.
     *
     * @param fieldSize the field size
     * @return the random position
     */
    public static int getRandomPosition( int fieldSize )
    {
        return getRandomInteger( 10, fieldSize - 20 );
    }

    /**
     * Blend two colors.
     *
     * @param firstColor   First color to blend.
     * @param secondColor  Second color to blend.
     * @param blendBalance The balance of the blend. between 0 and 1, 0,5 is an even blend.
     * @return Color The blended color.
     */
    public static Color blend( Color firstColor, Color secondColor, double blendBalance )
    {
        float colorOneRatio = (float) blendBalance;
        float colorTwoRatio = (float) 1.0 - colorOneRatio;

        firstColor.getColorComponents( colorOneRGB ); // Get the color values of Red, Green and Blue of the first color.
        secondColor.getColorComponents( colorTwoRGB );  // Get the color values of Red, Green and Blue of the second color.

        return new Color(
                (colorOneRGB[ 0 ] * colorOneRatio) + (colorTwoRGB[ 0 ] * colorTwoRatio),
                (colorOneRGB[ 1 ] * colorOneRatio) + (colorTwoRGB[ 1 ] * colorTwoRatio),
                (colorOneRGB[ 2 ] * colorOneRatio) + (colorTwoRGB[ 2 ] * colorTwoRatio)
        );
    }

    /**
     * Blend two colors evenly.
     *
     * @param firstColor  First color to blend.
     * @param secondColor Second color to blend.
     * @return Blended color.
     */
    public static Color blend( Color firstColor, Color secondColor )
    {
        return Helper.blend( firstColor, secondColor, 0.5 );
    }

    /**
     * Gets safe color value.
     *
     * @param unsafeColorValue the unsafe color value
     * @return the safe color value
     */
    public static int getSafeColorValue( int unsafeColorValue )
    {
        return (unsafeColorValue < 0) ? 0 : (unsafeColorValue > 255) ? 255 : unsafeColorValue;
    }

    /**
     * Make a color darker.
     *
     * @param color Color to make darker.
     * @return Darker color.
     */
    public static Color darker( Color color )
    {
        return darker( color, 0.2 );
    }

    /**
     * Make a color darker.
     *
     * @param color    Color to make darker.
     * @param fraction Darkness fraction.
     * @return Darker color.
     */
    public static Color darker( Color color, double fraction )
    {
        int red = (int) Math.round( color.getRed() * (1.0 - fraction) );
        int green = (int) Math.round( color.getGreen() * (1.0 - fraction) );
        int blue = (int) Math.round( color.getBlue() * (1.0 - fraction) );

        int alpha = color.getAlpha();

        return new Color( getSafeColorValue( red ), getSafeColorValue( green ), getSafeColorValue( blue ), alpha );
    }

    /**
     * Make a color lighter.
     *
     * @param color Color to make lighter.
     * @return Lighter color.
     */
    public static Color lighter( Color color )
    {
        return lighter( color, 0.2 );
    }

    /**
     * Make a color lighter.
     *
     * @param color    Color to make lighter.
     * @param fraction Darkness fraction.
     * @return Lighter color.
     */
    public static Color lighter( Color color, double fraction )
    {
        int red = (int) Math.round( color.getRed() * (1.0 + fraction) );
        int green = (int) Math.round( color.getGreen() * (1.0 + fraction) );
        int blue = (int) Math.round( color.getBlue() * (1.0 + fraction) );

        int alpha = color.getAlpha();

        return new Color( getSafeColorValue( red ), getSafeColorValue( green ), getSafeColorValue( blue ), alpha );
    }

    /**
     * Return the hex name of a specified color.
     *
     * @param color Color to get hexadecimal value of.
     * @return Hex name of color: "rrggbb".
     */
    public static String getHexadecimal( Color color )
    {
        return String.format( "%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue() );
    }

    /**
     * Get an random light color.
     *
     * @return Color an random light color.
     */
    public static Color getRandomLightColor()
    {
        return  Color.getHSBColor( random.nextFloat() , random.nextFloat(), 0.1f);
    }

    /**
     * Get an random dark color.
     *
     * @return Color an random light color.
     */
    public static Color getRandomDarkColor()
    {
        return  Color.getHSBColor( random.nextFloat() , random.nextFloat(), 0.5f);
    }

    /**
     * Gets an table with all rainbow colors.
     *
     * @return ArrayList<Color>  an list of rainbow colors.
     */
    public static ArrayList<Color> getRainbowColors()
    {
        ArrayList<Color> rainbowTable = new ArrayList<>();

        for( int r = 0; r < 100; r++ )
        {
            rainbowTable.add( new Color( r * 255 / 100, 255, 0 ) );
        }

        for( int g = 100; g > 0; g-- )
        {
            rainbowTable.add( new Color( 255, g * 255 / 100, 0 ) );
        }

        for( int b = 0; b < 100; b++ )
        {
            rainbowTable.add( new Color( 255, 0, b * 255 / 100 ) );
        }

        for( int r = 100; r > 0; r-- )
        {
            rainbowTable.add( new Color( r * 255 / 100, 0, 255 ) );
        }
        for( int g = 0; g < 100; g++ )
        {
            rainbowTable.add( new Color( 0, g * 255 / 100, 255 ) );
        }
        for( int b = 100; b > 0; b-- )
        {
            rainbowTable.add( new Color( 0, 255, b * 255 / 100 ) );
        }
        rainbowTable.add( new Color( 0, 255, 0 ) );
        return rainbowTable;
    }
}
