package com.jorisrietveld.containercompany.business.container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 23-10-2017 00:07
 * License: GPLv3 - General Public License version 3
 *
 * This data object is en specific type of container.
 */
class DryCaskStorageContainer extends Container implements NucliarContainerContract
{
    DryCaskStorageContainer()
    {
        super( 3, 6, 1 );
        this.setRemovalCost( this.getRemovalCost() / 2 );
        this.setRemovalCostUnder2m3( this.getRemovalCost() /2 );

        this.containerTypeName = "Half Height Container";
    }

    DryCaskStorageContainer( int id, double width, double length, double height )
    {
        super( id, width, length, height);
    }

    DryCaskStorageContainer( double width, double length, double height )
    {
        super( width, length, height);
    }

    DryCaskStorageContainer( int id )
    {
        super( id, 2, 6, 1 );
        this.setRemovalCost( this.getRemovalCost() / 2 );
        this.setRemovalCostUnder2m3( this.getRemovalCost() /2 );

        this.containerTypeName = "Half Height Container";
    }
}
