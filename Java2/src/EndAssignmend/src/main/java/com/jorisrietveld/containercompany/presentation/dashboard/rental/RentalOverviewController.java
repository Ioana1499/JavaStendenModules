package com.jorisrietveld.containercompany.presentation.dashboard.rental;

import com.jorisrietveld.containercompany.model.rental.Rental;
import com.jorisrietveld.containercompany.presentation.dashboard.AbstractPresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 17-10-2017 09:08
 * License: GPLv3 - General Public License version 3
 */
public class RentalOverviewController extends AbstractPresenter implements Initializable
{
    /**
     * An list with observable rental records that will be displayed inside the table view node.
     */
    private ObservableList<Rental> rentalObservableList = FXCollections.observableArrayList();

    /**
     * The Rentals overview table.
     */
    @FXML
    TableView<Rental> rentalsOverviewTable;

    /**
     * The Rental id column.
     */
    @FXML
    TableColumn<Rental, String> rentalIdColumn;

    /**
     * The Start date column.
     */
    @FXML
    TableColumn<Rental, String> startDateColumn;

    /**
     * The End date column.
     */
    @FXML
    TableColumn<Rental, String> endDateColumn;

    /**
     * The Rental period column.
     */
    @FXML
    TableColumn<Rental, String> rentalPeriodColumn;

    /**
     * The Container id column.
     */
    @FXML
    TableColumn<Rental, String> containerIdColumn;

    /**
     * The Rent column.
     */
    @FXML
    TableColumn<Rental, String> rentColumn;

    /**
     * The Total cost column.
     */
    @FXML
    TableColumn<Rental, String> totalCostColumn;

    /**
     * Create an mapping between rental records and the rental table view columns.
     */
    private void initiateRentalOverviewTable()
    {
        rentalIdColumn.setCellValueFactory( new PropertyValueFactory<Rental,String>( "id" ) );
        startDateColumn.setCellValueFactory( new PropertyValueFactory<Rental,String>( "startDate" ) );
        endDateColumn.setCellValueFactory( new PropertyValueFactory<Rental,String>( "endDate" ) );
        rentalPeriodColumn.setCellValueFactory( new PropertyValueFactory<Rental,String>( "rentalPeriod" ) );
        containerIdColumn.setCellValueFactory( new PropertyValueFactory<Rental,String>( "containerId" ) );
        rentColumn.setCellValueFactory( new PropertyValueFactory<Rental,String>( "rent" ) );
        totalCostColumn.setCellValueFactory( new PropertyValueFactory<Rental,String>( "totalPrice" ) );
    }

    /**
     * Fetch all stored rental records.
     */
    private void fetchRentalData()
    {
        this.rentalObservableList.addAll( this.rentalRepository.getAll() );
    }

    /**
     * Update the rental table view with data fetched from the rental model.
     */
    private void updateRentalOverviewTable()
    {
        fetchRentalData();
        this.rentalsOverviewTable.setItems( this.rentalObservableList );
    }

    /**
     * This method is used to initialize the RentalOverview view. It fetches data from the storage
     * services and injects it into the view.
     * @param location The location of the resources.
     * @param resources Resource items, like images and CSS, JS and FXML files
     */
    @FXML
    @Override
    public void initialize( URL location, ResourceBundle resources )
    {
        initiateRentalOverviewTable();
        updateRentalOverviewTable();
    }
}
