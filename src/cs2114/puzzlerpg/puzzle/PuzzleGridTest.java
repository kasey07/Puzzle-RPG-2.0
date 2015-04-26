package cs2114.puzzlerpg.puzzle;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the methods of the Puzzle Grid Class
 *
 * @author Kasey Johnson
 * @version Apr 22, 2015
 */
public class PuzzleGridTest
    extends TestCase
{
    private PuzzleGrid puzzle;


    public void setUp()
    {
        puzzle = new PuzzleGrid(3);
        puzzle.setType(new Location(0, 0), GemCellType.HEAL);
        puzzle.setType(new Location(1, 0), GemCellType.HEAL);
        puzzle.setType(new Location(2, 0), GemCellType.HEAL);

        puzzle.setType(new Location(0, 1), GemCellType.HEAL);
        puzzle.setType(new Location(1, 1), GemCellType.HEAL);
        puzzle.setType(new Location(2, 1), GemCellType.HEAL);

        puzzle.setType(new Location(0, 2), GemCellType.WATER);
        puzzle.setType(new Location(1, 2), GemCellType.FIRE);
        puzzle.setType(new Location(2, 2), GemCellType.EARTH);
    }


    /**
     * Test Get Type Method
     */
    public void testGetType()
    {
        assertEquals(GemCellType.HEAL, puzzle.getType(new Location(1, 1)));
    }


    /**
     * Test the size method.
     */
    public void testSize()
    {
        assertEquals(3, puzzle.size());
    }


    /**
     * Test the switchGems method.
     */
    public void testSwitchGems()
    {
        puzzle.switchGems(new Location(0, 1), new Location(1, 1));
        assertEquals(GemCellType.HEAL, puzzle.getType(new Location(0, 1)));
        assertEquals(GemCellType.WATER, puzzle.getType(new Location(1, 1)));
    }


    /**
     * Test Remove When it should remove
     */
    public void testRemove()
    {
        puzzle.remove(new Location(2, 2));

        assertEquals(GemCellType.FIRE, puzzle.getType(new Location(0, 2)));
        assertEquals(GemCellType.HEAL, puzzle.getType(new Location(1, 2)));
        assertEquals(GemCellType.FIRE, puzzle.getType(new Location(2, 2)));
    }

    /**
     * Test the countAdjacent method.
     */
    public void testCountAdjacent()
    {
        assertEquals(6, puzzle.countAdjacent(new Location(0, 0)));
        assertEquals(1, puzzle.countAdjacent(new Location(2, 2)));
    }

}
