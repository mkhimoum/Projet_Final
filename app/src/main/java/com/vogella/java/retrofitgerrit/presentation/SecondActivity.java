package com.vogella.java.retrofitgerrit.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vogella.java.retrofitgerrit.model.Constants;
import com.vogella.android.recyclerview.R;
import com.vogella.java.retrofitgerrit.model.Exercice;

public class SecondActivity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt = findViewById(R.id.textview_label);

        Gson gson = new Gson();

        String sessionId= getIntent().getStringExtra(Constants.KEY);
        Exercice exercice = gson.fromJson(sessionId, Exercice.class);
        txt.setText(Constants.fromHtml(exercice.getDescription()));

    }
}
