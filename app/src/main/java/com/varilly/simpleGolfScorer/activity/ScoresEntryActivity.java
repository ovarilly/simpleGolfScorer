package com.varilly.simpleGolfScorer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.varilly.simpleGolfScorer.R;
import com.varilly.simpleGolfScorer.activity.holes.Hole10Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole11Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole12Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole13Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole14Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole15Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole16Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole17Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole18Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole1Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole2Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole3Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole4Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole5Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole6Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole7Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole8Entry;
import com.varilly.simpleGolfScorer.activity.holes.Hole9Entry;

import androidx.appcompat.app.AppCompatActivity;

public class ScoresEntryActivity extends AppCompatActivity {

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores_entry_activity);
        bundle = getIntent().getExtras();
    }

    public void goToHole1(View view){
        Intent intent = new Intent(this, Hole1Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole2(View view){
        Intent intent = new Intent(this, Hole2Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole3(View view){
        Intent intent = new Intent(this, Hole3Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole4(View view){
        Intent intent = new Intent(this, Hole4Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole5(View view){
        Intent intent = new Intent(this, Hole5Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole6(View view){
        Intent intent = new Intent(this, Hole6Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole7(View view){
        Intent intent = new Intent(this, Hole7Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole8(View view){
        Intent intent = new Intent(this, Hole8Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole9(View view){
        Intent intent = new Intent(this, Hole9Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole10(View view){
        Intent intent = new Intent(this, Hole10Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole11(View view){
        Intent intent = new Intent(this, Hole11Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole12(View view){
        Intent intent = new Intent(this, Hole12Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole13(View view){
        Intent intent = new Intent(this, Hole13Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole14(View view){
        Intent intent = new Intent(this, Hole14Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole15(View view){
        Intent intent = new Intent(this, Hole15Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole16(View view){
        Intent intent = new Intent(this, Hole16Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole17(View view){
        Intent intent = new Intent(this, Hole17Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }public void goToHole18(View view){
        Intent intent = new Intent(this, Hole18Entry.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
