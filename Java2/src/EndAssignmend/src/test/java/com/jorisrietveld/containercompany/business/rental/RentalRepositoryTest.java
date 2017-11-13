package com.jorisrietveld.containercompany.business.rental;

import com.jorisrietveld.containercompany.business.container.*;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 30-10-2017 18:29
 * License: GPLv3 - General Public License version 3
 * Test suit for the rental business.
 * It it also tests the rental entity class and the super class NonPersistingRepository are behaving properly.
 */
@DisplayName( "Rental business test suite" )
@Tag( "Rental Tests" )
public class RentalRepositoryTest
{
    ContainerRepository containerRepository;
    RentalRepository rentalRepository;

    /**
     * Initiate an new rental business with an container business before each test.
     */
    @BeforeEach
    void setUp()
    {
        this.containerRepository = new ContainerRepository();
        containerRepository.addContainer( ContainerRepository.ContainerType.FLAT_RACK );
        containerRepository.addContainer( ContainerRepository.ContainerType.NORMAL );
        containerRepository.addContainer( ContainerRepository.ContainerType.FLAT_RACK );
        containerRepository.addContainer( ContainerRepository.ContainerType.HALF_HEIGHT );
        containerRepository.addContainer( ContainerRepository.ContainerType.TUNNEL );
        containerRepository.addContainer( ContainerRepository.ContainerType.TUNNEL );

        this.rentalRepository = new RentalRepository( this.containerRepository );

    }

    /**
     * After executing each test clear the used models.
     */
    @AfterEach
    void tearDown()
    {
        this.containerRepository = null;
        this.rentalRepository = null;
    }

    /**
     * Test adding a few rentals and check if they are stored properly.
     */
    @DisplayName( "Test adding new rental records." )
    @Test
    void testAddRental()
    {
        Rental rental = this.rentalRepository.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 1 ),
                containerRepository.getById( 1 )
        );
        Rental rental2 = this.rentalRepository.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 1 ),
                containerRepository.getById( 2 )
        );

        assertSame( this.rentalRepository.getById( rental.getId() ), rental );
        assertNotSame( this.rentalRepository.getById( rental.getId() ), rental2 );
    }

    /**
     * Test if the rental business behaves as expected when trying to store an negative rental period.
     */
    @DisplayName( "Test adding illegal rental records." )
    @Test
    void testAddIncorrectPeriodRental()
    {
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            this.rentalRepository.addRental(
                    LocalDate.now(),
                    LocalDate.now().minusDays( 1 ),
                    this.containerRepository.getById( 1 )
            );
        } );
        assertEquals( "Invalid rental period selected, the start date can not be before the end date.", exception.getMessage() );

        Throwable exception2 = assertThrows( IllegalArgumentException.class, () -> {
            this.rentalRepository.addRental(
                    LocalDate.now(),
                    LocalDate.now().minusDays( 1 ),
                    this.containerRepository.getById( 1 )
            );
        } );
        assertEquals( "Invalid rental period selected, the start date can not be before the end date.", exception2.getMessage() );
    }

    /**
     * Test if the rental business behaves as expected when trying to store invalid rental records.
     */
    @DisplayName( "Test adding illegal rental records that ar intersecting." )
    @Test
    void testAddIntersectingPeriodRental()
    {
        this.rentalRepository.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 3 ),
                containerRepository.getById( 1 )
        );

        // Test complete overlapping rental.
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> this.rentalRepository.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 3 ),
                containerRepository.getById( 1 )
        ) );
        assertEquals( "Invalid rental period, the container is already rented in this period.", exception.getMessage() );

        // Test intersecting at beginning
        Throwable exception2 = assertThrows( IllegalArgumentException.class, () -> this.rentalRepository.addRental(
                LocalDate.now().minusDays( 2 ),
                LocalDate.now().plusDays( 1 ),
                containerRepository.getById( 1 )
        ) );
        assertEquals( "Invalid rental period, the container is already rented in this period.", exception2.getMessage() );

        // Test intersecting at end
        Throwable exception3 = assertThrows( IllegalArgumentException.class, () -> this.rentalRepository.addRental(
                LocalDate.now().plusDays( 2 ),
                LocalDate.now().plusDays( 5 ),
                containerRepository.getById( 1 )
        ) );
        assertEquals( "Invalid rental period, the container is already rented in this period.", exception3.getMessage() );

        // Test overlapping but different container.
        try
        {
            this.rentalRepository.addRental(
                    LocalDate.now(),
                    LocalDate.now().plusDays( 3 ),
                    containerRepository.getById( 2 )
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
        Container someContainer = this.containerRepository.getById( 1 );
        int rentDays = 2;
        Rental rental1 = this.rentalRepository.addRental(
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
        this.rentalRepository = new RentalRepository();
        Container someContainer = containerRepository.getById( 1 );

        Rental rental1 = this.rentalRepository.addRental(
                LocalDate.now(),
                LocalDate.now().plusDays( 1 ),
                someContainer
        );
        Rental rental2 = this.rentalRepository.addRental(
                LocalDate.now().plusDays( 2 ),
                LocalDate.now().plusDays( 3 ),
                someContainer
        );
        Rental rental3 = this.rentalRepository.addRental(
                LocalDate.now().plusDays( 4 ),
                LocalDate.now().plusDays( 5 ),
                someContainer
        );

        double rentPrice = someContainer.getRentPrice() * 3 + someContainer.getRemovalCost() * 3;
        assertEquals(
                rentPrice,
                this.rentalRepository.getTotalRevenue(),
                "Incorrect total revenue returned."
        );
        assertEquals(
                rentPrice,
                this.rentalRepository.getTotalRevenue( someContainer.getId() ),
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
        this.rentalRepository = new RentalRepository();
        Container someContainer = containerRepository.getById( 1 );

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays( 1 );
        LocalDate secondStartDate = LocalDate.now().plusDays( 2 );
        LocalDate secondEndDate = LocalDate.now().plusDays( 3 );
        LocalDate thirdStartDate = LocalDate.now().plusDays( 4 );
        LocalDate thirdEndDate = LocalDate.now().plusDays( 5 );

        Rental rental1 = this.rentalRepository.addRental(
                startDate,
                endDate,
                someContainer
        );
        Rental rental2 = this.rentalRepository.addRental(
                secondStartDate,
                secondEndDate,
                someContainer
        );
        Rental rental3 = this.rentalRepository.addRental(
                thirdStartDate,
                thirdEndDate,
                someContainer
        );

        double rentPrice = someContainer.getRentPrice();
        double removePrice = someContainer.getRemovalCost();

        assertEquals(
                removePrice + rentPrice * startDate.until( endDate ).getDays(),
                this.rentalRepository.getTotalRevenue( startDate, endDate ),
                "Incorrect total revenue for 1 day returned."
        );
        assertEquals(
                this.rentalRepository.getRentals( startDate, secondEndDate ).stream().mapToDouble( Rental::getTotalPrice ).sum(),
                this.rentalRepository.getTotalRevenue( startDate, secondEndDate ),
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
        this.rentalRepository = new RentalRepository();
        Container someContainer = containerRepository.getById( 1 );
        Container someOtherContainer = containerRepository.getById( 2 );

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays( 1 );
        LocalDate secondStartDate = LocalDate.now().plusDays( 2 );
        LocalDate secondEndDate = LocalDate.now().plusDays( 3 );

        Rental rental1 = this.rentalRepository.addRental(
                startDate,
                endDate,
                someContainer
        );
        Rental rental2 = this.rentalRepository.addRental(
                secondStartDate,
                secondEndDate,
                someContainer
        );

        assertSame( rental1,
                this.rentalRepository.getRentals( startDate ).get( 0 ),
                "Incorrect rental returned."
        );

        Rental rental3 = this.rentalRepository.addRental(
                startDate,
                endDate,
                someOtherContainer
        );

        assertEquals(2,
                this.rentalRepository.getRentals( startDate ).size(),
                "Incorrect number of rentals returned."
        );

    }
}
