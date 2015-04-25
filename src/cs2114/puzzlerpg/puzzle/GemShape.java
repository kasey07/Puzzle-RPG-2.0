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

        setImage(type.getImage());
    }

}
