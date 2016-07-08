package com.hfad.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;


public class StopwatchActivity extends AppCompatActivity {

    //declare variables
    private int seconds = 0; //used to record seconds and to see if the stopwatch is running
    private boolean running;
    private boolean wasRunning;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
            savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);//saveInstanceState iS  the bundle.
        savedInstanceState.putBoolean("wasRunning", wasRunning);

    }

    //start the stopwatch when the user clicks Start
    public void onClickStart(View view) {
        running = true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (wasRunning) {
            running = true;
        }
    }

    Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        wasRunning = running;
        running = false;
    }



    //stop the stopwatch when the user clicks Stop
    public void onClickStop(View view) {
        running = false;
    }

    //reset the stopwatch when the user clicks Stop
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }



    private void runTimer() {
        //get reference to text view
        final TextView timeView = (TextView)findViewById(R.id.text_view);

        //handler=android class used to schedule code that should be run at some point in the future
        final Handler handler = new Handler();

        //call post(), passing it to new Runnable(the job). post() will process code w/o delay
        handler.post(new Runnable() {
            @Override
            public void run() { //with run, everything is executed on the same thread!!!!!
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = (seconds%60); //u want to mod this stuff so u can only get max 59 seconds and max 59 minutes.
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);

                timeView.setText(time);
                if (running) {
                    seconds++;
                }

                handler.postDelayed(this, 1000);//put code in the Runnable to run again after 1second.
                //this code is included in runnable's run() method, so this will be continually called.
            }

        }); //weird syntax. don't forget the semi colon
    }
}
