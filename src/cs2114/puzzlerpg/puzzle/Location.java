package cs2114.puzzlerpg.puzzle;

/**
 * This Location class represents a constant point in a 2D grid.
 *
 * @author andrew
 * @version Mar 29, 2015
 */
public class Location
{
    private final int x;
    private final int y;


    /**
     * Check if two locations are adjacent. Diagonals do not count.
     *
     * @param loc1
     *            The first location.
     * @param loc2
     *            The second location.
     * @return True if adjacent, false if not.
     */
    static public boolean isAdjacent(Location loc1, Location loc2)
    {

        int x = loc1.getX();
        int y = loc1.getY();
        return loc2 == new Location(x + 1, y) || loc2 == new Location(x - 1, y)
            || loc2 == new Location(x, y + 1) || loc2 == new Location(x, y - 1);
    }


    /**
     * Create a new Location with constant values 'x' and 'y'.
     *
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     */
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    /**
     * Return the x coordinate of the location.
     *
     * @return x coordinate
     */
    public int getX()
    {
        return x;
    }


    /**
     * Return the y coordinate of the location.
     *
     * @return y coordinate.
     */
    public int getY()
    {
        return y;
    }


    /**
     * Compare the location to another object to determine if they are equal
     *
     * @param obj
     *            The object to compare
     * @return if the objects have same x and y returns true
     */
    public boolean equals(Object obj)
    {

        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Location other = (Location)obj;
        return this.getX() == other.getX() && this.getY() == other.getY();

    }


    /**
     * Returns a string of the current x and y location
     *
     * @return the current x,y
     */
    public String toString()
    {
        return "(" + this.getX() + ", " + this.getY() + ")";

    }
}
