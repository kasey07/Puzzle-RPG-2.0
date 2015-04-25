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
    implements PuzzleGridI
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
        for (int i = 0; i < size; i++)
        {
            gemColumns[i] = new LinkedList<GemCellType>();
            for (int j = 0; j < size; j++)
            {
                gemColumns[i].insert(randomType());
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
        double nextValue = Math.random();
        if (nextValue < .30)
        {
            return GemCellType.EARTH;
        }
        else if (nextValue < .60)
        {
            return GemCellType.FIRE;
        }
        else if (nextValue < .90)
        {
            return GemCellType.WATER;
        }
        else
        {
            return GemCellType.HEAL;
        }

    }


    /**
     * Removes current gemCell and adjacent of similar types then calls
     * FillSquare to replace removed gemCells
     *
     * @param location
     *            of gemCell
     * @return type removed
     */
    public GemCellType remove(Location location)
    {
        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(location);
        Location temp = location;
        GemCellType type = this.getType(location);
        boolean adj = true;
        while (adj)
        {
            int size1 = locations.size();

            locations = getAdjacent(temp, locations, type);
            if (size1 == locations.size())
            {
                break;
            }
            for (int i = locations.size() - size1; i < locations.size(); i++)
            {
                temp = locations.get(i);
                locations = getAdjacent(temp, locations, type);
            }

            for (int i = 0; i < locations.size(); i++)
            {
                temp = locations.get(i);
                fillSquare(temp.getX(), temp.getY());
            }
        }
        notifyObservers();
        return type;
    }


    private ArrayList<Location> getAdjacent(
        Location location,
        ArrayList<Location> locations,
        GemCellType type)
    {
        int x = location.getX();
        int y = location.getY();
        Location temp = location;
        for (int i = x - 1; i <= x + 1; i++)
        {
            for (int j = x - 1; j <= x + 1; j++)
            {
                // add adjacent locations of same type
            }
        }

        return locations;
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
     * @param return The type of the cell at that location.
     */
    public GemCellType getType(Location loc)
    {
        return gemColumns[loc.getX()].get(loc.getY());
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
