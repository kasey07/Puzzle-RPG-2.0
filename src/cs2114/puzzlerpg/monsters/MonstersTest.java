package cs2114.puzzlerpg.monsters;

import cs2114.puzzlerpg.puzzle.GemCellType;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the methods of monster class
 *
 * @author Kasey Johnson
 * @version Apr 27, 2015
 */
public class MonstersTest
    extends TestCase
{

    private Monsters mon;

    /**
     * Set up the variables for testing Monsters class
     */
    public void setUp()
    {
        mon =
            new Monsters(
                40000,
                GemCellType.FIRE,
                1000,
                10,
                "Dragon King",
                5,
                "dragontank.gif");

    }


    /**
     * Test that the constructor sets values right
     */
    public void testConstructor()
    {
        assertEquals(40000, mon.getHealth());
        assertEquals(GemCellType.FIRE, mon.getType());
        assertEquals(1000, mon.getDefense());
        assertEquals("Dragon King", mon.getName());
        assertEquals(5, mon.getDefaultTurns());
        assertEquals("dragontank.gif", mon.getImage());
    }


    /**
     * Test attack method
     */
    public void testAttack()
    {
        sofia.util.Random.setNextInts(10);
        assertEquals(100, mon.attack());

    }


    /**
     * test that attackTurns works
     */
    public void testAttackTurns()
    {
        mon.setAttackTurns(2);
        assertEquals(2, mon.attackTurns());
        assertEquals(5, mon.getDefaultTurns());
    }


    // ----------------------------------------------------------
    /**
     * Test the reduce Health Method
     */
    public void testReduceHealth()
    {
        mon.reduceHealth(0);
        assertEquals(40000, mon.getHealth());

    }


    /**
     * Test the reduce Health Method when health ==0
     */
    public void testReduceHealth2()
    {
        mon.reduceHealth(10000000);
        assertEquals(0, mon.getHealth());

    }
}
