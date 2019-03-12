package com.vogella.java.retrofitgerrit.Controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.java.retrofitgerrit.data.RestApi;
import com.vogella.java.retrofitgerrit.model.RestExerciceResponse;
import com.vogella.java.retrofitgerrit.presentation.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {
    private MainActivity activity;



    public MainController(MainActivity mainActivity){
        this.activity=mainActivity;
    }
    public void onStart(){
        if(hasDataInDb()){

        }else{
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://wger.de/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            RestApi restApi = retrofit.create(RestApi.class);

            Call<RestExerciceResponse> call = restApi.getListExercices();
            call.enqueue(new Callback<RestExerciceResponse>() {
                @Override
                public void onResponse(Call<RestExerciceResponse> call, Response<RestExerciceResponse> response) {
                    activity.showList(response.body().getResults());
                }

                @Override
                public void onFailure(Call<RestExerciceResponse> call, Throwable t) {
                    Log.d("Error", "api error");
                }
            });
        }


    }

}
