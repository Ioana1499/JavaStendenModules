package com.jorisrietveld.containercompany;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * The main class that starts the graphical user interface for the container rental company Dockur. This
 * class initiates properties of the Gui like the size of the window and what fxml file to show.
 */
public class App extends Application
{
    private Stage primaryStage; // The primary window.
    private Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds(); // To get the screen dimensions.
    // private Preferences userPreferences = Preferences.userRoot().node( "/container/company" ); // Load user preferences.

    /**
     * This is the main access point of the Graphical container company application.
     *
     * @param args Commandline arguments passed to this application.
     */
    public static void main( String[] args )
    {
        App.launch( args );
    }

    /**
     * This starts the graphical user interface of the management soft ware for the container rental company: Dockur.
     *
     * @param primaryStage The outer most window.
     * @throws Exception If you fuck it up...
     */
    @Override
    public void start( Stage primaryStage ) throws Exception
    {
        Thread.setDefaultUncaughtExceptionHandler( App::showError );
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load( getClass().getResource( "presentation/dashboard/Dashboard.fxml" ) );
        primaryStage.setTitle( "Container Rental " );
        primaryStage.setScene( new Scene( root, 800, 470 ) );
        primaryStage.show();
    }

    /**
     * This function can be called to display errors. It will create an Alert Dialog if available
     * otherwise it will print the message to the console.
     * @param thread The JavaFX thread to create the dialog in.
     * @param exception The error that occurred.
     */
    private static void showError( Thread thread, Throwable exception )
    {
        if( Platform.isFxApplicationThread() )
        {
            showErrorDialog( exception );
        }
        System.err.println( "An unexpected error occurred in " + thread );
    }

    /**
     * This method will create an error dialog.
     * @param exception The error that occurred.
     */
    private static void showErrorDialog( Throwable exception )
    {
        showErrorDialog( exception, "Exception Dialog", "(ﾉಥ益ಥ）ﾉ\uFEFF ┻━┻ You broke it ლ(｀ー´ლ)", exception.getMessage() );
    }

    public static void showErrorDialog( Throwable exception, String dialogTitle, String dialogHeaderText, String dialogContentText )
    {
        Alert alert = new Alert( Alert.AlertType.ERROR, dialogContentText, ButtonType.CLOSE);
        alert.setTitle( dialogTitle );
        alert.getDialogPane().setStyle( "-fx-font-size: 15px;" );
        alert.setHeaderText( dialogHeaderText );

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea( stringWriter.toString() );
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxSize( Double.MAX_VALUE, Double.MAX_VALUE );
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
}
