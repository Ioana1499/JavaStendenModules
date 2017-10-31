package com.jorisrietveld.containercompany.model.container;

import java.util.*;

import com.jorisrietveld.containercompany.model.StorageModel;
/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 30-10-2017 12:00
 * License: GPLv3 - General Public License version 3
 *
 * This class is contains the api for creating, storing, receiving Containers. It is also used
 * for generating statistics about the stored containers.
 */
public class ContainerModel extends StorageModel<Container>
{
    /**
     * The enum containing all types of containers that are available.
     */
    public enum ContainerType{
        FLAT_RACK,
        HALF_HEIGHT,
        NORMAL,
        TUNNEL
    }

    /**
     * Instantiates a new Container model.
     */
    public ContainerModel( List<Container> containers )
    {
        super( containers );
    }
    public ContainerModel()
    {
        super( new ArrayList<Container>() );
    }

    /**
     * Gets average container volume.
     *
     * @return the average container volume
     */
    public double getAverageContainerVolume()
    {
        return repository.stream()
                .mapToDouble( Container::getVolume )
                .average()
                .orElse( 0 );
    }

    /**
     * Add an new container to the company.
     *
     * @param type the type
     */
    public Container addContainer( ContainerType type )
    {
        Container newContainer;
        switch( type )
        {
            case NORMAL:
                newContainer = new NormalContainer( getNewUniqueId() );
                break;
            case TUNNEL:
                newContainer = new TunnelContainer( getNewUniqueId() );
                break;
            case FLAT_RACK:
                newContainer = new FlatRackContainer( getNewUniqueId() );
                break;
            case HALF_HEIGHT:
                newContainer =new HalfHeightContainer( getNewUniqueId() );
                break;
            default:
                throw new IllegalArgumentException("Container type not implemented.");
        }
        this.add( newContainer );
        return newContainer;
    }
}
