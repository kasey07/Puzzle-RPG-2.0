package cs2114.puzzlerpg;

import sofia.util.Random;
import cs2114.puzzlerpg.monsters.Monsters;
import cs2114.puzzlerpg.puzzle.GemCellType;
import cs2114.puzzlerpg.playerclasses.*;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the RPG Controller methods
 *
 * @author Kasey Johnson
 * @version Apr 27, 2015
 */
public class RPGControllerTest
    extends TestCase
{
    private RPGController ctrl;
    private Mage          magey;
    private Warrior       max;
    private Rouge         theif;


    public void setUp()
    {
        max = new Warrior("max");
        magey = new Mage("magey");
        theif = new Rouge("theif");
        ctrl = new RPGController(max);
    }


    /**
     * Test getImage method Warrior
     */
    public void testGetImage()
    {
        assertEquals("warrior.png", ctrl.getImage());
    }


    /**
     * Test getImage method Mage
     */
    public void testGetImage2()
    {
        ctrl = new RPGController(magey);
        assertEquals("mage.png", ctrl.getImage());
    }


    /**
     * Test getImage method Theif
     */
    public void testGetImage3()
    {
        ctrl = new RPGController(theif);
        assertEquals("rouge.png", ctrl.getImage());
    }


    /**
     * Test the get Player method
     */
    public void testGetMonster()
    {
        assertEquals("troll", ctrl.getMonster().getName());
    }


    /**
     * Test update type heal
     */
    public void testUpdate()
    {
        ctrl.update(4, GemCellType.HEAL);
        assertEquals(10000, ctrl.getPlayer().getHealth());
    }


    /**
     * Test update type fire is weakness
     */
    public void testUpdate2()
    {
        ctrl.update(3, GemCellType.FIRE);
        assertEquals(1000, ctrl.getMonster().getHealth());

    }


    /**
     * Test update type not weakness
     */
    public void testUpdate3()
    {
        ctrl.update(3, GemCellType.WATER);
        assertEquals(1000, ctrl.getMonster().getHealth());

    }


    /**
     * Test update monster health 0
     */
    public void testUpdate4()
    {
        Monsters mon = ctrl.getMonster();
        mon.reduceHealth(1000000);
        ctrl.update(3, GemCellType.EARTH);
        assertFalse(ctrl.getMonster().equals(mon));
    }


    /**
     * Test update attack turn
     */
    public void testUpdate5()
    {
        ctrl.getMonster().setAttackTurns(1);
        ctrl.update(5, GemCellType.FIRE);
        assertEquals(9000, ctrl.getPlayer().getHealth());
        assertEquals(5, ctrl.getMonster().attackTurns());
    }


    /**
     * Special ability warrior
     */
    public void TestActivateSpecialAbility()
    {
        ctrl.getPlayer().setCounter(50);
        ctrl.activateSpecialAbility();
        assertEquals(10000, ctrl.getPlayer().getHealth());

    }


    /**
     * Special ability mage
     */
    public void TestActivateSpecialAbility2()
    {

        ctrl = new RPGController(magey);
        ctrl.getPlayer().setCounter(50);
        ctrl.activateSpecialAbility();
        assertEquals(2000, ctrl.getPlayer().getAttack(2));
    }


    /**
     * Special ability rouge
     */
    public void TestActivateSpecialAbility3()
    {
        ctrl = new RPGController(theif);
        ctrl.getPlayer().setCounter(50);
        Random.setNextInts(5);
        ctrl.activateSpecialAbility();
        assertEquals(10, ctrl.getMonster().attackTurns());
    }

}
