package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Intent Type");
        setContentView(R.layout.activity_destination);
        TextView values = (TextView)findViewById(R.id.txtValues);

        // TODO: extract any data passed by the caller
        Intent i = getIntent();
        if (i != null){
            String str = i.getStringExtra("StringData");
            Integer num =i.getIntExtra("IntData",-1);
            String data = str +" \n "+num.toString();
            values.setText(data);

        }


    }
}