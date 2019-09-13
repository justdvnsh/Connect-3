package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0 - player 1 ( red ) // 1 - player 2 ( yellow )
    int activePlayer = 0;

    // manage game state to avoid double clicking , on the same chip.
    int[] activeSlots = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    // checking the winning combinations . The multi dim array tells the positions of the chips.
    int[][] winningCombs = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {2,4,6}, {0,4,8}};

    public void dropIn(View view) {

        // get the grid. or the image stored there.
        ImageView counter = ( ImageView ) view; // doing the same thing as findById, just it is finding the grid user clicked on.

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if ( activeSlots[tappedCounter] == -1 ) {

            activeSlots[tappedCounter] = activePlayer;

            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.red);

                activePlayer = 0;

            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(600);

            for ( int[] winningComb: winningCombs ) {

                if ( activeSlots[winningComb[0]] == activeSlots[winningComb[1]] &&
                      activeSlots[winningComb[1]] == activeSlots[winningComb[2]] &&
                      activeSlots[winningComb[0]] != -1) {

                    Toast.makeText(MainActivity.this,
                            "Player " + activePlayer + " won.", Toast.LENGTH_LONG).show();

                }

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}