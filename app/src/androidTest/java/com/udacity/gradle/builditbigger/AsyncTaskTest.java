package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {
    
    @Test
    public void testDoInBackground() throws Exception {
        //Create the fragment
        MainActivityFragment fragment = new MainActivityFragment();
        //Set the test flag so that the Joke Activity won't attempt to launch
        fragment.setTesting(true);
        //Launch the AsyncTask
        new EndpointsAsyncTask().execute(fragment);
        //There is a delay in asyncTask for showing LoadingIndicator therefore we must wait a bit more
        Thread.sleep(10000);
        assertTrue(!TextUtils.isEmpty(fragment.getFetchedJoke()));
    }
}
