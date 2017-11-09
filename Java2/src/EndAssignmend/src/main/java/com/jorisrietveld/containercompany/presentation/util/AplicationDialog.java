package com.jorisrietveld.containercompany.presentation.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 09-11-2017 11:33
 * License: GPLv3 - General Public License version 3
 */
public class AplicationDialog
{
    public static void createInfoDialog( String title, String contentText )
    {
        createSimpleDialog( Alert.AlertType.INFORMATION, title, contentText );
    }

    public static void createInfoDialog( String title, String headerText, String contentText )
    {
        createSimpleDialog( Alert.AlertType.INFORMATION, title, headerText, contentText );
    }

    public static void createWarningDialog( String title, String contentText )
    {
        createSimpleDialog( Alert.AlertType.WARNING, title, contentText );
    }

    public static void createWarningDialog( String title, String headerText, String contentText )
    {
        createSimpleDialog( Alert.AlertType.WARNING, title, headerText, contentText );
    }

    public static void createErrorDialog( String title, String contentText )
    {
        createSimpleDialog( Alert.AlertType.ERROR, title, contentText  );
    }

    public static void createErrorDialog( String title, String headerText, String contentText )
    {
        createSimpleDialog( Alert.AlertType.ERROR, title, headerText, contentText );
    }

    public static void createSimpleDialog( Alert.AlertType type, String title, String contentText )
    {
        createSimpleDialog( type, title, null, contentText );
    }

    public static void createSimpleDialog( Alert.AlertType type, String title, String headerText, String contentText )
    {
        Alert alert = new Alert( type );
        alert.setTitle( title );
        alert.setHeaderText( headerText );
        alert.setContentText( contentText );
        alert.showAndWait();
    }

    public static void createExceptionDialog( Throwable exception, String title, String contentText )
    {
        createExceptionDialog( exception, title, contentText, exception.getMessage() );
    }

    public static void createExceptionDialog( Throwable exception )
    {
        createExceptionDialog( exception, "Exception Dialog", "(ﾉಥ益ಥ）ﾉ\uFEFF ┻━┻ You broke it ლ(｀ー´ლ)", exception.getMessage() );
    }

    public static void createExceptionDialog( Throwable exception, String dialogTitle, String dialogHeaderText, String dialogContentText )
    {
        Alert alert = new Alert( Alert.AlertType.ERROR, dialogContentText, ButtonType.CLOSE);
        alert.setTitle( dialogTitle );
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
