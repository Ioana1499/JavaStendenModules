package com.jorisrietveld.containercompany.model.container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 09:35
 * License: GPLv3 - General Public License version 3
 */
public class ContainerFactory
{
    public enum ContainerType{
        DRY_CASK_STORAGE,
        NORM_DRAIN,
        SEWAGE,
        URANIUM_HEXAFLUORIDE,
        PAPER,
        BIO
    }

    public Container getContainer( ContainerType type )
    {
        return new SewageContainer( 1 );
    }

    public Container getContainer( String type )
    {
        return new SewageContainer( 1 );
    }
}
