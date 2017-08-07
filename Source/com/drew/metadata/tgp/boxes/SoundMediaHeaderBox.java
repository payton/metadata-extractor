package com.drew.metadata.tgp.boxes;

import com.drew.lang.SequentialReader;
import com.drew.metadata.tgp.media.TgpSoundDirectory;

import java.io.IOException;

/**
 * ISO/IED 14496-12:2015 pg.159
 */
public class SoundMediaHeaderBox extends FullBox
{
    int balance;

    public SoundMediaHeaderBox(SequentialReader reader, Box box) throws IOException
    {
        super(reader, box);

        balance = reader.getInt16();
        reader.skip(2); // Reserved
    }

    public void addMetadata(TgpSoundDirectory directory)
    {
        double integer = balance & 0xFFFF0000;
        double fraction = (balance & 0x0000FFFF) / Math.pow(2, 4);
        directory.setDouble(TgpSoundDirectory.TAG_SOUND_BALANCE, integer + fraction);
    }

}
