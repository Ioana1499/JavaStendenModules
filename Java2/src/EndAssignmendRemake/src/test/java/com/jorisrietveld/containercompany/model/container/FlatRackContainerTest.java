package com.jorisrietveld.containercompany.model.container;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 31-10-2017 03:12
 * License: GPLv3 - General Public License version 3
 */
@DisplayName( "Flat Rack Container test suite." )
@Tag( "Container Test" )
class FlatRackContainerTest
{
    FlatRackContainer container;

    @BeforeEach
    void setUp()
    {
        container = new FlatRackContainer( 1 );
    }

    @AfterEach
    void tearDown()
    {
        container = null;
    }

    @DisplayName("Test correct flat rack container volume")
    @Test
    void testGetVolume()
    {
        assertEquals( container.getWidth() * container.getLength() * container.getHeight(),
                container.getVolume(),
                "The wrong volume is returned."
        );

    }

    @DisplayName("Test correct flat rack container prices")
    @Test
    void testGetPrices()
    {
        assertEquals( container.getVolume() * container.getRentM3(),
                container.getRentPrice(),
                "The wrong rent price is returned."
        );
    }
}