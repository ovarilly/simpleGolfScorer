package com.varilly.simpleGolfScorer.activity.holes;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.varilly.simpleGolfScorer.R;
import com.varilly.simpleGolfScorer.entity.Player;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import static com.varilly.simpleGolfScorer.Constants.PLAYER_A;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_B;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_C;
import static com.varilly.simpleGolfScorer.Constants.PLAYER_D;

public abstract class AbstractHoleEntry extends AppCompatActivity {

    void populateButtons() {
        if(null==getIntent().getExtras().getString(PLAYER_A)){
            Log.e("PLAYER ISSUE", "NO PLAYERS FOR MATCH");
        }else{
            Button btn = (Button)findViewById(R.id.playerA);
            btn.setVisibility(View.VISIBLE);
            btn.setText(getIntent().getExtras().getString(PLAYER_A));
            if(null!=getIntent().getExtras().getString(PLAYER_B)){
                Button btnB = (Button)findViewById(R.id.playerB);
                btnB.setVisibility(View.VISIBLE);
                btnB.setText(getIntent().getExtras().getString(PLAYER_B));
            }if(null!=getIntent().getExtras().getString(PLAYER_C)){
                Button btnC = (Button)findViewById(R.id.playerC);
                btnC.setVisibility(View.VISIBLE);
                btnC.setText(getIntent().getExtras().getString(PLAYER_C));
            }if(null!=getIntent().getExtras().getString(PLAYER_D)){
                Button btnD = (Button)findViewById(R.id.playerD);
                btnD.setVisibility(View.VISIBLE);
                btnD.setText(getIntent().getExtras().getString(PLAYER_D));
            }
        }
    }

    int getPlayerInHandHandicap(List<Player> currentList, String playerName) {
        for(Player player: currentList){
            if(player.getPlayerName().equals(playerName)){
                Log.d("Hole2", "found "+playerName+"'s handicap");
                return player.getHandicap();
            }
        }
        return 0;
    }

}
