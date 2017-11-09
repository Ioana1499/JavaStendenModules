package com.jorisrietveld.containercompany.presentation.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.util.Arrays;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 17-10-2017 12:31
 * License: GPLv3 - General Public License version 3
 */
public class DashboardController extends BaseController
{
    @FXML // Element that is used to hold all the tabs.
    private TabPane mainTabPane;

    /**
     * Add new tabs to the dashboards tab pain.
     *
     * @param newTabs the new tabs
     */
    protected void addTabs( Tab... newTabs )
    {
        mainTabPane.getTabs().addAll( newTabs );
    }

    /**
     * Reset the dashboards tab pain.
     */
    protected void resetTabPane()
    {
        mainTabPane.getTabs().clear();
    }

    private <T> T safeLoadFXML( String filepath )
    {
        try
        {
            return FXMLLoader.load( getClass().getResource( filepath) );
        }
        catch( IOException exception )
        {
            exception.printStackTrace();
            return null;
        }
    }

    /**
     * Load new tabs the dashboards tab pain..
     *
     * @param fileLocations the file locations
     */
    protected void loadNewTabs( String... fileLocations )
    {
        mainTabPane.getTabs().clear();
        Arrays.stream( fileLocations ).forEach( file -> mainTabPane.getTabs().add( safeLoadFXML( file ) ) );
    }

    /**
     * Show rental tabs on the dashboards.
     */
    @FXML
    protected void showRentalTabs()
    {
        loadNewTabs( "rental/AddRental.fxml", "rental/RentalOverview.fxml" );
    }

    /**
     * Show container tabs on the dashboards.
     */
    @FXML
    protected void showContainerTabs()
    {
        loadNewTabs( "container/AddContainer.fxml", "container/ContainerOverview.fxml" );
    }

    /**
     * Show statistics tabs on the dashboards.
     */
    @FXML
    protected void showStatisticsTabs()
    {
        loadNewTabs( "Statistics/Profit.fxml", "Statistics/ContainerVolume.fxml", "Statistics/RentalTime.fxml" );
    }

    /**
     * This functional interface is used to wrap lambda expressions that throw IOExceptions.
     *
     * @param <T> the type parameter
     * @param <R> the type parameter
     */
    @FunctionalInterface
    public interface CheckedFunction<T, R> {
        /**
         * Wrap the checked exception lambda.
         *
         * @param t the t
         * @return the r
         * @throws IOException the io exception
         */
        R apply(T t) throws IOException;
    }
}
