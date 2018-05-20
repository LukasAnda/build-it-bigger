package com.lukasanda.jokedisplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends Activity {
    public static final String JOKE_ID = "NewJoke";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView theJokeTextView = findViewById(R.id.joke_textview);
        
        //Retrieve the joke from the Intent Extras
        String passedJoke = null;
        //the Intent that started us
        Intent intent = getIntent();
        passedJoke = intent.getStringExtra(JOKE_ID);
        
        if (passedJoke != null) {
            //Set the textView to display the joke that was passed in
            theJokeTextView.setText(passedJoke);
        } else {
            //Something went wrong, tell the user
            theJokeTextView.setText(R.string.error_no_joke);
        }
    }
}
