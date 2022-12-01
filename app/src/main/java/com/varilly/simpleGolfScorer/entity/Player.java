package com.varilly.simpleGolfScorer.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "player_table")
public class Player {

   @PrimaryKey
   @NonNull
   private String playerName;
   private int score;
   @NonNull
   private int handicap;
   private int stablefordScore;


   public Player(String playerName, int score, int handicap, int stablefordScore) {
      this.playerName = playerName;
      this.score = score;
      this.handicap = handicap;
      this.stablefordScore = stablefordScore;
   }


   public String getPlayerName() {
      return playerName;
   }

   public void setPlayerName(String playerName) {
      this.playerName = playerName;
   }

   public int getScore() {
      return score;
   }

   public void setScore(int score) {
      this.score = score;
   }

   public int getHandicap() {
      return handicap;
   }

   public void setHandicap(int handicap) {
      this.handicap = handicap;
   }

   public int getStablefordScore() {
      return stablefordScore;
   }

   public void setStablefordScore(int stablefordScore) {
      this.stablefordScore = stablefordScore;
   }

   @Override
   public String toString() {
      return "Player{" +
              "playerName='" + playerName + '\'' +
              ", score=" + score +
              ", handicap=" + handicap +
              ", stablefordScore=" + stablefordScore +
              '}';
   }


}
