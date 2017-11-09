package com.jorisrietveld.containercompany.presentation.dashboard;

import com.jorisrietveld.containercompany.model.container.ContainerModel;
import com.jorisrietveld.containercompany.model.rental.RentalModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.util.StringConverter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 17-10-2017 09:04
 * License: GPLv3 - General Public License version 3
 */
public abstract class BaseController
{
    /**
     * The Container model.
     */
    protected ContainerModel containerModel = new ContainerModel();

    /**
     * The Rental model.
     */
    protected RentalModel rentalModel;

    /**
     * Instantiates a new Base controller.
     */
    public BaseController()
    {
        containerModel.addContainer( ContainerModel.ContainerType.FLAT_RACK );
        containerModel.addContainer( ContainerModel.ContainerType.NORMAL );
        containerModel.addContainer( ContainerModel.ContainerType.FLAT_RACK );
        containerModel.addContainer( ContainerModel.ContainerType.HALF_HEIGHT );
        containerModel.addContainer( ContainerModel.ContainerType.TUNNEL );
        containerModel.addContainer( ContainerModel.ContainerType.TUNNEL );
        rentalModel = new RentalModel( containerModel );
    }

}
