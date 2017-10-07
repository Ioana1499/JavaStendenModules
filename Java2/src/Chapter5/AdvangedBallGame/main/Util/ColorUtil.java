package AdvangedBallGame.main.Util;

import BallGame.Util.RandomUtil;

import java.util.ArrayList;

public class ColorUtil
{
    static float colorOneRGB[] = new float[ 3 ]; // An float array for storing rgb color values.
    static float colorTwoRGB[] = new float[ 3 ]; // An float array for storing rgb color values.

    /**
     * Blend two colors.
     *
     * @param firstColor   First color to blend.
     * @param secondColor  Second color to blend.
     * @param blendBalance The balance of the blend. between 0 and 1, 0,5 is an even blend.
     * @return ColorUtil The blended color.
     */
    public static java.awt.Color blend( java.awt.Color firstColor, java.awt.Color secondColor, double blendBalance )
    {
        float colorOneRatio = (float) blendBalance;
        float colorTwoRatio = (float) 1.0 - colorOneRatio;

        firstColor.getColorComponents( colorOneRGB ); // Get the color values of Red, Green and Blue of the first color.
        secondColor.getColorComponents( colorTwoRGB );  // Get the color values of Red, Green and Blue of the second color.

        return new java.awt.Color(
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
    public static java.awt.Color blend( java.awt.Color firstColor, java.awt.Color secondColor )
    {
        return ColorUtil.blend( firstColor, secondColor, 0.5 );
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
     * @param color ColorUtil to make darker.
     * @return Darker color.
     */
    public static java.awt.Color darker( java.awt.Color color )
    {
        return darker( color, 0.2 );
    }

    /**
     * Make a color darker.
     *
     * @param color    ColorUtil to make darker.
     * @param fraction Darkness fraction.
     * @return Darker color.
     */
    public static java.awt.Color darker( java.awt.Color color, double fraction )
    {
        int red = (int) Math.round( color.getRed() * (1.0 - fraction) );
        int green = (int) Math.round( color.getGreen() * (1.0 - fraction) );
        int blue = (int) Math.round( color.getBlue() * (1.0 - fraction) );

        int alpha = color.getAlpha();

        return new java.awt.Color( getSafeColorValue( red ), getSafeColorValue( green ), getSafeColorValue( blue ), alpha );
    }

    /**
     * Make a color lighter.
     *
     * @param color ColorUtil to make lighter.
     * @return Lighter color.
     */
    public static java.awt.Color lighter( java.awt.Color color )
    {
        return lighter( color, 0.2 );
    }

    /**
     * Make a color lighter.
     *
     * @param color    ColorUtil to make lighter.
     * @param fraction Darkness fraction.
     * @return Lighter color.
     */
    public static java.awt.Color lighter( java.awt.Color color, double fraction )
    {
        int red = (int) Math.round( color.getRed() * (1.0 + fraction) );
        int green = (int) Math.round( color.getGreen() * (1.0 + fraction) );
        int blue = (int) Math.round( color.getBlue() * (1.0 + fraction) );

        int alpha = color.getAlpha();

        return new java.awt.Color( getSafeColorValue( red ), getSafeColorValue( green ), getSafeColorValue( blue ), alpha );
    }

    /**
     * Return the hex name of a specified color.
     *
     * @param color ColorUtil to get hexadecimal value of.
     * @return Hex name of color: "rrggbb".
     */
    public static String getHexadecimal( java.awt.Color color )
    {
        return String.format( "%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue() );
    }

    /**
     * Get an random light color.
     *
     * @return ColorUtil an random light color.
     */
    public static java.awt.Color getRandomLightColor()
    {
        return  java.awt.Color.getHSBColor( BallGame.Util.RandomUtil.getFloat() , BallGame.Util.RandomUtil.getFloat(), 1.0f);
    }

    /**
     * Get an random dark color.
     *
     * @return ColorUtil an random light color.
     */
    public static java.awt.Color getRandomDarkColor()
    {
        return  java.awt.Color.getHSBColor( BallGame.Util.RandomUtil.getFloat() , RandomUtil.getFloat(), 0.5f);
    }

    /**
     * Gets an table with all rainbow colors.
     *
     * @return ArrayList<ColorUtil>  an list of rainbow colors.
     */
    public static ArrayList<java.awt.Color> getRainbowColors()
    {
        ArrayList<java.awt.Color> rainbowTable = new ArrayList<>();

        for( int r = 0; r < 100; r++ )
        {
            rainbowTable.add( new java.awt.Color( r * 255 / 100, 255, 0 ) );
        }

        for( int g = 100; g > 0; g-- )
        {
            rainbowTable.add( new java.awt.Color( 255, g * 255 / 100, 0 ) );
        }

        for( int b = 0; b < 100; b++ )
        {
            rainbowTable.add( new java.awt.Color( 255, 0, b * 255 / 100 ) );
        }

        for( int r = 100; r > 0; r-- )
        {
            rainbowTable.add( new java.awt.Color( r * 255 / 100, 0, 255 ) );
        }
        for( int g = 0; g < 100; g++ )
        {
            rainbowTable.add( new java.awt.Color( 0, g * 255 / 100, 255 ) );
        }
        for( int b = 100; b > 0; b-- )
        {
            rainbowTable.add( new java.awt.Color( 0, 255, b * 255 / 100 ) );
        }
        rainbowTable.add( new java.awt.Color( 0, 255, 0 ) );
        return rainbowTable;
    }
}
