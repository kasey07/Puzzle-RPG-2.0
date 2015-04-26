package cs2114.puzzlerpg.playerclasses;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the methods of the Player Class shared by all player classes
 *
 * @author Kasey Johnson
 * @version Apr 25, 2015
 */
public class PlayerTest
    extends TestCase
{
    private Player character;


    public void setUp()
    {
        character = new Player(10000, 1000, "Mary", 500, 20);
    }


    /**
     * Test reduce health method of player
     */
    public void testReduceHealth()
    {
        character.reduceHealth(100);
        assertEquals(9000, character.getHealth());
    }


    /**
     * Test reduce health method of player when damage greather than health
     */
    public void testReduceHealth2()
    {
        character.reduceHealth(100000);
        assertEquals(0, character.getHealth());
    }


    /**
     * Test that Max Health does not change after damage
     */
    public void testMaxHealth()
    {
        character.reduceHealth(100);
        assertEquals(10000, character.getMaxHealth());
    }


    /**
     * Test the add Health Method when heal will cause health to be greater than
     * max health
     */
    public void testAddHealth()
    {
        character.addHealth(100);
        assertEquals(10000, character.getHealth());
    }


    /**
     * Test the add Health Method
     */
    public void testAddHealth2()
    {
        character.reduceHealth(200);
        character.addHealth(100);
        assertEquals(9000, character.getHealth());
    }


    /**
     * test the constructor of player
     */
    public void testConstructor()
    {
        assertEquals(500, character.getAttack());
        assertEquals(1000, character.getDefense());
        assertEquals("Mary", character.getName());
        assertEquals(20, character.getTurns());
        assertEquals(0, character.getCounter());
    }


    /**
     * Test the set counter method of player
     */
    public void testSetCounter()
    {
        character.setCounter(30);
        assertEquals(30, character.getCounter());
    }


    /**
     * Test the special turns left method
     */
    public void testSpecialTurnsLeft()
    {
        character.setCounter(1);
        assertEquals(19, character.getCounter());
    }

}
