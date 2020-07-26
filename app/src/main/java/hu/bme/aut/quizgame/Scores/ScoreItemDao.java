package hu.bme.aut.quizgame.Scores;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ScoreItemDao {
    @Query("SELECT * FROM scoreitem")
    List<ScoreItem> getAll();

    @Insert
    long insert(ScoreItem shoppingItems);

    @Update
    void update(ScoreItem shoppingItem);

    @Delete
    void deleteItem(ScoreItem shoppingItem);
}