package cs2114.puzzlerpg.playerclasses;

// -------------------------------------------------------------------------
/**
 * Mage player class. Has high damage, but lower health than the other classes
 *
 * @author Kasey Johnson
 * @version Apr 24, 2015
 */
public class Mage
    extends Player
{

    private boolean specialAbility = false;


    // ----------------------------------------------------------
    /**
     * Create a new Mage object.
     *
     * @param name
     *            Name of player
     */
    public Mage(String name)
    {
        super(7500, 500, name, 750, 20);
    }


    /**
     * Does double the damage for an attack
     */
    public void specialAbility()
    {
        if (getCounter() >= 20)
        {
            specialAbility = true;
            setCounter(0);
        }

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @return the attack of the player
     */
    public int getAttack()
    {
        int attack = getAttack();
        if (specialAbility)
        {
            attack *= 2;
            specialAbility = false;

        }
        return attack;
    }

}
