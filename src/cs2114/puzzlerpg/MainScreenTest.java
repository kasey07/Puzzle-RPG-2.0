package cs2114.puzzlerpg;

import android.widget.EditText;
import android.widget.Spinner;
import student.TestCase;

/**
 *  Test class for MainScreen.
 *
 *  @author andrew
 *  @version Apr 27, 2015
 */
public class MainScreenTest extends student.AndroidTestCase<MainScreen>
{
    private Spinner  characterClass;
    private EditText characterName;
    private String   selected;

    /**
     * Empty constructor, do nothing.
     */
    public MainScreenTest()
    {
        super(MainScreen.class);
    }

    /**
     * Initialize the test features.
     */
    public void setUp()
    {
        // Do nothing
    }

    /**
     * Test the character spinner.
     */
    public void testCharacterSpinner()
    {
        assertEquals("Warrior", selected.toString());
    }

    /**
     * Test the character name.
     */
    public void testCharacterName()
    {
        assertEquals("", characterName.getText());
    }
}
