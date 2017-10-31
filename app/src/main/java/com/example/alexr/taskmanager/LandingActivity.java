package com.example.alexr.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        TextView message = (TextView)findViewById(R.id.message);
        message.setText("This is hardcoded, but thanks for visiting the app!  Our next hackathon is scheduled for the end of Q3.  We hope to see you there, be sure to add your ideas to the app!");
    }

    public void GetStarted(View view){
        Intent intent = new Intent(this, IdeaListActivity.class);
        startActivity(intent);
    }
}
