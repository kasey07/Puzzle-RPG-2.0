package cs2114.puzzlerpg.playerclasses;

import sofia.util.Random;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the Rouge class methods
 *
 * @author Kasey Johnson
 * @version Apr 25, 2015
 */
public class RougeTest
    extends TestCase
{
    private Rouge theif;


    public void setUp()
    {
        theif = new Rouge("Sneaky");
    }


    /**
     * Test special ability when it should not activate
     */
    public void testSpecialAbility()
    {
        assertEquals(0, theif.specialAbility());

    }


    /**
     * Test special ability when it should activiate
     */
    public void testSpecialAbility2()
    {
        theif.setCounter(15);
        Random.setNextInts(5);
        assertEquals(5, theif.specialAbility());
    }
}
