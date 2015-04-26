package cs2114.puzzlerpg.puzzle;

import sofia.util.Random;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Kasey Johnson
 * @version Mar 29, 2015
 */
public class PuzzleGrid
    extends sofia.util.Observable
{
    private LinkedList<GemCellType>[] gemColumns;
    private Random                    rand;


    /**
     * Create a new PuzzleGrid object.
     *
     * @param size
     *            the length/width of the board
     */
    public PuzzleGrid(int size)
    {
        rand = new Random();
        gemColumns = new LinkedList[size];
        for (int i = 0; i < size; i++)
        {
            gemColumns[i] = new LinkedList<GemCellType>();
            for (int j = 0; j < size; j++)
            {
                LinkedList<GemCellType> temp = gemColumns[i];
                temp.insert(randomType());
            }
        }
    }


    /**
     * Replaces all gems on the board with new random values.
     */
    public void resetBoard()
    {
        for (int x = 0; x < gemColumns.length; x++)
        {
            for (int y = 0; y < gemColumns.length; y++)
            {
                setType(new Location(x, y), randomType());
            }
        }
    }


    /**
     * Randomly Selects a Cell type to fill in layout
     */
    private GemCellType randomType()
    {
        int nextValue = rand.nextInt(4);
        switch (nextValue)
        {
            case 0:
                return GemCellType.EARTH;
            case 1:
                return GemCellType.FIRE;
            case 2:
                return GemCellType.WATER;
            case 3:
                return GemCellType.HEAL;
            default:
                // This should never happen, but I don't
                // care enough to use exceptions.
                return null;
        }

    }


    /**
     * Removes a cell and all adjacent cell of the same type.
     *
     * @param loc
     *            The start location.
     * @return The total number of gems removed.
     */
    public int remove(Location loc)
    {

        return removeHelper(loc, getType(loc), new LinkedList<Location>());

    }


    /**
     * Remove a cell of the given type and all adjacent cells of the same type.
     *
     * @param loc
     *            The location to start from
     * @param type
     *            The type of the cell to remove
     * @param visited
     *            A list of previously visited values.
     * @return The amount of cells removed,
     */
    private int removeHelper(
        Location loc,
        GemCellType type,
        LinkedList<Location> visited)
    {
        if (getType(loc) == null || visited.contains(loc))
        {
            return 0;
        }
        else if (!getType(loc).equals(type))
        {
            return 0;
        }
        else
        {
            int x = loc.getX();
            int y = loc.getY();
            visited.insert(loc);
            int scoreValue =
                removeHelper(new Location(x + 1, y), type, visited)
                    + removeHelper(new Location(x - 1, y), type, visited)
                    + removeHelper(new Location(x, y + 1), type, visited)
                    + removeHelper(new Location(x, y - 1), type, visited);
            gemColumns[x].delete(y);
            gemColumns[x].insert(randomType());
            notifyObservers();
            return scoreValue + 1;
        }
    }


    /**
     * Get the total amount of adjacent gems of the same type.
     *
     * @param loc
     *            The start location.
     * @return Amount of adjacent cells with same gem type.
     */
    public int countAdjacent(Location loc)
    {
        return countAdjacentHelper(
            loc,
            getType(loc),
            new LinkedList<Location>());
    }


    /**
     * Get the total amount of adjacent gems of the same type.
     *
     * @param loc
     *            The current location to spread from.
     * @param type
     *            The type to search for.
     * @param visited
     *            A list of locations to ignore.
     * @return Amount of adjacent cells with same gem type.
     */
    private int countAdjacentHelper(
        Location loc,
        GemCellType type,
        LinkedList<Location> visited)
    {
        if (getType(loc) == null || visited.contains(loc))
        {
            return 0;
        }
        else if (!getType(loc).equals(type))
        {
            return 0;
        }
        else
        {
            int x = loc.getX();
            int y = loc.getY();
            visited.insert(loc);
            return countAdjacentHelper(new Location(x + 1, y), type, visited)
                + countAdjacentHelper(new Location(x - 1, y), type, visited)
                + countAdjacentHelper(new Location(x, y + 1), type, visited)
                + countAdjacentHelper(new Location(x, y - 1), type, visited)
                + 1;
        }
    }


    /**
     * Get the size of the gem grid.
     *
     * @return The width and height of the gem grid.
     */
    public int size()
    {
        return gemColumns.length;
    }


    /**
     * Switches the values in two cells.
     *
     * @param loc1
     *            The first gem's location.
     * @param loc2
     *            The second gem's location.
     */
    public void switchGems(Location loc1, Location loc2)
    {
        GemCellType temp = getType(loc1);
        setType(loc1, getType(loc2));
        setType(loc2, temp);
        notifyObservers();
    }


    /**
     * Get the gem type at a location.
     *
     * @param loc
     *            The location of the cell to check.
     * @return The type of the cell at that location.
     */
    public GemCellType getType(Location loc)
    {
        int x = loc.getX();
        int y = loc.getY();
        if ((0 <= x && x < gemColumns.length)
            && (0 <= y && y < gemColumns.length))
        {
            return gemColumns[x].get(y);
        }
        else
        {
            return null;
        }
    }


    /**
     * Change the gem type at a location.
     *
     * @param loc
     *            The location to be updated.
     * @param gemType
     *            The new gem type value.
     */
    public void setType(Location loc, GemCellType gemType)
    {
        gemColumns[loc.getX()].set(loc.getY(), gemType);
    }


    /**
     * Unlimited moves for regular mode
     *
     * @return always true for regular mode
     */
    public boolean movesLeft()
    {
        return true;
    }

}
