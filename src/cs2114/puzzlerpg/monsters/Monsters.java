package cs2114.puzzlerpg.monsters;

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
    private ElementType type;
    private int         defense;
    private int         difficulty;
    private String      name;
    private Random      rand;
    private int         attackTurns;
    private int         defaultTurns;


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
     */
    public Monsters(
        int health,
        ElementType type,
        int defense,
        int difficulty,
        String name,
        int turns)
    {
        this.health = health;
        this.type = type;
        this.defense = defense;
        this.name = name;
        this.difficulty = difficulty;
        rand = new Random();
        this.attackTurns = turns;
        this.defaultTurns = turns; // remains unedited to update attack turns

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
    public ElementType getType()
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
     * Updates attack turns and attacks when turns is 0
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

}
