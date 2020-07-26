package hu.bme.aut.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = new Intent(MainActivity.this, GameplayActivity.class);
                startActivity(intent);
            }
        });

        Button btnScoreBoard = findViewById(R.id.btnScoreBoard);
        btnScoreBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = new Intent(MainActivity.this, ScoreboardActivity.class);
                startActivity(intent);
            }
        });

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                finish();
                System.exit(0);
            }
        });

    }
}
