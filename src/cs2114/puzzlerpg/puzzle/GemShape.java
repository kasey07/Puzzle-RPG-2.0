package cs2114.puzzlerpg.puzzle;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Extends the RectangleShape class. Gets the GemCellType and sets Image
 * appropriately.
 *
 * @author Kasey Johnson
 * @version Apr 9, 2015
 */
public class GemShape
    extends RectangleShape
{
    private GemCellType type;

    // ----------------------------------------------------------
    /**
     * Create a new GemShape object.
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @param type
     */
    public GemShape(
        float left,
        float top,
        float right,
        float bottom,
        GemCellType type)
    {
        super(left, top, right, bottom);
        this.type = type;
        setImage(type.getImage());
    }

    /**
     * Get the type of the gem shape.
     * @return The type of the gem shape.
     */
    public GemCellType getType()
    {
        return type;
    }

}
