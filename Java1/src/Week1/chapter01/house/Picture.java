import Java1.src.Week1.Exersize11.Circle;
import Java1.src.Week1.Exersize11.Square;
import Java1.src.Week1.Exersize11.Triangle;

/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael K�lling and David J. Barnes
 * @version 2016.02.29
 */
public class Picture
{
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;
    private Circle moon;
    private boolean drawn;
    private int days;
    private int endOfTheWorld = 2;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        wall = new Square();
        window = new Square();
        roof = new Triangle();  
        sun = new Circle();
        moon = new Circle();
        drawn = false;
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        if(!drawn) {
            wall.moveHorizontal(-140);
            wall.moveVertical(20);
            wall.changeSize(120);
            wall.makeVisible();
            
            window.changeColor("black");
            window.moveHorizontal(-120);
            window.moveVertical(40);
            window.changeSize(40);
            window.makeVisible();
    
            roof.changeSize(60, 180);
            roof.moveHorizontal(20);
            roof.moveVertical(-60);
            roof.makeVisible();
    
            sun.changeColor("yellow");
            sun.moveHorizontal(100);
            sun.moveVertical(-40);
            sun.changeSize(80);
            sun.makeVisible();
            
            moon.changeColor("grey");
            moon.moveHorizontal(-170);
            moon.moveVertical(210);
            moon.changeSize(40);
            moon.makeVisible();
            drawn = true;
            sunset();
        }
    }
    
    public void sunset()
    {        
        for( int i = 0; i < 23; i++)
        {
            sun.slowMoveVertical( i );
        }
        
        if( days < endOfTheWorld )
        {
             moonRise();
             sunRise();
        }
        
    }
    
    public void sunRise()
    {
        for( int i = 0; i < 23; i++)
        {
            sun.slowMoveVertical( -i );
        }
        days ++;
    }
    
    public void moonRise()
    {
        for( int i = 0; i < 23; i++)
        {
            moon.slowMoveVertical( -i );
        }
        moonSet();
    }
    
    public void moonSet()
    {
        for( int i = 0; i < 23; i++)
        {
            moon.slowMoveVertical( i );
        }
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        wall.changeColor("black");
        window.changeColor("white");
        roof.changeColor("black");
        sun.changeColor("black");
        moon.changeColor("grey");
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        wall.changeColor("red");
        window.changeColor("black");
        roof.changeColor("green");
        sun.changeColor("yellow");
        moon.changeColor("gray");
    }
}
