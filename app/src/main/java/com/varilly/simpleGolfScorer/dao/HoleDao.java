package com.varilly.simpleGolfScorer.dao;

import com.varilly.simpleGolfScorer.entity.Hole;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface HoleDao {

    @Insert
    void insert(Hole hole);

    @Query("DELETE FROM hole_table")
    void deleteAll();

    @Query("SELECT * FROM hole_table")
    LiveData<List<Hole>> getAllHole();

    @Query("SELECT * FROM hole_table WHERE holeNumber = :holeNumber")
    Hole findHoleWithHoleNumber(int holeNumber);

}
