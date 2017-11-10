package com.jorisrietveld.containercompany.model.container;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 31-10-2017 03:13
 * License: GPLv3 - General Public License version 3
 */
@DisplayName( "Half Height Container test suite." )
@Tag( "Container Test" )
class DryCaskStorageContainerTest
{
    DryCaskStorageContainer container;

    @BeforeEach
    void setUp()
    {
        container = new DryCaskStorageContainer( 1 );
    }

    @AfterEach
    void tearDown()
    {
        container = null;
    }

    @DisplayName("Test correct half height container volume")
    @Test
    void testGetVolume()
    {
        assertEquals( (container.getWidth() * container.getLength() * container.getHeight()),
                container.getVolume(),
                "The wrong volume is returned."
        );

    }

    @DisplayName("Test correct half height container prices")
    @Test
    void testGetPrices()
    {
        assertEquals( container.getVolume() * container.getRentM3(),
                container.getRentPrice(),
                "The wrong rent price is returned."
        );
    }
}