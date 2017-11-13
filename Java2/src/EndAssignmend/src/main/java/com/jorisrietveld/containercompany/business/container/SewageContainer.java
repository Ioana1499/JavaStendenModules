package com.jorisrietveld.containercompany.business.container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 23-10-2017 00:06
 * License: GPLv3 - General Public License version 3
 *
 * This data object is en specific type of container.
 */
class SewageContainer extends Container implements LiquidContainerContract
{
    /**
     * Create an new standard Flat Rack container.
     */
    SewageContainer()
    {
        super( 2.50, 6, 1.50 );
        this.setRentM3( 35 );
        this.containerTypeName = "Flat Rack Container";
    }

    SewageContainer( int id, double width, double length, double height )
    {
        super( id, width, length, height);
    }

    SewageContainer( double width, double length, double height )
    {
        super( width, length, height);
    }
}
