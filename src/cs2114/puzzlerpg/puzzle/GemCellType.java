package cs2114.puzzlerpg.puzzle;

// -------------------------------------------------------------------------
/**
 * The four elements used in the game. Each element has  a weakness and an
 * image associated with it
 *
 * @author Kasey Johnson
 * @version Apr 7, 2015
 */
public enum GemCellType
{
    FIRE,
    WATER,
    EARTH,
    HEAL;
    private String      imageName;
    private GemCellType weakness;

    static
    {
        FIRE.imageName = "fire.png";
        WATER.imageName = "water.png";
        EARTH.imageName = "earth.png";
        HEAL.imageName = "heal.png";

        FIRE.weakness = WATER;
        WATER.weakness = EARTH;
        EARTH.weakness = FIRE;

    }


    // ----------------------------------------------------------
    /**
     * Gets the image file for the Gem Type
     *
     * @return the image file name
     */
    public String getImage()
    {
        return imageName;
    }


    // ----------------------------------------------------------
    /**
     * GEt opposite element
     *
     * @return the opposite element
     */
    public GemCellType getWeakness()
    {

        return weakness;
    }
}
