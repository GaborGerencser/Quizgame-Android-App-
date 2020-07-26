package hu.bme.aut.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toolbar;

import java.util.List;

import hu.bme.aut.quizgame.Scores.ScoreItem;
import hu.bme.aut.quizgame.Scores.ScoreListDatabase;
import hu.bme.aut.quizgame.adapter.ScoreAdapter;
import hu.bme.aut.quizgame.fragments.NewScoreItemDialogFragment;

public class ScoreboardActivity extends AppCompatActivity implements NewScoreItemDialogFragment.NewScoreItemDialogListener,
        ScoreAdapter.ScoreItemClickListener {

    private RecyclerView recyclerView;
    private ScoreAdapter adapter;

    private ScoreListDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);


        database = Room.databaseBuilder(
                getApplicationContext(),
                ScoreListDatabase.class,
                "score-list"
        ).build();

        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.ScoreRecyclerView);
        adapter = new ScoreAdapter(this);
        loadItemsInBackground();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void loadItemsInBackground() {
        new AsyncTask<Void, Void, List<ScoreItem>>() {

            @Override
            protected List<ScoreItem> doInBackground(Void... voids) {
                return database.scoreItemDao().getAll();
            }

            @Override
            protected void onPostExecute(List<ScoreItem> scoreItems) {
                adapter.update(scoreItems);
            }
        }.execute();
    }

    @Override
    public void onItemChanged(final ScoreItem item) {
        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... voids) {
                database.scoreItemDao().update(item);
                return true;
            }

            @Override
            protected void onPostExecute(Boolean isSuccessful) {
                Log.d("MainActivity", "ShoppingItem update was successful");
            }
        }.execute();
    }

    public void onScoreItemCreated(final ScoreItem newItem) {
        new AsyncTask<Void, Void, ScoreItem>() {

            @Override
            protected ScoreItem doInBackground(Void... voids) {
                newItem.id = database.scoreItemDao().insert(newItem);
                return newItem;
            }

            @Override
            protected void onPostExecute(ScoreItem scoreItem) {
                adapter.addItem(scoreItem);
            }
        }.execute();
    }
}
