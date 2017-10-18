package Assignment6.ContainerCompany;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 19:47
 * License: GPLv3 - General Public License version 3
 */
public class Company
{
    /**
     * The stored container rentals.
     */
    private List<Rental> rentals;

    /**
     * The containers the company owns
     */
    private List<Container> containers = new ArrayList<>( Arrays.asList(
            new Container( 1,2, 6,1 ),
            new Container( 2,2, 1,1 ),
            new Container( 3, 2, 4,2 ),
            new Container( 4,2, 8,2 )
    ));

    /**
     * Instantiates a new Company.
     */
    public Company()
    {
        this.rentals = new ArrayList<>();
    }

    /**
     * Add rental.
     *
     * @param startDate   the start date of the rental period.
     * @param endDate     the end date  of the rental period.
     * @param containerId the container id that is being rented.
     * @throws IllegalArgumentException the illegal argument exception when there is something wrong with the rental.
     */
    public void addRental( LocalDate startDate, LocalDate endDate, int containerId ) throws IllegalArgumentException
    {
        if( endDate.isBefore( startDate ) )
        {
            throw new IllegalArgumentException( "Invalid rental period selected, the start date can not be before the end date." );
        }

        if( containerId == 0 || containerId >= containers.size() )
        {
            throw new IllegalArgumentException( "Invalid container id, the id does not exist." );
        }

        if( this.isIntersecting( startDate, endDate, containerId ))
        {
            throw new IllegalArgumentException( "Invalid rental period, the container is already rented in this period." );
        }

        this.rentals.add( new Rental( rentals.size(), startDate, endDate, this.containers.get( containerId ) ) );
    }

    /**
     * Gets average container volume.
     *
     * @return the average container volume
     */
    public int getAverageContainerVolume()
    {
        return (int)containers.stream().mapToInt( Container::getVolume ).average().orElse( 0 );
    }

    /**
     * Gets total revenue.
     *
     * @return the total revenue
     */
    public int getTotalRevenue()
    {
        return this.rentals.stream().mapToInt( Rental::getTotalPrice ).sum();
    }

    /**
     * Gets total revenue.
     *
     * @param containerId the container id
     * @return the total revenue
     */
    public int getTotalRevenue( int containerId )
    {
        return this.getRentalsByContainerId( containerId ).stream().mapToInt( Rental::getTotalPrice ).sum();
    }

    /**
     * Gets total revenue.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the total revenue
     */
    public int getTotalRevenue( LocalDate startDate, LocalDate endDate )
    {
        return this.getRentals( startDate, endDate ).stream().mapToInt( Rental::getTotalPrice ).sum();
    }

    /**
     * Check if an containers rental period is intersecting with stored rentals.
     * @param startDate The start date of the rental period.
     * @param endDate The end date of the rental period.
     * @param containerId the container id that is being rented.
     * @return Is this new renal period intersecting with existing rentals?
     */
    private boolean isIntersecting(LocalDate startDate, LocalDate endDate, int containerId )
    {
        List<Rental> intersectingRentals = this.getRentalsBy( r ->
                r.getContainerId() == containerId &&
                        endDate.isAfter( r.getStartDate() ) &&
                        startDate.isBefore( r.getEndDate() )
        );
        return intersectingRentals.size() > 0;
    }

    /**
     * Gets longest rent period.
     *
     * @return the longest rent period
     */
    public Rental getLongestRentPeriod()
    {
        return Collections.max( rentals, Comparator.comparing( r -> r.getRentalPeriod().getDays() ) );
    }

    /**
     * Gets rentals by container id.
     *
     * @param containerId the container id of the rentals.
     * @return All rentals of an specific container.
     */
    public List<Rental> getRentalsByContainerId( int containerId )
    {
        return this.getRentalsBy( r -> r.getContainerId() == containerId );
    }

    /**
     * Gets rentals for an specific date.
     *
     * @param forDate The date of the rental records.
     * @return All rental records for an specific date.
     */
    public List<Rental> getRentals( LocalDate forDate )
    {
        return this.getRentalsBy( r -> r.containsDate( forDate ) );
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
        return this.getRentalsBy( r -> endDate.isAfter( r.getStartDate() ) || startDate.isBefore( r.getEndDate() )  );
    }

    /**
     * An filter functions to filter rental records with an predicate.
     * @param condition The condition that has to be matched.
     * @return An list of rentals that are matching the condition.
     */
    private List<Rental> getRentalsBy( Predicate<Rental> condition )
    {
        return rentals.stream().filter( condition ).collect( Collectors.toList() );
    }

    /**
     * Get containers.
     *
     * @return An list with all containers the company owns.
     */
    public List<Container> getContainers()
    {
        return this.containers;
    }
}
