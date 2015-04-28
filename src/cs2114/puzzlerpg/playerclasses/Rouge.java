package cs2114.puzzlerpg.playerclasses;

import sofia.util.Random;

// -------------------------------------------------------------------------
/**
 * Balanced class. Has the same damage and defense. Special ability delays all
 * monsters attacks by 5 turns
 *
 * @author Kasey Johnson
 * @version Apr 24, 2015
 */
public class Rouge
    extends Player
{
    private Random rand;


    // ----------------------------------------------------------
    /**
     * Create a new Rouge object.
     *
     * @param name
     *            name of player
     */
    public Rouge(String name)
    {

        super(8000, 750, name, 750, 15);
        rand = new Random();
    }


    /**
     * Adds 0 to 7 turns until the monster attacks
     *
     * @return returns number of turns to reduce monster turn
     */
    public int specialAbility()
    {
        if (getCounter() >= 15)
        {
            int randNum = rand.nextInt(7);
            setCounter(0);
            return randNum;
        }
        return 0;

    }

}
