package com.drew.metadata.tgp.boxes;

import com.drew.lang.SequentialReader;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author Payton Garland
 */
public class HandlerBox extends FullBox
{
    String handlerType;

    public String getHandlerType()
    {
        return handlerType;
    }

    String name;

    public HandlerBox(SequentialReader reader, Box box) throws IOException
    {
        super(reader, box);

        reader.skip(4); // Pre-defined
        handlerType = reader.getString(4);
        reader.skip(12); // Reserved
        name = reader.getNullTerminatedString((int)size - 32, Charset.defaultCharset());
    }
}
