/*
 * Prescott Lau
 * October 22nd 2024
 * 
 * The MelodyNode class. These are individual objects that will play a note.
 */
package com.linked_list_tree_generator;

public class MelodyNode {
    
    MelodyManager melodies; //object reference to a MelodyManager class
    MelodyNode nextMelodyNode; //next node in the list
    int whichMelody; //which melody to play (indexes the MelodyManager class)
    
    public MelodyNode(MelodyManager melodies_, int m_) //constructor
    {
        melodies = melodies_;
        whichMelody = m_;
        nextMelodyNode = null;
    }


    /*
     * Getters & Setters for nextMelodyNode
     */

     public MelodyNode getNextMelodyNode()
     {
        return nextMelodyNode;
     }

     public void setNextMelodyNode(MelodyNode node)
     {
        this.nextMelodyNode = node;
     }


     /*
     * Getters & Setters for whichMelody
     */
    public int getWhichMelody()
    {
      return whichMelody;
    }

    public void setWhichMelody(int newWhichMelody)
    {
      whichMelody = newWhichMelody;
    }
     

     /*
      * This method starts the melody to start playing.
      */
     public void start()
     {
      if(melodies != null)
      {
         melodies.start(whichMelody);
      }
     }

     /*
      * This method brings in a new MelodyNode and creates a copy of it.
      */
     public MelodyNode copy()
     {
        return new MelodyNode(this.melodies, this.whichMelody);
     }

     //Checks to see if you're at the end of the melody, based off of MelodyManager
     boolean atEnd()
     {
      return melodies.atEnd(whichMelody);
     }


}
