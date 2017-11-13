package com.jorisrietveld.containercompany.business.container;

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
        switch( type )
        {
            case BIO:
                return new BioContainer();
            case PAPER:
                return new PaperContainer();
            case SEWAGE:
                return new SewageContainer();
            case NORM_DRAIN:
                return new NORMDrainContainer();
            case DRY_CASK_STORAGE:
                return new DryCaskStorageContainer();
            case URANIUM_HEXAFLUORIDE:
                return new UraniumHexafluorideContainer();
            default:
                throw new IllegalArgumentException( "Container type not implemented." );
        }
    }
}
