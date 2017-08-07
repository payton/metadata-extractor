package com.drew.metadata.tgp.boxes;

import com.drew.lang.SequentialReader;

import java.io.IOException;

/**
 * @author Payton Garland
 */
public class Box
{
    public long size;
    public String type;
    String usertype;

    public Box(SequentialReader reader) throws IOException
    {
        this.size = reader.getUInt32();
        this.type = reader.getString(4);
        if (size == 1) {
            size = reader.getInt64();
        } else if (size == 0) {
            size = -1;
        }
        if (type.equals("uuid")) {
            usertype = reader.getString(16);
        }
    }

    public Box(Box box)
    {
        this.size = box.size;
        this.type = box.type;
        this.usertype = box.usertype;
    }
}
