package com.jorisrietveld.containercompany.model.container;

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
     *
     * @param id The id of the container.
     */
    SewageContainer( int id )
    {
        super( id, 2.50, 6, 1.50 );
        this.setRentM3( 35 );
        this.containerTypeName = "Flat Rack Container";
    }

    SewageContainer( int id, double width, double length, double height )
    {
        super( id, width, length, height);
    }
}
