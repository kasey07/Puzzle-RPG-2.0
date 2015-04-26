package cs2114.puzzlerpg;

import cs2114.puzzlerpg.monsters.ElementType;
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
            ElementType.EARTH,
            500,
            1,
            "Troll",
            5,
            "Troll.png"));
        monsters.push(new Monsters(
            10000,
            ElementType.FIRE,
            600,
            2,
            "Fire Dragon",
            4,
            "fireDragon.png"));
        monsters.push(new Monsters(
            5000,
            ElementType.FIRE,
            700,
            3,
            "Lava",
            4,
            "lava.png"));
        monsters.push(new Monsters(
            7000,
            ElementType.WATER,
            700,
            4,
            "FishMan",
            4,
            "fish.png"));
        monsters.push(new Monsters(
            15000,
            ElementType.WATER,
            400,
            5,
            "Drowner",
            3,
            "drowner.png"));
        monsters.push(new Monsters(
            50000,
            ElementType.EARTH,
            800,
            6,
            "RatKing",
            5,
            "ratking.png"));
        monsters.push(new Monsters(
            20000,
            ElementType.FIRE,
            900,
            7,
            "FireTroll",
            7,
            "fireTroll.png"));
        monsters.push(new Monsters(
            10000,
            ElementType.WATER,
            800,
            8,
            "Imp",
            6,
            "imp.png"));
        monsters.push(new Monsters(
            20000,
            ElementType.EARTH,
            700,
            9,
            "Goblin",
            7,
            "goblin.png"));
        monsters.push(new Monsters(
            40000,
            ElementType.FIRE,
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
     * Updates player and monster stats
     *
     * @param combo
     *            the number of gems in combo
     */
    public void update(int combo)
    {
        // health of monster
        // check if monster is dead
        // update monster moves and character counter
        // check if monster attacks
        // if true attack resest monster turn count
        // else -- monster attack

    }

}
