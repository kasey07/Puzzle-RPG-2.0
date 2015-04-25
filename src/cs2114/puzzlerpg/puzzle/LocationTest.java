package cs2114.puzzlerpg.puzzle;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test the methods of the Location Class
 *
 *  @author Kasey Johnson
 *  @version Apr 22, 2015
 */
public class LocationTest
    extends TestCase
{
    // ----------------------------------------------------------
    private Location location;
    private Location location2;


    /**
     * Sets up the location for test
     */
    public void setUp()
    {
        location = new Location(2, 3);
    }


    /**
     * Test the x() method of the location class
     */
    public void testX()
    {
        assertEquals(2, location.getX());
    }


    /**
     * Test the y() method of the location class
     */
    public void testY()
    {
        assertEquals(3, location.getY());
    }


    /**
     * Test the toString() method of the location class
     */
    public void testToString()
    {
        assertEquals("(2, 3)", location.toString());
    }


    /**
     * Test the equals() method of the location class when comparing to itself
     */
    public void testEquals()
    {
        assertTrue(location.equals(location));
    }


    /**
     * Test the equals() method of the location class when comparing an object
     * of different class
     */
    public void testEquals2()
    {
        assertFalse(location.equals("(1, 2)"));
    }


    /**
     * Test the equals() method of the location class when comparing an object
     * of same class but not same values
     */
    public void testEquals3()
    {
        location2 = new Location(4, 4);
        assertFalse(location.equals(location2));
    }


    /**
     * Test the equals() method of the location class when comparing an object
     * of same class but not same values
     */
    public void testEquals4()
    {
        location2 = new Location(2, 4);
        assertFalse(location.equals(location2));
    }


    /**
     * Test the equals() method of the location class when comparing an object
     * of same class but not same values
     */
    public void testEquals5()
    {
        location2 = new Location(4, 3);
        assertFalse(location.equals(location2));
    }


    /**
     * Test the equals() method of the location class when comparing an object
     * of same class but not same values
     */
    public void testEquals6()
    {
        location2 = new Location(2, 3);
        assertTrue(location.equals(location2));
    }

    /**
     * Test the equals() method of the location class when comparing to null
     */
    public void testEquals7()
    {
        location2 = null;

        assertFalse(location.equals(location2));
    }


}
