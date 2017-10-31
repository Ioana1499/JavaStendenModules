package com.jorisrietveld.containercompany.model.rental;

import com.jorisrietveld.containercompany.model.container.ContainerModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 31-10-2017 03:15
 * License: GPLv3 - General Public License version 3
 */
class RentalTest
{
    ContainerModel containerModel;
    Rental rental;
    LocalDate now;

    @BeforeEach
    void setUp()
    {
        containerModel = new ContainerModel();
        containerModel.addContainer( ContainerModel.ContainerType.NORMAL );
        now = LocalDate.now();

        rental = new Rental( 1, now, now.plusDays( 5 ), containerModel.getById( 1 ) );
    }

    @AfterEach
    void tearDown()
    {
        containerModel = null;
        rental = null;
        now = null;
    }

    @Test
    void containsDate()
    {
    }

    @Test
    void getRent()
    {
    }

    @Test
    void getRemovalCost()
    {
    }

    @Test
    void getTotalPrice()
    {
    }

    @Test
    void getRentalPeriod()
    {
    }

}