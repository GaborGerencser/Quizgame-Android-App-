package hu.bme.aut.quizgame.Scores;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {ScoreItem.class},
        version = 1
)
public abstract class ScoreListDatabase extends RoomDatabase {
    public abstract ScoreItemDao scoreItemDao();
}
