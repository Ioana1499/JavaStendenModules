package com.jorisrietveld.containercompany.business.container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 09:46
 * License: GPLv3 - General Public License version 3
 */
public class BioContainer extends Container implements HouseholdWastContainerContract
{
    BioContainer()
    {
        super(1.50, 2, 1);
    }

    BioContainer( int id )
    {
        super(id, 1.50, 2, 1);
    }
}
