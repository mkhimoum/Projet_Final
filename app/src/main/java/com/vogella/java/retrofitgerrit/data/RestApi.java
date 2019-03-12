package com.vogella.java.retrofitgerrit.data;

import com.vogella.java.retrofitgerrit.model.RestExerciceResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("exercise")
    Call<RestExerciceResponse> getListExercices();
}
