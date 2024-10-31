/*
 * Prescott Lau -- based on Courtney Brown's vimeo videos & code
 * October 28th 2024
 * This class manages the LinkedListMelody and manages the files!
 */
package com.linked_list_tree_generator;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class LinkedListMelodyManager extends MelodyManager implements Drawable {

    //access to files -- I put this in my derived MelodyManager.java class
    static FileSystem sys = FileSystems.getDefault();
    static String prependPath = "mid"  + sys.getSeparator();
    static String appendType = ".mid"  + sys.getSeparator();

    String[] files = {"motive1Am", "motive1E", "motive2Am", "motive2E", "motive3Am", "motive3E", "motive4Am", "motive4E"};

    LinkedListMelodyManager()
    {
        super();
    }

    void setup()
    {
        for(int i = 0; i < files.length; i++)
        {
            addMidiFile(prependPath+files[i]+appendType);
        }
    }

    int size()
    {
        return files.length;
    }

    public void draw()
    {
        playMelodies();
    }
}
