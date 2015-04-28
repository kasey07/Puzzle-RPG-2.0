package cs2114.puzzlerpg;

import android.widget.Button;
import android.widget.ImageButton;
import cs2114.puzzlerpg.puzzle.GemCellType;
import sofia.graphics.Color;
import android.widget.TextView;
import cs2114.puzzlerpg.playerclasses.Rouge;
import cs2114.puzzlerpg.playerclasses.Mage;
import cs2114.puzzlerpg.playerclasses.Warrior;
import android.content.Intent;
import sofia.graphics.RectangleShape;
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
    private static final int GRID_SIZE = 4;
    private RectangleShape   playerShape;
    private RectangleShape   monsterShape;
    private RPGController    ctrl;
    private TextView         charHealth;
    private ShapeView        player;
    private ShapeView        monster;
    private TextView         monsterHealth;
    private Button           special;
    private Location         firstClick;


    // ----------------------------------------------------------
    /**
     * Initialize the battle screen
     */
    public void initialize()
    {

        // Get player class and Name information from intent
        Intent intent = getIntent();
        createRPGController(intent.getExtras().getString("name"), intent
            .getExtras().getString("class"));

        puzzle = new PuzzleGrid(GRID_SIZE);

        this.length =
            (Math.min(shapeView.getHeight(), shapeView.getWidth()) / GRID_SIZE);
        this.gem = new GemShape[GRID_SIZE][GRID_SIZE];
        setupPuzzle();
        setUpRPGArea();
        puzzle.addObserver(this);
        ctrl.addObserver(this);

    }


    /**
     * Creates the rpg controller for the screen determines the class of
     * selected character and creates a new player of that class and passes it
     * into the rpg controller
     */
    private void createRPGController(String name, String classType)
    {
        if (classType.equals("Warrior"))
        {
            this.ctrl = new RPGController(new Warrior(name));

        }
        else if (classType.equals("Mage"))
        {
            this.ctrl = new RPGController(new Mage(name));
        }
        else
        {
            this.ctrl = new RPGController(new Rouge(name));
        }
    }


    /**
     * Sets up the puzzle grid
     */
    private void setupPuzzle()
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
                square.setColor(Color.black);
                shapeView.add(square);
                gem[i][j] = square;

            }
        }

    }


    /**
     * Sets the beginning character and monster fields including the image of
     * each, the health of each, and the turns of the monster
     */
    private void setUpRPGArea()
    {

        // set up monster health and turns bar
        monsterHealth.setText(ctrl.getMonster().attackTurns() + " turns" + "/"
            + ctrl.getMonster().getHealth() + "hp");
        special.setText(ctrl.getPlayer().specialTurnsLeft() + "left");
        // set up character health
        charHealth.setText(ctrl.getPlayer().getHealth() + "/"
            + ctrl.getPlayer().getMaxHealth());
        // create player shape
        playerShape =
            new RectangleShape(0, 0, player.getWidth(), player.getHeight());
        playerShape.setImage(ctrl.getImage());
        // create monster shape
        monsterShape =
            new RectangleShape(0, 0, monster.getWidth(), monster.getHeight());
        monsterShape.setImage(ctrl.getMonster().getImage());
        // add monster and player to screen
        player.add(playerShape);
        monster.add(monsterShape);
    }


    // ----------------------------------------------------------
    /**
     * Process a touch being completed
     *
     * @param x
     *            the x pixel location clicked
     * @param y
     *            the y pixel location clicked
     */
    public void onTouchDown(float x, float y)
    {
        processTouch(y, x);

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
     * Gets the gem under the click and deletes adjacents of the same type
     *
     * @param x
     *            the pixel location of x
     * @param y
     *            the pizel location of y
     */
    public void processTouch(float x, float y)
    {
        GemShape tile =
            this.getShapes().locatedAt(x, y).withClass(GemShape.class).front();

        if (tile != null)
        {
            int yValue = getValue(y);
            int xValue = getValue(x);

            if (firstClick == null)
            {
                firstClick = new Location(xValue, yValue);
            }
            else
            {
                GemCellType temp = puzzle.getType(firstClick);
                GemCellType type = puzzle.getType(new Location(xValue, yValue));
                if (Location.isAdjacent(
                    firstClick,
                    new Location(xValue, yValue)))
                {
                    puzzle.switchGems(firstClick, new Location(xValue, yValue));
                    if (puzzle.countAdjacent(firstClick) >= 3)
                    {
                        ctrl.update(puzzle.remove(firstClick), type);
                    }
                    if (puzzle.countAdjacent(new Location(xValue, yValue)) >= 3)
                    {
                        ctrl.update(
                            puzzle.remove(new Location(xValue, yValue)),
                            temp);
                    }
                    firstClick = null;
                }
            }
        }

    }


    /**
     * Update the screen when the rpg makes changes
     *
     * @param control
     *            The rpg controller.
     */
    public void changeWasObserved(RPGController control)
    {
        // Update character health
        charHealth.setText(ctrl.getPlayer().getHealth() + "/"
            + ctrl.getPlayer().getMaxHealth());
        // update monster image in case monster has changed
        monsterShape.setImage(ctrl.getMonster().getImage());
        // update monster health and turns
        monsterHealth.setText(ctrl.getMonster().attackTurns() + " turns" + "/"
            + ctrl.getMonster().getHealth() + "hp");
        // determine if special can be activated yet and sets text of bottom
        if (ctrl.getPlayer().specialTurnsLeft() > 0)
        {
            special.setText(ctrl.getPlayer().specialTurnsLeft() + "left");
        }
        else
        {
            special.setText("Special");
        }

    }


    // ----------------------------------------------------------
    /**
     * When special is clicked activate special skill
     */
    public void specialClicked()
    {
        ctrl.activateSpecialAbility();
    }


    // ----------------------------------------------------------
    /**
     * updates the screen when puzzle changes
     *
     * @param grid
     *            the puzzle
     */
    public void changeWasObserved(PuzzleGrid grid)
    {
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid.size(); j++)
            {

                // GemShape oldGem = gem[i][j];
                // if (oldGem.getType() != puzzle.getType(new Location(i, j)))
                // {
                // oldGem.animate(400).rotation(720).play();
                // gem[i][j] = oldGem;
                // shapeView.add(gem[i][j]);

                // }

                gem[i][j].setImage(grid.getType(new Location(i, j)).getImage());

            }

        }

    }
}
