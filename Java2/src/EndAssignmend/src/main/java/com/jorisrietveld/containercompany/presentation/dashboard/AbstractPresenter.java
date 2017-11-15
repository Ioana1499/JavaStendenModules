package com.jorisrietveld.containercompany.presentation.dashboard;

import com.jorisrietveld.containercompany.business.Customer.CustomerFactory;
import com.jorisrietveld.containercompany.business.Customer.CustomerRepository;
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

    /**
     * The Rental business.
     */
    protected RentalRepository rentalRepository;

    protected ContainerFactory containerFactory = new ContainerFactory();

    protected CustomerFactory customerFactory = new CustomerFactory();
    protected CustomerRepository customerRepository = new CustomerRepository( );
    /**
     * Instantiates a new Base controller.
     */
    protected AbstractPresenter()
    {

        containerRepository.addContainer( this.containerFactory.getContainer(
                        ContainerFactory.ContainerType.URANIUM_HEXAFLUORIDE ).set( 2, 4.5, 1.5 ));
        containerRepository.addContainer( this.containerFactory.getContainer(
                ContainerFactory.ContainerType.BIO ).set( 2, 4.5, 1.5 ));
        containerRepository.addContainer( this.containerFactory.getContainer(
                ContainerFactory.ContainerType.NORM_DRAIN ).set( 2, 4.5, 1.5 ));
        containerRepository.addContainer( this.containerFactory.getContainer(
                ContainerFactory.ContainerType.DRY_CASK_STORAGE ).set( 2, 4.5, 1.5 ));
        containerRepository.addContainer( this.containerFactory.getContainer(
                ContainerFactory.ContainerType.SEWAGE ).set( 2, 4.5, 1.5 ));
        containerRepository.addContainer( this.containerFactory.getContainer(
                ContainerFactory.ContainerType.NORM_DRAIN ).set( 2, 4.5, 1.5 ));
        containerRepository.addContainer( this.containerFactory.getContainer(
                ContainerFactory.ContainerType.URANIUM_HEXAFLUORIDE ).set( 2, 4.5, 1.5 ));
        containerRepository.addContainer( this.containerFactory.getContainer(
                ContainerFactory.ContainerType.SEWAGE ).set( 2, 4.5, 1.5 ));
        containerRepository.addContainer( this.containerFactory.getContainer(
                ContainerFactory.ContainerType.NORM_DRAIN ).set( 2, 4.5, 1.5 ));

        rentalRepository = new RentalRepository( containerRepository );
    }
}
