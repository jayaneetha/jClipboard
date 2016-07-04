package me.jayaneetha;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Created by jayaneetha on 6/23/2016.
 * mail [at] jayaneetha [dot] me
 */
class ClipBoardListener implements Runnable
{

	@Override
	public void run()
	{
		while ( true )
		{
			try
			{
				Controller.updateClipBoard();

			}
			catch ( IOException | UnsupportedFlavorException ignored )
			{
			}
			finally
			{
				try
				{
					Thread.sleep( 1000 );
				}
				catch ( InterruptedException ignored )
				{
				}
			}

		}
	}
}