package cs2114.puzzlerpg;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import student.TestCase;

/**
 * Test class for MainScreen.
 *
 * @author andrew
 * @author Kasey Johnson
 * @version Apr 27, 2015
 */
public class MainScreenTest
    extends student.AndroidTestCase<MainScreen>
{
    private Spinner  characterClass;
    private EditText characterName;
    private Button   start;


    /**
     * Empty constructor, do nothing.
     */
    public MainScreenTest()
    {
        super(MainScreen.class);
    }


    /**
     * Test the character spinner.
     */
    public void testCharacterSpinner()
    {
        assertEquals("Warrior", characterClass.getSelectedItem().toString());
    }


    /**
     * Test the character name.
     */
    public void testCharacterName()
    {

        assertEquals("", characterName.getEditableText());
    }


    /**
     * Test clicking Start
     */
    public void testStartClicked()
    {
        prepareForUpcomingActivity(Intent.ACTION_VIEW);
        this.click(start);
    }
}
