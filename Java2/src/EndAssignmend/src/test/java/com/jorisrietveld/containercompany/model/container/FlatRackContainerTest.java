package com.jorisrietveld.containercompany.model.container;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 31-10-2017 03:12
 * License: GPLv3 - General Public License version 3
 */
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

    @DisplayName("Test correct container volume")
    @Test
    void testGetVolume()
    {
        assertEquals( container.getHeight() * container.getWidth() * container.getWidth(),
                container.getVolume(),
                "The wrong volume is returned."
        );

    }

    @DisplayName("Test correct container prices")
    @Test
    void testGetPrices()
    {
        assertEquals( container.getVolume() * container.getRentM3(),
                container.getRentPrice(),
                "The wrong rent price is returned."
        );

        assertEquals( container.getVolume() * container.getRentM3(),
                container.getRemovalCost(),
                "The wrong removal cost is returned."
        );
    }
}