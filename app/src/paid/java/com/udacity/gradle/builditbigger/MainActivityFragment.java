package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.lukasanda.jokedisplayer.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    
    public static final String JOKE_ID = "NewJoke";
    
    private boolean isTesting = false;
    
    ProgressBar loadingBar = null;
    
    private String fetchedJoke = null;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        
        //Set onclickListener for the button
        Button jokeBtn = (Button) root.findViewById(R.id.joke_button);
        jokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingBar.setVisibility(View.VISIBLE);
                fetchJoke();
            }
        });
        
        loadingBar = (ProgressBar) root.findViewById(R.id.joke_loading_spinner);
        loadingBar.setVisibility(View.GONE);
        
        return root;
    }
    
    public void fetchJoke() {
        new EndpointsAsyncTask().execute(this);
    }
    
    public void launchJokeActivity(String fetchedJoke) {
        this.fetchedJoke = fetchedJoke;
        if (!isTesting) {
            Context context = getActivity();
            
            //Create a new Intent to launch the new JokeFactory Activity
            Intent jokeIntent = new Intent(context, JokeActivity.class);
            
            //Set a String Extra for the joke
            jokeIntent.putExtra(JOKE_ID, fetchedJoke);
            
            //start the Activity
            if (context != null) {
                context.startActivity(jokeIntent);
            }
            
            loadingBar.setVisibility(View.GONE);
        }
    }
    
    public String getFetchedJoke() {
        return fetchedJoke;
    }
    
    public void setTesting(boolean testing) {
        isTesting = testing;
    }
}