package com.varilly.simpleGolfScorer.activity.holes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.varilly.simpleGolfScorer.R;
import com.varilly.simpleGolfScorer.activity.HoleScoreEntry;
import com.varilly.simpleGolfScorer.viewmodel.HoleListAdapter;
import com.varilly.simpleGolfScorer.viewmodel.HoleViewModel;
import com.varilly.simpleGolfScorer.viewmodel.PlayerViewModel;
import com.varilly.simpleGolfScorer.viewmodel.ScoreboardListAdapter;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.varilly.simpleGolfScorer.Constants.HOLE_NUMBER;
import static com.varilly.simpleGolfScorer.Constants.HOLE_PAR;
import static com.varilly.simpleGolfScorer.Constants.HOLE_SI;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_IN_HAND;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_IN_HAND_HC;

public class Hole2Entry extends AbstractHoleEntry {

    private PlayerViewModel mPlayerViewModel;
    private HoleViewModel mHoleViewModel;
    private HoleListAdapter holeListAdapter;
    private ScoreboardListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hole2_entry_activity);

        RecyclerView recyclerView = findViewById(R.id.scoreRecyclerview);
        adapter = new ScoreboardListAdapter(new ScoreboardListAdapter.ScoresDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mPlayerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
        mPlayerViewModel.getAllScores().observe(this, scores -> {
            // Update the cached copy of the scoreboard in the adapter.
            adapter.submitList(scores);
        });
        holeListAdapter = new HoleListAdapter(new HoleListAdapter.ScoresDiff());
        mHoleViewModel = new ViewModelProvider(this).get(HoleViewModel.class);
        // Update the cached copy of the scoreboard in the adapter.
        mHoleViewModel.getHoleList().observe(this,
                list -> holeListAdapter.submitList(list)
        );
        populateButtons();

    }

    public void goToScoreEntry(View view){
        Intent intent = new Intent(this, HoleScoreEntry.class);
        Bundle b = new Bundle();
        Button btn =  (Button)findViewById(view.getId());
        String playerName = (String) btn.getText();
        b.putInt(PLAYER_IN_HAND_HC, getPlayerInHandHandicap(adapter.getCurrentList(), playerName));
        b.putString(PLAYER_IN_HAND, playerName);
        b.putAll(getIntent().getExtras());
        b.putInt(HOLE_NUMBER, holeListAdapter.getCurrentList().get(1).getHoleNumber());
        b.putInt(HOLE_PAR, holeListAdapter.getCurrentList().get(1).getPar());
        b.putInt(HOLE_SI, holeListAdapter.getCurrentList().get(1).getStrokeIndex());
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }

}
