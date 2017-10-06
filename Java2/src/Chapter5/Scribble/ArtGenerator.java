package Scribble;

import java.awt.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the
 * Pen class to create various drawings.
 */
public class ArtGenerator
{
    private static final String DEFAULT_TITLE = "Art Generator";

    private int canvasWidth;
    private int canvasHeight;
    private String canvasTitle;

    private Canvas myCanvas;
    private SecureRandom random = new SecureRandom();
    private Color penColor = Color.green;

    private int startY = 50;
    private int startX = 50;
    private int sizeY = 100;
    private int sizeX = 100;

    private ArrayList<String> debugMessages = new ArrayList<>();

    /**
     * The enum Polygons.
     */
    public enum Polygons
    {
        TRIANGLE( 3 ), QUADRILATERAL( 4 ), PENTAGON( 5 ), HEXAGON( 6 ), HEPTAGON( 7 ), OCTAGON( 8 ), NONAGON( 9 ), DECAGON( 10 ), CIRCLE(30);
        private int value = 10;

        Polygons( int sides )
        {
            this.value = sides;
        }

        /**
         * Getter for property 'sides'.
         *
         * @return Value for property 'sides'.
         */
        public int getSides()
        {
            return this.value;
        }
    }

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public ArtGenerator()
    {
        this( DEFAULT_TITLE, Color.black );
    }

    /**
     * Instantiates a new Art generator.
     *
     * @param title           the title
     * @param backgroundColor the background color
     */
    public ArtGenerator( String title, Color backgroundColor )
    {
        setCanvasSize();
        myCanvas = new Canvas( title, this.canvasWidth, this.canvasHeight, backgroundColor );
    }

    /**
     * Show message.
     *
     * @param message the message
     */
    public void showMessage( String message )
    {
        this.myCanvas.drawString( message, 0, 0 );
    }

    /**
     * Sets canvas size.
     */
    private void setCanvasSize()
    {
        GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        this.canvasWidth = screen.getDisplayMode().getWidth();
        this.canvasHeight = screen.getDisplayMode().getHeight();
    }

    /**
     * Draw square.
     */
    public void drawSquare()
    {
        drawSquare( this.sizeX, this.sizeY, this.penColor );
    }

    /**
     * Draw a square on the screen.
     *
     * @param sizeX the size x
     * @param sizeY the size y
     * @param color the color
     */
    public void drawSquare( int sizeX, int sizeY, Color color )
    {
        setObjectSize( sizeX, sizeY );
        square( getPen() );
    }

    /**
     * Draw a wheel made of many squares.
     *
     * @param size    the size
     * @param polygon the polygon
     * @param color   the color
     * @param amount  the amount
     * @param degrees the degrees
     */
    public void drawWheel( int size, Polygons polygon, Color color, int amount, int degrees )
    {
        setObjectSize( size );
        Pen pen = getPen( color );

        for( int i = 0; i < amount; i++ )
        {
            regularPolygon( pen, polygon, sizeY );
            //square( pen );
            pen.turn( degrees );
        }
    }

    /**
     * Draw an triangle shape.
     *
     * @param size the triangle size
     */
    public void drawTriangle( int size )
    {
        setObjectSize( size );
        Pen pen = getPen();
        pen.turnTo( 180 );

        for( int i = 0; i < 3; i++ )
        {
            pen.move( size );
            pen.turn( 360 / 3 );
        }
    }

    /**
     * Draw polygon.
     *
     * @param shape the shape
     * @param size  the size
     */
    public void drawPolygon( Polygons shape, int size )
    {
        this.setObjectSize( size );
        regularPolygon( getPen(), shape, size );
    }

    /**
     * Hail satan.
     */
    public void hailSatan()
    {
        this.setObjectSize( 600 );
        Pen pen = getPen( Color.red );
        pen.turnTo( 180 );

        for( int i = 0; i < 5; i++ )
        {
            pen.move( 600 );
            pen.turn( 144 );
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square( Pen pen )
    {
        for( int i = 0; i < 4; i++ )
        {
            pen.move( (i % 2 == 0) ? sizeY : sizeX );
            pen.turn( 90 );
        }
    }

    /**
     * Draw an regular polygon shape.
     *
     * @param pen        The pen to use.
     * @param polygon    The shape to draw.
     * @param sideLength The length of each side of the polygon.
     */
    private void regularPolygon( Pen pen, Polygons polygon, int sideLength )
    {
        for( int i = 0; i < polygon.value; i++ )
        {
            pen.move( sideLength );
            pen.turn( 360 / polygon.value );
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen( 0, canvasHeight - 30, myCanvas );

        for( int i = 0; i < 100; i++ )
        {
            // pick a random color
            int red = random.nextInt( 255 );
            int green = random.nextInt( 256 - 100 ) + 100;
            int blue = random.nextInt( 50 );

            pen.setColor( new Color( 255, 0, 0 ) );
            IntStream.range( 0, 5 ).forEach( a -> pen.randomSquiggle() );

            pen.setColor( new Color( 255, green, blue ) );
            IntStream.range( 0, 10 ).forEach( a -> pen.randomSquiggle() );
        }
    }

    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }

    /**
     * Get an pen and and initiate all values for drawing. (lazy alias)
     *
     * @return AN new pen
     */
    private Pen getPen()
    {
        return getPen( this.penColor );
    }

    /**
     * Get an pen and and initiate all values for drawing.
     *
     * @param penColor The color of the pen.
     * @return An pen that can draw an shape.
     */
    private Pen getPen( Color penColor )
    {
        Pen pen = new Pen( this.startX, this.startY, this.myCanvas );
        pen.setColor( penColor );
        return pen;
    }

    /**
     * Set the starting coordinates for drawing a shape.
     *
     * @param objectSizeX X position in pixels
     * @param objectSizeY Y position in pixels
     */
    private void setCenterCoordinates( int objectSizeX, int objectSizeY )
    {
        startY = (canvasHeight / 2) + objectSizeY / 100 * 30;
        startX = (canvasWidth / 2) + (objectSizeX / 2);
    }

    /**
     * Sets object size.
     *
     * @param size the size
     */
    public void setObjectSize( int size )
    {
        setObjectSize( size, size );
    }

    /**
     * Sets object size.
     *
     * @param sizeX the size x
     * @param sizeY the size y
     */
    public void setObjectSize( int sizeX, int sizeY )
    {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        setCenterCoordinates( sizeX, sizeY );
    }
}
