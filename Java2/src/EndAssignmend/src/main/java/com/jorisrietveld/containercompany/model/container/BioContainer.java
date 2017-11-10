package com.jorisrietveld.containercompany.model.container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 09:46
 * License: GPLv3 - General Public License version 3
 */
public class BioContainer extends Container implements HouseholdWastContainerContract
{
    BioContainer()
    {
        super(1, 1.50, 2, 1);
    }
}
