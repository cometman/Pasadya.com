package org.wicketstuff.gae;

import org.apache.wicket.serialize.java.JavaSerializer;

import java.io.*;

/**
 * Use plain JDK Object(Input|Output)Stream
 */
public class GaeObjectSerializer extends JavaSerializer
{
	public GaeObjectSerializer(String applicationKey)
	{
		super(applicationKey);
	}

	@Override
	protected ObjectInputStream newObjectInputStream(InputStream in) throws IOException
	{
		return new ObjectInputStream(in);
	}

	@Override
	protected ObjectOutputStream newObjectOutputStream(OutputStream out) throws IOException
	{
		return new ObjectOutputStream(out);
	}
}
