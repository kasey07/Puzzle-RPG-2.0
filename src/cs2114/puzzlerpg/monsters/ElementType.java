package cs2114.puzzlerpg.monsters;

// -------------------------------------------------------------------------
/**
 * The element of the monster
 *
 * @author Kasey Johnson (kasey7)
 * @version Apr 24, 2015
 */
public enum ElementType
{
    FIRE,
    WATER,
    EARTH;
    private ElementType weakness;
    static
    {
        FIRE.weakness = WATER;
        WATER.weakness = EARTH;
        EARTH.weakness = FIRE;

    }


    // ----------------------------------------------------------
    /**
     * Get the weakness of the monster
     *
     * @return the weakness of the monster
     */
    ElementType getWeakness()
    {
        return weakness;
    }
}
