package com.jorisrietveld.containercompany.presentation.dashboard.container;

import com.jorisrietveld.containercompany.model.container.ContainerRepository;
import com.jorisrietveld.containercompany.presentation.dashboard.BaseController;
import com.jorisrietveld.containercompany.presentation.util.AplicationDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 07-11-2017 12:07
 * License: GPLv3 - General Public License version 3
 */
public class AddContainerController extends BaseController implements Initializable
{

    /**
     * The Container type observable list.
     */
    ObservableList<ContainerRepository.ContainerType> containerTypeObservableList;

    /**
     * The Container type choice box.
     */
    @FXML
    ChoiceBox<ContainerRepository.ContainerType> containerTypeChoiceBox;

    /**
     * The Width slider.
     */
    @FXML // This node contains the width of the new container
            Slider widthSlider;

    /**
     * The Length slider.
     */
    @FXML // This node contains the length of the new container.
            Slider lengthSlider;

    /**
     * The Height slider.
     */
    @FXML // This node contains the height of the new container.
            Slider heightSlider;

    /**
     * This method is used to initialize the Add Container view. It fetches data from the storage
     * services and injects it into the view.
     *
     * @param location  The location of the resources.
     * @param resources Resource items, like images and CSS, JS and FXML files
     */
    @FXML
    @Override
    public void initialize( URL location, ResourceBundle resources )
    {
        initializeContainerTypeChoiceBox();
    }

    /**
     * Initialize the container choice box.
     */
    private void initializeContainerTypeChoiceBox()
    {
        this.containerTypeObservableList = FXCollections.observableArrayList(
                ContainerRepository.ContainerType.values()
        );

        containerTypeChoiceBox.setItems( this.containerTypeObservableList );
        containerTypeChoiceBox.getSelectionModel().select( 0 );
    }

    /**
     * Attempt to add an new container.
     */
    @FXML // This action inserts an new container into the storage model.
    private void addContainer()
    {
        try
        {
            containerRepository.addContainer(
                    containerTypeChoiceBox.getValue(),
                    widthSlider.getValue(),
                    lengthSlider.getValue(),
                    heightSlider.getValue()
            );
            AplicationDialog.createInfoDialog(
                    "Successfully added the Container",
                    "The container is successfully added to the Rental Model.",
                    "Click on OK to close this window."
            );
            containerTypeChoiceBox.getSelectionModel().select( 0 );
            widthSlider.setValue( 0 );
            lengthSlider.setValue( 0 );
            heightSlider.setValue( 0 );
        }
        catch( IllegalArgumentException invalidArgument )
        {
            AplicationDialog.createErrorDialog(
                    "Error while adding the container",
                    invalidArgument.getMessage(),
                    "Please correct the error and try again, click on OK to close this window."
            );
        }
    }
}
