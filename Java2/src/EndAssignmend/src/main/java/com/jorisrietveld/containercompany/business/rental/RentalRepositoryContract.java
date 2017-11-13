package com.jorisrietveld.containercompany.business.rental;

import com.jorisrietveld.containercompany.business.container.Container;

import java.time.LocalDate;
import java.util.List;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 10:05
 * License: GPLv3 - General Public License version 3
 *
 * An contract for creating rental storage repository implementations.
 */
public interface RentalRepositoryContract
{
    /**
     * Add rental.
     *
     * @param startDate the start date of the rental period.
     * @param endDate   the end date  of the rental period.
     * @param container the container that is being rented.
     * @return the rental just created.
     * @throws IllegalArgumentException the illegal argument exception when there is something wrong with the rental.
     */
    Rental addRental( LocalDate startDate, LocalDate endDate, Container container ) throws IllegalArgumentException;

    /**
     * Gets total revenue.
     *
     * @return the total revenue
     */
    double getTotalRevenue();

    /**
     * Gets total revenue.
     * @param containerId the container id
     * @return the total revenue
     */
    double getTotalRevenue( int containerId );

    /**
     * Gets total revenue in an certain range.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the total revenue
     */
    double getTotalRevenue( LocalDate startDate, LocalDate endDate );

    /**
     * Check if an containers rental period is intersecting with stored rentals.
     *
     * @param startDate   The start date of the rental period.
     * @param endDate     The end date of the rental period.
     * @param containerId the container id that is being rented.
     * @return Is this new renal period intersecting with existing rentals?
     */
    boolean isIntersecting(LocalDate startDate, LocalDate endDate, int containerId );

    /**
     * Gets longest rent period.
     *
     * @return the longest rent period
     */
    Rental getLongestRentPeriod();

    /**
     * Gets rentals by container id.
     *
     * @param containerId the container id of the rentals.
     * @return All rentals of an specific container.
     */
     List<Rental> getRentalsByContainerId( int containerId );

    /**
     * Gets rentals for an specific date.
     *
     * @param forDate The date of the rental records.
     * @return All rental records for an specific date.
     */
     List<Rental> getRentals( LocalDate forDate );

    /**
     * Gets rentals in an specific period (range)
     *
     * @param startDate the start date of the period.
     * @param endDate   the end date of the period.
     * @return All rental records in an specific period.
     */
    List<Rental> getRentals( LocalDate startDate, LocalDate endDate );
}
