package cs2114.puzzlerpg.playerclasses;

import student.TestCase;

public class WarriorTest
    extends TestCase
{
    private Warrior character;


    public void setUp()
    {
        character = new Warrior("Max");
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
        character.reduceHealth(10000);
        assertEquals(0, character.getHealth());
    }


    /**
     * Test reduce health method of warrior when special ability is true
     */
    public void testReduceHealth3()
    {
        character.specialAbility();
        character.reduceHealth(10000);
        assertEquals(10000, character.getHealth());
    }


    /**
     * Test reduce health method of warrior when special ability is true and
     * counter is 1
     */
    public void testReduceHealth4()
    {

        character.specialAbility();
        character.setCounter(1);
        character.reduceHealth(10000);
        assertEquals(10000, character.getHealth());
        assertEquals(0, character.getCounter());
    }

}
