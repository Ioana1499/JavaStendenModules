package com.jorisrietveld.containercompany.business.container;

import static com.jorisrietveld.containercompany.business.container.ContainerRepository.ContainerType;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 30-10-2017 18:28
 * License: GPLv3 - General Public License version 3
 * Test suit for the container business.
 * It it also tests all the container entity classes and the super class NonPersistingRepository are behaving properly.
 */
@DisplayName( "Container Model test suite." )
@Tag( "Container Test" )
class ContainerRepositoryTest
{
    List<Container> testContainers = new ArrayList<>( new ArrayList<Container>( Arrays.asList(
            new NORMDrainContainer( 1 ),
            new UraniumHexafluorideContainer( 2 ),
            new SewageContainer( 3 ),
            new NORMDrainContainer( 4 ),
            new UraniumHexafluorideContainer( 5 ),
            new UraniumHexafluorideContainer( 6 )
    ) ) );
    ContainerRepository model;

    /**
     * Test the initiation of the container business.
     */
    @DisplayName( "Test initiating an container." )
    @Test
    void testInit()
    {
        ContainerRepository model = new ContainerRepository();

        assertTrue( model.getAll().isEmpty() );
    }

    /**
     * Test adding a few containers and check if they are stored properly.
     */
    @DisplayName( "Test Adding an new container to the business." )
    @Test
    void testAddContainer()
    {
        ContainerRepository model = new ContainerRepository();
        Container newContainer = model.addContainer( ContainerType.FLAT_RACK );
        Container newContainer2 = model.addContainer( ContainerType.NORMAL );

        assertSame( model.getById( newContainer.getId() ), newContainer );
        assertSame( model.getById( newContainer2.getId() ), newContainer2 );

        assertNotSame( model.getById( newContainer.getId() ), newContainer2 );
        assertNotSame( model.getById( newContainer2.getId() ), newContainer );
    }

    /**
     * Test if the average volume calculation is correct.
     */
    @DisplayName( "Test calculating average container volume." )
    @Test
    void testAverageContainerVolume()
    {
        ContainerRepository model = new ContainerRepository();
        Container containerNormal = model.addContainer( ContainerType.NORMAL );
        Container containerHalfHeight = model.addContainer( ContainerType.HALF_HEIGHT );

        double average = (containerNormal.getVolume() + containerHalfHeight.getVolume()) / 2;

        assertEquals( average, model.getAverageContainerVolume() );

    }
}
