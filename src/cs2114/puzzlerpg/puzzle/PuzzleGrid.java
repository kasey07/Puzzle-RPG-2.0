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
    private int             size;
    private GemCellType[][] gemLayout;
    private Random          rand;


    // ----------------------------------------------------------
    /**
     * Create a new PuzzleGrid object.
     *
     * @param size
     *            the length/width of the board
     */
    public PuzzleGrid(int size)
    {
        this.rand = new Random();
        this.size = size;
        gemLayout = new GemCellType[size][size];

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                fillSquare(i, j);
            }
        }

    }


    /**
     * Randomly Selects a Cell type to fill in layout
     */
    private void fillSquare(int x, int y)
    {
        int nextValue = rand.nextInt(4);
        switch (nextValue)
        {
            case 0:
                gemLayout[x][y] = GemCellType.EARTH;
                break;

            case 1:
                gemLayout[x][y] = GemCellType.FIRE;
                break;

            case 2:
                gemLayout[x][y] = GemCellType.WATER;
                break;

            case 3:
                gemLayout[x][y] = GemCellType.HEAL;
                break;

            default:
                // does nothing
                break;
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


    public int size()
    {
        return this.size;
    }


    public void switchGems(Location location1, Location location2)
    {
        GemCellType temp = this.getType(location1);
        gemLayout[location1.getX()][location1.getY()] = this.getType(location2);
        gemLayout[location2.getX()][location2.getY()] = temp;
        notifyObservers();

    }


    public GemCellType getType(Location location)
    {
        return gemLayout[location.getX()][location.getY()];
    }


    public void setType(Location location, GemCellType gemType)
    {
        gemLayout[location.getX()][location.getY()] = gemType;

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
