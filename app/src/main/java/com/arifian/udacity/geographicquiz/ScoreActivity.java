package com.arifian.udacity.geographicquiz;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    public static final String KEY_SCORE = "score";
    TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTextView = (TextView)findViewById(R.id.score);

        int score = getIntent().getIntExtra(KEY_SCORE, 0);
        String title, message;
        if(score == 10){
            title = getString(R.string.title_10);
            message = getString(R.string.message_10);
            setScoreColor(R.color.score_10);
        }else if(score >= 7){
            title = getString(R.string.title_7);
            message = getString(R.string.message_7);
            setScoreColor(R.color.score_7);
        }else if(score >= 5){
            title = getString(R.string.title_5);
            message = getString(R.string.message_5);

            setScoreColor(R.color.score_5);
        }else if(score >= 3){
            title = getString(R.string.title_3);
            message = getString(R.string.message_3);
            setScoreColor(R.color.score_3);
        }else{
            title = getString(R.string.title_0);
            message = getString(R.string.message_0);
            setScoreColor(R.color.score_0);
        }

        scoreTextView.setText(String.valueOf(score));
        ((TextView) findViewById(R.id.title)).setText(title);
        ((TextView) findViewById(R.id.short_message)).setText(message);
    }

    private void setScoreColor(int color){
        if(Build.VERSION.SDK_INT >= 23){
            scoreTextView.setTextColor(getColor(color));
        }else{
            scoreTextView.setTextColor(getResources().getColor(color));
        }
    }
}
