package cs2114.puzzlerpg.puzzle;

// -------------------------------------------------------------------------
/**
 * Interface of the Puzzle Grid. Follow it with additional details about its
 * purpose, what abstraction it represents, and how to use it.
 *
 * @author Kasey Johnson
 * @version Mar 30, 2015
 */
public interface PuzzleGridI
{

    // ----------------------------------------------------------
    /**
     * Remove the gem at the location selected
     *
     * @param location
     *            the x,y coordinate of gem
     */
    public GemCellType remove(Location location);


    // ----------------------------------------------------------
    /**
     * returns the size of the grid
     *
     * @return grid size
     */
    public int size();


    // ----------------------------------------------------------
    /**
     * Switches the position of 2 gems
     *
     * @param location
     *            1 The gem to moved
     * @param location
     *            2 The gem to switch location 1 with
     */
    public void switchGems(Location location1, Location location2);


    // ----------------------------------------------------------
    /**
     * Returns the gem type at the given location
     *
     * @param location
     *            location of gem
     * @return the gem type
     */
    public GemCellType getType(Location location);


    // ----------------------------------------------------------
    /**
     * Allows you to change gem type
     *
     * @param location
     *            the location of the gem
     * @param gemType
     *            the gem type to set the gem to
     */
    public void setType(Location location, GemCellType gemType);


    // ----------------------------------------------------------
    /**
     * Determines if the player still have combinations left
     *
     * @return true if there are still combinations
     */
    public boolean movesLeft();
}
