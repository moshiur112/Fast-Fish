package com.example.fastfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {
    private Button restartGame;
    private TextView showscore;
    private String scoreFromMaInintent;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        db = new DBHelper(this);

        scoreFromMaInintent = getIntent().getExtras().get("score").toString();
        restartGame = (Button) findViewById(R.id.playAgainButton);
        showscore = (TextView) findViewById(R.id.score);
        restartGame.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });
        int old = User.getHighScore();
        int newscore = Integer.parseInt(scoreFromMaInintent);
        if(newscore > old) {
            User.setHighScore(newscore);
            db.updateData(User.getUsername(), User.getPassword(), Integer.toString(newscore));
            showscore.setText("New Highscore = " + scoreFromMaInintent);

        } else {
            showscore.setText("Score = " + scoreFromMaInintent);

        }
    }
}
