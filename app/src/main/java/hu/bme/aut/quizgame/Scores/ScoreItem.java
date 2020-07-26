package hu.bme.aut.quizgame.Scores;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "scoreitem")
public class ScoreItem {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "prize")
    public String prize;

    @ColumnInfo(name="time")
    public int time;

}
