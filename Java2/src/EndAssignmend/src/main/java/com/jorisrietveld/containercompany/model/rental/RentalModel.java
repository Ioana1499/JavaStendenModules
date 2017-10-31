package com.jorisrietveld.containercompany.model.rental;

import java.time.LocalDate;
import java.util.*;

import com.jorisrietveld.containercompany.model.StorageModel;
import com.jorisrietveld.containercompany.model.container.ContainerModel;
import com.jorisrietveld.containercompany.model.container.Container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 30-10-2017 12:00
 * License: GPLv3 - General Public License version 3
 * This class is contains the api for creating, storing, receiving Rentals. It is also used
 * for generating statistics about the stored containers.
 */
public class RentalModel extends StorageModel<Rental>
{
    /**
     * Instantiates a new Rental model.
     */
    public RentalModel()
    {
        super( new ArrayList<Rental>(  ) );
    }

    /**
     * Instantiates a new Rental model.
     *
     * @param containerModel the container model
     */
    public RentalModel( ContainerModel containerModel)
    {
        super( new ArrayList<Rental>( Arrays.asList(
                new Rental( 1, LocalDate.of( 2017, 9, 10 ), LocalDate.of( 2017, 9, 15 ), containerModel.getById( 1 ) ),
                new Rental( 2, LocalDate.of( 2017, 9, 16 ), LocalDate.of( 2017, 9, 20 ), containerModel.getById( 1 ) ),
                new Rental( 3, LocalDate.of( 2017, 9, 5 ), LocalDate.of( 2017, 9, 12 ), containerModel.getById( 1 ) ),
                new Rental( 4, LocalDate.of( 2017, 9, 16 ), LocalDate.of( 2017, 9, 18 ), containerModel.getById( 1 ) ),
                new Rental( 5, LocalDate.of( 2017, 9, 19 ), LocalDate.of( 2017, 9, 30 ), containerModel.getById( 1 ) ),
                new Rental( 6, LocalDate.of( 2017, 10, 2 ), LocalDate.of( 2017, 10, 7 ), containerModel.getById( 1 ) ),
                new Rental( 7, LocalDate.of( 2017, 10, 2 ), LocalDate.of( 2017, 10, 7 ), containerModel.getById( 1 ) ),
                new Rental( 8, LocalDate.of( 2017, 9, 3 ), LocalDate.of( 2017, 9, 7 ), containerModel.getById( 1 ) ),
                new Rental( 9, LocalDate.of( 2017, 9, 9 ), LocalDate.of( 2017, 9, 14 ), containerModel.getById( 1 ) ),
                new Rental( 10, LocalDate.of( 2017, 10, 5 ), LocalDate.of( 2017, 10, 7 ), containerModel.getById( 1 ) ),
                new Rental( 11, LocalDate.of( 2017, 10, 10 ), LocalDate.of( 2017, 9, 16 ), containerModel.getById( 1 ) )
                )));
    }

    /**
     * Add rental.
     *
     * @param startDate the start date of the rental period.
     * @param endDate   the end date  of the rental period.
     * @param container the container that is being rented.
     * @return the rental just created.
     * @throws IllegalArgumentException the illegal argument exception when there is something wrong with the rental.
     */
    public Rental addRental( LocalDate startDate, LocalDate endDate, Container container ) throws IllegalArgumentException
    {
        if( endDate.isBefore( startDate ) )
        {
            throw new IllegalArgumentException( "Invalid rental period selected, the start date can not be before the end date." );
        }

        if( this.isIntersecting( startDate, endDate, container.getId() ))
        {
            throw new IllegalArgumentException( "Invalid rental period, the container is already rented in this period." );
        }

        Rental newRental = new Rental( this.getNewUniqueId(), startDate, endDate, container );
        this.add( newRental );
        return newRental;
    }

    /**
     * Gets total revenue.
     *
     * @return the total revenue
     */
    public double getTotalRevenue()
    {
        return this.repository.stream().mapToDouble( Rental::getTotalPrice ).sum();
    }

    /**
     * Gets total revenue.
     *
     * @param containerId the container id
     * @return the total revenue
     */
    public double getTotalRevenue( int containerId )
    {
        return this.getRentalsByContainerId( containerId ).stream().mapToDouble( Rental::getTotalPrice ).sum();
    }

    /**
     * Gets total revenue in an certain range.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the total revenue
     */
    public double getTotalRevenue( LocalDate startDate, LocalDate endDate )
    {
        return this.getRentals( startDate, endDate ).stream().mapToDouble( Rental::getTotalPrice ).sum();
    }

    /**
     * Check if an containers rental period is intersecting with stored rentals.
     *
     * @param startDate   The start date of the rental period.
     * @param endDate     The end date of the rental period.
     * @param containerId the container id that is being rented.
     * @return Is this new renal period intersecting with existing rentals?
     */
    public boolean isIntersecting(LocalDate startDate, LocalDate endDate, int containerId )
    {
        return this.hasEntityWhere( r -> r.getContainerId() == containerId && endDate.isAfter( r.getStartDate() ) && startDate.isBefore( r.getEndDate() ));
    }

    /**
     * Gets longest rent period.
     *
     * @return the longest rent period
     */
    public Rental getLongestRentPeriod()
    {
        return Collections.max( repository, Comparator.comparing( r -> r.getRentalPeriod().getDays() ) );
    }

    /**
     * Gets rentals by container id.
     *
     * @param containerId the container id of the rentals.
     * @return All rentals of an specific container.
     */
    public List<Rental> getRentalsByContainerId( int containerId )
    {
        return this.getWhere( rental -> rental.getContainerId() == containerId );
    }

    /**
     * Gets rentals for an specific date.
     *
     * @param forDate The date of the rental records.
     * @return All rental records for an specific date.
     */
    public List<Rental> getRentals( LocalDate forDate )
    {
        return this.getWhere( r -> r.containsDate( forDate ) );
    }

    /**
     * Gets rentals in an specific period (range)
     *
     * @param startDate the start date of the period.
     * @param endDate   the end date of the period.
     * @return All rental records in an specific period.
     */
    public List<Rental> getRentals( LocalDate startDate, LocalDate endDate )
    {
        return this.getWhere( r -> endDate.isAfter( r.getStartDate() ) && startDate.isBefore( r.getEndDate() )  );
    }
}
