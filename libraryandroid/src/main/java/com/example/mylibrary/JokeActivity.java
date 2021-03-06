package com.example.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public final static String KEYJOKE = "KEY_JOKE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(KEYJOKE);

        TextView jokeTextView = (TextView) findViewById(R.id.joke_text);
        if (joke != null) {
            jokeTextView.setText(joke);
        }
    }
}

