package com.varilly.simpleGolfScorer.persistance;

import android.app.Application;
import android.util.Log;

import com.varilly.simpleGolfScorer.dao.PlayerDao;
import com.varilly.simpleGolfScorer.entity.Player;

import java.util.List;

import androidx.lifecycle.LiveData;

public class PlayerRepository {
   private final PlayerDao mPlayerDao;
   private final LiveData<List<Player>> mAllScores;
   private static final String TAG = "ScoresRepository Log";

   public PlayerRepository(Application application){
      PlayerRoomDatabase db = PlayerRoomDatabase.getDatabase(application);
      mPlayerDao = db.playerDao();
      mAllScores = mPlayerDao.getRoundScores();
   }

   public LiveData<List<Player>> getAllScores(){
      return mAllScores;
   }

   public LiveData<Integer> getNumberOfPlayers(){
      return mPlayerDao.getRowCount();
   }

   public void deletePlayerByPlayerName(String playerName){
      try{
         PlayerRoomDatabase.databaseWriteExecutor.execute(()-> {
            mPlayerDao.deletePlayerByPlayerName(playerName);
            Log.i(TAG, "Deleted "+playerName.toString());
         });
      }catch (Exception e){
         Log.e(TAG, "Failed deletion of "+  playerName.toString());
      }
   }

   public void addToScoreForPlayerName(String playerName, int addition, int stableforAddition){
      try{
         PlayerRoomDatabase.databaseWriteExecutor.execute(()-> {
            mPlayerDao.addToScoreForPlayerName(playerName, addition, stableforAddition);
            Log.i(TAG, "Updated score for "+playerName);
         });
      }catch (Exception e){
         Log.e(TAG, "Failed score updare of "+  playerName);
      }
   }

   public void insert(Player player){
      try{
         PlayerRoomDatabase.databaseWriteExecutor.execute(()-> {
                    mPlayerDao.insert(player);
            Log.i(TAG, "Inserted "+player.toString());
         });
      }catch (Exception e){
         Log.e(TAG, "Failed insert of "+  player.toString());
      }
   }

   public void deleteAll() {
      try{
         PlayerRoomDatabase.databaseWriteExecutor.execute(()-> {
            mPlayerDao.deleteAll();
         });
      }catch (Exception e){
         Log.e(TAG, "Failed to delete all");
      }
   }


   public void resetScores() {
      try{
         PlayerRoomDatabase.databaseWriteExecutor.execute(()-> {
            mPlayerDao.resetScores();
         });
      }catch (Exception e){
         Log.e(TAG, "Failed to reset all");
      }
   }
}
