package com.varilly.simpleGolfScorer.viewmodel;

import android.app.Application;
import android.util.Log;

import com.varilly.simpleGolfScorer.entity.Hole;
import com.varilly.simpleGolfScorer.persistance.HoleRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class HoleViewModel extends AndroidViewModel {

   private HoleRepository holeRepository;
   private static final String TAG = "HoleViewModel Log";

   private final LiveData<List<Hole>> holeList;

   public HoleViewModel(@NonNull Application application) {
      super(application);
      holeRepository = new HoleRepository(application);
      holeList = holeRepository.getAllHoles();
   }

   public LiveData<List<Hole>> getHoleList(){return holeList;}

   public void insert(Hole hole){
      try{
         holeRepository.insert(hole);
         Log.i(TAG, "Inserted "+hole.toString());
      }catch (Exception e){
         Log.e(TAG, "Failed insert of "+  hole.toString());
      }}

   public Hole findHoleWithHoleNumber(int holeNumber) {
         return holeRepository.findHoleWithHoleNumber(holeNumber);
   }

   public void deleteAllHoles() {
      try{
         holeRepository.deleteAll();
         Log.i(TAG, "Deleted all Holes");
      }catch (Exception e){
         Log.e(TAG, "Failed to delete all Holes");
      }
   }
}
