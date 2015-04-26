package cs2114.puzzlerpg;

import cs2114.puzzlerpg.puzzle.GemCellType;
import cs2114.puzzlerpg.monsters.Monsters;
import java.util.Stack;
import cs2114.puzzlerpg.playerclasses.Player;

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
     * Adds 10 Monsters to the
     */
    public void addMonsters()
    {

        monsters.push(new Monsters(
            1000,
            GemCellType.EARTH,
            500,
            1,
            "Troll",
            5,
            "Troll.png"));
        monsters.push(new Monsters(
            10000,
            GemCellType.FIRE,
            600,
            2,
            "Fire Dragon",
            4,
            "fireDragon.png"));
        monsters.push(new Monsters(
            5000,
            GemCellType.FIRE,
            700,
            3,
            "Lava",
            4,
            "lava.png"));
        monsters.push(new Monsters(
            7000,
            GemCellType.WATER,
            700,
            4,
            "FishMan",
            4,
            "fish.png"));
        monsters.push(new Monsters(
            15000,
            GemCellType.WATER,
            400,
            5,
            "Drowner",
            3,
            "drowner.png"));
        monsters.push(new Monsters(
            50000,
            GemCellType.EARTH,
            800,
            6,
            "RatKing",
            5,
            "ratking.png"));
        monsters.push(new Monsters(
            20000,
            GemCellType.FIRE,
            900,
            7,
            "FireTroll",
            7,
            "fireTroll.png"));
        monsters.push(new Monsters(
            10000,
            GemCellType.WATER,
            800,
            8,
            "Imp",
            6,
            "imp.png"));
        monsters.push(new Monsters(
            20000,
            GemCellType.EARTH,
            700,
            9,
            "Goblin",
            7,
            "goblin.png"));
        monsters.push(new Monsters(
            40000,
            GemCellType.FIRE,
            1000,
            10,
            "Dragon King",
            5,
            "dragonking.png"));

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
            else
            {
                // if still alive update counter and process attack
                mon.setAttackTurns(mon.attackTurns() - 1);
                // see if attack turns is 0
                if (mon.attackTurns() == 0)
                {
                    mainChar.reduceHealth(mon.attack());
                    mon.setAttackTurns(mon.getDefaultTurns());
                }

            }

        }
    }
}
