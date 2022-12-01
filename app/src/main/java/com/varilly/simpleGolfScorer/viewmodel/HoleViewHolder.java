package com.varilly.simpleGolfScorer.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.varilly.simpleGolfScorer.R;
import com.varilly.simpleGolfScorer.entity.Hole;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class HoleViewHolder extends RecyclerView.ViewHolder {

   private final TextView holeNumberView;
   private final TextView holeParView;
   private final TextView holeSiView;

   public HoleViewHolder(@NonNull View itemView) {
      super(itemView);
      holeNumberView = itemView.findViewById(R.id.holeDisplay);
      holeParView = itemView.findViewById(R.id.holeDisplay);
      holeSiView = itemView.findViewById(R.id.holeDisplay);

   }

   public void bindHole(Hole hole){
      holeNumberView.setText(Integer.toString(hole.getHoleNumber()));
      holeParView.setText(Integer.toString(hole.getPar()));
      holeSiView.setText(Integer.toString(hole.getStrokeIndex()));
   }

   static HoleViewHolder create(ViewGroup parent){
      View view = LayoutInflater.from(parent.getContext())
              .inflate(R.layout.hole_score_entry_activity, parent, false);
      return new HoleViewHolder(view);
   }
}
