package cs2114.puzzlerpg;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Intent;
import android.view.View;
import sofia.app.Screen;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

// -------------------------------------------------------------------------
/**
 * Main Menu of Puzzle RPG 2.0
 *
 * @author Kasey Johnson
 * @version Apr 22, 2015
 */
public class MainScreen
    extends Screen
{
    private Spinner  characterClass;
    private EditText characterName;
    private String   selected;


    // -------------------------------------------------------------------------
    /**
     * Listens for value selected in Spinner
     *
     * @author Kasey Johnson
     * @version Apr 25, 2015
     */
    public class ClassSelectedListener
        implements OnItemSelectedListener
    {

        /**
         * Get the selected value from the spinner
         */
        public void onItemSelected(
            AdapterView<?> parent,
            View view,
            int pos,
            long id)
        {
            selected = parent.getItemAtPosition(pos).toString();
        }


        public void onNothingSelected(AdapterView<?> parent)
        {
            selected = "Warrior";
        }
    }


    /**
     * Set up the screen class
     */
    public void initialize()
    {
        ArrayAdapter<CharSequence> adapter =
            ArrayAdapter.createFromResource(
                this,
                R.array.character_classes,
                android.R.layout.simple_spinner_item);
        adapter
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        characterClass.setAdapter(adapter);
        characterClass.setOnItemSelectedListener(new ClassSelectedListener());
    }


    // ----------------------------------------------------------
    /**
     * Opens up the playing screen of the game
     *
     * @param view
     *            Current View
     */
    public void startClicked(View view)
    {
        Intent intent = new Intent(this, BattleScreen.class);
        intent.putExtra("class", selected);
        intent.putExtra("name", characterName.getText().toString());
        startActivity(intent);

    }
}
