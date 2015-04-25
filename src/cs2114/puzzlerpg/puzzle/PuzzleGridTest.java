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
        puzzle.setType(new Location(1, 0), GemCellType.FIRE);
        puzzle.setType(new Location(0, 1), GemCellType.WATER);
        puzzle.setType(new Location(1, 1), GemCellType.EARTH);
    }


    // ----------------------------------------------------------

    /**
     * Test Get Type Method
     */
    public void testGetType()
    {
        assertEquals(GemCellType.HEAL, puzzle.getType(new Location(0, 0)));
    }


    /**
     * Test Remove When it should remove
     */
    public void testRemove()
    {
        puzzle.setType(new Location(0, 1), GemCellType.HEAL);
        puzzle.setType(new Location(0, 2), GemCellType.HEAL);

        assertEquals(GemCellType.HEAL, puzzle.remove(new Location(0, 0)));

    }

}
