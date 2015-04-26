package cs2114.puzzlerpg.monsters;

import cs2114.puzzlerpg.puzzle.GemCellType;
import java.util.Random;

// -------------------------------------------------------------------------
/**
 * Holds data for a monster.
 *
 * @author Kasey Johnson
 * @version Apr 24, 2015
 */
public class Monsters
{
    private int         health;
    private GemCellType type;
    private int         defense;
    private int         difficulty;
    private String      name;
    private Random      rand;
    private int         attackTurns;
    private int         defaultTurns;
    private String      pic;


    // attack defense name health element type difficulty

    // ----------------------------------------------------------
    /**
     * Create a new Monsters object.
     *
     * @param health
     *            amount of health of monster
     * @param type
     *            the element type of monster
     * @param defense
     *            the defense of monster
     * @param difficulty
     *            the difficulty level
     * @param name
     *            name of monster
     * @param turns
     *            turns between attacks
     * @param pic
     *            String of file name containing image of monster
     */
    public Monsters(
        int health,
        GemCellType type,
        int defense,
        int difficulty,
        String name,
        int turns,
        String pic)
    {
        this.health = health;
        this.type = type;
        this.defense = defense;
        this.name = name;
        this.difficulty = difficulty;
        rand = new Random();
        this.attackTurns = turns;
        this.defaultTurns = turns; // remains unedited to update attack turns
        this.pic = pic;
    }


    // ----------------------------------------------------------
    /**
     * Gets the health of the monster
     *
     * @return the health of the monster
     */
    public int getHealth()
    {
        return health;
    }


    /**
     * Gets the type of the monster
     *
     * @return the type of the monster
     */
    public GemCellType getType()
    {
        return type;
    }


    /**
     * Gets the defense of the monster
     *
     * @return the defense of the monster between 1 and 10
     */
    public int getDefense()
    {
        return defense;
    }


    /**
     * Gets the name of the monster
     *
     * @return the name of the monster
     */
    public String getName()
    {
        return name;
    }


    /**
     * Monster attacks player
     *
     * @return damage done by monster
     */
    public int attack()
    {

        return rand.nextInt(10) * difficulty;

    }


    /**
     * returns attack turns number (0 mean attack turn)
     *
     * @return attackTurns
     */
    public int attackTurns()
    {

        return attackTurns;
    }


    /**
     * Set attackTurns to new Value
     *
     * @param newTurns
     *            new number of turns till attack
     */
    public void setAttackTurns(int newTurns)
    {
        attackTurns = newTurns;
    }


    // ----------------------------------------------------------
    /**
     * REturns number of turns between attacks for monster
     *
     * @return default number of turns for monster
     */
    public int getDefaultTurns()
    {
        return defaultTurns;
    }


    /**
     * Get the image name of monster
     *
     * @return file name of monsters picture
     */
    public String getImage()
    {
        return pic;
    }


    /**
     * Set Health of monster after damage
     *
     * @param damageTaken
     *            damage taken by player
     */
    public void reduceHealth(int damageTaken)
    {

        int actualDamage = Math.max(0, damageTaken - defense / 2);
        if (health - actualDamage < 0)
        {
            this.health = 0;
        }
        else
        {
            this.health -= actualDamage;
        }
    }

}
