package cs2114.puzzlerpg;

import cs2114.puzzlerpg.puzzle.GemShape;
import cs2114.puzzlerpg.puzzle.Location;
import cs2114.puzzlerpg.puzzle.PuzzleGrid;
import sofia.app.ShapeScreen;
import sofia.graphics.ShapeView;


// -------------------------------------------------------------------------
/**
 * Battle Screen of the Puzzle-RPG.
 *
 * @author Kasey Johnson
 * @author
 * @version Mar 29, 2015
 */
public class BattleScreen
    extends ShapeScreen
{

    private PuzzleGrid       puzzle;
    private int              length;
    private ShapeView        shapeView;
    private GemShape[][]     gem;
    private Location         firstClick;
    private static final int GRID_SIZE = 4;


    // ----------------------------------------------------------
    /**
     * Initialize the battle screen
     */
    public void initialize()
    {
        firstClick = null;

        puzzle = new PuzzleGrid(GRID_SIZE);
        puzzle.addObserver(this);
        this.length =
            (Math.min(shapeView.getHeight(), shapeView.getWidth()) / GRID_SIZE);
        this.gem = new GemShape[GRID_SIZE][GRID_SIZE];
        setupScreen();

    }


    private void setupScreen()
    {

        for (int i = 0; i < GRID_SIZE; i++)
        {
            for (int j = 0; j < GRID_SIZE; j++)

            {
                GemShape square =
                    new GemShape(
                        (length * j),
                        length * i,
                        (length * (j + 1)),
                        length * (i + 1),
                        puzzle.getType(new Location(i, j)));

                shapeView.add(square);
                gem[i][j] = square;

            }
        }

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param x
     * @param y
     */
    public void onTouchMove(float x, float y)
    {

    }


    /**
     * Place a description of your method here.
     *
     * @param x
     * @param y
     */
    public void onTouchDown(float x, float y)
    {
        processTouch(x, y);

    }


    // ----------------------------------------------------------
    /**
     * Determines the equivalent coordinate of a pixel
     *
     * @param value
     *            the value location of the screen
     * @return returns the coordinate value
     */
    private int getValue(float value)
    {
        return (int)(value / length);

    }


    /**
     * Place a description of your method here.
     *
     * @param x
     * @param y
     */
    public void processTouch(float x, float y)
    {
        GemShape tile =
            this.getShapes().locatedAt(x, y).withClass(GemShape.class).front();

        if (tile != null)
        {
            int yValue = getValue(x);
            int xValue = getValue(y);
            if (firstClick == null)
            {
                firstClick = new Location(xValue, yValue);
            }
            else
            {

                puzzle.switchGems(firstClick, new Location(xValue, yValue));

                puzzle.remove(new Location(xValue, yValue));
                // puzzle
                // .remove(new Location(firstClick.getX(), firstClick.getY()));
                firstClick = null;

            }

        }

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param puzzle
     */
    public void changeWasObserved(PuzzleGrid puzzle)
    {
        for (int i = 0; i < puzzle.size(); i++)
        {
            for (int j = 0; j < puzzle.size(); j++)
            {

                gem[i][j].setImage(puzzle.getType(new Location(i, j))
                    .getImage());
                // animation?

            }

        }

    }
}