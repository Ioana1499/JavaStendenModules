package com.jorisrietveld.containercompany.business.rental;

import com.jorisrietveld.containercompany.business.container.Container;
import com.jorisrietveld.containercompany.business.container.ContainerRepository;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 31-10-2017 03:15
 * License: GPLv3 - General Public License version 3
 */
@DisplayName( "Rental test suite" )
@Tag( "Rental Tests" )
class RentalTest
{
    ContainerRepository containerRepository;

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


    }

    /**
     * After executing each test clear the used models.
     */
    @AfterEach
    void tearDown()
    {
        this.containerRepository = null;
    }

    /**
     * Test if an rental record returns if it fall's in an specific date.
     */
    @DisplayName( "Test renal inside specific date. " )
    @Test
    void containsDate()
    {
        Rental newRental = new Rental( 1, LocalDate.now().minusDays( 2 ), LocalDate.now().plusDays( 2 ), containerRepository.getById( 1 )  );

        assertTrue( newRental.containsDate( LocalDate.now() ), "Failed asserting that an rental falls inside an specific date." );
        assertFalse( newRental.containsDate( LocalDate.now().plusDays( 3 )), "Failed asserting that an rental falls inside an specific date." );
    }

    /**
     * Test getting the correct rental period.
     */
    @DisplayName( "Test getting the correct rental period." )
    @Test
    void getRentalPeriod()
    {
        Container someContainer = containerRepository.getById( 1 );
        Rental newRental = new Rental( 1, LocalDate.now().minusDays( 1 ), LocalDate.now().plusDays( 1 ), someContainer );

        assertEquals( 3,
                newRental.getRentalPeriod().getDays(),
                "Failed asserting the correct rental period."
        );
    }

    /**
     * Test getting the correct rental price for an certain rental period.
     */
    @DisplayName( "Test get rental rent " )
    @Test
    void getRent()
    {
        Container someContainer = containerRepository.getById( 1 );
        Rental newRental = new Rental( 1, LocalDate.now().minusDays( 1 ), LocalDate.now().plusDays( 1 ), someContainer );

        assertEquals( someContainer.getRentPrice() * newRental.getRentalPeriod().getDays() + someContainer.getRemovalCost(),
                newRental.getTotalPrice(),
                "Failed asserting the correct rent price for an container."
        );
    }
}