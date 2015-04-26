package cs2114.puzzlerpg.playerclasses;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the mage class methods.
 *
 * @author Kasey Johnson
 * @version Apr 26, 2015
 */
public class MageTest
    extends TestCase
{
    private Mage magey;


    // ----------------------------------------------------------
    /**
     * Create a new MageTest object.
     */
    public MageTest()
    {
        // Nothing needed...
    }


    public void setUp()
    {
        magey = new Mage("Sparky");

    }


    /**
     * Test special ability when should not activate
     */
    public void testSpecialAbility()
    {
        magey.setCounter(19);
        magey.specialAbility();
        assertEquals(19, magey.getCounter());

    }


    /**
     * Test special ability when should activate
     */
    public void testSpecialAbility2()
    {
        magey.setCounter(20);
        magey.specialAbility();
        assertEquals(0, magey.getCounter());

    }


    /**
     * Test get attack method when special is activated
     */
    public void testGetAttack()
    {
        magey.setCounter(20);
        magey.specialAbility();
        assertEquals(1500, magey.getAttack());
    }


    /**
     * Test get attack method when special not activated
     */
    public void testGetAttack2()
    {

        magey.specialAbility();
        assertEquals(750, magey.getAttack());
    }
}
