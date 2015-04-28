package cs2114.puzzlerpg;

import cs2114.puzzlerpg.puzzle.Location;
import cs2114.puzzlerpg.puzzle.GemCellType;
import cs2114.puzzlerpg.puzzle.PuzzleGrid;
import sofia.graphics.Shape;
import android.widget.Button;
import sofia.graphics.ShapeView;
import android.widget.TextView;

// -------------------------------------------------------------------------
/**
 * Test the battle screen class.
 *
 * @author Kasey Johnson
 * @version Apr 27, 2015
 */
public class BattleScreenTest
    extends student.AndroidTestCase<BattleScreen>
{
    private TextView   monsterHealth;
    private TextView   charHealth;
    private ShapeView  player;
    private ShapeView  monster;
    private ShapeView  shapeView;
    private Button     special;
    private PuzzleGrid puzzle;
    private int        cellSize;


    // ----------------------------------------------------------
    /**
     * Create a new BattleScreenTest object.
     */
    public BattleScreenTest()
    {
        super(BattleScreen.class);

    }


    /**
     * Set up values for test
     */
    public void setUp()
    {

        float viewSize = Math.min(shapeView.getWidth(), shapeView.getHeight());
        puzzle = getScreen().getPuzzle();
        cellSize = (int)(viewSize / puzzle.size());

        for (int i = 0; i < puzzle.size(); i++)
        {
            for (int j = 0; j < puzzle.size(); j++)
            {
                puzzle.setType(new Location(i, j), GemCellType.FIRE);
            }
        }

    }


    // ----------------------------------------------------------
    /**
     * Test that damage was done when combo made
     */
    public void testProcessTouch()
    {

        this.touchDownCell(0, 0);
        this.touchUp();
        this.touchDownCell(0, 1);
        this.touchUp();

        assertTrue(this.getScreen().getController().getMonster().getHealth() < 2000);

    }


    /**
     * Test that no damage was done when no combo made
     */
    public void testProcessTouch2()
    {

        puzzle.setType(new Location(0, 0), GemCellType.HEAL);
        puzzle.setType(new Location(0, 1), GemCellType.WATER);
        this.touchDownCell(0, 0);
        this.touchUp();
        this.touchDownCell(0, 1);
        this.touchUp();
        assertEquals(1000, getScreen().getController().getMonster().getHealth());

    }


    /**
     * Test when second click not adjacent
     */
    public void testProcessTouch3()
    {
        for (int i = 0; i < puzzle.size(); i++)
        {
            for (int j = 0; j < puzzle.size(); j++)
            {
                puzzle.setType(new Location(i, j), GemCellType.FIRE);
            }
        }
        puzzle.setType(new Location(0, 0), GemCellType.HEAL);
        this.touchDownCell(0, 0);
        this.touchUp();
        this.touchDownCell(0, 4);
        this.touchUp();
        assertEquals(GemCellType.HEAL, puzzle.getType(new Location(0, 0)));

    }


    /**
     * Test only one is cleared
     */
    public void testProcessTouch4()
    {
        for (int i = 0; i < puzzle.size(); i++)
        {
            for (int j = 0; j < puzzle.size(); j++)
            {
                puzzle.setType(new Location(i, j), GemCellType.FIRE);
            }
        }
        puzzle.setType(new Location(0, 0), GemCellType.HEAL);
        this.touchDownCell(0, 0);
        this.touchUp();
        this.touchDownCell(0, 1);
        this.touchUp();
        assertEquals(GemCellType.HEAL, puzzle.getType(new Location(0, 0)));

    }


    /**
     * Test only one is cleared
     */
    public void testProcessTouch5()
    {
        puzzle.setType(new Location(0, 1), GemCellType.HEAL);
        this.touchDownCell(0, 0);
        this.touchUp();
        this.touchDownCell(0, 1);
        this.touchUp();
        assertEquals(GemCellType.HEAL, puzzle.getType(new Location(0, 1)));

    }


    // ----------------------------------------------------------
    /**
     * Test than the correct character Health
     */
    public void testCharHealth()
    {
        assertEquals("10000/10000", charHealth.getText());
    }


    // ----------------------------------------------------------
    /**
     * Test the number of shapes in player view
     */
    public void testPlayer()
    {

        assertEquals(1, player.getShapes().count());
    }


    /**
     * Test the number of shapes in monster view
     */
    public void testMonster()
    {

        assertEquals(1, monster.getShapes().count());
    }


    /**
     * test values in monster health
     */
    public void testmonsterHealth()
    {
        assertEquals("5 turns/1000hp", monsterHealth.getText());
    }


    /**
     * Test special being clicked
     */
    public void testSpecial()
    {
        this.click(special);
        assertEquals(0, getScreen().getController().getPlayer().getCounter());
    }


    /**
     * Simulates touching down on the middle of the specified cell in the maze.
     */
    private void touchDownCell(int x, int y)
    {
        touchDown(shapeView, (x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }

}
