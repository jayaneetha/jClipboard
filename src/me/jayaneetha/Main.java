package me.jayaneetha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by jayaneetha on 6/23/2016.
 * mail [at] jayaneetha [dot] me
 */
public class Main extends Application
{

	public static void main( String[] args )
	{
		launch( args );
	}

	@Override
	public void start( Stage primaryStage ) throws Exception
	{
		Parent root = FXMLLoader.load( getClass().getResource( "main.fxml" ) );
		primaryStage.setTitle( "Clipboard" );
		primaryStage.setScene( new Scene( root ) );
		primaryStage.setResizable( false );
		primaryStage.show();
	}
}
