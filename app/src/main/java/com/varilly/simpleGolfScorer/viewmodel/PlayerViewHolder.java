package com.varilly.simpleGolfScorer.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.varilly.simpleGolfScorer.R;
import com.varilly.simpleGolfScorer.entity.Player;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class PlayerViewHolder extends RecyclerView.ViewHolder {
    private final TextView playerNameView;
    private final TextView handicapView;

    public PlayerViewHolder(@NonNull View itemView) {
        super(itemView);
        playerNameView = itemView.findViewById(R.id.playerNameView);
        handicapView = itemView.findViewById(R.id.handicapView);

    }

    public void bindPlayer(Player player){
        playerNameView.setText(player.getPlayerName());
        handicapView.setText(Integer.toString(player.getHandicap()));
    }

    static PlayerViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview2_item, parent, false);
        return new PlayerViewHolder(view);
    }
}
