package BallGame;

import BallGame.Util.ColorUtil;
import BallGame.Util.RandomUtil;

import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Formatter;

/**
 * The type Ball.
 */
public class Ball
{
    /**
     * The Radius.
     */
    float radius; // The radius of the ball.
    private Color color; // The color of the ball.
    private static int collisionCount = 0;
    public boolean rainbowBall = false;
    private ArrayList<Color> colorTable;
    private static int drawCounter = 0;
    private int colorIndex = 0;

    float x; // The x coordinate of the ball on the screen.
    float y; // The x coordinate of the ball on the screen.
    float speedX; // The speed in in the x direction.
    float speedY; // The speed in in the y direction.

    // Re-use to build the formatted string for toString()
    private StringBuilder stringBuilder = new StringBuilder();
    private Formatter formatter = new Formatter( stringBuilder );

    /**
     * Initiate an new ball.
     *
     * @param x             The position of the ball on the x axis.
     * @param y             The position of the ball on the y axis.
     * @param radius        The radius of the ball.
     * @param speed         The speed of the ball.
     * @param angleInDegree // The direction the ball is moving in.
     * @param color         The color of the ball.
     */
    public Ball( float x, float y, float radius, float speed, float angleInDegree, Color color )
    {
        this.colorTable = ColorUtil.getRainbowColors();
        this.x = x;
        this.y = y;
        this.speedX = (float) (speed * Math.cos( Math.toRadians( angleInDegree ) ));
        this.speedY = (float) (-speed * (float) Math.sin( Math.toRadians( angleInDegree ) ));
        this.radius = radius;
        this.color = color;
    }

    /**
     * Instantiates a new Ball.
     *
     * @param x             The position of the ball on the x axis.
     * @param y             The position of the ball on the y axis.
     * @param radius        The radius of the ball.
     * @param speed         The speed of the ball.
     * @param angleInDegree // The direction the ball is moving in.
     */
    public Ball( float x, float y, float radius, float speed, float angleInDegree )
    {
        this( x, y, radius, speed, angleInDegree, ColorUtil.getRandomLightColor() );
    }

    /**
     * Instantiates a new Ball with random parameters.
     * @param position The position of the ball.
     * @param canvasDimension The width and height of the canvas.
     */
    public Ball( Point position, Dimension canvasDimension )
    {
        this(
                position.x, // RandomUtil position on the x axis.
                position.y, // RandomUtil position on the y axis.
                RandomUtil.getRadius(), // RandomUtil ball radius size.
                RandomUtil.getSpeed(), // RandomUtil ball movement speed
                RandomUtil.getDegrees(), // RandomUtil movement direction.
                ColorUtil.getRandomLightColor()
        );
    }

    /**
     * Instantiates a new Ball with random parameters.
     *
     * @param canvasDimension The width and height of the canvas.
     */
    public Ball( Dimension canvasDimension )
    {
        this( RandomUtil.getPosition( canvasDimension ), canvasDimension );
    }

    /**
     * Draw itself using the given graphics context.
     */
    public void draw( Graphics g )
    {
        drawCounter++;
        drawCounter %= 15;

        if( rainbowBall )
        {
            if( colorIndex >= (colorTable.size() - 1)  )
            {
                colorIndex = 0;
            }
            this.setColor( colorTable.get( ++colorIndex ) );
        }
        g.setColor( color );
        g.fillOval( (int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius) );
    }

    /**
     * Make one move, check for collision and react accordingly if collision occurs.
     *
     * @param box : the container (obstacle) for this ball.
     */
    public void moveOneStepWithCollisionDetection( Box box )
    {
        // Get the ball's bounds, offset by the radius of the ball
        float ballMinX = box.minX + radius;
        float ballMinY = box.minY + radius;
        float ballMaxX = box.maxX - radius;
        float ballMaxY = box.maxY - radius;

        // Calculate the ball's new position
        x += this.speedX;
        y += this.speedY;
        boolean collisionDetected = false;

        if( x < ballMinX ) // Is the ball at collision at the left side of the x axis.
        {
            this.speedX = -this.speedX; // Reflect along normal
            x = ballMinX;     // Re-position the ball at the edge
            collisionDetected = true;
        }
        else if( x > ballMaxX ) // Is the ball at collision at the right side of the x axis.
        {
            this.speedX = -this.speedX;
            x = ballMaxX;
            collisionDetected = true;
        }

        if( y < ballMinY ) // Is the ball at collision at the top side of the x axis.
        {
            this.speedY = -this.speedY;
            y = ballMinY;
            collisionDetected = true;
        }
        else if( y > ballMaxY ) // Is the ball at collision at the bottom side of the x axis.
        {
            this.speedY = -this.speedY;
            y = ballMaxY;
            collisionDetected = true;
        }

        if( collisionDetected && rainbowBall)
        {
            collisionCount++;
        }
        else if( collisionDetected )
        {
            collisionCount++;
            this.setColor( ColorUtil.getRandomLightColor() );
        }
    }

    public void setColor( Color color )
    {
        this.color = color;
    }

    /**
     * Return the magnitude of speed.
     *
     * @return the speed
     */
    public float getSpeed()
    {
        return (float) Math.sqrt( this.speedX * this.speedX + this.speedY * this.speedY );
    }

    /**
     * Return mass
     *
     * @return the mass
     */
    public float getMass()
    {
        return radius * radius * radius / 1000f;  // Normalize by a factor
    }

    /**
     * Return the direction of movement in degrees (counter-clockwise).
     *
     * @return the move angle
     */
    public float getMoveAngle()
    {
        return (float) Math.toDegrees( Math.atan2( -speedY, speedX ) );
    }

    /**
     * Return the kinetic energy (0.5mv^2)
     *
     * @return the kinetic energy
     */
    public float getKineticEnergy()
    {
        return 0.5f * getMass() * (speedX * speedX + speedY * speedY);
    }

    /**
     * Describe itself.
     */
    public String toString()
    {
        stringBuilder.delete( 0, stringBuilder.length() );
        formatter.format(
                "@(%5.0f,%5.0f) V=(%5.0f,%5.0f) S=%5.1f \u0398=%4.0f KE=%5.0f",
                x, y, radius, speedX, speedY, getSpeed(), getMoveAngle(),
                getKineticEnergy() );  // \u0398 is theta
        return stringBuilder.toString();
    }

    public static int getCollisionCount()
    {
        return collisionCount;
    }
}
