package com.drew.imaging.zip;

import com.drew.imaging.FileType;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Interface to apply a filter that determines the FileType/use-case of the given ZipInputStream
 *
 * @author Payton Garland
 */
public interface ZipFilter
{
    // List of boolean flags that specify whether this filter's conditions were met

    public FileType getFileType();

    public void filterEntry(ZipEntry entry, ZipInputStream inputStream);
}
