package cs2114.puzzlerpg;

import android.view.View;
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
    private static final int GRID_SIZE = 4;
    private RectangleShape   playerShape;
    private RectangleShape   monsterShape;
    private RPGController    ctrl;
    private TextView         charName;
    private TextView         charHealth;
    private TextView         monsterTurns;
    private ShapeView        player;
    private ShapeView        monster;


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

        playerShape =

        new RectangleShape(0, 0, player.getWidth(), player.getHeight());

        playerShape.setColor(Color.beige);
        playerShape.setFillColor(Color.black);
        monsterShape =
            new RectangleShape(0, 0, monster.getWidth(), monster.getHeight());
        monsterShape.setColor(Color.black);
        monsterShape.setFillColor(Color.black);
        player.add(playerShape);
        monster.add(monsterShape);

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

            ctrl.update(
                puzzle.remove(new Location(xValue, yValue)),
                puzzle.getType(new Location(xValue, yValue)));
        }

    }


    /**
     * Update view for monster.
     *
     * @param control
     *            The rpg controller.
     */
    public void changeWasObserved(RPGController control)
    {
        monsterTurns.setText(ctrl.getMonster().attackTurns() + "turns");
        charHealth.setText(ctrl.getPlayer().getHealth() + "/"
            + ctrl.getPlayer().getMaxHealth());
    }


    // ----------------------------------------------------------
    /**
     * updates the screen
     *
     * @param puzzle
     *            the puzzle
     */
    public void changeWasObserved(PuzzleGrid puzzle)
    {
        for (int i = 0; i < puzzle.size(); i++)
        {
            for (int j = 0; j < puzzle.size(); j++)
            {

                // GemShape oldGem = gem[i][j];
                // if (oldGem.getType() != puzzle.getType(new Location(i, j)))
                // {
                // oldGem.animate(400).rotation(720).play();
                // gem[i][j] = oldGem;
                // shapeView.add(gem[i][j]);

                // }

                gem[i][j].setImage(puzzle.getType(new Location(i, j))
                    .getImage());

            }

        }

    }
}
