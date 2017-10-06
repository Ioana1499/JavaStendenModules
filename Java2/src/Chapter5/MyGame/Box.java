package MyGame;

import java.awt.*;

/**
 * This will contain the window with the canvas to create the game in.
 */
public class Box
{
    int minX;
    int maxX;
    int minY;
    int maxY;
    private Color colorFilled;   // Box's filled color (background)
    private Color colorBorder;   // Box's border color
    private static final Color DEFAULT_COLOR_FILLED = Color.BLACK;
    private static final Color DEFAULT_COLOR_BORDER = Color.YELLOW;

    /**
     * Constructors
     */
    public Box( int x, int y, int width, int height, Color colorFilled, Color colorBorder )
    {
        minX = x;
        minY = y;
        maxX = x + width - 1;
        maxY = y + height - 1;
        this.colorFilled = colorFilled;
        this.colorBorder = colorBorder;
    }

    /**
     * Constructor with the default color
     */
    public Box( int x, int y, int width, int height )
    {
        this( x, y, width, height, DEFAULT_COLOR_FILLED, DEFAULT_COLOR_BORDER );
    }

    /**
     * Set or reset the boundaries of the box.
     */
    public void set( int x, int y, int width, int height )
    {
        minX = x;
        minY = y;
        maxX = x + width - 1;
        maxY = y + height - 1;
    }

    /**
     * Draw itself using the given graphic context.
     */
    public void draw( Graphics g )
    {
        g.setColor( colorFilled );
        g.fillRect( minX, minY, maxX - minX - 1, maxY - minY - 1 );
        g.setColor( colorBorder );
        g.drawRect( minX, minY, maxX - minX - 1, maxY - minY - 1 );
    }
}
