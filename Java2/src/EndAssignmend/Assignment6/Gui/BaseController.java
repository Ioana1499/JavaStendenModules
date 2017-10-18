package Assignment6.Gui;

import Assignment6.ContainerCompany.Company;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 17-10-2017 09:04
 * License: GPLv3 - General Public License version 3
 */
public abstract class BaseController
{
    private Company company = new Company();

    protected void addTabs( Tab... newTabs )
    {
        mainTabPane.getTabs().addAll( newTabs );
    }

    protected void resetTabPane()
    {
        mainTabPane.getTabs().clear();
    }

    private <T> T safeLoadFXML( String filepath )
    {
        try
        {
            return FXMLLoader.load( getClass().getResource( filepath ) );
        }
        catch( IOException exception )
        {
            exception.printStackTrace();
            return null;
        }
    }

    protected void loadNewTabs( String... fileLocations )
    {
        mainTabPane.getTabs().clear();
        Arrays.stream( fileLocations ).forEach( file -> mainTabPane.getTabs().add( safeLoadFXML( file ) ) );
    }

    @FXML // Element that is used to hold all the tabs.
    private TabPane mainTabPane;

    @FXML
    protected void showRentalTabs()
    {
        loadNewTabs( "Rental/AddRental.fxml", "Rental/RentalOverview.fxml" );
    }

    @FXML
    protected void showContainerTabs()
    {
        loadNewTabs( "Container/AddContainer.fxml", "Container/ContainerOverview.fxml" );
    }

    @FXML
    protected void showStatisticsTabs()
    {
        loadNewTabs( "Statistics/Profit.fxml", "Statistics/ContainerVolume.fxml", "Statistics/RentalTime.fxml" );
    }

    protected void showExceptionDialog( Exception exception )
    {
        StringWriter stackTrace = new StringWriter();
        PrintWriter stacktraceWriter = new PrintWriter(stackTrace);
        exception.printStackTrace(stacktraceWriter);
        String exceptionText = stackTrace.toString();

        // Create the panel
        Alert alert = new Alert( Alert.AlertType.ERROR);
        alert.setTitle("An Exception was thrown o(╥﹏╥)o");
        alert.setHeaderText("Great, you broke it... (ง •̀_•́)ง");
        alert.setContentText( exception.getMessage() );
        Label label = new Label("The exception stacktrace was:");
        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane exceptionInfoPane = new GridPane();
        exceptionInfoPane.setMaxWidth(Double.MAX_VALUE);
        exceptionInfoPane.add(label, 0, 0);
        exceptionInfoPane.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(exceptionInfoPane);

        alert.showAndWait();
    }

    @FunctionalInterface
    public interface CheckedFunction<T, R> {
        R apply(T t) throws IOException;
    }
}
