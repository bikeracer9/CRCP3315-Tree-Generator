/*
 * Prescott Lau
 * TreeMelodyNode: a subclass of MelodyNode
 */

 package com.linked_list_tree_generator;
 import java.util.ArrayList;

public class TreeMelodyNode extends MelodyNode{

    TreeMelodyManager t_M_Manager = new TreeMelodyManager();
    
    ArrayList<TreeMelodyNode> nodes = new ArrayList<>();
    ArrayList<Integer> midiNotes = new ArrayList<>();
    
    //ArrayList<k>
    TreeMelodyNode(MelodyManager melodies_, int m_)
    {
        super(melodies_, m_);
    }

    // Insert nodes into the tree – ie. Populate the tree with data. Each note handles adding its own child nodes.
void addNextNodes( ArrayList<TreeMelodyNode> motives )
{
    
    for (TreeMelodyNode curMelody: motives) 
    {
        if( (!midiNotes.isEmpty() ) && ( !curMelody.midiNotes.isEmpty() ) )
        {
            int lastP = midiNotes.get(midiNotes.size() - 1);
            int firstP = curMelody.midiNotes.get(0);

            if(firstP == lastP)
            {
                //t_M_Manager.popNoteFromMelody();
            }

        }
    }
    

}



}
