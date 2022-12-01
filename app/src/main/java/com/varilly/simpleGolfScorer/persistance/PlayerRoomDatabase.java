package com.varilly.simpleGolfScorer.persistance;

import android.content.Context;

import com.varilly.simpleGolfScorer.dao.HoleDao;
import com.varilly.simpleGolfScorer.dao.PlayerDao;
import com.varilly.simpleGolfScorer.entity.Hole;
import com.varilly.simpleGolfScorer.entity.Player;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Player.class, Hole.class}, version = 3, exportSchema = false)
public abstract class PlayerRoomDatabase extends RoomDatabase {

   public abstract PlayerDao playerDao();
   public abstract HoleDao holeDao();

   private static volatile PlayerRoomDatabase INSTANCE;
   private static final int NUMBER_OF_THREADS = 4;
   static final ExecutorService databaseWriteExecutor =
           Executors.newFixedThreadPool(NUMBER_OF_THREADS);

   static PlayerRoomDatabase getDatabase(final Context context) {
      if (INSTANCE == null) {
         synchronized (PlayerRoomDatabase.class) {
            if (INSTANCE == null) {
               INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                               PlayerRoomDatabase.class, "player_database")
                       .addCallback(sRoomDatabaseCallback)
                       .addCallback(sRoomHolesCallback)
                       .fallbackToDestructiveMigration()
                       .build();
            }
         }
      }
      return INSTANCE;
   }

   private static RoomDatabase.Callback sRoomHolesCallback = new RoomDatabase.Callback() {
      @Override
      public void onCreate(@NonNull SupportSQLiteDatabase db) {
         super.onCreate(db);

         databaseWriteExecutor.execute(() -> {            // Populate the database in the background.

            HoleDao holeDao = INSTANCE.holeDao();
            holeDao.insert(new Hole(1, 11, 3));
            holeDao.insert(new Hole(2, 5, 4));
            holeDao.insert(new Hole(3, 9, 4));
            holeDao.insert(new Hole(4, 13, 5));
            holeDao.insert(new Hole(5, 3, 4));
            holeDao.insert(new Hole(6, 15, 3));
            holeDao.insert(new Hole(7, 7, 4));
            holeDao.insert(new Hole(8, 1, 3));
            holeDao.insert(new Hole(9, 17, 3));
            holeDao.insert(new Hole(10, 14, 4));
            holeDao.insert(new Hole(11, 6, 4));
            holeDao.insert(new Hole(12, 12, 3));
            holeDao.insert(new Hole(13, 4, 4));
            holeDao.insert(new Hole(14, 8, 3));
            holeDao.insert(new Hole(15, 16, 5));
            holeDao.insert(new Hole(16, 2, 4));
            holeDao.insert(new Hole(17, 10, 4));
            holeDao.insert(new Hole(18, 18, 4));

         });
      }
   };

   private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
      @Override
      public void onCreate(@NonNull SupportSQLiteDatabase db) {
         super.onCreate(db);

         // If you want to keep data through app restarts,
         // comment out the following block
         databaseWriteExecutor.execute(() -> {
            // Populate the database in the background.
            PlayerDao dao = INSTANCE.playerDao();
            dao.deleteAll();

            Player player = new Player("PlayerA", 0, 16, 0);
            dao.insert(player);
            player = new Player("PlayerB", 0, 16, 0);
            dao.insert(player);
            player = new Player("PlayerC", 0, 16, 0);
            dao.insert(player);
            player = new Player("PlayerD", 0, 16, 0);
            dao.insert(player);
         });
      }
   };

}
