package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Intent Type");
        findViewById(R.id.APP_INTENTS).setOnClickListener(this);
        findViewById(R.id.Creat_EXPLICIT_INTENT).setOnClickListener(this);
        findViewById(R.id.CREAT_IMPLICIT_INTENT).setOnClickListener(this);
        findViewById(R.id.MEDI_INTENT).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Creat_EXPLICIT_INTENT:
                // TODO: Build an explicit Intent to launch our Activity
                Intent i = new Intent(this, DestinationActivity.class);

                // TODO: send data along with the Intent to the destination
                // also can send object of data like student object or another type
                i.putExtra("StringData", "This is a string");
                i.putExtra("IntData", 1234);
                // TODO: Start the activity with our explicit inten
                startActivity(i);
//
                break;
            case R.id.CREAT_IMPLICIT_INTENT:
                // TODO: Build an implicit intent to handle a type of action
                String textMessage = "This is a sample message";
                Intent i1 = new Intent();
                i1.setAction(Intent.ACTION_SEND);
                i1.setType("text/plain");
                i1.putExtra(Intent.EXTRA_TEXT, textMessage);
                // TODO: use an intent chooser to force a choose dialog
                Intent chooser = Intent.createChooser(i1,"Select an app:");


                // TODO: Verify that the intent will resolve to an activity
                if (i1.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser );
                }
                // Typically you would handle the null case here by informing the user
                // that there is no installed app to handle this intent or
                // by taking some other action

                break;


            case R.id.APP_INTENTS:
                Intent i2 = new Intent(this, AppsActivity.class);
                startActivity(i2);

                break;

            case R.id.MEDI_INTENT:
                Intent MEDIA_INTENT = new Intent(this, MediaActivity.class);
                startActivity(MEDIA_INTENT);

                break;
        }

    }
}