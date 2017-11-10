package com.jorisrietveld.containercompany.model.container;

import com.jorisrietveld.containercompany.model.Storable;
/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 19:46
 * License: GPLv3 - General Public License version 3
 *
 * This is the base class of every container.
 */
public abstract class Container implements Storable, ContainerContract
{
    /**
     * The Rent of the container in cubic meters.
     */
    protected double rentM3 = 40;
    //protected double rentPricePerCubicMeter;
    //protected double transportationCost;

    /**
     * The Removal cost of the container for an volume under 2 cubic meters
     */
    protected double removalCostUnder2m3 = 60;
    protected double transportationCost;

    /**
     * The Removal cost of the container.
     */
    protected double removalCost = 120;
    /**
     * The Width of the container.
     */
    protected double width;
    /**
     * The Length of the container.
     */
    protected double length;
    /**
     * The Height of the container.
     */
    protected double height;
    /**
     * The unique identification code of the Container.
     */
    protected int containerId;

    protected String containerTypeName = "Container"; // Todo add this to every thing

    /**
     * Create an new container with certain dimensions.
     *
     * @param id     the id code of the container
     * @param width  the width of the container.
     * @param length the length of the container.
     * @param height the height of the container.
     */
    protected Container( int id, double width, double length, double height )
    {
        this.containerId = id;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    /**
     * Gets the unique identification code of the container.
     * @return
     */
    @Override
    public int getId()
    {
        return this.containerId;
    }

    /**
     * Sets the rent per cubic meter of the container.
     *
     * @param rentM3 the rent per cubic meter.
     */
    protected void setRentM3( double rentM3 )
    {
        this.rentM3 = rentM3;
    }

    /**
     * Sets removal cost under for an container that contains less than 2 cubic meters.
     *
     * @param removalCostUnder2m3 the removal cost under two cubic meter.
     */
    protected void setRemovalCostUnder2m3( double removalCostUnder2m3 )
    {
        this.removalCostUnder2m3 = removalCostUnder2m3;
    }

    /**
     * Sets removal cost.
     *
     * @param removalCost the removal cost
     */
    protected void setRemovalCost( double removalCost )
    {
        this.removalCost = removalCost;
    }

    /**
     * Gets width.
     *
     * @return the width of the container.
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * Gets length.
     *
     * @return the length of the container.
     */
    public double getLength()
    {
        return length;
    }

    /**
     * Gets height.
     *
     * @return the height of the container.
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Gets volume.
     *
     * @return the volume of the container.
     */
    public double getVolume()
    {
        return this.width * this.length * this.height;
    }

    /**
     * Gets rent price.
     *
     * @return the rent price
     */
    public double getRentPrice()
    {
        return this.getVolume() * rentM3;
    }

    public double getRentM3()
    {
        return this.rentM3;
    }
    /**
     * Gets removal cost.
     *
     * @return the removal cost
     */
    public double getRemovalCost()
    {
        return this.getVolume() <= 2 ? removalCostUnder2m3 : removalCost;
    }

    /**
     * Get an string representation of an container.
     * @return An string showing the type and id of the id.
     */
    @Override
    public String toString()
    {
        return String.format( "Type: %s, id: %03d", this.containerTypeName, this.containerId);
    }
}
