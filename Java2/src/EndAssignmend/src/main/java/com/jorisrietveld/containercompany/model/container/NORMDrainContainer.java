package com.jorisrietveld.containercompany.model.container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 23-10-2017 00:08
 * License: GPLv3 - General Public License version 3
 */
public class NORMDrainContainer extends Container implements NucliarContainerContract, LiquidContainerContract
{
    public NORMDrainContainer( int id )
    {
        super( id, 2,2,2 );
        this.setRentM3( 20 );
        this.containerTypeName = "Tunnel Container";
    }

    NORMDrainContainer( int id, double width, double length, double height )
    {
        super( id, width, length, height);
    }
}
