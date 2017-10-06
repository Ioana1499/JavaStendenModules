package Test.Scribble;

import Scribble.Canvas;
import org.junit.Test;

import java.awt.*;
import java.security.SecureRandom;

public class CanvasTest
{
    private int width = 1980;
    private int height = 730;
    private Canvas art = new Canvas( "Its like picasso", width, height, Color.black );
    private SecureRandom rand = new SecureRandom();

    public static void main( String[] args )
    {
        CanvasTest demo = new CanvasTest();

        switch( 2 )
        {
            case 0:
                demo.assignment52();
                break;
            case 1:
                demo.assignment55();
                break;
            case 2:

                break;
        }
    }

    @Test
    public void assignment52()
    {
        int lastX = 0;
        int lastY = 0;
        int newX = 0;
        int newY = 0;

        for( int i = 0; i < 100; i++ )
        {
            newX = this.rand.nextInt( width );
            newY = this.rand.nextInt( height );
            art.setForegroundColor( Color.green );
            art.drawLine( lastX, lastY, newX, newY );
            lastX = newX;
            lastY = newY;
        }
    }

    @Test
    public void assignment55()
    {
        int squareSize = 400;
        int locationX = (width / 2) - (squareSize / 2);
        int locationy = (height / 2) - (squareSize / 2);
        art.setForegroundColor( Color.green );
        art.fillRectangle( locationX, locationy, squareSize, squareSize );
    }
}
