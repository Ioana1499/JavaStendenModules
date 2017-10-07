package AdvangedBallGame.main;

import BallGame.Util.ScreenUtil;

import java.awt.*;

/**
 * This will contain the window with the canvas to create the game in.
 */
public class Box
{
    public int minX;
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
     * Constructor with less arguments.
     * @param position
     * @param boxDimensions
     */
    public Box( Point position, Dimension boxDimensions )
    {
        this( position.x, position.y, boxDimensions.width, boxDimensions.height );
    }

    /**
     * Constructor with less arguments.
     * @param boxDimensions
     */
    public Box( Dimension boxDimensions )
    {
        this( 0, 0, boxDimensions.width, boxDimensions.height );
    }

    /**
     * Constructor with no arguments.
     */
    public Box()
    {
        this( ScreenUtil.getDisplayDimensions() );
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

    public void set( Point position, Dimension dimension )
    {
        minX = position.x;
        minY = position.y;
        maxX = minX + dimension.width -1;
        maxY = minY + dimension.height -1;
    }

    /**
     * Draw itself using the given graphic context.
     */
    public void draw( Graphics g )
    {
        g.setColor( colorFilled );
        g.fillRect( minX, minY, maxX - minX - 1, maxY - minY - 1 );
        //g.setColor( colorBorder );
        //g.drawRect( minX, minY, maxX - minX - 1, maxY - minY - 1 );
    }
}
