package com.varilly.simpleGolfScorer.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.varilly.simpleGolfScorer.R;
import com.varilly.simpleGolfScorer.viewmodel.PlayerListAdapter;
import com.varilly.simpleGolfScorer.viewmodel.PlayerViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import static com.varilly.simpleGolfScorer.Constants.EIGHT;
import static com.varilly.simpleGolfScorer.Constants.FIVE;
import static com.varilly.simpleGolfScorer.Constants.FOUR;
import static com.varilly.simpleGolfScorer.Constants.HOLE_PAR;
import static com.varilly.simpleGolfScorer.Constants.HOLE_SI;
import static com.varilly.simpleGolfScorer.Constants.ONE;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_IN_HAND;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_IN_HAND_HC;
import static com.varilly.simpleGolfScorer.Constants.SEVEN;
import static com.varilly.simpleGolfScorer.Constants.SIX;
import static com.varilly.simpleGolfScorer.Constants.THREE;
import static com.varilly.simpleGolfScorer.Constants.TWO;

public class HoleScoreEntry extends AppCompatActivity{

    private PlayerViewModel mScoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hole_score_entry_activity);
        final PlayerListAdapter adapter =
                new PlayerListAdapter(new PlayerListAdapter.ScoresDiff());
        mScoreViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
        mScoreViewModel.getAllScores().observe(this, scores -> {
            // Update the cached copy of the scoreboard in the adapter.
            adapter.submitList(scores);
        });
        setButtonValues();
    }

    private void setButtonValues() {
        int par = getIntent().getExtras().getInt(HOLE_PAR);
        if(par == 3){
            Button eagleButton = (Button)findViewById(R.id.eagle);
            eagleButton.setText(ONE);
            Button birdieButton = (Button)findViewById(R.id.birdie);
            birdieButton.setText(TWO);
            Button parButton = (Button)findViewById(R.id.par);
            parButton.setText(THREE);
            Button bogeyButton = (Button)findViewById(R.id.bogey);
            bogeyButton.setText(FOUR);
            Button doubleButton = (Button)findViewById(R.id.doubleBogey);
            doubleButton.setText(FIVE);
            Button tripleButton = (Button)findViewById(R.id.triple);
            tripleButton.setText(SIX);
        }if(par == 4){
            Button eagleButton = (Button)findViewById(R.id.eagle);
            eagleButton.setText(TWO);
            Button birdieButton = (Button)findViewById(R.id.birdie);
            birdieButton.setText(THREE);
            Button parButton = (Button)findViewById(R.id.par);
            parButton.setText(FOUR);
            Button bogeyButton = (Button)findViewById(R.id.bogey);
            bogeyButton.setText(FIVE);
            Button doubleButton = (Button)findViewById(R.id.doubleBogey);
            doubleButton.setText(SIX);
            Button tripleButton = (Button)findViewById(R.id.triple);
            tripleButton.setText(SEVEN);
        }if(par == 5){
            Button eagleButton = (Button)findViewById(R.id.eagle);
            eagleButton.setText(THREE);
            Button birdieButton = (Button)findViewById(R.id.birdie);
            birdieButton.setText(FOUR);
            Button parButton = (Button)findViewById(R.id.par);
            parButton.setText(FIVE);
            Button bogeyButton = (Button)findViewById(R.id.bogey);
            bogeyButton.setText(SIX);
            Button doubleButton = (Button)findViewById(R.id.doubleBogey);
            doubleButton.setText(SEVEN);
            Button tripleButton = (Button)findViewById(R.id.triple);
            tripleButton.setText(EIGHT);        }
    }

    public void scoreUpdate(View view){
            String playerName = getIntent().getExtras().getString(PLAYER_IN_HAND);
            int handicap = getIntent().getExtras().getInt(PLAYER_IN_HAND_HC);
            int par = getIntent().getExtras().getInt(HOLE_PAR);
            int si = getIntent().getExtras().getInt(HOLE_SI);
            Button btn =  (Button)findViewById(view.getId());
            int score = Integer.parseInt(btn.getText().toString());
            int stablefordToAdd = calculateStablefordScore(par,si,handicap,score);
            mScoreViewModel.addToScoreForPlayerName(playerName, score, stablefordToAdd);
            finish();

    }

        private int calculateStablefordScore(int par, int si, int handicap, int score){
            int minusAmount = 0;
            if(36<handicap-si){
                minusAmount = 3;
            }if(18<handicap-si){
                minusAmount = 2;
            }if(0<handicap-si){
                minusAmount = 1;
            }
            int netScore = score - minusAmount;
            switch(netScore-par){
                case 2:
                    return 0;
                case 1:
                    return 1;
                case 0:
                    return 2;
                case -1:
                    return 3;
                case -2:
                    return 4;
                case -3:
                    return 5;
                case -4:
                    return 6;
            }
            return 0;
        }


    }
