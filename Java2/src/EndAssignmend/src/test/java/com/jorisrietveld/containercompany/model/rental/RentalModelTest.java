package com.jorisrietveld.containercompany.model.rental;

import com.jorisrietveld.containercompany.model.container.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 30-10-2017 18:29
 * License: GPLv3 - General Public License version 3
 * Test suit for the rental model.
 * It it also tests the rental entity class and the super class StorageModel are behaving properly.
 */
public class RentalModelTest
{
    /**
     * Test the initiation of the rental model.
     */
    @Test
    void testInitiation()
    {
        ContainerModel containerModel = new ContainerModel();
        RentalModel model = new RentalModel( containerModel );
        RentalModel emptyModel = new RentalModel();

        assertFalse( model.getAll().isEmpty() );
        assertTrue( emptyModel.getAll().isEmpty() );
    }

    /**
     * Test adding a few rentals and check if they are stored properly.
     */
    @Test
    void testAddRental()
    {
        ContainerModel containerModel = new ContainerModel();
        RentalModel model = new RentalModel();

        Rental rental = model.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 1 ),
                containerModel.getById( 1 )
        );
        Rental rental2 = model.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 1 ),
                containerModel.getById( 2 )
        );

        assertSame( model.getById( rental.getId() ), rental );
        assertNotSame( model.getById( rental.getId() ), rental2 );
    }

    /**
     * Test if the rental model behaves as expected when trying to store an negative rental period.
     */
    @Test
    void testAddIncorrectPeriodRental()
    {
        ContainerModel containerModel = new ContainerModel();
        RentalModel model = new RentalModel( containerModel );
        RentalModel emptyModel = new RentalModel();

        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            emptyModel.addRental(
                    LocalDate.now(),
                    LocalDate.now().minusDays( 1 ),
                    containerModel.getById( 1 )
            );
        } );
        assertEquals( "Invalid rental period selected, the start date can not be before the end date.", exception.getMessage() );
        Throwable exception2 = assertThrows( IllegalArgumentException.class, () -> {
            model.addRental(
                    LocalDate.now(),
                    LocalDate.now().minusDays( 1 ),
                    containerModel.getById( 1 )
            );
        } );
        assertEquals( "Invalid rental period selected, the start date can not be before the end date.", exception2.getMessage() );
    }

    /**
     * Test if the rental model behaves as expected when trying to store invalid rental records.
     */
    @Test
    void testAddIntersectingPeriodRental()
    {
        ContainerModel containerModel = new ContainerModel();
        RentalModel emptyModel = new RentalModel();

        emptyModel.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 3 ),
                containerModel.getById( 1 )
        );

        // Test complete overlapping rental.
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> emptyModel.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 3 ),
                containerModel.getById( 1 )
        ) );
        assertEquals( "Invalid rental period, the container is already rented in this period.", exception.getMessage() );

        // Test intersecting at beginning
        Throwable exception2 = assertThrows( IllegalArgumentException.class, () -> emptyModel.addRental(
                LocalDate.now().minusDays( 2 ),
                LocalDate.now().plusDays( 1 ),
                containerModel.getById( 1 )
        ) );
        assertEquals( "Invalid rental period, the container is already rented in this period.", exception2.getMessage() );

        // Test intersecting at end
        Throwable exception3 = assertThrows( IllegalArgumentException.class, () -> emptyModel.addRental(
                LocalDate.now().plusDays( 2 ),
                LocalDate.now().plusDays( 5 ),
                containerModel.getById( 1 )
        ) );
        assertEquals( "Invalid rental period, the container is already rented in this period.", exception3.getMessage() );

        // Test overlapping but different container.
        try
        {
            emptyModel.addRental(
                    LocalDate.now(),
                    LocalDate.now().plusDays( 3 ),
                    containerModel.getById( 2 )
            );
        }
        catch( IllegalArgumentException ex )
        {
            assertFalse( true, "An exception was thrown for adding an valid container that intersects with an other container." );
        }
    }

    /**
     * Test if the rental returns the correct rent price.
     */
    @Test
    void testGetRentPrice()
    {
        ContainerModel containerModel = new ContainerModel();
        RentalModel emptyModel = new RentalModel();
        Container someContainer = containerModel.getById( 1 );
        int rentDays = 2;
        Rental rental1 = emptyModel.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( rentDays ),
                someContainer
        );

        assertEquals( someContainer.getRentPrice() * rentDays + someContainer.getRemovalCost(),
                rental1.getTotalPrice(),
                "The wrong rent price was returned"
        );

    }

    /**
     * Test is the correct total revenue is returned.
     */
    @Test
    void testGetTotalRevenue()
    {
        ContainerModel containerModel = new ContainerModel();
        RentalModel model = new RentalModel();
        Container someContainer = containerModel.getById( 1 );

        Rental rental1 = model.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 1 ),
                someContainer
        );
        Rental rental2 = model.addRental(
                LocalDate.now().plusDays( 2 ),
                LocalDate.now().plusDays( 3 ),
                someContainer
        );
        Rental rental3 = model.addRental(
                LocalDate.now().plusDays( 4 ),
                LocalDate.now().plusDays( 5 ),
                someContainer
        );

        double rentPrice = someContainer.getRentPrice() * 3 + someContainer.getRemovalCost() * 3;
        assertEquals(
                rentPrice,
                model.getTotalRevenue(),
                "Incorrect total revenue returned."
        );
        assertEquals(
                rentPrice,
                model.getTotalRevenue( someContainer.getId() ),
                "Incorrect total revenue returned for an specific container."
        );
    }

    /**
     * Test is the correct total revenue is returned.
     */
    @Test
    void testGetTotalRevenueRange()
    {
        ContainerModel containerModel = new ContainerModel();
        RentalModel model = new RentalModel();
        Container someContainer = containerModel.getById( 1 );

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays( 1 );
        LocalDate secondStartDate = LocalDate.now().plusDays( 2 );
        LocalDate secondEndDate = LocalDate.now().plusDays( 3 );
        LocalDate thirdStartDate = LocalDate.now().plusDays( 4 );
        LocalDate thirdEndDate = LocalDate.now().plusDays( 5 );

        Rental rental1 = model.addRental(
                startDate,
                endDate,
                someContainer
        );
        Rental rental2 = model.addRental(
                secondStartDate,
                secondEndDate,
                someContainer
        );
        Rental rental3 = model.addRental(
                thirdStartDate,
                thirdEndDate,
                someContainer
        );

        double rentPrice = someContainer.getRentPrice();
        double removePrice = someContainer.getRemovalCost();

        assertEquals(
                removePrice + rentPrice * startDate.until( endDate ).getDays(),
                model.getTotalRevenue( startDate, endDate ),
                "Incorrect total revenue for 1 day returned."
        );
        assertEquals(
                model.getRentals( startDate, secondEndDate ).stream().mapToDouble( Rental::getTotalPrice ).sum(),
                model.getTotalRevenue( startDate, secondEndDate ),
                "Incorrect total revenue for 2 day returned."
        );
    }

    /**
     * Test get all rentals for a day.
     */
    @Test
    void testGetRentalsOnDate()
    {
        ContainerModel containerModel = new ContainerModel();
        RentalModel model = new RentalModel();
        Container someContainer = containerModel.getById( 1 );
        Container someOtherContainer = containerModel.getById( 2 );

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays( 1 );
        LocalDate secondStartDate = LocalDate.now().plusDays( 2 );
        LocalDate secondEndDate = LocalDate.now().plusDays( 3 );

        Rental rental1 = model.addRental(
                startDate,
                endDate,
                someContainer
        );
        Rental rental2 = model.addRental(
                secondStartDate,
                secondEndDate,
                someContainer
        );

        assertSame(
                rental1,
                model.getRentals( startDate ).get( 0 ),
                "Incorrect rental returned."
        );

        Rental rental3 = model.addRental(
                startDate,
                endDate,
                someOtherContainer
        );

        assertEquals(
                2,
                model.getRentals( startDate ).size(),
                "Incorrect number of rentals returned."
        );

    }
}
