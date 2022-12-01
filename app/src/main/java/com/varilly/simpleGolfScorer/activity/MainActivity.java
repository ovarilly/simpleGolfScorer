package com.varilly.simpleGolfScorer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.varilly.simpleGolfScorer.Constants;
import com.varilly.simpleGolfScorer.R;
import com.varilly.simpleGolfScorer.entity.Player;
import com.varilly.simpleGolfScorer.viewmodel.PlayerViewModel;
import com.varilly.simpleGolfScorer.viewmodel.ScoreboardListAdapter;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.varilly.simpleGolfScorer.Constants.PLAYER_A;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_A_HC;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_B;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_B_HC;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_C;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_C_HC;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_D;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.varilly.simpleGolfScorer.MESSAGE";
    private PlayerViewModel mScoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ScoreboardListAdapter adapter =
                new ScoreboardListAdapter(new ScoreboardListAdapter.ScoresDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mScoreViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
        mScoreViewModel.getAllScores().observe(this, scores -> {
            // Update the cached copy of the scoreboard in the adapter.
            adapter.submitList(scores);
        });

        Button scoresEditButton = (Button)findViewById(R.id.scoreEntry);
        scoresEditButton.setOnClickListener(v -> {
            goToScoresPage(adapter.getCurrentList());
        });
    }


    /**
     * INTENT Called when user taps Score Entry button
     * @param currentList
     */
    private void goToScoresPage(List<Player> currentList){
        Intent intent = new Intent(this, ScoresEntryActivity.class);
        Bundle b = new Bundle();
        if(1<=currentList.size()){
            b.putString(PLAYER_A, currentList.get(0).getPlayerName());
            b.putInt(PLAYER_A_HC, currentList.get(0).getHandicap());
        }if(2<=currentList.size()){
            b.putString(PLAYER_B, currentList.get(1).getPlayerName());
            b.putInt(PLAYER_B_HC, currentList.get(1).getHandicap());
        }if(3<=currentList.size()){
            b.putString(PLAYER_C, currentList.get(2).getPlayerName());
            b.putInt(PLAYER_C_HC, currentList.get(2).getHandicap());
        }if(4==currentList.size()){
            b.putString(PLAYER_D, currentList.get(3).getPlayerName());
            b.putInt(Constants.PLAYER_D_HC, currentList.get(3).getHandicap());
        }
        intent.putExtras(b);
        startActivity(intent);
    }

    /**
     * INTENT Called when user taps Total Scores button
     */
    public void goToPlayerEditPage(View view){
        Intent intent = new Intent(this, PlayerEditActivity.class);
        startActivity(intent);
    }

    public void resetScores(View view){
        mScoreViewModel.resetScores();
    }



}