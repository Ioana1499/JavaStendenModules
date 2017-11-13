package com.jorisrietveld.containercompany.business.container;

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
}
