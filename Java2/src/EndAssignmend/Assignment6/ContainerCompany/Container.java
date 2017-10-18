package Assignment6.ContainerCompany;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 19:46
 * License: GPLv3 - General Public License version 3
 */
class Container
{
    private static final int RENT_PER_M3 = 40;
    private static final int REMOVAL_COST_LET_2 = 60;
    private static final int REMOVAL_COST = 120;
    private int width;
    private int length;
    private int height;
    private int containerId;

    /**
     * Create an new container with certain dimensions.
     *
     * @param id     the id code of the container
     * @param width  the width of the container.
     * @param length the length of the container.
     * @param height the height of the container.
     */
    Container( int id, int width, int length, int height )
    {
        this.containerId = id;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    /**
     * Gets width.
     *
     * @return the width of the container.
     */
    int getWidth()
    {
        return width;
    }

    /**
     * Gets length.
     *
     * @return the length of the container.
     */
    int getLength()
    {
        return length;
    }

    /**
     * Gets height.
     *
     * @return the height of the container.
     */
    int getHeight()
    {
        return height;
    }

    /**
     * Gets volume.
     *
     * @return the volume of the container.
     */
    int getVolume()
    {
        return width * length * height;
    }

    /**
     * Gets rent price.
     *
     * @return the rent price
     */
    int getRentPrice()
    {
        return this.getVolume() * Container.RENT_PER_M3;
    }

    /**
     * Gets removal cost.
     *
     * @return the removal cost
     */
    int getRemovalCost()
    {
        return this.getVolume() <= 2 ? Container.REMOVAL_COST_LET_2 : RENT_PER_M3;
    }

    /**
     * Gets container id.
     *
     * @return the container id
     */
    public int getContainerId()
    {
        return containerId;
    }
}
