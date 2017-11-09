package com.jorisrietveld.containercompany.model.container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 29-10-2017 21:36
 * License: GPLv3 - General Public License version 3
 *
 * This data object is en specific type of container.
 */
class NormalContainer extends Container
{
    NormalContainer( int id )
    {
        super( id, 3, 6, 2 );
        this.containerTypeName = "Normal Container";
    }

    NormalContainer( int id, double width, double length, double height )
    {
        super( id, width, length, height);
    }
}
