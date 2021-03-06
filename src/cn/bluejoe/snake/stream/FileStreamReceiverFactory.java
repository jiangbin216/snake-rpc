package cn.bluejoe.snake.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamReceiverFactory implements StreamReceiverFactory
{
	@Override
	public StreamReceiver create()
	{
		return new StreamReceiver()
		{
			File _baos = new File("temp");

			@Override
			public void destroy()
			{
				_baos.delete();
			}

			@Override
			public InputStream openInputStream(int size)
			{
				try
				{
					return new FileInputStream(_baos);
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				return null;
			}

			@Override
			public OutputStream openOutputStream(int size)
			{
				try
				{
					return new FileOutputStream(_baos);
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				return null;
			}
		};
	}

}
