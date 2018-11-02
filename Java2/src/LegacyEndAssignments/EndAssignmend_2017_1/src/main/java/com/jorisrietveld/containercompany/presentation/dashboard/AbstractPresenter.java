package com.jorisrietveld.containercompany.presentation.dashboard;

import com.jorisrietveld.containercompany.business.container.ContainerFactory;
import com.jorisrietveld.containercompany.business.container.ContainerRepository;
import com.jorisrietveld.containercompany.business.rental.RentalRepository;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 17-10-2017 09:04
 * License: GPLv3 - General Public License version 3
 */
public abstract class AbstractPresenter
{
    /**
     * The Container business.
     */
    protected ContainerRepository containerRepository = new ContainerRepository();

    protected ContainerFactory containerFactory = new ContainerFactory();

    /**
     * The Rental business.
     */
    protected RentalRepository rentalRepository;

    /**
     * Instantiates a new Base controller.
     */
    protected AbstractPresenter()
    {
        containerRepository.addContainer(
                this.containerFactory.getContainer( ContainerFactory.ContainerType.DRY_CASK_STORAGE ).
        )
        containerRepository.addContainer( ContainerRepository.ContainerType.FLAT_RACK );
        containerRepository.addContainer( ContainerRepository.ContainerType.NORMAL );
        containerRepository.addContainer( ContainerRepository.ContainerType.FLAT_RACK );
        containerRepository.addContainer( ContainerRepository.ContainerType.HALF_HEIGHT );
        containerRepository.addContainer( ContainerRepository.ContainerType.TUNNEL );
        containerRepository.addContainer( ContainerRepository.ContainerType.TUNNEL );
        rentalRepository = new RentalRepository( containerRepository );
    }
}
