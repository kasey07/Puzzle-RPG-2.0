package cs2114.puzzlerpg;

import cs2114.puzzlerpg.monsters.Monsters;
import cs2114.puzzlerpg.playerclasses.Player;
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
    private Location         firstClick;
    private static final int GRID_SIZE = 4;
    private RectangleShape   player;
    private RectangleShape   monster;
    private RPGController    ctrl;
    private TextView         charName;
    private TextView         charHealth;
    private TextView         monsterTurns;


    // ----------------------------------------------------------
    /**
     * Initialize the battle screen
     */
    public void initialize()
    {
        Intent intent = getIntent();
        createRPGController(intent.getExtras().getString("name"), intent
            .getExtras().getString("class"));
        charName.setText(ctrl.getPlayer().getName());
        charHealth.setText(ctrl.getPlayer().getHealth() + "/"
            + ctrl.getPlayer().getMaxHealth());
        firstClick = null;

        puzzle = new PuzzleGrid(GRID_SIZE);
        puzzle.addObserver(this);
        ctrl.addObserver(this);
        this.length =
            (Math.min(shapeView.getHeight(), shapeView.getWidth()) / GRID_SIZE);
        this.gem = new GemShape[GRID_SIZE][GRID_SIZE];
        setupScreen();

    }


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
                square.setColor(Color.black);
                shapeView.add(square);
                gem[i][j] = square;

            }
        }
        player =
            new RectangleShape(length * 6, length * 2, (length * (6)), length
                * (2 + 1));

        player.setColor(Color.beige);
        player.setFillColor(Color.black);
        monster =
            new RectangleShape(
                length * 6,
                length * 6,
                (length * (6)),
                length * (6));
        monster.setColor(Color.black);
        monster.setFillColor(Color.black);
        shapeView.add(player);
        shapeView.add(monster);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
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
            int yValue = getValue(y);
            int xValue = getValue(x);
            if (firstClick == null)
            {
                firstClick = new Location(xValue, yValue);
            }

            else if (Location.isAdjacent(firstClick, new Location(
                xValue,
                yValue)))
            {

                puzzle.switchGems(firstClick, new Location(xValue, yValue));

                int comboNumber = puzzle.remove(new Location(xValue, yValue));

                // puzzle
                // .remove(new Location(firstClick.getX(), firstClick.getY()));
                ctrl.update(comboNumber);
                firstClick = null;

            }

        }

    }

    /**
     * Update view for monster.
     * @param monsters The monster to display data on in views.
     */
    public void changeWasObserved(Monsters monsters)
    {
        monsterTurns.setText(monsters.getDefaultTurns());
    }

    /**
     * Update view for player data.
     * @param character The player to display data on in views.
     */
    public void changeWasObserved(Player character)
    {
        charHealth.setText(character.getHealth());
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
                GemShape oldGem = gem[i][j];
                if (oldGem.getType() != puzzle.getType(new Location(i, j)))
                {
                    oldGem.animate(400).alpha(0).rotation(720).removeWhenComplete().play();
                    gem[i][j] = new GemShape(
                        oldGem.getX(),
                        oldGem.getY(),
                        oldGem.getWidth(),
                        oldGem.getHeight(),
                        oldGem.getType());
                }
            }

        }

    }
}
