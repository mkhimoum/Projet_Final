package com.vogella.java.retrofitgerrit.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.java.retrofitgerrit.Controller.MainController;
import com.vogella.java.retrofitgerrit.model.Constants;
import com.vogella.android.recyclerview.R;
import com.vogella.java.retrofitgerrit.data.RestApi;
import com.vogella.java.retrofitgerrit.model.Exercice;
import com.vogella.java.retrofitgerrit.model.RestExerciceResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController controller;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        controller=new MainController(this);
        controller.onStart();

    }

    public void showList(List<Exercice> input) {
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(input, getListener());
        recyclerView.setAdapter(mAdapter);
    }

    private MyAdapter.OnItemClickListener getListener() {
        return new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Exercice item) {
                Gson gson = new Gson();

                Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                intent.putExtra(Constants.KEY,gson.toJson(item));
                startActivity(intent);
            }
        };
    }
}