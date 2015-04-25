package cs2114.puzzlerpg.playerclasses;

// -------------------------------------------------------------------------
/**
 * Base class for player. Player has health, defense, and a name.
 *
 * @author Kasey Johnson
 * @version Apr 24, 2015
 */
public abstract class Player
{
    private int    health;
    private int    defense;
    private String name;
    private int    attack;
    private int    turns;
    private int    counter;
    private int    maxHealth;


    // ----------------------------------------------------------
    /**
     * Create a new Player object.
     *
     * @param health
     *            health of player
     * @param defense
     *            defense of player
     * @param name
     *            name of player
     * @param attack
     *            the attack of the player
     * @param turns
     *            turns to get special ability
     */
    public Player(int health, int defense, String name, int attack, int turns)
    {
        this.health = health;
        this.defense = defense;
        this.name = name;
        this.attack = attack;
        this.turns = turns;
        this.maxHealth = health;

    }


    // ----------------------------------------------------------
    /**
     * Get Health of Player
     *
     * @return health of player
     */
    public int getHealth()
    {
        return health;
    }


    // ----------------------------------------------------------
    /**
     * Set Health of Player after damage
     *
     * @param damageTaken
     *            damage taken by player
     */
    public void reduceHealth(int damageTaken)
    {

        if (health - damageTaken < 0)
        {
            this.health = 0;
        }
        else
        {
            this.health -= damageTaken;
        }
    }


    /**
     * Set Health of Player after damage
     *
     * @param heal
     */
    public void addHealth(int heal)
    {
        if (this.health + heal > maxHealth)
        {
            this.health = maxHealth;
        }
        else
        {
            this.health += heal;
        }

    }


    // ----------------------------------------------------------
    /**
     * Get Max Health of Player
     *
     * @return Max health of player
     */
    public int getMaxHealth()
    {
        return maxHealth;
    }


    // ----------------------------------------------------------
    /**
     * Get attack of Player
     *
     * @return attack of player
     */
    public int getAttack()
    {
        return attack;
    }


    // ----------------------------------------------------------
    /**
     * Get defense of Player
     *
     * @return defense of player
     */
    public int getDefense()
    {
        return defense;
    }


    // ----------------------------------------------------------
    /**
     * Get Name of Player
     *
     * @return Name of player
     */
    public String getName()
    {
        return name;
    }


    /**
     * Get turns till special attack of Player
     *
     * @return turns till special attack
     */
    public int getTurns()
    {
        return turns;
    }


    /**
     * Special ability of the player
     */
    public abstract void specialAbility();


    /**
     * number of turns till special ability available
     *
     * @return the number of turns till special attack available
     */
    public int specialTurnsLeft()
    {
        return turns;

    }


    // ----------------------------------------------------------
    /**
     * Player takes damage
     *
     * @param damage
     *            damage caused of player
     */
    public void damageTaken(int damage)
    {
        health -= damage;
    }


    // ----------------------------------------------------------
    /**
     * Set the counter for the special attack
     *
     * @param num
     */
    public void setCounter(int num)
    {
        counter = num;
    }


    // ----------------------------------------------------------
    /**
     * get the counter for the special attack
     *
     * @return return the counter number
     */
    public int getCounter()
    {
        return counter;
    }

}
