package com.jorisrietveld.containercompany.business.container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 29-10-2017 21:36
 * License: GPLv3 - General Public License version 3
 *
 * This data object is en specific type of container.
 */
class UraniumHexafluorideContainer extends Container implements NucliarContainerContract
{
    UraniumHexafluorideContainer()
    {
        super( 3, 6, 2 );
        this.containerTypeName = "Normal Container";
    }

    UraniumHexafluorideContainer( double width, double length, double height )
    {
        super( width, length, height);
    }

    UraniumHexafluorideContainer( int id, double width, double length, double height )
    {
        super( id, width, length, height);
    }
}
