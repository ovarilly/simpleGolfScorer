package com.varilly.simpleGolfScorer.viewmodel;

import android.view.ViewGroup;

import com.varilly.simpleGolfScorer.entity.Hole;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class HoleListAdapter extends ListAdapter<Hole, HoleViewHolder> {

   public HoleListAdapter(@NonNull DiffUtil.ItemCallback<Hole> diffCallback) {
      super(diffCallback);
   }

   @Override
   public HoleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return HoleViewHolder.create(parent);
   }

   @Override
   public void onBindViewHolder(HoleViewHolder holder, int position) {
      Hole current = getItem(position);
      holder.bindHole(current);
   }

   public static class ScoresDiff extends DiffUtil.ItemCallback<Hole> {

      @Override
      public boolean areItemsTheSame(@NonNull Hole oldItem, @NonNull Hole newItem) {
         return oldItem == newItem;
      }

      @Override
      public boolean areContentsTheSame(@NonNull Hole oldItem, @NonNull Hole newItem) {
         return oldItem.getHoleNumber()==newItem.getHoleNumber();
      }
   }
}
