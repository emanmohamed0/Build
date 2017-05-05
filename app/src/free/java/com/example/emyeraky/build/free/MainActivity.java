package com.example.emyeraky.build.free;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.JokeClass;
import com.example.emyeraky.build.R;
import com.example.mylibrary.JokeActivity;

public class MainActivity extends AppCompatActivity {
    EndpointsAsyncTask endpointsAsyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button jokeBtn = (Button)findViewById(R.id.btnjoke);
        jokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
                fetchJoke();
            }
        });
    }
    public void fetchJoke() {
        endpointsAsyncTask = (EndpointsAsyncTask) new EndpointsAsyncTask(this).execute();
    }

    public  void tellJoke() {
        Intent intent = new Intent(this, JokeActivity.class);
        String joke = JokeClass.jokes;
        intent.putExtra(JokeActivity.KEYJOKE, joke);
        startActivity(intent);


    }
}
