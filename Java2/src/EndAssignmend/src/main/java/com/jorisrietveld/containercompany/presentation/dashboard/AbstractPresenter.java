package com.jorisrietveld.containercompany.presentation.dashboard;

import com.jorisrietveld.containercompany.model.Repository;
import com.jorisrietveld.containercompany.model.Storable;
import com.jorisrietveld.containercompany.model.container.ContainerContract;
import com.jorisrietveld.containercompany.model.container.ContainerRepository;
import com.jorisrietveld.containercompany.model.rental.Rental;
import com.jorisrietveld.containercompany.model.rental.RentalRepository;
import com.jorisrietveld.containercompany.presentation.dashboard.rental.AddRentalController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 17-10-2017 09:04
 * License: GPLv3 - General Public License version 3
 */
public abstract class AbstractPresenter
{
    /**
     * The Container model.
     */
    protected ContainerRepository containerRepository = new ContainerRepository();

    /**
     * The Rental model.
     */
    protected RentalRepository rentalRepository;

    /**
     * Instantiates a new Base controller.
     */
    protected AbstractPresenter()
    {
        containerRepository.addContainer( ContainerRepository.ContainerType.FLAT_RACK );
        containerRepository.addContainer( ContainerRepository.ContainerType.NORMAL );
        containerRepository.addContainer( ContainerRepository.ContainerType.FLAT_RACK );
        containerRepository.addContainer( ContainerRepository.ContainerType.HALF_HEIGHT );
        containerRepository.addContainer( ContainerRepository.ContainerType.TUNNEL );
        containerRepository.addContainer( ContainerRepository.ContainerType.TUNNEL );
        rentalRepository = new RentalRepository( containerRepository );
    }
}
