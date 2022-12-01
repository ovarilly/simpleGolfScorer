package com.varilly.simpleGolfScorer.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.varilly.simpleGolfScorer.R;
import com.varilly.simpleGolfScorer.entity.Player;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScoreboardViewHolder extends RecyclerView.ViewHolder {
    private final TextView playerNameView;
    private final TextView handicapView;
    private final TextView scoreView;
    private final TextView stablefordView;

    public ScoreboardViewHolder(@NonNull View itemView) {
        super(itemView);
        playerNameView = itemView.findViewById(R.id.playerNameView);
        handicapView = itemView.findViewById(R.id.handicapView);
        scoreView = itemView.findViewById(R.id.scoreView);
        stablefordView = itemView.findViewById(R.id.stablefordView);
    }

    public void bindPlayer(Player player){
        playerNameView.setText(player.getPlayerName());
        handicapView.setText(Integer.toString(player.getHandicap()));
        scoreView.setText(Integer.toString(player.getScore()));
        stablefordView.setText(Integer.toString(player.getStablefordScore()));
    }

    static ScoreboardViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ScoreboardViewHolder(view);
    }
}
