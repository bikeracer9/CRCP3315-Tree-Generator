/*
 * Prescott Lau
 * November 3rd 2024
 * TreeMelody class - holds all the MelodyNodes to be able to play a melody.
 */
package com.linked_list_tree_generator;

import java.util.ArrayList;


public class TreeMelody extends LinkedListMelody {

    TreeMelodyManager manager;
    TreeMelodyNode root;

    public TreeMelody(TreeMelodyManager manager)
    {
        super();
        this.manager = manager;
        this.root = (TreeMelodyNode)head;
    }

    public void print()
    {
        if(root != null)
        {
            root.print();
        }
        else
        {
            System.out.println("Nothing to print, the Tree is empty!");
        }
    }

    public void clear()
    {
        root = null;
        head = null;
    }

    void train(int index, int motiveNoteCount)
    {
        //1
        ArrayList<TreeMelodyNode> motives = manager.convertToMotivesAndReplace(motiveNoteCount);

        //2
        if(index == -1)
        {
            index = (int)(Math.random() * manager.melodySize());
        }

        //3
        for(int i = 0; i < manager.melodySize(); i++)
        {
            ArrayList<Integer> melPitches = manager.getMelodyPitches(i);
            TreeMelodyNode nodes = new TreeMelodyNode(melPitches);
            motives.add(nodes);

        }

        //4
        if(root == null)
        {
            root = motives.get(index);
        }

        //5
        motives.remove(root); //root ? / index

        //6
        if(root != null)
        {
            root.addNextNodes(motives);
        }
    }

    void train()
    {
        train(0, 4); //Train with noteMotiveCount = 4 and root with index =0

    }

    public void start()
    {
        System.out.println("Start!"); //???
        if(root != null)
        {
            curPlayingNode = root;
            root.start();
        }
    }

    public void weave()
    {
        System.out.println("Warning: the weave() function is depreciated and is NOT used in this context!");
    }

    public void loop()
    {
        System.out.println("Looping the Melody!");
    }

    public void stop()
    {
        System.out.println("Stopping the Melody!");
        root = null;
        head = null;
    }

    public void play()
    {
        System.out.println("Playing the Melody!");
    }
}
