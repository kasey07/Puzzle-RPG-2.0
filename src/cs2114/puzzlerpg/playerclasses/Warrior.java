package cs2114.puzzlerpg.playerclasses;

// -------------------------------------------------------------------------
/**
 * Class with high defense but weaker attack. Has special ability to
 *
 * @author Kasey Johnson
 * @version Apr 24, 2015
 */
public class Warrior
    extends Player
{
    private boolean specialAbility = false;


    // ----------------------------------------------------------
    /**
     * Create a new Warrior object.
     *
     * @param name
     *            Name of the character
     */
    public Warrior(String name)
    {
        super(10000, 1000, name, 500, 20);

    }


    /**
     * Special ability of warrior. Immune to attacks for 2 turns takes 20 turns
     * to charge
     */
    public void specialAbility()
    {
        if (getCounter() >= 20)
        {
            this.specialAbility = true;
            setCounter(2);
        }

    }


    // ----------------------------------------------------------
    /**
     * Override damage to take into account special ability
     *
     * @param damage
     *            damage received
     */
    public void reduceHealth(int damage)
    {
        int damageTaken = damage;
        if (specialAbility)
        {
            damageTaken = 0;
            setCounter(getCounter() - 1);
            if (getCounter() == 0)
            {
                specialAbility = false;
            }
        }
        super.reduceHealth(damageTaken);
    }

}
