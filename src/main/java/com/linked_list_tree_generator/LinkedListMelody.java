/*
 * c2024  Prescott Lau using a template by Dr. Courtney Brown
 * Class: LinkedListMelody
 * Description: The "container" that holds all the MelodyNodes to play them.
 * 
 */


package com.linked_list_tree_generator;

public class LinkedListMelody implements Drawable {
    MelodyNode head;//start of the list
    MelodyNode curPlayingNode; //the currently playing node of the melody

    LinkedListMelodyManager manager = new LinkedListMelodyManager(); //object reference to a MelodyManager class

    //drawLoop boolean.
    boolean drawLoop = false;

    public LinkedListMelody() //constructor.
    {
        head = null;
        curPlayingNode = null;
    }


    //fill in this class *****************************
    public void draw()
    {
        play();
        if(drawLoop)
        {
            play();
            if(curPlayingNode == null)
            {
                curPlayingNode = head;
            }
        }
        
    
    }//end of draw()

    MelodyNode curMelodyNode = null; //init to nothing bc nothings playing at the start.

    //this method will play the first note - start the music.
    public void start()
    {
        if(head != null)
        {
            curPlayingNode = head;
            head.start();
        }
    }//end of start()

    /*
     * Prints all the foods in a list.
     * If there is nothing in the list, it prints "GroceryList is empty."
     */
    public void print()
    {
        if (isEmpty()) //if isEmpty = true:
        
            System.out.println("MelodyList is empty"); 
        
        MelodyNode current = head ; //Start at head
        
        System.out.println("Melody: ");
        while (current != null)
            { //While not the end of the list
                
                System.out.print(" " + current.getWhichMelody()); //print data
                
                current = current.getNextMelodyNode(); //go to next node
            }
            System.out.println(" "); 
        
    } //end of print()


    /*
     * Boolean to return "true" if the list is empty.
     */
    boolean isEmpty() 
    {
        return head == null;
    }//end of isEmpty()


    /*
    * inserts a MelodyNode at the indicated index provided.
    */
    void insert(int index, MelodyNode node)
    {
        if(index == 0) //if the given index is zero, insert the node at the beginning.
        {
            insertAtStart(node);
        }
        else //otherwise: loop through the nodes to find where to place the next node.
        {
            MelodyNode current = head;
            int count = 0;
            while( (current != null) && (count < index - 1))
            {
                current = current.getNextMelodyNode();
                count++;
            }
            if (current != null) 
            {
                node.setNextMelodyNode( current.getNextMelodyNode() );
                current.setNextMelodyNode(node);
            }
        }
    }//end of insert(index, node)


    /*
     * Inserts a MelodyNode at the start of the list (prepend).
     */
    void insertAtStart(MelodyNode node) 
    {
        node.setNextMelodyNode(head); 
        head = node;
    }//end of insertAtStart()


    /*
     * Inserts a MelodyNode at the end of the list (append). 
     */
    void insertAtEnd(MelodyNode node) 
    {
        if(head == null) 
        {
            head = node;
        }
        else
        {
            MelodyNode current = head;
            while(current.getNextMelodyNode() != null)
            {
                current = current.getNextMelodyNode();
            }
            current.setNextMelodyNode(node);
        }
    }//end of insertAtEnd()


    /*
     * This is the play method, it goes through all the Nodes and plays them!
     */
    public void play()
    {
        if( curPlayingNode != null )
        {
            if( curPlayingNode.atEnd() )
            {
                curPlayingNode = curPlayingNode.getNextMelodyNode();
                if(curPlayingNode != null)
                {
                    curPlayingNode.start();
                }
            }
        }
    }//end of play()


    /*
     * This is the stop method, it stops playing the melodies.
     */
    public void stop()
    {
        curPlayingNode = null;
        System.out.println("Stopped playing Melodies.");
    }//end of stop()

    
    /*
     * Loops the melody & also stops the loop.
     */
    public void loop(boolean loop_)
    {
        System.out.println("Looping : " + loop_);

        if(loop_)
        {
            drawLoop = true;
        }
        if(!loop_)
        {
            drawLoop = false;
        }

    }//end of loop()

    
    /*
     * Weave the input melodyNode count times every skip nodes.
     */
    public void weave(MelodyNode node, int count, int skip)
    {        

        MelodyNode current = head;
        int currentIndex = 0;
        int weave = 0;
        while(current != null && weave < count)
        {
            if(currentIndex == count-1)
            {
                MelodyNode copyNode = node.copy();
                copyNode.setNextMelodyNode(current.getNextMelodyNode());
                current.setNextMelodyNode(copyNode);

                current = copyNode.getNextMelodyNode();
                weave++;
                currentIndex = 0;
            }
            else
            {
                current = current.getNextMelodyNode();
                currentIndex++;
            }
            
        }
    }//end of weave()


    /*
     * ------------------------------------------------
     * TWO OTHER METHODS BELOW:
     * ------------------------------------------------
     */


     /*
      * Clear method: this clears the List by setting both nodes to be null.
      */
      public void clear()
      {
        head = null;
        curPlayingNode = null;
      }

      /*
       * Reverse method: Reverses the List!
       */
      public void reverse()
      {
        System.out.println("Reversing the Melody: ");
        MelodyNode previous = null;//set the previous node to be null.
        MelodyNode current = head; //set the current node to be the head node.
        MelodyNode next = null;    //set the next node to be null.

        while(current != null) //while loop to go through the list.
        {
            next = current.getNextMelodyNode(); //store the next node
            current.setNextMelodyNode(previous); //set current node to previous node (reverse)
            previous = current; //previous node moves forwards to next one
            current = next; //move to the next node
        }
        head = previous; //head node changes to previous node
      }


      /*
       * I added some more functions to add melodies to the list below.
       */
      void addMelody1()
      {
        
        MelodyNode m1_1 = new MelodyNode(manager, 1); 
        
        insertAtEnd( m1_1 ); 
       
        
        System.out.println("Added Melody 1: ");
        print();
      }

}
