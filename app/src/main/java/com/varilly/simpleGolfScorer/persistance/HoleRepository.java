package com.varilly.simpleGolfScorer.persistance;

import android.app.Application;
import android.util.Log;

import com.varilly.simpleGolfScorer.dao.HoleDao;
import com.varilly.simpleGolfScorer.entity.Hole;

import java.util.List;

import androidx.lifecycle.LiveData;

public class HoleRepository {
   private final HoleDao mHoleDao;
   private final LiveData<List<Hole>> mAllHoles;
   private static final String TAG = "HoleRepository Log";

   public HoleRepository(Application application){
      PlayerRoomDatabase db = PlayerRoomDatabase.getDatabase(application);
      mHoleDao = db.holeDao();
      mAllHoles = mHoleDao.getAllHole();
   }

   public LiveData<List<Hole>> getAllHoles(){
      return mAllHoles;
   }

   public Hole findHoleWithHoleNumber(int holeNumber){
      return findHoleWithHoleNumber(holeNumber);
   }

   public void insert(Hole hole){
      try{
         PlayerRoomDatabase.databaseWriteExecutor.execute(()-> {
                    mHoleDao.insert(hole);
            Log.i(TAG, "Inserted "+hole.toString());
         });
      }catch (Exception e){
         Log.e(TAG, "Failed insert of "+  hole.toString());
      }
   }

   public void deleteAll() {
      try{
         PlayerRoomDatabase.databaseWriteExecutor.execute(()-> {
            mHoleDao.deleteAll();
         });
      }catch (Exception e){
         Log.e(TAG, "Failed to delete all");
      }
   }
}
