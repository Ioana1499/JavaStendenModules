package com.jorisrietveld.containercompany.business.container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 09:46
 * License: GPLv3 - General Public License version 3
 */
public class PaperContainer extends Container implements HouseholdWastContainerContract
{
    PaperContainer()
    {
        super(1, 1.50, 2, 1);
    }

    PaperContainer( int id, double width, double length, double height )
    {
        super(id, width,length,height);
    }

    PaperContainer( double width, double length, double height )
    {
        super( width,length,height);
    }

    @Override
    public Container set( double width, double length, double height )
    {
        super.set( width, length, height );
        return this;
    }
}
