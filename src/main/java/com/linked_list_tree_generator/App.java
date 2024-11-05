/*
* c2017-2024 Courtney Brown 
* Class: Main Class for Hello World for CC3 Class Projects streaming MIDI, etc.
* Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer, 2024 - add processing/interactivity
* 
* Test Weave Functions are called in this class in the settings() method.
* 
* Prescott Lau - based on Courtney Brown's code & vimeo videos
* October 28th 2024
* 
*/

package com.linked_list_tree_generator;


//importing the JMusic stuff
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.ArrayList;

import processing.core.PApplet;


//make sure this class name matches your file name, if not fix.
public class App extends PApplet {

    //access to files -- I put this in my derived MelodyManager.java class
    static FileSystem sys = FileSystems.getDefault();
    static String prependPath = "mid"  + sys.getSeparator();
    static String appendType = ".mid"  + sys.getSeparator();
    
    //all the objects that implement an onpress
    ArrayList<OnMousePress> presses = new ArrayList<>(); 

    //all the objects that implement a draw
    ArrayList<Drawable> draws = new ArrayList<>(); 

    LinkedListMelody melody = new LinkedListMelody();
    TreeMelodyManager manager = new TreeMelodyManager();
    TreeMelody treeMelody = new TreeMelody(manager);

    public static void main(String[] args) {
        PApplet.main("com.linked_list_music_template.App");       
    }

    //setup stuff that should be done before Processing code is called
    public void settings()
    {
        size(500, 500);
        manager.setup();
        addNodes();
        setupButtons();
        treeMelody.train(0,4);
        treeMelody.print();
        addMelodyDraw();
        
        
    }

    //adds the drawable melody objects to the draws array to call their draw() ie update()
    public void addMelodyDraw()
    {
        draws.add( treeMelody );
        draws.add( manager );
    }

    /*
     *  adding all the files
     */
    void addNodes()
    {   
        for(int i = 0; i < manager.fileSize(); i++)
        {
            melody.insertAtEnd( new MelodyNode(manager, i) );
        }
    }

    //create & add your buttons to presses & draws 
    public void setupButtons()
    {
        //helpful variables for formatting -- use or not. if you don't use, delete.
        float X_bR = width-100; 
        float Y_bR = 350; 
        float spacer = 35;

        float X_tL = 95; 
        float Y_tL = 35; 
        float spacer2 = 60;

        //Buttons on the bottom right below:
        PlayButton playB = new PlayButton(this, melody, X_bR, Y_bR);
        draws.add(playB);
        presses.add(playB);

        StopButton stopB = new StopButton(this, melody, X_bR, (playB.y + spacer) );
        draws.add(stopB);
        presses.add(stopB);

        LoopTrueButton loopTrueB = new LoopTrueButton(this, melody, X_bR, (stopB.y + spacer) );
        draws.add(loopTrueB);
        presses.add(loopTrueB);

        LoopFalseButton loopFalseB = new LoopFalseButton(this, melody, X_bR, (loopTrueB.y + spacer) );
        draws.add(loopFalseB);
        presses.add(loopFalseB);
        //--------

        //Buttons on the top left below:

        //test weave function:
        TestWeaveButton testWeaveB = new TestWeaveButton(this, melody, X_tL, Y_tL);
        draws.add(testWeaveB);
        presses.add(testWeaveB);

        addMelody1Button addMelody1B = new addMelody1Button(this, melody, X_tL, (testWeaveB.y + spacer2));
        draws.add(addMelody1B);
        presses.add(addMelody1B);

        weave_3_4_Button weave_3_4_B = new weave_3_4_Button(this, melody, X_tL, (addMelody1B.y + spacer));
        draws.add(weave_3_4_B);
        presses.add(weave_3_4_B);

        weave_2_1_Button weave_2_1_B = new weave_2_1_Button(this, melody, X_tL, (weave_3_4_B.y + spacer));
        draws.add(weave_2_1_B);
        presses.add(weave_2_1_B);

        weave_5_3_Button weave_5_3_B = new weave_5_3_Button(this, melody, X_tL, (weave_2_1_B.y + spacer));
        draws.add(weave_5_3_B);
        presses.add(weave_5_3_B);

        clearListButton clearListB = new clearListButton(this, melody, X_tL, (weave_5_3_B.y + spacer));
        draws.add(clearListB);
        presses.add(clearListB);

        reverseListButton reverseListB = new reverseListButton(this, melody, X_tL, (clearListB.y + spacer));
        draws.add(reverseListB);
        presses.add(reverseListB);
        
        
        //--------
    }

    //doing all the setup stuff for Processing
    public void setup() {
        background(0); //defaults by drawing a black blackground but you do you.
    }

    //play the melody in real-time & draw all the buttons
    public void draw()
    {
        for(Drawable drawer : draws)
        {
            drawer.draw();
        }
    }

    //handle all the mousePressed functions for all our objects.
    public void mousePressed()
    {
        for(OnMousePress press : presses )
        {
            press.mousePressed(mouseX, mouseY);
        }
    }

}
 