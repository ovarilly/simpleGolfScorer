package com.varilly.simpleGolfScorer.viewmodel;

import android.app.Application;
import android.util.Log;

import com.varilly.simpleGolfScorer.entity.Player;
import com.varilly.simpleGolfScorer.persistance.PlayerRepository;
import com.varilly.simpleGolfScorer.persistance.PlayerRoomDatabase;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class PlayerViewModel extends AndroidViewModel {

   private PlayerRepository playerRepository;
   private static final String TAG = "PlayerViewModel Log";

   private final LiveData<List<Player>> allScores;

   public PlayerViewModel(@NonNull Application application) {
      super(application);
      playerRepository = new PlayerRepository(application);
      allScores = playerRepository.getAllScores();
   }

   public LiveData<List<Player>> getAllScores(){return allScores;}

   public LiveData<Integer> getNumberOfPlayers(){
      return playerRepository.getNumberOfPlayers();
   }

   public void insert(Player player){
      try{
         playerRepository.insert(player);
         Log.i(TAG, "Inserted "+player.toString());
      }catch (Exception e){
         Log.e(TAG, "Failed insert of "+  player.toString());
      }}

   public void deletePlayer(String playerName) {
      try{
         playerRepository.deletePlayerByPlayerName(playerName);
         Log.i(TAG, "Deleted "+playerName.toString());
      }catch (Exception e){
         Log.e(TAG, "Failed to delete "+  playerName.toString());
      }
   }

   public void deleteAllPlayers() {
      try{
         playerRepository.deleteAll();
         Log.i(TAG, "Deleted all players");
      }catch (Exception e){
         Log.e(TAG, "Failed to delete all players");
      }
   }

   public void addToScoreForPlayerName(String playerName, int scoreAddition, int stablefordAddition) {
      try{
         playerRepository.addToScoreForPlayerName(playerName, scoreAddition, stablefordAddition);
         Log.i(TAG, "Added score for "+playerName);
      }catch (Exception e){
         Log.e(TAG, "Failed to change score");
      }
   }

   public void resetScores() {
      try{
         playerRepository.resetScores();
         Log.i(TAG, "Reset all scores");
      }catch (Exception e){
         Log.e(TAG, "Failed to reset scores");
      }
   }

}
