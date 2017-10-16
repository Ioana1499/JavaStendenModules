package Assignment6.Main;

import java.time.LocalDate;
import java.time.Period;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 19:47
 * License: GPLv3 - General Public License version 3
 */
public class Rental
{
    private LocalDate startDate;
    private LocalDate endDate;
    private Container container;
    private boolean paid;

    public Rental( LocalDate startDate, LocalDate endDate, Container container )
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.container = container;
        this.paid = false;
    }

    public boolean containsDate( LocalDate date )
    {
        return date.isAfter( startDate ) && date.isBefore( endDate );
    }

    public int getContainerId()
    {
        return this.container.getContainerId();
    }

    public int getRent()
    {
        return this.container.getRentPrice() * this.getRentalPeriod().getDays();
    }

    public int getRemovalCost()
    {
        return this.container.getRemovalCost();
    }

    public int getTotalPrice()
    {
        return this.getRemovalCost() + this.getRemovalCost();
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public void updateStartDate( LocalDate startDate )
    {
        this.startDate = startDate;
    }

    public LocalDate getEndDate()
    {
        return endDate;
    }

    public void updateEndDate( LocalDate endDate )
    {
        this.endDate = endDate;
    }

    public Period getRentalPeriod()
    {
        return Period.between( startDate, endDate );
    }

    public boolean isPaid()
    {
        return this.paid;
    }

    public void pay()
    {
        this.paid = true;
    }
}
