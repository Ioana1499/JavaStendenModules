package AdvangedBallGame.main.GameObject;

import BallGame.Util.ColorUtil;

import java.awt.*;

/**
 * The type Game object.
 *
 * @param <T> the type parameter
 */
public abstract class GameObject<T extends GameObjectShape>
{
    private T objectShape;
    private Color objectColor;
    private boolean visible = false;
    private int xPosition = 0;
    private int yPosition = 0;
    private static int objectCount = 0;

    /**
     * Initiates an game object.
     *
     * @param objectColor The fill color of the object.
     */
    GameObject( Color objectColor )
    {
        objectCount++;
        this.objectColor = objectColor;
    }

    /**
     * Initiates an static game object with an random color.
     */
    GameObject()
    {
        this( ColorUtil.getRandomLightColor() );
    }

    /**
     * Getter for property 'objectColor'.
     *
     * @return Value for property 'objectColor'.
     */
    public Color getObjectColor()
    {
        return objectColor;
    }

    /**
     * Setter for property 'objectColor'.
     *
     * @param objectColor Value to set for property 'objectColor'.
     */
    public void setObjectColor( Color objectColor )
    {
        this.objectColor = objectColor;
    }

    /**
     * Getter for property 'objectShape'.
     *
     * @return An shape that implements the GameObjectShape method.
     */
    public T getObjectShape()
    {
        return objectShape;
    }

    /**
     * Is visible the object visible?
     * @return the boolean
     */
    public boolean isVisible()
    {
        return visible;
    }

    /**
     * Make visible.
     */
    public void makeVisible()
    {
        this.visible = true;
    }

    /**
     * Make invisible.
     */
    public void makeInvisible()
    {
        this.visible = false;
    }

    /**
     * Render the object on the graphical context.
     */
    public void renderTo( Graphics graphicsContext )
    {
        objectShape.renderTo( graphicsContext );
    }

    public static int getObjectCount()
    {
        return objectCount;
    }

    protected static void decreaseObjectCount()
    {
        objectCount--;
    }
}
