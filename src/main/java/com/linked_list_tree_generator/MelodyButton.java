/*
 * Prescott Lau --based off of Courtney Brown's vimeo videos.
 * October 23rd 2024
 * 
 * Description: This class contains all the buttons for the MelodyLinkedList!
 * 
 * Classes included in this Class:
 * MelodyButton   -- the super class for all the buttons that use the MelodyLinkedList
 * PlayButton     -- plays the MelodyLinkedList
 * StopButton     -- stops playing the MelodyLinkedList.
 * LoopTrueButton -- turns ON the loop() function to loop the MelodyLinkedList.
 * LoopFalseButton-- turns OFF the loop() function to STOP looping the MelodyLinkedList.
 * TestWeaveButton: calls the WeaveUnitTest Class and tests the two weave methods.
 * addMelody1Button: adds "Melody 1" to the Melody Class to be able to play.
 * weave_3_4_Button: Weaves melody 4 every 3 nodes.
 * weave_2_1_Button: Weaves melody 1 every 2 nodes.
 * weave_5_3_Button: Weaves melody 5 every 3 nodes.
 * clearListButton: Clears the list!
 * reverseListButton: Reverses the list
 */
package com.linked_list_tree_generator;

import processing.core.PApplet;

/*
 * --------
 * MelodyButton: the super class for all the buttons that use the MelodyLinkedList
 * --------
 */
public abstract class MelodyButton extends Button{

    LinkedListMelody melody; //Linked List Melody to control

    //----- TEST WEAVE OBJECT DECLARATION
    WeaveUnitTest weaveUnitTest = new WeaveUnitTest();

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    MelodyButton(PApplet main_, LinkedListMelody melody_, String label_,float x_, float y_)
    {
        super(main_, label_, x_, y_); 
        melody = melody_;
    }

}


/*
 * --------
 * PlayButton: plays the MelodyLinkedList
 * --------
 */
class PlayButton extends MelodyButton{

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    PlayButton(PApplet main_, LinkedListMelody melody_, float x_, float y_)
    {
        super(main_, melody_, "Play", x_, y_); 
    }

    //Start playing the Melody
    public void onPress()
    {
        melody.start();
    }
}



/*
 * --------
 * StopButton: stops playing the MelodyLinkedList.
 * --------
 */
class StopButton extends MelodyButton{

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    StopButton(PApplet main_, LinkedListMelody melody_, float x_, float y_)
    {
        super(main_, melody_, "Stop", x_, y_); 
    }

    //Start playing the Melody
    public void onPress()
    {
        melody.stop();
        if(melody.drawLoop)
        {
            melody.drawLoop = false;
        }
    }
}




/*
 * --------
 * LoopTrueButton: turns ON the loop() function to loop the MelodyLinkedList.
 * --------
 */
class LoopTrueButton extends MelodyButton{

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    LoopTrueButton(PApplet main_, LinkedListMelody melody_, float x_, float y_)
    {
        super(main_, melody_, "Turn ON Loop", x_, y_); 
    }

    //Start playing the Melody
    public void onPress()
    {
        melody.loop(true);
    }
}



/*
 * --------
 * LoopFalseButton: turns OFF the loop() function to STOP looping the MelodyLinkedList.
 * --------
 */
class LoopFalseButton extends MelodyButton{

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    LoopFalseButton(PApplet main_, LinkedListMelody melody_, float x_, float y_)
    {
        super(main_, melody_, "Turn OFF Loop", x_, y_); 
    }

    //Start playing the Melody
    public void onPress()
    {
        melody.stop();
        if(melody.drawLoop)
        {
            melody.drawLoop = false;
        }
    }
}



/*
 * --------
 * TestWeaveButton: calls the WeaveUnitTest Class and tests the weave method.
 * --------
 */
class TestWeaveButton extends MelodyButton{

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    TestWeaveButton(PApplet main_, LinkedListMelody melody_, float x_, float y_)
    {
        super(main_, melody_, "WeaveUnitTest", x_, y_); 
    }

    //Test the WeaveUnitTests
    public void onPress()
    {
        weaveUnitTest.testWeave1();
        weaveUnitTest.testWeave2();
    }
}


/*
 * --------
 * addMelody1Button: adds "Melody 1" to the Melody Class to be able to play.
 * --------
 */
class addMelody1Button extends MelodyButton{

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    addMelody1Button(PApplet main_, LinkedListMelody melody_, float x_, float y_)
    {
        super(main_, melody_, "Add Melody 1:", x_, y_); 
    }

    //Test the WeaveUnitTests
    public void onPress()
    {
        melody.addMelody1();
        melody.play();
    }
}



/*
 * --------
 * weave_3_4_Button: Weaves melody 4 every 3 nodes.
 * --------
 */
class weave_3_4_Button extends MelodyButton{

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    weave_3_4_Button(PApplet main_, LinkedListMelody melody_, float x_, float y_)
    {
        super(main_, melody_, "Weave(3,4)", x_, y_); 
    }

    //Test the WeaveUnitTests
    public void onPress()
    {
        MelodyNode node = new MelodyNode(null, 0);
        melody.weave(node, 3,4);
    }
}


/*
 * --------
 * weave_2_1_Button: Weaves melody 1 every 2 nodes.
 * --------
 */
class weave_2_1_Button extends MelodyButton{

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    weave_2_1_Button(PApplet main_, LinkedListMelody melody_, float x_, float y_)
    {
        super(main_, melody_, "Weave(2,1)", x_, y_); 
    }

    //Test the WeaveUnitTests
    public void onPress()
    {
        MelodyNode node = new MelodyNode(null, 0);
        melody.weave(node, 2,1);
    }
}


/*
 * --------
 * weave_5_3_Button: Weaves melody 5 every 3 nodes.
 * --------
 */
class weave_5_3_Button extends MelodyButton{

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    weave_5_3_Button(PApplet main_, LinkedListMelody melody_, float x_, float y_)
    {
        super(main_, melody_, "Weave(5,3)", x_, y_); 
    }

    //Test the WeaveUnitTests
    public void onPress()
    {
        MelodyNode node = new MelodyNode(null, 0);
        melody.weave(node, 5,3);
    }
}



/*
 * --------
 * clearListButton: Clears the list!
 * --------
 */
class clearListButton extends MelodyButton{

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    clearListButton(PApplet main_, LinkedListMelody melody_, float x_, float y_)
    {
        super(main_, melody_, "Clear List:", x_, y_); 
    }

    //Test the WeaveUnitTests
    public void onPress()
    {
        melody.clear();
        melody.print();
    }
}

/*
 * --------
 * reverseListButton: Reverses the list
 * --------
 */
class reverseListButton extends MelodyButton{

    //overload the constructor for the MelodyButon -- use the default size for height & width & color.
    reverseListButton(PApplet main_, LinkedListMelody melody_, float x_, float y_)
    {
        super(main_, melody_, "Reverse List:", x_, y_); 
    }

    //Test the WeaveUnitTests
    public void onPress()
    {
        melody.reverse();
        melody.print();
    }
}