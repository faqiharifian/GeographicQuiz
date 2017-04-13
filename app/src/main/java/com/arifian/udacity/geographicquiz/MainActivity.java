package com.arifian.udacity.geographicquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getString(R.string.your_name));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(nameEditText.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, getString(R.string.please_tell_me), Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra(QuizActivity.KEY_NAME, nameEditText.getText().toString());
                    startActivity(intent);
                }
            }
        });

        alertDialog = builder.create();
        nameEditText = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        nameEditText.setLayoutParams(lp);
        nameEditText.setPadding(
                getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin),
                nameEditText.getPaddingTop(),
                getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin),
                nameEditText.getPaddingBottom());
        alertDialog.setView(nameEditText);

        findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
    }
}
