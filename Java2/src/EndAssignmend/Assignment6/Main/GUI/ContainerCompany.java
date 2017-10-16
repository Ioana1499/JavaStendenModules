package Assignment6.Main.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * The main class that starts the graphical user interface for the Container rental company Dockur. This
 * class initiates properties of the GUI like the size of the window and what fxml file to show.
 */
public class ContainerCompany extends Application
{
    private Stage primaryStage; // The primary window.
    private Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds(); // To get the screen dimensions.
   // private Preferences userPreferences = Preferences.userRoot().node( "/container/company" ); // Load user preferences.

    /**
     * This starts the graphical user interface of the management soft ware for the container rental company: Dockur.
     *
     * @param primaryStage The outer most window.
     * @throws Exception If you fuck it up...
     */
    @Override
    public void start( Stage primaryStage ) throws Exception
    {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load( getClass().getResource( "View/ContainerCompany.fxml" ) );

        primaryStage.setTitle( "Container Rental " );
        primaryStage.setScene( new Scene( root, visualBounds.getWidth(),visualBounds.getHeight() - 40));
        primaryStage.setResizable( true );
        primaryStage.show();
    }

    public static void main( String[] args )
    {
        ContainerCompany.launch( args );
    }
}
