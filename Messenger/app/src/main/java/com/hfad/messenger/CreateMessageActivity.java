package com.hfad.messenger;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view) {

        //get reference to EditText
        EditText messageView = (EditText) findViewById(R.id.message);

        //change reference to string
        String messageText = messageView.getText().toString(); //get text in the EditText


        //Intent intent = new Intent(this, ReceiveMessageActivity.class);
        //first parameter tells Android which object the intent is from (this = current activity)
        //2nd parameter = class name of activity that needs to receive the intent.

        //put extra stuff in the intent
        //intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
        //using a constant for name of the extra info so that we know CreateMessageActivity and ReceiveMessageActivity
        // are using the same String.

        //create intent
        Intent intent = new Intent(Intent.ACTION_SEND); //this is implicit
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_TEXT, messageText); //if u use extra text, u have to use text/plain
        /*instead of creating an intent that's explicitly for ReceiveMessageActivity, we create an intent that
        uses a send action*/

        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle); //chooserTitle displays chooser dialog

        //start intent
        startActivity(chosenIntent);
    }
}
