package com.varilly.simpleGolfScorer.viewmodel;

import android.view.ViewGroup;

import com.varilly.simpleGolfScorer.entity.Player;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class PlayerListAdapter extends ListAdapter<Player, PlayerViewHolder> {

   public PlayerListAdapter(@NonNull DiffUtil.ItemCallback<Player> diffCallback) {
      super(diffCallback);
   }

   @Override
   public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return PlayerViewHolder.create(parent);
   }

   @Override
   public void onBindViewHolder(PlayerViewHolder holder, int position) {
      Player current = getItem(position);
      holder.bindPlayer(current);
   }

   public static class ScoresDiff extends DiffUtil.ItemCallback<Player> {

      @Override
      public boolean areItemsTheSame(@NonNull Player oldItem, @NonNull Player newItem) {
         return oldItem == newItem;
      }

      @Override
      public boolean areContentsTheSame(@NonNull Player oldItem, @NonNull Player newItem) {
         return oldItem.getPlayerName().equals(newItem.getPlayerName());
      }
   }
}