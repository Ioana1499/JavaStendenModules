package Assignment6.Main;

import org.omg.PortableServer.THREAD_POLICY_ID;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * The type Container.
 */
public class Container
{
    private final static int RENT_PER_1M2 = 40;
    private static final int REMOVAL_COST_LTE_2M3 = 60;
    private static final int REMOVAL_COST_2M3 = 125;

    private int content;
    private int height;
    private int width;
    private int length;

    /**
     * Instantiates a new Container.
     */
    public Container()
    {
        this( 2, 2, 6 );
    }

    /**
     * Instantiates a new Container.
     *
     * @param height the height
     * @param width  the width
     * @param length the length
     */
    public Container( int height, int width, int length )
    {
        this.height = height;
        this.width = width;
        this.length = length;
        this.content = 0;
    }

    /**
     * Instantiates a new Container.
     *
     * @param height   the height
     * @param width    the width
     * @param length   the length
     * @param contents the contents
     */
    public Container( int height, int width, int length, int contents )
    {
        this.height = height;
        this.width = width;
        this.length = length;
        this.content = contents;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public int getContent()
    {
        return this.content;
    }

    /**
     * Add content.
     *
     * @param newContent the new content
     */
    public void addContent( int newContent )
    {
        this.content += newContent;
    }

    /**
     * Gets rent per day.
     *
     * @return the rent per day
     */
    public int getRentPerDay()
    {
        return this.getSizeM2() * RENT_PER_1M2;
    }

    /**
     * Gets removal cost.
     *
     * @return the removal cost
     */
    public int getRemovalCost()
    {
        return this.getContent() <= 2 ? REMOVAL_COST_LTE_2M3 : REMOVAL_COST_2M3;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * Gets length.
     *
     * @return the length
     */
    public int getLength()
    {
        return this.length;
    }

    /**
     * Gets size in quebec meters.
     *
     * @return the size m 3
     */
    public int getSizeM3()
    {
        return this.height * this.length * this.width;
    }

    /**
     * Gets size square metera.
     *
     * @return The size in m3
     */
    public int getSizeM2()
    {
        return this.width * this.length;
    }

    /**
     * Gets remaining space.
     *
     * @return remaining space
     */
    public int getRemainingSpace()
    {
        return getSizeM3() - content;
    }
}
