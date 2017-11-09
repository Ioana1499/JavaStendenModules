package com.jorisrietveld.containercompany.model.rental;

import com.jorisrietveld.containercompany.model.container.*;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 30-10-2017 18:29
 * License: GPLv3 - General Public License version 3
 * Test suit for the rental model.
 * It it also tests the rental entity class and the super class StorageModel are behaving properly.
 */
@DisplayName( "Rental model test suite" )
@Tag( "Rental Tests" )
public class RentalModelTest
{
    ContainerModel containerModel;
    RentalModel rentalModel;

    /**
     * Initiate an new rental model with an container model before each test.
     */
    @BeforeEach
    void setUp()
    {
        this.containerModel = new ContainerModel();
        containerModel.addContainer( ContainerModel.ContainerType.FLAT_RACK );
        containerModel.addContainer( ContainerModel.ContainerType.NORMAL );
        containerModel.addContainer( ContainerModel.ContainerType.FLAT_RACK );
        containerModel.addContainer( ContainerModel.ContainerType.HALF_HEIGHT );
        containerModel.addContainer( ContainerModel.ContainerType.TUNNEL );
        containerModel.addContainer( ContainerModel.ContainerType.TUNNEL );

        this.rentalModel = new RentalModel( this.containerModel );

    }

    /**
     * After executing each test clear the used models.
     */
    @AfterEach
    void tearDown()
    {
        this.containerModel = null;
        this.rentalModel = null;
    }

    /**
     * Test adding a few rentals and check if they are stored properly.
     */
    @DisplayName( "Test adding new rental records." )
    @Test
    void testAddRental()
    {
        Rental rental = this.rentalModel.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 1 ),
                containerModel.getById( 1 )
        );
        Rental rental2 = this.rentalModel.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 1 ),
                containerModel.getById( 2 )
        );

        assertSame( this.rentalModel.getById( rental.getId() ), rental );
        assertNotSame( this.rentalModel.getById( rental.getId() ), rental2 );
    }

    /**
     * Test if the rental model behaves as expected when trying to store an negative rental period.
     */
    @DisplayName( "Test adding illegal rental records." )
    @Test
    void testAddIncorrectPeriodRental()
    {
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            this.rentalModel.addRental(
                    LocalDate.now(),
                    LocalDate.now().minusDays( 1 ),
                    this.containerModel.getById( 1 )
            );
        } );
        assertEquals( "Invalid rental period selected, the start date can not be before the end date.", exception.getMessage() );

        Throwable exception2 = assertThrows( IllegalArgumentException.class, () -> {
            this.rentalModel.addRental(
                    LocalDate.now(),
                    LocalDate.now().minusDays( 1 ),
                    this.containerModel.getById( 1 )
            );
        } );
        assertEquals( "Invalid rental period selected, the start date can not be before the end date.", exception2.getMessage() );
    }

    /**
     * Test if the rental model behaves as expected when trying to store invalid rental records.
     */
    @DisplayName( "Test adding illegal rental records that ar intersecting." )
    @Test
    void testAddIntersectingPeriodRental()
    {
        this.rentalModel.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 3 ),
                containerModel.getById( 1 )
        );

        // Test complete overlapping rental.
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> this.rentalModel.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 3 ),
                containerModel.getById( 1 )
        ) );
        assertEquals( "Invalid rental period, the container is already rented in this period.", exception.getMessage() );

        // Test intersecting at beginning
        Throwable exception2 = assertThrows( IllegalArgumentException.class, () -> this.rentalModel.addRental(
                LocalDate.now().minusDays( 2 ),
                LocalDate.now().plusDays( 1 ),
                containerModel.getById( 1 )
        ) );
        assertEquals( "Invalid rental period, the container is already rented in this period.", exception2.getMessage() );

        // Test intersecting at end
        Throwable exception3 = assertThrows( IllegalArgumentException.class, () -> this.rentalModel.addRental(
                LocalDate.now().plusDays( 2 ),
                LocalDate.now().plusDays( 5 ),
                containerModel.getById( 1 )
        ) );
        assertEquals( "Invalid rental period, the container is already rented in this period.", exception3.getMessage() );

        // Test overlapping but different container.
        try
        {
            this.rentalModel.addRental(
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
    @DisplayName( "Test getting the correct rent price." )
    @Test
    void testGetRentPrice()
    {
        Container someContainer = this.containerModel.getById( 1 );
        int rentDays = 2;
        Rental rental1 = this.rentalModel.addRental(
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
    @DisplayName( "Test getting an correct total revenue." )
    @Test
    void testGetTotalRevenue()
    {
        this.rentalModel = new RentalModel();
        Container someContainer = containerModel.getById( 1 );

        Rental rental1 = this.rentalModel.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 1 ),
                someContainer
        );
        Rental rental2 = this.rentalModel.addRental(
                LocalDate.now().plusDays( 2 ),
                LocalDate.now().plusDays( 3 ),
                someContainer
        );
        Rental rental3 = this.rentalModel.addRental(
                LocalDate.now().plusDays( 4 ),
                LocalDate.now().plusDays( 5 ),
                someContainer
        );

        double rentPrice = someContainer.getRentPrice() * 3 + someContainer.getRemovalCost() * 3;
        assertEquals(
                rentPrice,
                this.rentalModel.getTotalRevenue(),
                "Incorrect total revenue returned."
        );
        assertEquals(
                rentPrice,
                this.rentalModel.getTotalRevenue( someContainer.getId() ),
                "Incorrect total revenue returned for an specific container."
        );
    }

    /**
     * Test is the correct total revenue is returned.
     */
    @DisplayName( "Test getting the total revenue for an certain range." )
    @Test
    void testGetTotalRevenueRange()
    {
        this.rentalModel = new RentalModel();
        Container someContainer = containerModel.getById( 1 );

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays( 1 );
        LocalDate secondStartDate = LocalDate.now().plusDays( 2 );
        LocalDate secondEndDate = LocalDate.now().plusDays( 3 );
        LocalDate thirdStartDate = LocalDate.now().plusDays( 4 );
        LocalDate thirdEndDate = LocalDate.now().plusDays( 5 );

        Rental rental1 = this.rentalModel.addRental(
                startDate,
                endDate,
                someContainer
        );
        Rental rental2 = this.rentalModel.addRental(
                secondStartDate,
                secondEndDate,
                someContainer
        );
        Rental rental3 = this.rentalModel.addRental(
                thirdStartDate,
                thirdEndDate,
                someContainer
        );

        double rentPrice = someContainer.getRentPrice();
        double removePrice = someContainer.getRemovalCost();

        assertEquals(
                removePrice + rentPrice * startDate.until( endDate ).getDays(),
                this.rentalModel.getTotalRevenue( startDate, endDate ),
                "Incorrect total revenue for 1 day returned."
        );
        assertEquals(
                this.rentalModel.getRentals( startDate, secondEndDate ).stream().mapToDouble( Rental::getTotalPrice ).sum(),
                this.rentalModel.getTotalRevenue( startDate, secondEndDate ),
                "Incorrect total revenue for 2 day returned."
        );
    }

    /**
     * Test get all rentals for a day.
     */
    @DisplayName( "Test getting all rentals for an specific date." )
    @Test
    void testGetRentalsOnDate()
    {
        this.rentalModel = new RentalModel();
        Container someContainer = containerModel.getById( 1 );
        Container someOtherContainer = containerModel.getById( 2 );

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays( 1 );
        LocalDate secondStartDate = LocalDate.now().plusDays( 2 );
        LocalDate secondEndDate = LocalDate.now().plusDays( 3 );

        Rental rental1 = this.rentalModel.addRental(
                startDate,
                endDate,
                someContainer
        );
        Rental rental2 = this.rentalModel.addRental(
                secondStartDate,
                secondEndDate,
                someContainer
        );

        assertSame( rental1,
                this.rentalModel.getRentals( startDate ).get( 0 ),
                "Incorrect rental returned."
        );

        Rental rental3 = this.rentalModel.addRental(
                startDate,
                endDate,
                someOtherContainer
        );

        assertEquals(2,
                this.rentalModel.getRentals( startDate ).size(),
                "Incorrect number of rentals returned."
        );

    }
}
