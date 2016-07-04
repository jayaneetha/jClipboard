package me.jayaneetha;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jayaneetha on 6/23/2016.
 * mail [at] jayaneetha [dot] me
 */

public class Controller implements Initializable
{

	private static ObservableList<String> clips;
	public ListView<String> listView;
	public Button cleanButton;
	public Button deleteItem;

	static void updateClipBoard() throws IOException, UnsupportedFlavorException
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		String result = ( String ) clipboard.getData( DataFlavor.stringFlavor );
		if ( !clips.contains( result ) )
		{
			clips.add( result );
		}
	}

	@Override
	public void initialize( URL location, ResourceBundle resources )
	{
		clips = listView.getItems();

		Thread t = new Thread( new ClipBoardListener() );
		t.start();

		listView.getSelectionModel().selectedItemProperty().addListener( new ChangeListener()
		{
			@Override
			public void changed( ObservableValue observable, Object oldValue, Object newValue )
			{
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Clipboard clipboard = toolkit.getSystemClipboard();
				StringSelection strSel = new StringSelection( ( String ) newValue );
				clipboard.setContents( strSel, null );
			}
		} );
	}

	public void clean( ActionEvent actionEvent )
	{
		clips.clear();
	}

	public void deleteItem( ActionEvent actionEvent )
	{
		clips.remove( listView.getSelectionModel().getSelectedIndex() );
	}

	public void exit( ActionEvent actionEvent )
	{
		System.exit( 0 );
	}
}