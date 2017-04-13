package com.arifian.udacity.whatsitscapitalname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    public static String KEY_SCORE = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ((TextView)findViewById(R.id.score)).setText(getIntent().getStringExtra(KEY_SCORE));
    }
}
