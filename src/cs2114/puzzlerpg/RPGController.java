package cs2114.puzzlerpg;

import cs2114.puzzlerpg.playerclasses.Player;

;

// -------------------------------------------------------------------------
/**
 *  Control RPG elements of the game. Keeps track of monster
 *
 *  @author Kasey Johnson
 *  @version Apr 26, 2015
 */
public class RPGController
{
    private Player mainChar;


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
