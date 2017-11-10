package com.jorisrietveld.containercompany.model.container;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 09:58
 * License: GPLv3 - General Public License version 3
 */
public interface ContainerRepositoryContract
{
    /**
     * Gets average container volume.
     *
     * @return the average container volume
     */
    double getAverageContainerVolume();

    Container addContainer( Container container );

    /**
     * Add an new container to the company.
     *
     * @param type the type
     */
    Container addContainer( ContainerRepository.ContainerType type );

    /**
     * Add an new container to the company.
     *
     * @param type the type
     */
    Container addContainer( ContainerRepository.ContainerType type, double width, double length, double height );
}
