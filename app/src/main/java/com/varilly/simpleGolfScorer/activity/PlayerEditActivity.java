package com.varilly.simpleGolfScorer.activity;

import android.content.Intent;
import android.os.Bundle;

import com.varilly.simpleGolfScorer.R;
import com.varilly.simpleGolfScorer.entity.Player;
import com.varilly.simpleGolfScorer.viewmodel.PlayerListAdapter;
import com.varilly.simpleGolfScorer.viewmodel.PlayerViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PlayerEditActivity extends AppCompatActivity {

    public static final int NEW_PLAYER_ACTIVITY_REQUEST_CODE = 1;
    public static final int REMOVE_PLAYER_ACTIVITY_REQUEST_CODE = 2;
    private PlayerViewModel mScoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_edit);

        RecyclerView recyclerView = findViewById(R.id.recyclerview2);
        final PlayerListAdapter adapter =
                new PlayerListAdapter(new PlayerListAdapter.ScoresDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mScoreViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
        mScoreViewModel.getAllScores().observe(this, scores -> {
            // Update the cached copy of the scoreboard in the adapter.
            adapter.submitList(scores);
        });

        FloatingActionButton fab = findViewById(R.id.addPlayer);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(PlayerEditActivity.this, NewPlayerActivity.class);
            startActivityForResult(intent, NEW_PLAYER_ACTIVITY_REQUEST_CODE);
        });

        FloatingActionButton remove = findViewById(R.id.remove);
        remove.setOnClickListener( view -> {
            Intent intent = new Intent(PlayerEditActivity.this, DeletePlayerActivity.class);
            startActivityForResult(intent, REMOVE_PLAYER_ACTIVITY_REQUEST_CODE);
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_PLAYER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Player player =
                    new Player(data.getStringExtra(NewPlayerActivity.EXTRA_REPLY).toUpperCase(Locale.ROOT),
                            0, Integer.parseInt(data.getStringExtra(NewPlayerActivity.EXTRA_REPLY_HANDICAP)),  0);
            mScoreViewModel.insert(player);
        }if (requestCode == REMOVE_PLAYER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Player player = new Player(data.getStringExtra(DeletePlayerActivity.EXTRA_REPLY), 0, 0, 0);
            mScoreViewModel.deletePlayer(player.getPlayerName().toUpperCase(Locale.ROOT));
        }

    }
}
