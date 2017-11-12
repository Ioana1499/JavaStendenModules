package com.jorisrietveld.containercompany.model.rental;

import java.time.LocalDate;
import java.time.Period;

import com.jorisrietveld.containercompany.model.Storable;
import com.jorisrietveld.containercompany.model.container.Container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 19:47
 * License: GPLv3 - General Public License version 3
 * This data object is represents an rental at the container company.
 */
public class Rental implements Storable, RentalContract
{
    private int rentalId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Container container;

    /**
     * Instantiates a new Rental object.
     *
     * @param rentalId  the rental id
     * @param startDate the start date
     * @param endDate   the end date
     * @param container the container
     */
    public Rental( int rentalId, LocalDate startDate, LocalDate endDate, Container container )
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.container = container;
        this.rentalId = rentalId;
    }

    public Rental()
    {}

    /**
     * This method checks if an certain date falls inside the rental period of this rental.
     *
     * @param date the date to check
     * @return the boolean
     */
    public boolean containsDate( LocalDate date )
    {
        return startDate.isBefore( date ) || startDate.isEqual( date ) && endDate.isAfter( date ) || endDate.isEqual( date );
    }

    /**
     * Gets container id.
     *
     * @return the container id
     */
    public int getContainerId()
    {
        return this.container.getId();
    }

    /**
     * Gets rent.
     *
     * @return the rent
     */
    public double getRent()
    {
        return this.container.getRentPrice() * this.getRentalPeriod().getDays();
    }

    /**
     * Gets removal cost.
     *
     * @return the removal cost
     */
    public double getRemovalCost()
    {
        return this.container.getRemovalCost();
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public double getTotalPrice()
    {
        return this.getRemovalCost() + this.getRent();
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public LocalDate getStartDate()
    {
        return startDate;
    }

    /**
     * Update start date.
     *
     * @param startDate the start date
     */
    public void updateStartDate( LocalDate startDate )
    {
        this.startDate = startDate;
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public LocalDate getEndDate()
    {
        return endDate;
    }

    /**
     * Update end date.
     *
     * @param endDate the end date
     */
    public void updateEndDate( LocalDate endDate )
    {
        this.endDate = endDate;
    }

    /**
     * Gets rental period.
     *
     * @return the rental period
     */
    public Period getRentalPeriod()
    {
        return Period.between( startDate, endDate );
    }

    /**
     * Gets rental id.
     *
     * @return the rental id
     */
    public int getId()
    {
        return rentalId;
    }

    /**
     * Convert an rental record to an string representation.
     * @return An sting representation of an rental object.
     */
    @Override
    public String toString()
    {
        return String.format( "Rental id: %03d Container id: %03d StartDate: %s endDate: %s",
            this.getId(),
                this.getContainerId(),
                this.getStartDate().toString(),
                this.getEndDate().toString()
                );
    }
}
