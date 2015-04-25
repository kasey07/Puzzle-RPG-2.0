package cs2114.puzzlerpg.playerclasses;

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

    // ----------------------------------------------------------
    /**
     * Create a new Rouge object.
     *
     * @param name
     *            name of player
     */
    public Rouge(String name)
    {
        super(8000, 750, name, 750, 35);
    }


    /**
     * Adds 5 turns until the monster attacks
     */
    public void specialAbility()
    {
        // TODO Auto-generated method stub

    }

}
