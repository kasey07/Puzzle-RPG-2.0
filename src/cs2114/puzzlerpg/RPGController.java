package cs2114.puzzlerpg;

import cs2114.puzzlerpg.playerclasses.Mage;
import cs2114.puzzlerpg.playerclasses.Warrior;
import cs2114.puzzlerpg.puzzle.GemCellType;
import cs2114.puzzlerpg.monsters.Monsters;
import java.util.Stack;
import cs2114.puzzlerpg.playerclasses.*;

;

// -------------------------------------------------------------------------
/**
 * Control RPG elements of the game. Keeps track of monster
 *
 * @author Kasey Johnson
 * @version Apr 26, 2015
 */
public class RPGController
    extends sofia.util.Observable
{
    private Player          mainChar;
    private Stack<Monsters> monsters;


    // ----------------------------------------------------------
    /**
     * Create a new RPGController object.
     *
     * @param player
     *            player class for rpg
     */
    public RPGController(Player player)
    {

        this.mainChar = player;
        monsters = new Stack<Monsters>();
        this.addMonsters();
    }


    // ----------------------------------------------------------
    /**
     * returns the image of the characters
     *
     * @return image of character
     */
    public String getImage()
    {
        if (mainChar instanceof Warrior)
        {
            return "warrior.png";
        }
        if (mainChar instanceof Mage)
        {
            return "mage.png";
        }
        else
        {
            return "rouge.png";
        }

    }


    // ----------------------------------------------------------
    /**
     * Adds 10 Monsters to the monsters stack
     */
    public void addMonsters()
    {

        monsters.push(new Monsters(
            40000,
            GemCellType.FIRE,
            1000,
            10,
            "Dragon King",
            5,
            "dragontank.gif"));
        monsters.push(new Monsters(
            20000,
            GemCellType.EARTH,
            700,
            9,
            "Skeleton",
            7,
            "skeleton.png"));
        monsters.push(new Monsters(
            10000,
            GemCellType.WATER,
            800,
            8,
            "water beast",
            6,
            "waterbeast.gif"));

        monsters.push(new Monsters(
            20000,
            GemCellType.FIRE,
            900,
            7,
            "Goblin",
            7,
            "goblin.png"));

        monsters.push(new Monsters(
            50000,
            GemCellType.EARTH,
            800,
            6,
            "RatKing",
            5,
            "ratking.png"));

        monsters.push(new Monsters(
            15000,
            GemCellType.WATER,
            400,
            5,
            "Drowner",
            3,
            "drowner.gif"));
        monsters.push(new Monsters(
            7000,
            GemCellType.WATER,
            700,
            4,
            "Water Dragon",
            4,
            "waterdragon.png"));

        monsters.push(new Monsters(
            10000,
            GemCellType.FIRE,
            600,
            2,
            "Fire Dragon",
            4,
            "firedragon.png"));

        monsters.push(new Monsters(
            1000,
            GemCellType.EARTH,
            500,
            1,
            "Troll",
            5,
            "troll.png"));

    }


    // ----------------------------------------------------------
    /**
     * Get the player
     *
     * @return the current player
     */
    public Player getPlayer()
    {
        return mainChar;
    }


    /**
     * Get the current monster.
     *
     * @return The current monster.
     */
    public Monsters getMonster()
    {
        return monsters.peek();
    }


    /**
     * Updates player and monster stats
     *
     * @param combo
     *            the number of gems in combo
     * @param typeRemoved
     *            element type of combo
     */
    public void update(int combo, GemCellType typeRemoved)
    {
        Monsters mon = monsters.peek();
        mon.setAttackTurns(mon.attackTurns() - 1);

        if (mon.attackTurns() == 0)
        {
            mainChar.reduceHealth(mon.attack());
            mon.setAttackTurns(mon.getDefaultTurns());
        }

        mainChar.setCounter(mainChar.getCounter() + 1);
        if (typeRemoved.equals(GemCellType.HEAL))
        {
            mainChar.addHealth(combo * 10);
        }
        else
        {
            if (typeRemoved.equals(mon.getType().getWeakness()))
                // If attacked by weakness additional 100 damage
                mon.reduceHealth(mainChar.getAttack(combo) + 100);
            else
            {
                mon.reduceHealth(mainChar.getAttack(combo));

            }
            if (mon.getHealth() == 0)
            {
                // remove dead monster from stack
                monsters.pop();
            }

        }

        notifyObservers();
    }


    // ----------------------------------------------------------
    /**
     * Activates Special Ability of Player
     */
    public void activateSpecialAbility()
    {

        if (mainChar instanceof Warrior)
        {
            ((Warrior)mainChar).specialAbility();
        }
        if (mainChar instanceof Mage)
        {
            ((Mage)mainChar).specialAbility();

        }
        if (mainChar instanceof Rouge)
        {
            monsters.peek().setAttackTurns(
                ((Rouge)mainChar).specialAbility()
                    + monsters.peek().attackTurns());

        }
    }
}
