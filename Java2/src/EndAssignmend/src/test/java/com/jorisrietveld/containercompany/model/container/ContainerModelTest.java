package com.jorisrietveld.containercompany.model.container;

import static com.jorisrietveld.containercompany.model.container.ContainerModel.ContainerType;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 30-10-2017 18:28
 * License: GPLv3 - General Public License version 3
 * Test suit for the container model.
 * It it also tests all the container entity classes and the super class StorageModel are behaving properly.
 */
class ContainerModelTest
{
    List<Container> testContainers = new ArrayList<>( new ArrayList<Container>( Arrays.asList(

            new TunnelContainer( 1 ),
            new NormalContainer( 2 ),
            new FlatRackContainer( 3 ),
            new TunnelContainer( 4 ),
            new NormalContainer( 5 ),
            new NormalContainer( 6 )
    ) ) );
    ContainerModel model;

    /**
     * Test the initiation of the container model.
     * TODO update this!
     */
    @Test
    void testInit()
    {
        ContainerModel model = new ContainerModel();
        ContainerModel emptyModel = new ContainerModel();

        assertFalse( model.getAll().isEmpty() );
        assertTrue( emptyModel.getAll().isEmpty() );
    }

    /**
     * Test adding a few containers and check if they are stored properly.
     * TODO update this!
     */
    @Test
    void testAddContainer()
    {
        ContainerModel model = new ContainerModel();
        ContainerModel emptyModel = new ContainerModel();

        Container newContainer = model.addContainer( ContainerType.FLAT_RACK );
        Container newContainer2 = model.addContainer( ContainerType.NORMAL );

        Container newContainer3 = emptyModel.addContainer( ContainerType.FLAT_RACK );
        Container newContainer4 = emptyModel.addContainer( ContainerType.HALF_HEIGHT );

        assertSame( model.getById( newContainer.getId() ), newContainer );
        assertSame( model.getById( newContainer2.getId() ), newContainer2 );
        assertSame( emptyModel.getById( newContainer3.getId() ), newContainer3 );
        assertSame( emptyModel.getById( newContainer4.getId() ), newContainer4 );

        assertNotSame( model.getById( newContainer.getId() ), newContainer2 );
        assertNotSame( model.getById( newContainer2.getId() ), newContainer );
        assertNotSame( emptyModel.getById( newContainer3.getId() ), newContainer4 );
        assertNotSame( emptyModel.getById( newContainer4.getId() ), newContainer3 );
    }

    /**
     * Test if the average volume calculation is correct.
     * TODO update this!
     */
    @Test
    void testAverageContainerVolume()
    {
        ContainerModel model = new ContainerModel();
        Container containerNormal = model.addContainer( ContainerType.NORMAL );
        Container containerHalfHeight = model.addContainer( ContainerType.HALF_HEIGHT );

        double average = (containerNormal.getVolume() + containerHalfHeight.getVolume()) / 2;

        assertEquals( average, model.getAverageContainerVolume() );

    }
}
