package cs2114.puzzlerpg.puzzle;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
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
    private String imageName;

    static
    {
        FIRE.imageName = "fire.png";
        WATER.imageName = "water.png";
        EARTH.imageName = "earth.png";
        HEAL.imageName = "heal.png";

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
}
