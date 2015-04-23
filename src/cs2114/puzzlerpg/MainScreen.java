package cs2114.puzzlerpg;

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

    // ----------------------------------------------------------
    /**
     * Opens up the playing screen of the game
     *
     * @param view Current View
     */
    public void startClicked(View view)
    {
        Intent intent = new Intent(this, BattleScreen.class);
        startActivity(intent);

    }

}
