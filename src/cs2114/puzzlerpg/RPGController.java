package cs2114.puzzlerpg;

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
        this.addMonsters();
    }


    // ----------------------------------------------------------
    /**
     * Adds 10 Monsters to the
     */
    public void addMonsters()
    {
        for (int i = 0; i < 10; i++)
        {
        }
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

}
