/*
 * Prescott Lau
 * November 3rd 2024
 * TreeMelodyNode: a subclass of MelodyNode
 */

 package com.linked_list_tree_generator;
 import java.util.ArrayList;
 import java.util.Random;

public class TreeMelodyNode extends MelodyNode{

    //TreeMelodyManager t_M_Manager = new TreeMelodyManager();
    
    ArrayList<TreeMelodyNode> nodes;
    ArrayList<Integer> midiNotes;
    
    TreeMelodyNode(MelodyManager melodies_, int m_)
    {
        super(melodies_, m_);
        nodes = new ArrayList<>();
        midiNotes = new ArrayList<>();
    }

    //create another constructor that has a parameter of ArrayList<Integer> 
    //to set melPitches in TreeMelody class (& to finish step #3).
    TreeMelodyNode(ArrayList<Integer> midiNotes) 
    {
        super(null,0);
        nodes = new ArrayList<>();
        this.midiNotes = midiNotes;
    }

    // Insert nodes into the tree – ie. Populate the tree with data. Each note handles adding its own child nodes.
public void addNextNodes( ArrayList<TreeMelodyNode> motives )
{
    ArrayList<TreeMelodyNode> addNodes = new ArrayList<>();
    
    for (TreeMelodyNode curMelody: motives) 
    {
        if( ( (!midiNotes.isEmpty() ) && ( !curMelody.midiNotes.isEmpty() ) ) && (midiNotes.get(midiNotes.size() - 1).equals(curMelody.midiNotes.get(0))) )
        {
            curMelody.midiNotes.remove(0);
            addNodes.add(curMelody);
        }
    }

    motives.removeAll(addNodes);
    nodes.addAll(addNodes);

    for (TreeMelodyNode node : nodes) 
    {
        node.addNextNodes(motives);
    }

}

public ArrayList<Integer> getMidiNotes() 
{
    return new ArrayList<>(midiNotes);
}

@Override
public MelodyNode getNextMelodyNode() {
    {
        if(nodes.isEmpty()) 
        {
            return null;
        }
        return nodes.get(new Random().nextInt(nodes.size()));
    }
}

// Print the tree in tree form. Each node prints its own data then calls to its own children to print theirs.
void print(int spacesBefore)
{
    for (int i = 0; i < spacesBefore; i++) 
    {
        System.out.print(" ");
    
        System.out.println("-- " + getMidiNotes());
        
        for (TreeMelodyNode node : nodes) 
        {
            node.print(spacesBefore + 1);
        }
    }
        
}



    //overload print
    public void print()
    {
        print(0);
    }


}