package com.example.alexr.taskmanager;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alexr.taskmanager.helpers.DummyContent;
import com.example.alexr.taskmanager.models.Idea;

public class IdeaCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Button createIdea = (Button) findViewById(R.id.idea_create);
        final EditText ideaName = (EditText) findViewById(R.id.idea_name);
        final EditText ideaDescription = (EditText) findViewById(R.id.idea_description);
        final EditText ideaOwner = (EditText) findViewById(R.id.idea_owner);
        final EditText ideaStatus = (EditText) findViewById(R.id.idea_status);

        createIdea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Idea newIdea = new Idea();
                newIdea.setName(ideaName.getText().toString());
                newIdea.setDescription(ideaDescription.getText().toString());
                newIdea.setStatus(ideaStatus.getText().toString());
                newIdea.setOwner(ideaOwner.getText().toString());

                DummyContent.createIdea(newIdea);
            }
        });
    }
}
