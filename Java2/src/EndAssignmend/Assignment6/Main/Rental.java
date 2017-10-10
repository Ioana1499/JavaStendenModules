package Assignment6.Main;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.time.Period;

public class Rental
{
    private boolean paied = false;

    private Container container;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
    private Period rentalPeriod;
    private int price;

    Rental( Container container, LocalDate rentStartDate, LocalDate rentEndDate )
    {
        this.container = container;
        this.rentStartDate = rentStartDate;
        this.rentEndDate = rentEndDate;
        this.updatePeriod();
    }

    private void updatePeriod()
    {
        rentalPeriod = Period.between( rentStartDate, rentStartDate );
    }

    public void updateStartDate( LocalDate newStartDate )
    {
        this.rentStartDate = newStartDate;
        this.updatePeriod();
    }

    public void updateEndDate( LocalDate newEndDate )
    {
        this.rentEndDate = newEndDate;
        this.updatePeriod();
    }

    public void updateRentalPeriod( LocalDate newStartDate, LocalDate newEndDate )
    {
        updateStartDate( newStartDate );
        updateEndDate( newEndDate );
    }

    public boolean isOverlappingPeriod( Period period )
    {
        throw new NotImplementedException();
    }

    public boolean isPaied()
    {
        return this.paied;
    }

    public int getRentPrice()
    {
        throw new NotImplementedException();
    }

    public int getPrice()
    {
        throw new NotImplementedException();
    }

    public Rental finsishRental()
    {
        throw new NotImplementedException();
      //  this.container.getContent( )
    }
}
