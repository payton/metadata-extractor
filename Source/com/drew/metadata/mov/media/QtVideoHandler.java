package com.drew.metadata.mov.media;

import com.drew.lang.SequentialReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.QtAtomTypes;
import com.drew.metadata.mov.QtMediaHandler;
import com.drew.metadata.mov.atoms.AtomTimeToSample;
import com.drew.metadata.mov.atoms.AtomHeaderMediaVideoInformation;
import com.drew.metadata.mov.atoms.AtomSampleDescriptionVideo;

import java.io.IOException;

/**
 * https://developer.apple.com/library/content/documentation/QuickTime/QTFF/QTFFChap3/qtff3.html#//apple_ref/doc/uid/TP40000939-CH205-74522
 */
public class QtVideoHandler extends QtMediaHandler<QtVideoDirectory>
{
    public QtVideoHandler(Metadata metadata)
    {
        super(metadata);
    }

    @Override
    protected String getMediaInformation()
    {
        return QtAtomTypes.ATOM_VIDEO_MEDIA_INFO;
    }

    @Override
    protected QtVideoDirectory getDirectory()
    {
        return new QtVideoDirectory();
    }

    @Override
    public void processSampleDescription(@NotNull SequentialReader reader) throws IOException
    {
        AtomSampleDescriptionVideo atom = new AtomSampleDescriptionVideo(reader, baseAtom);
        atom.addMetadata(directory);
    }

    /**
     * https://developer.apple.com/library/content/documentation/QuickTime/QTFF/QTFFChap2/qtff2.html#//apple_ref/doc/uid/TP40000939-CH204-25642
     */
    @Override
    public void processMediaInformation(@NotNull SequentialReader reader) throws IOException
    {
        AtomHeaderMediaVideoInformation atom = new AtomHeaderMediaVideoInformation(reader, baseAtom);
        atom.addMetadata(directory);
    }

    /**
     * https://developer.apple.com/library/content/documentation/QuickTime/QTFF/QTFFChap2/qtff2.html#//apple_ref/doc/uid/TP40000939-CH204-BBCGFJII
     */
    @Override
    public void processTimeToSample(@NotNull SequentialReader reader) throws IOException
    {
        AtomTimeToSample atom = new AtomTimeToSample(reader, baseAtom);
        atom.addMetadata(directory);
    }
}
