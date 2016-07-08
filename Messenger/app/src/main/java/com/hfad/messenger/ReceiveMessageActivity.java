package com.hfad.messenger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message"; //constant: name of xtra value were passing in the intent

    @Override
    protected void onCreate(Bundle savedInstanceState) { //this method gets called automatically when activity is created
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        //get intent
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE); //get the message from the intent

        //use findViewById to retrieve the widgets in that UI that you need to interact with programmatically
        TextView messageView = (TextView) findViewById(R.id.message); //message is the id name of the textview in the xml

        messageView.setText(messageText);

    }
}
