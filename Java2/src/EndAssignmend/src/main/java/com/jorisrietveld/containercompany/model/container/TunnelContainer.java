package com.jorisrietveld.containercompany.model.container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 23-10-2017 00:08
 * License: GPLv3 - General Public License version 3
 */
public class TunnelContainer extends NormalContainer
{
    public TunnelContainer( int id )
    {
        super( id );
        this.setRentM3( 20 );
    }
}
