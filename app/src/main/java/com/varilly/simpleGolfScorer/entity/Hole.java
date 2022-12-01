package com.varilly.simpleGolfScorer.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hole_table")
public class Hole {

   @PrimaryKey
   @NonNull
   private int holeNumber;
   private int strokeIndex;
   private int par;

   public Hole(int holeNumber, int strokeIndex, int par) {
      this.holeNumber = holeNumber;
      this.strokeIndex = strokeIndex;
      this.par = par;
   }
   public int getHoleNumber() {
      return holeNumber;
   }

   public void setHoleNumber(int holeNumber) {
      this.holeNumber = holeNumber;
   }

   public int getStrokeIndex() {
      return strokeIndex;
   }

   public void setStrokeIndex(int strokeIndex) {
      this.strokeIndex = strokeIndex;
   }

   public int getPar() {
      return par;
   }

   public void setPar(int par) {
      this.par = par;
   }

   @Override
   public String toString() {
      return "Hole{" +
              "holeNumber=" + holeNumber +
              ", strokeIndex=" + strokeIndex +
              ", par=" + par +
              '}';
   }


}
