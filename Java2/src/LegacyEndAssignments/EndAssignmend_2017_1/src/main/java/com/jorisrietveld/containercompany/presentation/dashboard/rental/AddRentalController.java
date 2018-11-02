package com.jorisrietveld.containercompany.presentation.dashboard.rental;

import com.jorisrietveld.containercompany.business.container.Container;
import com.jorisrietveld.containercompany.business.rental.Rental;
import com.jorisrietveld.containercompany.presentation.dashboard.AbstractPresenter;
import com.jorisrietveld.containercompany.presentation.util.DialogFactory;
import com.jorisrietveld.containercompany.presentation.util.DateConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 08-11-2017 04:24
 * License: GPLv3 - General Public License version 3
 */
public class AddRentalController extends AbstractPresenter implements Initializable
{
    private static final int RECENT_HISTORY_DAYS = 60;

    /**
     * An list of displayable rental records for the rental List View.
     */
    private ObservableList<Rental> recentRentalsObservebleList;

    /**
     * An list of displayable container records for the Choice box.
     */
    private ObservableList<ContainerChoice> choicesObservableList;

    /**
     * The Recent rental list view.
     */
    @FXML
    ListView<Rental> recentRentalListView;

    /**
     * The Container choice box.
     */
    @FXML
    ChoiceBox<ContainerChoice> containerChoiceBox;

    /**
     * The Date picker start.
     */
    @FXML
    DatePicker datePickerStart;

    /**
     * The Get date picker end.
     */
    @FXML
    DatePicker getDatePickerEnd;

    /**
     * Initialize the container choice box and add containers to choose from with data fetched
     * from the Container storage business.
     */
    private void initializeContainerChoiceBox()
    {
        this.choicesObservableList = FXCollections.observableArrayList();
        this.fetchContainerData();
        containerChoiceBox.setItems( this.choicesObservableList );
        containerChoiceBox.getSelectionModel().select( 0 );
        datePickerStart.setConverter( new DateConverter() );
        getDatePickerEnd.setConverter( new DateConverter() );
    }

    /**
     * Fetch container records from the storage business and inject it into the choice box element for
     * choosing an container to rent.
     */
    private void fetchContainerData()
    {
        for( Iterator<Container> iterator = this.containerRepository.getAll().iterator(); iterator.hasNext(); )
        {
            Container container = iterator.next();
            this.choicesObservableList.add( new ContainerChoice( container.getId(), container.toString() ) );
        }
    }

    /**
     * Update the container choice box with container choices from the storage business.
     */
    private void updateContainerChoiceBox()
    {
        this.fetchContainerData();
        this.containerChoiceBox.setItems( this.choicesObservableList );
    }

    /**
     * Fetch recent rental records from the storage business from the currently selected container.
     */
    private void fetchRecentRentalData()
    {
        this.recentRentalsObservebleList = FXCollections.observableList(
                this.rentalRepository.getRentalsByContainerId( containerChoiceBox.getValue().id )
        );
    }

    /**
     * Update the rental list view with recent rental record data fetched from the
     * rental business based on the currently selected container.
     */
    @FXML
    private void updateRentalListView()
    {
        fetchRecentRentalData();
        if( containerChoiceBox.getValue() != null )
        {
            List<Rental> recentRentals = this.rentalRepository.getRentalsByContainerId( containerChoiceBox.getValue().id );
            recentRentalListView.setItems( FXCollections.observableList( recentRentals ) );
        }
    }

    /**
     * This method is used to initialize the AddRental view. It fetches data from the storage
     * services and injects it into the view.
     *
     * @param location  The location of the resources.
     * @param resources Resource items, like images and CSS, JS and FXML files
     */
    @FXML
    @Override
    public void initialize( URL location, ResourceBundle resources )
    {
        initializeContainerChoiceBox();

    }

    /**
     * This method will attempt to create an new rental record in the storage business.
     */
    @FXML
    public void rentAContainer()
    {
        try
        {
            rentalRepository.addRental( datePickerStart.getValue(), getDatePickerEnd.getValue(), containerRepository.getById( containerChoiceBox.getValue().id ));
            DialogFactory.createInfoDialog(
                    "Successfully added the Rental",
                    "The rental is successfully added to the Rental Model.",
                    "Click on OK to close this window."
            );
            datePickerStart.setValue( null );
            getDatePickerEnd.setValue( null );
        }
        catch( IllegalArgumentException invalidArgument )
        {
            DialogFactory.createErrorDialog(
                    "Error while adding the rental",
                    invalidArgument.getMessage(),
                    "Please correct the error and try again, click on OK to close this window."
            );
        }
        updateRentalListView();
    }

}
