package com.varilly.simpleGolfScorer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.varilly.simpleGolfScorer.R;
import com.varilly.simpleGolfScorer.viewmodel.PlayerViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class DeletePlayerActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.varilly.android.wordlistsql.REPLY";

    private EditText mEditPlayersView;
    private PlayerViewModel mScoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_player);
        mScoreViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
        mEditPlayersView = findViewById(R.id.remove);

        final Button button = findViewById(R.id.del_player);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditPlayersView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditPlayersView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

    public void deleteAll(View view){
        mScoreViewModel.deleteAllPlayers();
        finish();
    }

}