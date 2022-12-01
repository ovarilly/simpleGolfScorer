package com.varilly.simpleGolfScorer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.varilly.simpleGolfScorer.R;

import androidx.appcompat.app.AppCompatActivity;

public class NewPlayerActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.varilly.android.wordlistsql.REPLY";
    public static final String EXTRA_REPLY_HANDICAP = "com.varilly.android.wordlistsql.REPLY_HANDICAP";

    private EditText mEditPlayerNameView;
    private EditText mEditPlayerHandicapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);
        mEditPlayerNameView = findViewById(R.id.add_player_name);
        mEditPlayerHandicapView = findViewById(R.id.add_player_handicap);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditPlayerNameView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                replyIntent.putExtra(EXTRA_REPLY, mEditPlayerNameView.getText().toString());
                replyIntent.putExtra(EXTRA_REPLY_HANDICAP,
                        mEditPlayerHandicapView.getText().toString());
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}